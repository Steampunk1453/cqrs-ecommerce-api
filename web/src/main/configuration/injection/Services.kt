package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.domain.shipping.ShippingService
import cqrs.ecommerce.api.infrastructure.services.EmailNotificationService
import cqrs.ecommerce.api.infrastructure.services.FedExDeliveryService
import cqrs.ecommerce.api.infrastructure.services.PaymentServiceImpl
import cqrs.ecommerce.api.web.rest.mappers.LastOrdersMapper
import cqrs.ecommerce.api.web.rest.mappers.OrderPerCustomerMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Services {
    @Bean
    fun getPaymentService(): PaymentServiceImpl {
        return PaymentServiceImpl()
    }

    @Bean
    fun getFedExDeliveryService(): FedExDeliveryService {
        return FedExDeliveryService()
    }

    @Bean
    fun getEmailNotificationService(): EmailNotificationService {
        return EmailNotificationService()
    }

    @Bean
    fun getShippingService(): ShippingService {
        return ShippingService(getEmailNotificationService(), getFedExDeliveryService())
    }

    @Bean
    fun getOrderPerCustomerMapper(): OrderPerCustomerMapper {
        return OrderPerCustomerMapper()
    }

    @Bean
    fun getLastOrdersMapper(): LastOrdersMapper {
        return LastOrdersMapper()
    }
}