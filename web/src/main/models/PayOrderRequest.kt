package cqrs.ecommerce.api.web.models

import java.util.Date

class PayOrderRequest(
        val cardName :String = "",
        val cardNumber :String = "",
        val expirationDate : Date? = null,
        val verificationCode :String = ""
)