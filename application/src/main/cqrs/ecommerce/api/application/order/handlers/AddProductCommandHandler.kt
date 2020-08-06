package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.AddProductCommand
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.commandhandling.CommandHandler

open class AddProductCommandHandler(private val repository: OrderRepository) {
    @CommandHandler
    fun handle(command: AddProductCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.addProduct(product, command.quantity)

        repository.save(order)
    }
}

