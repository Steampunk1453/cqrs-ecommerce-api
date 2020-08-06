package cqrs.ecommerce.api.infrastructure.services

import cqrs.ecommerce.api.domain.order.customer.Customer
import cqrs.ecommerce.api.domain.shipping.NotificationService
import cqrs.ecommerce.api.domain.shipping.ShippingLabel
import java.util.UUID

class EmailNotificationService : NotificationService {
    override fun notifyCustomerOrderShipped(customer: Customer, id: UUID, shippingLabel: ShippingLabel) {
        // populate and send mail ...
    }
}