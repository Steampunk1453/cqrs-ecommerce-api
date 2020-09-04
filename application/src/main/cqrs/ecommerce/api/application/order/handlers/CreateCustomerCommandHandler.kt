package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.commands.CreateCustomerCommand
import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.domain.order.customer.Customer
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import org.axonframework.commandhandling.CommandHandler
import java.util.UUID

open class CreateCustomerCommandHandler(private val customerRepository: CustomerRepository) {
    @CommandHandler
    fun handle(command: CreateCustomerCommand): UUID {
        val customerId = UUID.randomUUID()

        val customer = Customer(customerId, command.name,
                Address(command.address.id, command.address.street, command.address.number,
                        command.address.town,  command.address.country))
        customerRepository.save(customer)

        return customerId
    }
}

