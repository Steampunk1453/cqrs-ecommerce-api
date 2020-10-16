package cqrs.ecommerce.api.domain.order.customer

import java.util.UUID

interface CustomerRepository {
    fun save(customer: Customer)
    fun findCustomerById(customerId: UUID): Customer
}