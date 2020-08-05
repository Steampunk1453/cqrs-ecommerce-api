package cqrs.ecommerce.api.application.order.commands

import java.util.UUID

data class CreateOrderCommand(val customerId: UUID)