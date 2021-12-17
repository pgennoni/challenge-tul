package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.controller.AbstractCartController
import com.tul.challenge.shoppingcart.cart.controller.dtos.CheckoutRequestDTO
import com.tul.challenge.shoppingcart.cart.controller.dtos.CheckoutResponseDTO
import com.tul.challenge.shoppingcart.cart.enums.State
import com.tul.challenge.shoppingcart.shared.validators.IdValidator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckoutController(private val checkoutCartService: CheckoutCartService): AbstractCartController() {
    @PatchMapping("/{id}")
    fun invoke(@Validated @PathVariable id: String, @Validated @RequestBody checkoutRequestDTO: CheckoutRequestDTO ): ResponseEntity<CheckoutResponseDTO>{
        IdValidator.validateId(id)
        val cart = checkoutCartService.invoke(id);
        return ResponseEntity<CheckoutResponseDTO>(CheckoutResponseDTO(cart.total, cart.status), HttpStatus.OK)
    }
}




