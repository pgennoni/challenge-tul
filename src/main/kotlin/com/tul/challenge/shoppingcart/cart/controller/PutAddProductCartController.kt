package com.tul.challenge.shoppingcart.cart.controller

import com.tul.challenge.shoppingcart.cart.domain.EmptyRequestIdException
import com.tul.challenge.shoppingcart.cart.domain.IDNotValidException
import com.tul.challenge.shoppingcart.cart.services.AddProductCartService
import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.shared.validators.IdValidator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class PutAddProductCartController(private val addProductCartService: AddProductCartService): AbstractCartController() {
    @PutMapping("/{cartId}/products")
    fun addProduct(@Validated @PathVariable cartId: String, @Validated @RequestBody product: Product): ResponseEntity<HttpStatus>{
        IdValidator.validateId(cartId)
        addProductCartService.invoke(cartId, product)
        return ResponseEntity(HttpStatus.CREATED)
    }

}