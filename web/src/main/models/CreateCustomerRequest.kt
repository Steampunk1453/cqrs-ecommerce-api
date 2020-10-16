package cqrs.ecommerce.api.web.models

import cqrs.ecommerce.api.domain.order.customer.Customer
import java.util.UUID

data class CreateCustomerRequest(val name: String, val address: AddressRequest)

fun CreateCustomerRequest.toDomain(): Customer = Customer(
        id = UUID.randomUUID(),
        name = name,
        address.toDomain()
)