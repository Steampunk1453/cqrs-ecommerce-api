package cqrs.ecommerce.api.infrastructure.repositories.order

import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.infrastructure.entities.order.toDomain
import cqrs.ecommerce.api.infrastructure.entities.order.toEntity
import java.util.UUID

class JpaOrderRepository(private val orderRepository: SpringDataOrderRepository) : OrderRepository {

    override fun findAll(): List<Order> {
        return orderRepository.findAll().map { it.toDomain() }
    }

    override fun findById(id: UUID): Order {
        return orderRepository.findById(id).orElse(null).toDomain()
    }

    override fun findOrdersByCustomer(customer: String): List<Order> {
        return orderRepository.findOrderEntitiesByCustomerName(customer).map { it.toDomain() }
    }

    override fun save(order: Order) {
        orderRepository.save(order.toEntity())
    }

}