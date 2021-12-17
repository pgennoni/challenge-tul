package com.tul.challenge.shoppingcart.cart.controller

import com.tul.challenge.shoppingcart.cart.domain.Item
import com.tul.challenge.shoppingcart.cart.mappers.ProductMapper
import com.tul.challenge.shoppingcart.cart.services.GetProductsCartService
import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class GetProductCartController(private val getProductsCartService: GetProductsCartService): AbstractCartController() {
    @GetMapping("/{cartId}/products")
    fun execute(@Validated  @PathVariable cartId: String): List<Item> = getProductsCartService.getProducts(cartId)
}