package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.domain.Cart
import com.tul.challenge.shoppingcart.cart.domain.CartNotFoundException
import com.tul.challenge.shoppingcart.cart.domain.Item
import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.repositories.CartRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetCartService(private val cartRepository: CartRepository, private val getProductsCartService: GetProductsCartService) {
    fun invoke(id: String): CartEntity = cartRepository.findByIdOrNull(id) ?: throw CartNotFoundException("Cart with id $id not found")

    fun getCartDTO(id: String):Cart {
        val cartEntity = invoke(id)
        val items = getProductsCartService.getProducts(id)
        return Cart(UUID.fromString(cartEntity.id), cartEntity.state, items)
    }


}