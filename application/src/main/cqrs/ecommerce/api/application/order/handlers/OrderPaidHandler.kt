package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.domain.order.OrderPaid
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.shipping.ShippingService
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventhandling.EventHandler

open class OrderPaidHandler(private val orderRepository: OrderRepository,
                            private val shippingService: ShippingService) {
    @CommandHandler
    fun handle(event: OrderPaid) {
        val order = orderRepository.findById(event.orderId)
        shippingService.shipOrder(order)
    }
}

