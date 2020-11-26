package cqrs.ecommerce.api.web.rest.commands

import cqrs.ecommerce.api.application.order.commands.PayOrderCommand
import cqrs.ecommerce.api.domain.order.payment.CreditCard
import cqrs.ecommerce.api.web.rest.models.requests.PayOrderRequest
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.Date

@RestController
class PayOrderController(val commandGateway: CommandGateway) {

    @PatchMapping("/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    fun pay(@PathVariable("orderId") orderId: String,
                 @RequestBody request: PayOrderRequest) {

        val card = CreditCard(request.cardName, request.cardNumber, request.expirationDate ?: Date(), request.verificationCode)
        val command = PayOrderCommand(UUID.fromString(orderId), card)

        commandGateway.sendAndWait<UUID>(command)
    }

}