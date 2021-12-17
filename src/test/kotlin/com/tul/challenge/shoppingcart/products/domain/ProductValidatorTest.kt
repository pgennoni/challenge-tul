package com.tul.challenge.shoppingcart.products.domain

import com.tul.challenge.shoppingcart.products.controller.Product
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class ProductValidatorTest {
    @Test
    fun `should validate ok`() {
        val product = Product(UUID.randomUUID(), UUID.randomUUID(), "Caja de madera con muchas cosas", "Caja de madera", 1000.00F, false, false)
        ProductValidator.validate(product)
    }

    @Test
    fun `should validate description`() {
        val product = Product(UUID.randomUUID(), UUID.randomUUID(), "", "Caja de madera", 1000.00F, false, false)
        try {
            ProductValidator.validate(product)
        } catch(e: DescriptionNotValidException) {
            assertNotNull(e)
        }
    }
    @Test
    fun `should validate name`() {
        val product = Product(UUID.randomUUID(), UUID.randomUUID(), "Caja de madera con muchas cosas", "", 1000.00F, false, false)
        try {
            ProductValidator.validate(product)
        } catch(e: NameNotValidException) {
            assertNotNull(e)
        }
    }
    @Test
    fun `should validate amount`() {
        val product = Product(UUID.randomUUID(), UUID.randomUUID(), "Caja de madera con muchas cosas", "Caja", 220.00F, false, false)
        try {
            ProductValidator.validate(product)
        } catch(e: CostNotValidException) {
            assertNotNull(e)
        }
    }
}