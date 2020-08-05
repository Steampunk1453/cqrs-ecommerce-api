package cqrs.ecommerce.api.application.order.commandhandlers

import cqrs.ecommerce.api.application.order.commandhandlers.commands.*
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.commandhandling.CommandHandler
import cqrs.ecommerce.api.domain.order.payment.PaymentService
import org.axonframework.eventhandling.EventBus
import java.util.UUID

open class OrderCommandHandlers(private val repository: OrderRepository,
                                private val paymentService: PaymentService,
                                private val eventBus: EventBus) {
    @CommandHandler
    fun createOrder(command: CreateOrderCommand): UUID {
        val orderId = UUID.randomUUID()
        val customer = repository.findCustomerById(command.customerId)

        val order = Order(orderId, customer)
        repository.save(order)

        return orderId
    }

    @CommandHandler
    fun addProduct(command: AddProductCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.addProduct(product, command.quantity)

        repository.save(order)
    }

    @CommandHandler
    fun changeProductQuantity(command: ChangeProductQuantityCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.changeProductQuantity(product, command.quantity)

        repository.save(order)
    }

    @CommandHandler
    fun removeProduct(command: RemoveProductCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.removeProduct(product)

        repository.save(order)
    }

    @CommandHandler
    fun payOrder(command: PayOrderCommand) {
        val order = repository.findById(command.orderId)

        order.pay(command.creditCard, paymentService, eventBus) //TODO provide global access to eventBus

        repository.save(order)
    }
}

