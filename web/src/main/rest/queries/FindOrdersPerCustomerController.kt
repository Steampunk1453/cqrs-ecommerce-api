package cqrs.ecommerce.api.web.rest.queries

import cqrs.ecommerce.api.application.order.queries.FindOrdersPerCustomerQuery
import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.web.rest.mappers.OrderPerCustomerMapper
import cqrs.ecommerce.api.web.rest.models.dtos.OrderPerCustomerDTO
import org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindOrdersPerCustomerController(val queryGateway: QueryGateway,
                                      val orderPerCustomerMapper: OrderPerCustomerMapper) {

    @GetMapping("/orders/perCustomer")
    fun find(): List<OrderPerCustomerDTO>{
        val orders = queryGateway.query(FindOrdersPerCustomerQuery(""), multipleInstancesOf(Order::class.java)).get()
        return orderPerCustomerMapper.map(orders)
    }

}