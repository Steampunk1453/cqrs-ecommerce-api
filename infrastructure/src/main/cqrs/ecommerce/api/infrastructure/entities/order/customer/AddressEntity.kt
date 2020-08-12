package cqrs.ecommerce.api.infrastructure.entities.order.customer

import cqrs.ecommerce.api.domain.order.customer.Address
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "address")
data class AddressEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: UUID,
        val street: String,
        val number: Int,
        val state: String,
        val country: String
)

fun Address.toEntity(): AddressEntity = AddressEntity(id, street, number, state, country)

fun AddressEntity.toDomain(): Address = Address(id, street, number, state, country)

