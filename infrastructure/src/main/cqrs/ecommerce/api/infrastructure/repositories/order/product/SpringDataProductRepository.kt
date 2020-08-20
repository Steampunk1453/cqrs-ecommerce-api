package cqrs.ecommerce.api.infrastructure.repositories.order.product

import cqrs.ecommerce.api.infrastructure.entities.order.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataProductRepository : JpaRepository<ProductEntity, UUID>