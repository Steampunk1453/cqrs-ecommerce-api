package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.ChangeProductQuantityCommand
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.commandhandling.CommandHandler

open class ChangeProductQuantityCommandHandler(private val repository: OrderRepository) {
    @CommandHandler
    fun handle(command: ChangeProductQuantityCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.changeProductQuantity(product, command.quantity)

        repository.save(order)
    }
}

