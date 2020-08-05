package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.PayOrderCommand
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.payment.PaymentService
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventhandling.EventBus

open class PayOrderCommandHandler(private val repository: OrderRepository,
                                  private val paymentService: PaymentService,
                                  private val eventBus: EventBus) {

    @CommandHandler
    fun handle(command: PayOrderCommand) {
        val order = repository.findById(command.orderId)

        order.pay(command.creditCard, paymentService, eventBus) //TODO provide global access to eventBus

        repository.save(order)
    }
}

