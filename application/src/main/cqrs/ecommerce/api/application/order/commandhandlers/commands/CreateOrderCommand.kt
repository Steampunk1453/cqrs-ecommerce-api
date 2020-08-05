package cqrs.ecommerce.api.application.order.commandhandlers.commands

import java.util.UUID

data class CreateOrderCommand(val customerId: UUID)