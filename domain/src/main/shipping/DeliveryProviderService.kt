package cqrs.ecommerce.api.domain.shipping

import cqrs.ecommerce.api.domain.order.Order

interface DeliveryProviderService {
    fun requestFastDelivery(order: Order) : ShippingLabel
    fun requestStandardDelivery(order: Order) : ShippingLabel
}