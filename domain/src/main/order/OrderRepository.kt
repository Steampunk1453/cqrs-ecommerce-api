package cqrs.ecommerce.api.domain.order

import java.util.UUID

interface OrderRepository {
    fun findById(id: UUID): Order
    fun save(order: Order)
}