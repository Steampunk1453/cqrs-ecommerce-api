package cqrs.ecommerce.api.domain.order

import java.util.UUID

data class OrderPaid(val orderId: UUID)