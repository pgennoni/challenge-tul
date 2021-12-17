package com.tul.challenge.shoppingcart.cart.mappers

import com.tul.challenge.shoppingcart.cart.builders.ProductEntityBuilder
import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class ProductMapperTest {
    @Test
    fun `should map product from entity`() {
        val productEntity = ProductEntityBuilder.cost(15533F).description("Que grande esta tarjeta").build()
        val product = ProductMapper.fromEntity(productEntity)
        assertNotNull(product)
    }
    @Test
    fun `should map product from DTO`() {
        val product = Product(UUID.randomUUID(), UUID.randomUUID(), "Caja de maderas con muchas maderas", "caja de maderas", 10000.00F, true, false)
        val productEntity = ProductMapper.toEntity(product)
        assertNotNull(productEntity)
    }
}