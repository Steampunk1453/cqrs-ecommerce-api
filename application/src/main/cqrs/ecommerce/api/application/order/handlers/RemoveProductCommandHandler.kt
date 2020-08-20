package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.RemoveProductCommand
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.product.ProductRepository
import org.axonframework.commandhandling.CommandHandler

open class RemoveProductCommandHandler(private val orderRepository: OrderRepository,
                                       private val productRepository: ProductRepository) {
    @CommandHandler
    fun handle(command: RemoveProductCommand) {
        val order = orderRepository.findById(command.orderId)
        val product = productRepository.findProductById(command.productId)

        order.removeProduct(product)

        orderRepository.save(order)
    }
}

