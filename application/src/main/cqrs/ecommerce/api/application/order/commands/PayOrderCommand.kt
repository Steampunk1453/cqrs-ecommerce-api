package cqrs.ecommerce.api.application.order.commands

import cqrs.ecommerce.api.domain.order.payment.CreditCard
import java.util.UUID

data class PayOrderCommand(val orderId: UUID, val creditCard: CreditCard)