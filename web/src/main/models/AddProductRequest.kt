package cqrs.ecommerce.api.web.models

data class AddProductRequest(val productId: String = "", val quantity: Int = 0)