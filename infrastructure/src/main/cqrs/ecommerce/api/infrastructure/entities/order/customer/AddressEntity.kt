package cqrs.ecommerce.api.infrastructure.entities.order.customer

import cqrs.ecommerce.api.domain.order.customer.Address
import org.hibernate.annotations.DynamicUpdate
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "address")
@DynamicUpdate
data class AddressEntity(
        @Id
        val id: UUID,
        val street: String,
        val number: Int,
        val town: String,
        val country: String
)

fun Address.toEntity(): AddressEntity = AddressEntity(id, street, number, town, country)

fun AddressEntity.toDomain(): Address = Address(id, street, number, town, country)

