package cqrs.ecommerce.api.infrastructure.services

import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.shipping.DeliveryProviderService
import cqrs.ecommerce.api.domain.shipping.ShippingLabel
import java.util.Date

class FedExDeliveryService : DeliveryProviderService {
    override fun requestFastDelivery(order: Order): ShippingLabel {
        // call FedEx service...

        return ShippingLabel("ABCD-123456", Date())
    }

    override fun requestStandardDelivery(order: Order): ShippingLabel {
        // call FedEx service...

        return ShippingLabel("EFGH-456789", Date())
    }
}