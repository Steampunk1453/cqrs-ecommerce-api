package cqrs.ecommerce.api.web.models

import cqrs.ecommerce.api.domain.order.customer.Address
import java.util.UUID

data class AddressRequest(
        val street: String,
        val number: Int,
        val town: String,
        val country: String
)

fun AddressRequest.toDomain(): Address = Address(
        id = UUID.randomUUID(),
        street = street,
        number = number,
        town = town,
        country = country
)