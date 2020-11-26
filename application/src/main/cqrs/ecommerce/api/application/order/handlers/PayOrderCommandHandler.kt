package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.application.order.commands.PayOrderCommand
import cqrs.ecommerce.api.domain.order.payment.PaymentService
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.gateway.CommandGateway

open class PayOrderCommandHandler(private val repository: OrderRepository,
                                  private val paymentService: PaymentService,
                                  private val commandGateway: CommandGateway) {

    @CommandHandler
    fun handle(command: PayOrderCommand) {
        val order = repository.findById(command.orderId)

        order.pay(command.creditCard, paymentService, commandGateway)

        repository.save(order)
    }
}

