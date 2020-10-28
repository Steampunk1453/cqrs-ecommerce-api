package cqrs.ecommerce.api.infrastructure.queries.dtos

import cqrs.ecommerce.api.domain.order.Item
import cqrs.ecommerce.api.domain.order.Order
import java.util.UUID

data class OrderDTO(val id: UUID, val items: List<ItemDTO>)

data class ItemDTO(val description: String, val quantity: Int, val value: Double)

fun Order.toDto(): OrderDTO = OrderDTO(id, items().map { it.toDto() })

fun Item.toDto(): ItemDTO = ItemDTO(product.description, 1, product.value.number.toDouble())

