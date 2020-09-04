package cqrs.ecommerce.api.application.order.commands

import cqrs.ecommerce.api.domain.order.customer.Address

data class CreateCustomerCommand(val name :String, val address: Address)