package cqrs.ecommerce.api.web.rest.queries

import cqrs.ecommerce.api.infrastructure.queries.OrdersQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindLastOrdersController() {
    @GetMapping("/orders", params = ["last_orders"])
    fun find() : List<Any> {
        return OrdersQuery.findLastOrders()
    }
}