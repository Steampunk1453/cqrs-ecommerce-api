package cqrs.ecommerce.api.application.order.queries

data class FindOrdersPerCustomerQuery (val customer: String)