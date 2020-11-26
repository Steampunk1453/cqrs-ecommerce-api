package cqrs.ecommerce.api.web.rest.queries

import cqrs.ecommerce.api.application.order.queries.FindLastOrdersQuery
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.web.rest.mappers.LastOrdersMapper
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FindLastOrdersController(val queryGateway: QueryGateway,
                               val lastOrdersMapper: LastOrdersMapper) {

    @GetMapping("/orders", params = ["last_orders"])
    fun find(@RequestParam(value = "last_orders") lastOrders: Int) : List<Any> {
        val query = FindLastOrdersQuery(lastOrders)
        val orders = queryGateway.query(query, ResponseTypes.multipleInstancesOf(Order::class.java)).get()
        return lastOrdersMapper.map(orders)
    }

}