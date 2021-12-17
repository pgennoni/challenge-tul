package com.tul.challenge.shoppingcart.cart.domain

import com.tul.challenge.shoppingcart.cart.enums.State
import java.util.*

class Item(val id:UUID, val sku: UUID, val amount: Float, val quantity:Int, val name: String, val description: String, val discount: Boolean) {
var total:Float = 0.0F
    get() {
        if(discount == true) {
            field = ((amount * quantity) / 2)
        } else {
            field = amount * quantity
        }
        return field
    }
}

class Cart(val id: UUID, val status: State, val items: List<Item>) {
    var total:Float = 0.0F
    get() {
        for(item in items) {
            field += item.total
        }
        return field
    }
}