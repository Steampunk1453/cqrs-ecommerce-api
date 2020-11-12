package cqrs.ecommerce.api.infrastructure.repositories.order

import cqrs.ecommerce.api.domain.order.Order
import cqrs.ecommerce.api.domain.order.OrderRepository
import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.domain.order.customer.Customer
import java.util.UUID

class DefaultOrderRepository : OrderRepository {
    private val fakeCustomer = Customer(UUID.randomUUID(), "John Doe",
            Address(UUID.fromString("c04ecc99-d7ba-460c-be78-6995805c5177"), "a",1, "c", "d"))

    override fun findAllOrders(): List<Order> {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Order {
        return Order(id = id,
                     customer = fakeCustomer)
    }

    override fun findOrdersByCustomer(customer: String): List<Order> {
        TODO("Not yet implemented")
    }

    override fun save(order: Order) {
        //TODO
    }
}
