package cqrs.ecommerce.api.domain.order.product

import java.util.UUID

interface ProductRepository {
    fun findProductById(productId: UUID): Product
}