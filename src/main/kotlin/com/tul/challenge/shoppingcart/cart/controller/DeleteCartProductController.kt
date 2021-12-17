package com.tul.challenge.shoppingcart.cart.controller

import com.tul.challenge.shoppingcart.cart.services.DeleteCartProductService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteCartProductController(private val deleteCartProduct: DeleteCartProductService): AbstractCartController(){
    @DeleteMapping("/{cartId}/products/{productId}")
    fun execute(@Validated  @PathVariable cartId: String, @Validated @PathVariable productId: String) {
        deleteCartProduct.invoke(cartId, productId)
    }
}