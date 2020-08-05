package cqrs.ecommerce.api.web.rest.commands

import cqrs.ecommerce.api.application.order.commandhandlers.commands.AddProductCommand
import cqrs.ecommerce.api.web.models.AddProductRequest
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class AddProductController(val commandGateway: CommandGateway) {
    @PatchMapping("/orders/{orderId}/products")
    @ResponseStatus(HttpStatus.OK)
    fun add(@PathVariable("orderId") orderId: String, @RequestBody request: AddProductRequest) {
        val command = AddProductCommand(UUID.fromString(orderId),
                UUID.fromString(request.productId),
                request.quantity)

        commandGateway.sendAndWait<UUID>(command)
    }
}