package cqrs.ecommerce.api.infrastructure.entities.order.customer

import cqrs.ecommerce.api.domain.order.customer.Customer
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

fun Customer.toEntity(): CustomerEntity = CustomerEntity(id, name, address.toEntity())

fun CustomerEntity.toDomain(): Customer =  Customer(id, name, address.toDomain())