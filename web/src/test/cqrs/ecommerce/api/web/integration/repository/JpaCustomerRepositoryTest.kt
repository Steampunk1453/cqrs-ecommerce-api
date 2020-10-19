package cqrs.ecommerce.api.web.integration.repository

import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.domain.order.customer.Customer
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import cqrs.ecommerce.api.web.ContextStarterTest
import cqrs.ecommerce.api.web.stubs.CreateCustomerStub
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.DirtiesContext

class JpaCustomerRepositoryTest(@Autowired private val customerRepository: CustomerRepository,
                                @Autowired private val addressRepository: AddressRepository) : ContextStarterTest() {

    @Test
    @DirtiesContext
    fun `should save customer`() {
        val customer = CreateCustomerStub.random()
        save(customer)
    }

    @Test
    @DirtiesContext
    fun `should find customer by id`() {
        val customer = CreateCustomerStub.random()
        save(customer)

        val result = customer.id.let { customerRepository.findCustomerById(it) }

        result shouldNotBe {null}
        result shouldBe customer
        result.id shouldBe customer.id
        result.name shouldBe customer.name
        result.address shouldBe customer.address
        result.address.id shouldBe customer.address.id
        result.address.country shouldBe customer.address.country
        result.address.number shouldBe customer.address.number
        result.address.street shouldBe customer.address.street
        result.address.town shouldBe customer.address.town
    }

    private fun save(customer: Customer) {
        addressRepository.save(customer.address)
        customerRepository.save(customer)
    }

}