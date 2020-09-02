package cqrs.ecommerce.api.domain.order.product

import cqrs.ecommerce.api.domain.order.Product
import cqrs.ecommerce.api.domain.order.customer.Customer
import java.util.UUID

interface ProductRepository {
    fun findProductById(productId: UUID): Product
}