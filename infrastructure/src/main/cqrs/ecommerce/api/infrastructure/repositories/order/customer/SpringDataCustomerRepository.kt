package cqrs.ecommerce.api.infrastructure.repositories.order.customer

import cqrs.ecommerce.api.infrastructure.entities.order.customer.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SpringDataCustomerRepository : JpaRepository<CustomerEntity, UUID>