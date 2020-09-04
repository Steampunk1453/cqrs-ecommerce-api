package cqrs.ecommerce.api.web.rest.commands

import cqrs.ecommerce.api.application.order.commands.CreateCustomerCommand
import cqrs.ecommerce.api.application.order.commands.CreateOrderCommand
import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.web.models.CreateCustomerRequest
import cqrs.ecommerce.api.web.models.CreateOrderRequest
import cqrs.ecommerce.api.web.models.toDomain
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CreateCustomerController(val commandGateway: CommandGateway) {

    @PostMapping("/customers")
    fun create(@RequestBody request: CreateCustomerRequest): ResponseEntity<UUID> {
        val command = CreateCustomerCommand(request.name, request.address.toDomain())
        val customerId = commandGateway.sendAndWait<UUID>(command)

        return ResponseEntity(customerId, HttpStatus.CREATED)
    }

}