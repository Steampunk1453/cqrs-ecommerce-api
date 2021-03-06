package cqrs.ecommerce.api.domain.shipping

import cqrs.ecommerce.api.domain.order.Order

class ShippingService(private val notificationService: NotificationService,
                      private val deliveryProviderService: DeliveryProviderService) {

    fun shipOrder(order: Order) {
        val shippingLabel = if (availableForUltraFastShipping(order))
                                deliveryProviderService.requestFastDelivery(order)
                            else
                                deliveryProviderService.requestStandardDelivery(order)

        notificationService.notifyCustomerOrderShipped(order.customer, order.id, shippingLabel)
    }

    private fun availableForUltraFastShipping(order: Order) : Boolean {
        val availableTowns = listOf("LON", "MAN", "LIV", "NEW")
        return availableTowns.contains(order.customer.address.town)
    }
}