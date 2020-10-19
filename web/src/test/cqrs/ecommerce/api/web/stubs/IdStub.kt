package cqrs.ecommerce.api.web.stubs

import java.util.UUID

class IdStub {
    companion object {
        fun random(): UUID = UUID.randomUUID()
    }
}