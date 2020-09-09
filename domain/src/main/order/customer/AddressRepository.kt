package cqrs.ecommerce.api.domain.order.customer

import java.util.UUID

interface AddressRepository {
    fun findAddressById(addressId: UUID): Address
    fun save(address: Address)
}