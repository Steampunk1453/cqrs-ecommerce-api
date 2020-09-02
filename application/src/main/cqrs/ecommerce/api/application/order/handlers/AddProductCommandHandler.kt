package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.AddProductCommand
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.product.ProductRepository
import org.axonframework.commandhandling.CommandHandler

open class AddProductCommandHandler(private val orderRepository: OrderRepository,
                                    private val productRepository: ProductRepository) {
    @CommandHandler
    fun handle(command: AddProductCommand) {
        val order = orderRepository.findById(command.orderId)
        val product = productRepository.findProductById(command.productId)

        order.addProduct(product, command.quantity)

        orderRepository.save(order)
    }
}

