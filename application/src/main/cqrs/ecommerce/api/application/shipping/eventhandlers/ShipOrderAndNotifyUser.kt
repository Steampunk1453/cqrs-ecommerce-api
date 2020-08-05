package cqrs.ecommerce.api.application.shipping.eventhandlers

import cqrs.ecommerce.api.domain.order.OrderPaid
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.shipping.ShippingService
import org.axonframework.eventhandling.EventHandler

open class ShipOrderAndNotifyUser(private val orderRepository: OrderRepository,
                                  private val shippingService: ShippingService) {
    @EventHandler
    fun handle(event: OrderPaid) {
        val order = orderRepository.findById(event.orderId)
        shippingService.shipOrder(order)
    }
}

