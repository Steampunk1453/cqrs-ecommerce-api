package cqrs.ecommerce.api.domain.order.customer

import java.util.UUID

interface CustomerRepository {
    fun findCustomerById(customerId: UUID): Customer
}