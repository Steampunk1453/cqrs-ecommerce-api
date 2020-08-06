package cqrs.ecommerce.api.web.configuration.injection

import cqrs.ecommerce.api.application.shipping.eventhandlers.ShipOrderAndNotifyUser
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.shipping.ShippingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventHandlers {
    @Autowired
    lateinit var orderRepository: OrderRepository

    @Autowired
    lateinit var shippingService: ShippingService

    @Bean
    fun getShipPaidProductAndNotifyUserEventHandler(): ShipOrderAndNotifyUser {
        return ShipOrderAndNotifyUser(orderRepository, shippingService)
    }
}