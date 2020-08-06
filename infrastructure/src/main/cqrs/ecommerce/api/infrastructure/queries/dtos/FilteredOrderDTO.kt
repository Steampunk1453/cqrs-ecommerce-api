package cqrs.ecommerce.api.infrastructure.queries.dtos

import java.util.UUID

data class OrderDTO(val id: UUID, val items: List<ItemDTO>)

data class ItemDTO(val description: String, val quantity: Int, val value: Double)

