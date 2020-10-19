package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.CreateCustomerCommand
import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import org.axonframework.commandhandling.CommandHandler
import java.util.UUID

open class CreateCustomerCommandHandler(private val customerRepository: CustomerRepository,
                                        private val addressRepository: AddressRepository) {

    @CommandHandler
    fun handle(command: CreateCustomerCommand): UUID {
        addressRepository.save(command.customer.address)
        customerRepository.save(command.customer)

        return command.customer.id
    }

}

