package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.CreateOrderCommand
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.commandhandling.CommandHandler
import java.util.UUID

open class CreateOrderCommandHandler(private val repository: OrderRepository) {
    @CommandHandler
    fun handle(command: CreateOrderCommand): UUID {
        val orderId = UUID.randomUUID()
        val customer = repository.findCustomerById(command.customerId)

        val order = Order(orderId, customer)
        repository.save(order)

        return orderId
    }
}

