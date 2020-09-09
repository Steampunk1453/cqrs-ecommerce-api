package cqrs.ecommerce.api.web.models

import com.fasterxml.jackson.annotation.JsonProperty
import cqrs.ecommerce.api.domain.order.customer.Address

data class AddressRequest(
        @JsonProperty("street") val street: String,
        @JsonProperty("number") val number: Int,
        @JsonProperty("town") val town: String,
        @JsonProperty("country") val country: String
)

fun AddressRequest.toDomain(): Address = Address(
        id = null,
        street = street,
        number = number,
        town = town,
        country = country
)