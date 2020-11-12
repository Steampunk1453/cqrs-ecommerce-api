package cqrs.ecommerce.api.web.rest.mappers

import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.web.rest.models.dtos.LastOrderDTO
import cqrs.ecommerce.api.web.rest.models.dtos.OrderPerCustomerDTO

class LastOrdersMapper {

    fun map(orders: List<Order>): List<LastOrderDTO> {
        return orders.map { LastOrderDTO(it.id, it.customer.name) }
    }

}