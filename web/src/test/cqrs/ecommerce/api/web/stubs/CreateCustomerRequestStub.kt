package cqrs.ecommerce.api.web.stubs

import com.github.javafaker.Faker
import cqrs.ecommerce.api.web.models.AddressRequest
import cqrs.ecommerce.api.web.models.CreateCustomerRequest

class CreateCustomerRequestStub {

    companion object {
        fun random(name: String = Faker().name().fullName(),
                   address: AddressRequest = AddressRequest(
                           Faker().address().streetName(),
                           Faker().address().streetAddressNumber().toInt(),
                           Faker().address().cityName(),
                           Faker().address().country())) =
                CreateCustomerRequest(name, address)
    }

}