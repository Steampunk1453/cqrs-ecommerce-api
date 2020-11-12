package cqrs.ecommerce.api.application.order.queries

import java.util.UUID

data class FindOrderQuery (val orderId: UUID)