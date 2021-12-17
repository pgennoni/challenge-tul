package com.tul.challenge.shoppingcart.cart.controller.dtos

import com.tul.challenge.shoppingcart.products.controller.Product
import java.util.*

data class CartRequestDTO(val id: UUID, val products: List<Product>?)
