package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.domain.Cart
import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.enums.State
import com.tul.challenge.shoppingcart.cart.repositories.CartRepository
import org.springframework.stereotype.Service

@Service
class CheckoutCartService(private val getCartService: GetCartService, private val cartRepository: CartRepository) {
    fun invoke(cartId: String): Cart {
        val cart = getCartService.invoke(cartId)
        changeState(cart)
        return getCartService.getCartDTO(cartId)
    }

    fun changeState(cart: CartEntity) {
        cart.state = State.COMPLETED
        cartRepository.save(cart)
    }
}



