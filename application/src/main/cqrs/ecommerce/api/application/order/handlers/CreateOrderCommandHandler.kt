package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.CreateOrderCommand
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import org.axonframework.commandhandling.CommandHandler
import java.util.UUID

open class CreateOrderCommandHandler(private val orderRepository: OrderRepository,
                                     private val customerRepository: CustomerRepository) {
    @CommandHandler
    fun handle(command: CreateOrderCommand): UUID {
        val orderId = UUID.randomUUID()
        val customer = customerRepository.findCustomerById(command.customerId)

        val order = Order(orderId, customer)
        orderRepository.save(order)

        return orderId
    }
}

