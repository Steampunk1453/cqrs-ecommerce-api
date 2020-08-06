package cqrs.ecommerce.api.domain.order.payment

interface PaymentService {
    fun debitValueByCreditCard(creditCard: CreditCard) : Boolean
}