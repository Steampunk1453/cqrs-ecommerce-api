package cqrs.ecommerce.api.infrastructure.entities.order

import cqrs.ecommerce.api.domain.order.Product
import cqrs.ecommerce.api.domain.order.customer.Address
import cqrs.ecommerce.api.infrastructure.entities.order.customer.AddressEntity
import org.javamoney.moneta.Money
import javax.money.MonetaryAmount
import java.util.UUID
import javax.money.Monetary
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "product")
data class ProductEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        val description: String,
        val price: Double,
        val currency: String
)

fun Product.toEntity(): ProductEntity = ProductEntity(id, description, convertToPrince(value), convertToCurrency(value))

fun ProductEntity.toDomain(): Product = Product(id, description, convertToMonetaryAmount(price, currency))

fun convertToPrince(value: MonetaryAmount): Double = value.number.toDouble()

fun convertToCurrency(value: MonetaryAmount): String = value.currency.toString()

fun convertToMonetaryAmount(price: Double, currency: String): Money = Money.of(price, currency)