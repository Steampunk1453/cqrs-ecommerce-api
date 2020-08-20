package cqrs.ecommerce.api.infrastructure.entities.order

import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.infrastructure.entities.order.customer.CustomerEntity
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toDomain
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toEntity
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "order_table")
data class OrderEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        @ManyToOne
        val customer: CustomerEntity
)

fun Order.toEntity(): OrderEntity = OrderEntity(id, customer.toEntity())

fun OrderEntity.toDomain(): Order =  Order(id, customer.toDomain())
