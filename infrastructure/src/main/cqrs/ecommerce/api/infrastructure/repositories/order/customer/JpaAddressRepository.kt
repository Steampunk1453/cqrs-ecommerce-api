package cqrs.ecommerce.api.infrastructure.repositories.order.customer

import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toDomain
import cqrs.ecommerce.api.infrastructure.entities.order.customer.toEntity
import java.util.UUID

class JpaAddressRepository(private val addressRepository: SpringDataAddressRepository) : AddressRepository {

    override fun findAddressById(addressId: UUID): Address {
        return addressRepository.findById(addressId).orElse(null).toDomain()
    }

    override fun save(address: Address) {
        val addressEntity = address.toEntity()
        addressRepository.save(addressEntity)
    }

}