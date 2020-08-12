package cqrs.ecommerce.api.infrastructure.entities.order

import cqrs.ecommerce.api.infrastructure.entities.order.customer.CustomerEntity
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "order")
class OrderEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        @ManyToOne
        val customer: CustomerEntity) {


}
