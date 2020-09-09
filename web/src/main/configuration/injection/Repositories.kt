package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import cqrs.ecommerce.api.domain.order.product.ProductRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.JpaOrderRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.SpringDataOrderRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.customer.JpaAddressRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.customer.JpaCustomerRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.customer.SpringDataAddressRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.customer.SpringDataCustomerRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.product.JpaProductRepository
import cqrs.ecommerce.api.infrastructure.repositories.order.product.SpringDataProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Repositories {

    @Autowired
    lateinit var springDataOrderRepository: SpringDataOrderRepository

    @Autowired
    lateinit var springDataProductRepository: SpringDataProductRepository

    @Autowired
    lateinit var springDataCustomerRepository: SpringDataCustomerRepository

    @Autowired
    lateinit var springDataAddressRepository: SpringDataAddressRepository

    @Bean
    fun getOrderRepository() : OrderRepository {
        return JpaOrderRepository(springDataOrderRepository)
    }

    @Bean
    fun getProductRepository() : ProductRepository {
        return JpaProductRepository(springDataProductRepository)
    }

    @Bean
    fun getCustomerRepository() : CustomerRepository {
        return JpaCustomerRepository(springDataCustomerRepository)
    }

    @Bean
    fun getAddressRepository() : AddressRepository {
        return JpaAddressRepository(springDataAddressRepository)
    }

}
