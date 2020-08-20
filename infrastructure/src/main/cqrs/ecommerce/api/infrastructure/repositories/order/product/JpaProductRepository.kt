package cqrs.ecommerce.api.infrastructure.repositories.order.product

import cqrs.ecommerce.api.domain.order.Product
import cqrs.ecommerce.api.domain.order.product.ProductRepository
import cqrs.ecommerce.api.infrastructure.entities.order.toDomain
import java.util.UUID

class JpaProductRepository(private val productRepository: SpringDataProductRepository) : ProductRepository {

    override fun findProductById(productId: UUID): Product {
        return productRepository.findById(productId).orElse(null).toDomain()
    }

}