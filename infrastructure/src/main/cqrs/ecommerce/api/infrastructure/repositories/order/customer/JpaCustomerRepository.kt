package cqrs.ecommerce.api.infrastructure.repositories.order.customer

import cqrs.ecommerce.api.domain.order.customer.Customer
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toDomain
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toEntity
import java.util.UUID

class JpaCustomerRepository(private val customerRepository: SpringDataCustomerRepository) : CustomerRepository {

    override fun findCustomerById(customerId: UUID): Customer {
        return customerRepository.findById(customerId).orElse(null).toDomain()
    }

    override fun save(customer: Customer) {
        customerRepository.save(customer.toEntity())
    }

}