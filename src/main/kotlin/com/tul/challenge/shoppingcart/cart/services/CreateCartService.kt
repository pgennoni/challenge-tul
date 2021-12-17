package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.controller.dtos.CartRequestDTO
import com.tul.challenge.shoppingcart.cart.domain.Cart
import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.enums.State
import com.tul.challenge.shoppingcart.cart.repositories.CartRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateCartService(private val cartRepository: CartRepository) {
    fun invoke(cart: CartRequestDTO): Cart {
        val cartEntity = CartEntity(cart.id.toString(), State.PENDING)
        cartRepository.save(cartEntity)
        return Cart(cart.id, State.PENDING, ArrayList())

    }
}