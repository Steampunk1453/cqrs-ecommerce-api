package cqrs.ecommerce.api.web.integration.rest

import cqrs.ecommerce.api.web.ContextStarterTest
import cqrs.ecommerce.api.web.stubs.CreateCustomerRequestStub
import io.kotlintest.shouldBe
import org.axonframework.commandhandling.gateway.CommandGateway
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import java.util.UUID

class CreateCustomerControllerTest(@Autowired  private val restTemplate: TestRestTemplate) : ContextStarterTest()  {

    @Test
    @DirtiesContext
    fun `POST should create a customer`() {
        val customerRequest = CreateCustomerRequestStub.random()

        val response = this.restTemplate.postForEntity(
                "/customers",
                customerRequest,
                String::class.java,
                emptyMap<String, String>()
        )

        response.statusCode shouldBe HttpStatus.CREATED
    }

    @Test
    @DirtiesContext
    fun `POST should returns 415 if the json body isn't expected`() {
        val entity = HttpEntity("")

        val response = this.restTemplate.exchange(
                "/customers",
                HttpMethod.POST,
                entity,
                String::class.java
        )

        response.statusCode shouldBe HttpStatus.UNSUPPORTED_MEDIA_TYPE
    }

}