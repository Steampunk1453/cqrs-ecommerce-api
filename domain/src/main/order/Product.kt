package cqrs.ecommerce.api.domain.order

import javax.money.MonetaryAmount
import java.util.UUID

data class Product(val id: UUID, val description: String, val value: MonetaryAmount)
