package cqrs.ecommerce.api.web.rest.models.requests

data class AddProductRequest(val productId: String = "", val quantity: Int = 0)