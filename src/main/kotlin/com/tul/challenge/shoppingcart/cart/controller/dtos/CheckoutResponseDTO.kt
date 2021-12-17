package com.tul.challenge.shoppingcart.cart.controller.dtos

import com.tul.challenge.shoppingcart.cart.enums.State

data class CheckoutResponseDTO(val totalAmount: Float, val status: State)