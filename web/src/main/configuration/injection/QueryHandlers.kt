package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.application.order.handlers.AddProductCommandHandler
import cqrs.ecommerce.api.application.order.handlers.ChangeProductQuantityCommandHandler
import cqrs.ecommerce.api.application.order.handlers.CreateCustomerCommandHandler
import cqrs.ecommerce.api.application.order.handlers.CreateOrderCommandHandler
import cqrs.ecommerce.api.application.order.handlers.FindOrderQueryHandler
import cqrs.ecommerce.api.application.order.handlers.PayOrderCommandHandler
import cqrs.ecommerce.api.application.order.handlers.RemoveProductCommandHandler
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import cqrs.ecommerce.api.domain.order.payment.PaymentService
import cqrs.ecommerce.api.domain.order.product.ProductRepository
import org.axonframework.eventhandling.EventBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryHandlers {

    @Autowired
    lateinit var orderRepository: OrderRepository

    @Bean
    fun geFindOrderQueryHandler(): FindOrderQueryHandler {
        return FindOrderQueryHandler(orderRepository)
    }

}