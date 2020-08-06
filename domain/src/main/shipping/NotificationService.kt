package cqrs.ecommerce.api.domain.shipping

import cqrs.ecommerce.api.domain.order.customer.Customer
import java.util.UUID

interface NotificationService {
    fun notifyCustomerOrderShipped(customer: Customer, id: UUID, shippingLabel: ShippingLabel)
}