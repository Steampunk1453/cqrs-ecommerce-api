package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.infrastructure.repositories.OrderRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Repositories {
    @Bean
    fun getOrderRepository() : OrderRepository {
        return OrderRepositoryImpl()
    }
}
