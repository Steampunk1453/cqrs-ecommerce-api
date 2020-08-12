package cqrs.ecommerce.api.infrastructure.entities.order.customer

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "customer")
data class CustomerEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        val name: String,
        @ManyToOne
        val address: AddressEntity
)
