package cqrs.ecommerce.api.web.models

data class CreateCustomerRequest(val name: String = "", val address: AddressRequest)