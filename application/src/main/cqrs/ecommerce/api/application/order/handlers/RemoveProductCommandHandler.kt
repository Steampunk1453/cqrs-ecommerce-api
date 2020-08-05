package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.RemoveProductCommand
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.commandhandling.CommandHandler

open class RemoveProductCommandHandler(private val repository: OrderRepository) {
    @CommandHandler
    fun handle(command: RemoveProductCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.removeProduct(product)

        repository.save(order)
    }
}

