package cqrs.ecommerce.api.web.stubs

import com.github.javafaker.Faker
import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.domain.order.customer.Customer

class CreateCustomerStub {

    companion object {
        fun random(name: String = Faker().name().fullName(),
                   address: Address = Address(
                           IdStub.random(),
                           Faker().address().streetName(),
                           Faker().address().streetAddressNumber().toInt(),
                           Faker().address().cityName(),
                           Faker().address().country())) =
                Customer(IdStub.random(), name, address)
    }

}