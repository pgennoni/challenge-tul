package com.tul.challenge.shoppingcart.cart.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class ItemTest {
    @Test
    fun shouldCalculateATotalOfAnItem() {
        val item: Item = Item(UUID.randomUUID(), UUID.randomUUID(), 100.00F, 1, "Tornillos", "Tornillos cabeza redonda", true)
        val total = item.total
        assertEquals(50.00F, total)
    }

    @Test
    fun shouldFailCalculatingATotal() {
        val item: Item = Item(UUID.randomUUID(), UUID.randomUUID(),100.00F, 2, "Tornillos", "Tornillos cabeza redonda", true)
        val total = item.total

        assertNotEquals(total, 50.00F)
    }

}