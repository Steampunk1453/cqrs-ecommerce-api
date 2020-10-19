package cqrs.ecommerce.api.domain.order.customer

import java.util.UUID

interface AddressRepository {
    fun save(address: Address)
    fun findAddressById(addressId: UUID): Address
}