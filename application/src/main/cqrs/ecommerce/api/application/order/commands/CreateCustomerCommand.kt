package cqrs.ecommerce.api.application.order.commands

import cqrs.ecommerce.api.domain.order.customer.Customer

data class CreateCustomerCommand(val customer: Customer)