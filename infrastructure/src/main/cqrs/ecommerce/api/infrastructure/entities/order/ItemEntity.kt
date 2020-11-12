package cqrs.ecommerce.api.infrastructure.entities.order

import cqrs.ecommerce.api.domain.order.Item
import java.util.UUID
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Embeddable
@Table(name = "item")
class ItemEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID?,
        @ManyToOne
        val product: ProductEntity,
        val quantity: Int
)

fun Item.toEntity(): ItemEntity = ItemEntity(null, product.toEntity(), quantity)

fun ItemEntity.toDomain(): Item = Item(product.toDomain(), quantity)