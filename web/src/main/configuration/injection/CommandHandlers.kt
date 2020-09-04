package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.application.order.handlers.AddProductCommandHandler
import cqrs.ecommerce.api.application.order.handlers.ChangeProductQuantityCommandHandler
import cqrs.ecommerce.api.application.order.handlers.CreateCustomerCommandHandler
import cqrs.ecommerce.api.application.order.handlers.CreateOrderCommandHandler
import cqrs.ecommerce.api.application.order.handlers.PayOrderCommandHandler
import cqrs.ecommerce.api.application.order.handlers.RemoveProductCommandHandler
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import cqrs.ecommerce.api.domain.order.payment.PaymentService
import cqrs.ecommerce.api.domain.order.product.ProductRepository
import org.axonframework.eventhandling.EventBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CommandHandlers {
    @Autowired
    lateinit var orderRepository: OrderRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var paymentService: PaymentService

    @Autowired
    lateinit var eventBus: EventBus

    @Bean
    fun getCreateOrderCommandHandler(): CreateOrderCommandHandler {
        return CreateOrderCommandHandler(orderRepository, customerRepository)
    }

    @Bean
    fun getAddProductCommandHandler(): AddProductCommandHandler {
        return AddProductCommandHandler(orderRepository, productRepository)
    }

    @Bean
    fun getChangeProductQuantityCommandHandler(): ChangeProductQuantityCommandHandler {
        return ChangeProductQuantityCommandHandler(orderRepository, productRepository)
    }

    @Bean
    fun getRemoveProductCommandHandler(): RemoveProductCommandHandler {
        return RemoveProductCommandHandler(orderRepository, productRepository)
    }

    @Bean
    fun getPayOrderCommandHandler(): PayOrderCommandHandler {
        return PayOrderCommandHandler(orderRepository, paymentService, eventBus)
    }

    @Bean
    fun getCreatCustomerCommandHandler(): CreateCustomerCommandHandler {
        return CreateCustomerCommandHandler(customerRepository)
    }

}