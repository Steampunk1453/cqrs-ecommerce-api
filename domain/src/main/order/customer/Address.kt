package cqrs.ecommerce.api.domain.order.customer

data class Address(val street: String, val number: Int, val state: String, val country: String)