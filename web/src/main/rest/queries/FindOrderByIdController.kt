package cqrs.ecommerce.api.web.rest.queries

import cqrs.ecommerce.api.application.order.queries.FindOrderQuery
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.infrastructure.queries.dtos.OrderDTO
import cqrs.ecommerce.api.infrastructure.queries.dtos.toDto
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class FindOrderByIdController(val queryGateway: QueryGateway) {

    @GetMapping("/orders/{orderId}")
    fun find(@PathVariable("orderId") orderId: String): OrderDTO {
        val query = FindOrderQuery(UUID.fromString(orderId))
        return queryGateway.query(query, Order::class.java).get().toDto()
    }

}