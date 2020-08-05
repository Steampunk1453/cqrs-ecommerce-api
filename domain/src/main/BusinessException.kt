package cqrs.ecommerce.api.domain

data class BusinessException(override var message: String): Exception(message)