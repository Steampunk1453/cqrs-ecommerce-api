package cqrs.ecommerce.api.domain.order

import cqrs.ecommerce.api.domain.order.customer.Customer
import java.util.UUID

interface OrderRepository {
    fun findById(id: UUID) : Order
    fun findProductById(productId: UUID): Product
    fun findCustomerById(customerId: UUID): Customer
    fun save(order: Order)
}