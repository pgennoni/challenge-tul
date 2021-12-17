package com.tul.challenge.shoppingcart.cart.mappers

import com.tul.challenge.shoppingcart.cart.domain.Item
import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import java.util.*

object ItemListFillerFromProductsCart {
    fun fill(productsCart: List<CartProductEntity>): MutableList<Item> {
        var itemList:MutableList<Item> = ArrayList()
        for(product in productsCart) {
            itemList.add(ProductsCartToItemMapper.map(product))
        }
        return itemList
    }
}