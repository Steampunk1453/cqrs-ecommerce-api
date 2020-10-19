package cqrs.ecommerce.api.web.stubs

import cqrs.ecommerce.api.domain.order.customer.Address

import com.github.javafaker.Faker
import cqrs.ecommerce.api.application.order.commands.CreateCustomerCommand
import cqrs.ecommerce.api.domain.order.customer.Customer
import org.springframework.data.jpa.domain.AbstractPersistable_.id

class CreateCustomerCommandStub {
    companion object {
        fun random() = CreateCustomerCommand(CreateCustomerStub.random())
    }
}