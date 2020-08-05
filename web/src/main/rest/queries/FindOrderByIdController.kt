package cqrs.ecommerce.api.web.rest.queries

import cqrs.ecommerce.api.infrastructure.queries.OrdersQuery
import cqrs.ecommerce.api.infrastructure.queries.dtos.OrderDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class FindOrderByIdController() {
    @GetMapping("/orders/{orderId}")
    fun find(@PathVariable("orderId") orderId: String): OrderDTO {
        return OrdersQuery.findOrderById(UUID.fromString(orderId))
    }
}