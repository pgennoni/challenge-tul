package com.tul.challenge.shoppingcart.cart.controller

import com.tul.challenge.shoppingcart.cart.domain.Cart
import com.tul.challenge.shoppingcart.cart.services.GetCartService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetCartController(private val getCartService: GetCartService): AbstractCartController() {
    @GetMapping("/{id}")
    fun execute(@Validated @PathVariable id: String):Cart = getCartService.getCartDTO(id)
}
