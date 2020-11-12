package cqrs.ecommerce.api.infrastructure.repositories.order

import cqrs.ecommerce.api.infrastructure.entities.order.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataOrderRepository : JpaRepository<OrderEntity, UUID> {
    fun findOrderEntitiesByCustomerName(customer: String): List<OrderEntity>
}

