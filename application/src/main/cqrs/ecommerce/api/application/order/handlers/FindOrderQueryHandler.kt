package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.queries.FindOrderQuery
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.queryhandling.QueryHandler

open class FindOrderQueryHandler(private val orderRepository: OrderRepository) {

    @QueryHandler
    fun handle(query: FindOrderQuery): Order {
        return orderRepository.findById(query.orderId).also { it.guardOrderExists(it.id, it) }
    }

}

