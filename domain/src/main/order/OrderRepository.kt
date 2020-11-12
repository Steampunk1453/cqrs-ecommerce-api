package cqrs.ecommerce.api.domain.order

import java.util.UUID

interface OrderRepository {
    fun findAll(): List<Order>
    fun findById(id: UUID): Order
    fun findOrdersByCustomer(customer: String): List<Order>
    fun save(order: Order)
}