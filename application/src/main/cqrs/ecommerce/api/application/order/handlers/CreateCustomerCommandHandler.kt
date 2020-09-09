package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.CreateCustomerCommand
import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.domain.order.customer.Customer
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import org.axonframework.commandhandling.CommandHandler
import java.util.UUID

open class CreateCustomerCommandHandler(private val customerRepository: CustomerRepository,
                                        private val addressRepository: AddressRepository) {
    @CommandHandler
    fun handle(command: CreateCustomerCommand): UUID {
        val addressId  = UUID.randomUUID()
        val customerId = UUID.randomUUID()

        val address = Address(addressId, command.address.street, command.address.number,
                command.address.town,  command.address.country)
        addressRepository.save(address)

        val customer = Customer(customerId, command.name, address)
        customerRepository.save(customer)

        return customerId
    }
}

