package com.tul.challenge.shoppingcart.cart.mappers

import com.tul.challenge.shoppingcart.cart.domain.Item
import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import java.util.*

object ProductsCartToItemMapper {
    fun map(productCart: CartProductEntity): Item {
        return Item(UUID.fromString(productCart.product.id), UUID.fromString(productCart.product.sku), productCart.product.cost, productCart.quantity, productCart.product.name, productCart.product.description, productCart.product.discount)
    }
}