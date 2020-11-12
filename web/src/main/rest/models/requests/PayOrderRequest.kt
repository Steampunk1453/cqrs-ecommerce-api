package cqrs.ecommerce.api.web.rest.models.requests

import java.util.Date

class PayOrderRequest(
        val cardName :String = "",
        val cardNumber :String = "",
        val expirationDate : Date? = null,
        val verificationCode :String = ""
)