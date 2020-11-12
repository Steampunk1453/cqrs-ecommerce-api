package cqrs.ecommerce.api.application.order.handlers

import cqrs.ecommerce.api.application.order.queries.FindOrdersPerCustomerQuery
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import org.axonframework.queryhandling.QueryHandler

open class FindOrdersPerCustomerQueryHandler(private val orderRepository: OrderRepository) {

    @QueryHandler
    fun handle(query: FindOrdersPerCustomerQuery): List<Order> {
        return orderRepository.findAllOrders()
        }

}

