package com.tul.challenge.shoppingcart.cart.controller.dtos

import com.tul.challenge.shoppingcart.cart.enums.Operation


data class CheckoutRequestDTO(
        val operation: Operation
)