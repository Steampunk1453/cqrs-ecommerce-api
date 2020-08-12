package cqrs.ecommerce.api.infrastructure.entities.order

import javax.money.MonetaryAmount
import java.util.UUID

data class ProductEntity(val id: UUID, val description: String, val value: MonetaryAmount)
