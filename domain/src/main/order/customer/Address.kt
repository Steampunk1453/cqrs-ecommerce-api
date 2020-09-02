package cqrs.ecommerce.api.domain.order.customer

import java.util.UUID

data class Address(val id: UUID, val street: String, val number: Int, val state: String, val country: String)