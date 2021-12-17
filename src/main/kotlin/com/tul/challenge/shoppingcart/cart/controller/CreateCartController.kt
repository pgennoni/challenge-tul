package com.tul.challenge.shoppingcart.cart.controller

import com.tul.challenge.shoppingcart.cart.controller.dtos.CartRequestDTO
import com.tul.challenge.shoppingcart.cart.domain.Cart
import com.tul.challenge.shoppingcart.cart.enums.State
import com.tul.challenge.shoppingcart.cart.services.CreateCartService
import com.tul.challenge.shoppingcart.products.controller.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class CreateCartController(private val cartService: CreateCartService): AbstractCartController() {
    @PutMapping
    fun create(@Validated @RequestBody cart: CartRequestDTO): ResponseEntity<Cart> {
        val cartResponse:Cart = cartService.invoke(cart)
        return ResponseEntity(cartResponse, HttpStatus.OK)
    }
}

