package cqrs.ecommerce.api.web.rest.queries

import cqrs.ecommerce.api.infrastructure.queries.OrdersQuery
import cqrs.ecommerce.api.infrastructure.queries.dtos.OrderPerUsersDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindOrdersPerUsersController() {
    @GetMapping("/orders", params = ["orders_per_users"])
    fun find() : List<OrderPerUsersDTO>{
        return OrdersQuery.findOrderPerUsers()
    }
}