package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.queries.FindLastOrdersQuery
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.queryhandling.QueryHandler

open class FindLastOrdersQueryHandler(private val orderRepository: OrderRepository) {

    @QueryHandler
    fun handle(query: FindLastOrdersQuery): List<Order> {
        return orderRepository.findAll().takeLast(query.limit)
    }

}

