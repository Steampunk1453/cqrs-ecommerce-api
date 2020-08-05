package cqrs.ecommerce.api.web.rest.commands

import cqrs.ecommerce.api.application.order.commandhandlers.commands.RemoveProductCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class DeleteProductController(val commandGateway: CommandGateway) {
    @DeleteMapping("/orders/{orderId}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("orderId") orderId: String,
                      @PathVariable("productId") productId: String) {

        val command = RemoveProductCommand(UUID.fromString(orderId), UUID.fromString(productId))

        commandGateway.sendAndWait<UUID>(command)
    }

}