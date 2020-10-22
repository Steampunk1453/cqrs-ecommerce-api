package cqrs.ecommerce.api.web.handler

import cqrs.ecommerce.api.application.order.handlers.CreateCustomerCommandHandler
import cqrs.ecommerce.api.domain.order.customer.AddressRepository
import cqrs.ecommerce.api.domain.order.customer.CustomerRepository
import cqrs.ecommerce.api.web.stubs.CreateCustomerCommandStub
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.verify
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class CreateCustomerCommandHandlerTest {

    @MockK
    private lateinit var customerRepository: CustomerRepository

    @MockK
    private lateinit var addressRepository: AddressRepository

    @InjectMockKs
    private lateinit var handler: CreateCustomerCommandHandler

    @Test
    fun `should create a new customer and returns not null value`() {
        val createCustomerCommand = CreateCustomerCommandStub.random()
        every { addressRepository.save(any()) } just Runs
        every { customerRepository.save(any()) } just Runs

        handler = CreateCustomerCommandHandler(customerRepository, addressRepository)

        val result = handler.handle(createCustomerCommand)

        verify(atLeast = 1) { addressRepository.save(any()) }
        verify(atLeast = 1) { customerRepository.save(any()) }

        assertThat(result, `is`(not(nullValue())))
    }

}