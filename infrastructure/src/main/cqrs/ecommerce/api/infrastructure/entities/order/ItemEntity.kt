package cqrs.ecommerce.api.infrastructure.entities.order

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "item")
class ItemEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        @ManyToOne
        val product: ProductEntity,
        val quantity: Int
)