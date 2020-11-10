package cqrs.ecommerce.api.infrastructure.entities.order

import cqrs.ecommerce.api.domain.order.Item
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.infrastructure.entities.order.customer.CustomerEntity
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toDomain
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toEntity
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "order_table")
data class OrderEntity(
        @Id
        val id: UUID,
        @ManyToOne
        val customer: CustomerEntity,
        @OneToMany(orphanRemoval = true, cascade = [CascadeType.ALL])
        val items: List<ItemEntity>,
        val paid: Boolean
)

fun Order.toEntity(): OrderEntity = OrderEntity(id, customer.toEntity(), items().map { it.toEntity() }, paid)

fun OrderEntity.toDomain(): Order{
        val order = Order(id, customer.toDomain())
        order.items = items.map { it.toDomain() } as MutableList<Item>
        return order
}


