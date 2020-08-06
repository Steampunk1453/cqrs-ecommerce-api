package cqrs.ecommerce.api.infrastructure.services

import cqrs.ecommerce.api.domain.order.payment.CreditCard
import cqrs.ecommerce.api.domain.order.payment.PaymentService

class PaymentServiceImpl : PaymentService {
    override fun debitValueByCreditCard(creditCard: CreditCard): Boolean {
        return true
    }
}