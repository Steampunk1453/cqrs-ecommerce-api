package cqrs.ecommerce.api.web.rest.mappers

import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.web.rest.models.dtos.OrderPerCustomerDTO

class OrderPerCustomerMapper {

    fun map(orders: List<Order>): List<OrderPerCustomerDTO> {
        return orders.map {
            OrderPerCustomerDTO(it.customer.name,
                    orders.count { order -> order.customer.id == it.customer.id })
        }.distinctBy { it.customer }
    }

}