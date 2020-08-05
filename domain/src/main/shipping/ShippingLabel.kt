package cqrs.ecommerce.api.domain.shipping

import java.util.Date

data class ShippingLabel(val number: String, val estimatedArrival: Date)