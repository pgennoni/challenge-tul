package com.tul.challenge.shoppingcart.cart.repositories

import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<CartEntity, String> {

}