package cqrs.ecommerce.api.web.rest.commands

import cqrs.ecommerce.api.application.order.commands.ChangeProductQuantityCommand
import cqrs.ecommerce.api.web.rest.models.requests.ChangeProductQuantityRequest
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ChangeProductQuantityController(val commandGateway: CommandGateway) {
    @PatchMapping("/orders/{orderId}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun change(@PathVariable("orderId") orderId: String,
                              @PathVariable("productId") productId: String,
                              @RequestBody request: ChangeProductQuantityRequest) {

        val command = ChangeProductQuantityCommand(UUID.fromString(orderId),
                UUID.fromString(productId),
                request.quantity)

        commandGateway.sendAndWait<UUID>(command)
    }
}