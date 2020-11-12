package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.application.order.handlers.FindLastOrdersQueryHandler
import cqrs.ecommerce.api.application.order.handlers.FindOrderQueryHandler
import cqrs.ecommerce.api.application.order.handlers.FindOrdersPerCustomerQueryHandler
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryHandlers {

    @Autowired
    lateinit var orderRepository: OrderRepository

    @Bean
    fun getFindOrderQueryHandler(): FindOrderQueryHandler {
        return FindOrderQueryHandler(orderRepository)
    }

    @Bean
    fun getFindOrdersPerCustomerQueryHandler(): FindOrdersPerCustomerQueryHandler {
        return FindOrdersPerCustomerQueryHandler(orderRepository)
    }

    @Bean
    fun getFindLastOrdersQueryHandler(): FindLastOrdersQueryHandler {
        return FindLastOrdersQueryHandler(orderRepository)
    }

}