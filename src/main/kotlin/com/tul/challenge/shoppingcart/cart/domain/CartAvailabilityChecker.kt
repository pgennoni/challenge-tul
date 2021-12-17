package com.tul.challenge.shoppingcart.cart.domain

import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.enums.State

object CartAvailabilityChecker {
    fun check(cart: CartEntity) {
        if(cart.state.equals(State.COMPLETED)) {
            throw CartCompletedException("The cart with id: ${cart.id} was completed, you can't add new products")
        }
    }
}