package cqrs.ecommerce.api.web.stubs

import cqrs.ecommerce.api.application.order.commands.CreateCustomerCommand


class CreateCustomerCommandStub {
    companion object {
        fun random() = CreateCustomerCommand(CreateCustomerStub.random())
    }
}