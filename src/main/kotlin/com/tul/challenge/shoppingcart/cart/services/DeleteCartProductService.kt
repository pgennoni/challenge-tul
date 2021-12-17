package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.domain.CartAvailabilityChecker
import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import com.tul.challenge.shoppingcart.cart.mappers.ProductMapper
import com.tul.challenge.shoppingcart.cart.repositories.ProductCartRepository
import com.tul.challenge.shoppingcart.products.controller.Product
import org.springframework.stereotype.Service
import java.util.*

@Service
class DeleteCartProductService(private val cartProductRepository: ProductCartRepository, private val getCartService: GetCartService) {
    fun invoke(cartId: String, productId: String) {
        val cart = getCartService.invoke(cartId)
        CartAvailabilityChecker.check(cart)
        val productFiltered = cart.cartProducts.filter { it.product.id.equals(productId) }
        deleteProduct(productFiltered.get(0), cartId, productId.toString())
        incrementQuantity(productFiltered.get(0), cart, productId.toString())
    }

    fun deleteProduct(productFiltered:CartProductEntity, cartId: String, productId: String) {
        if(productFiltered.quantity == 1) {
            cartProductRepository.deleteProductByCartProductId(cartId, productId)
        }
    }
    fun incrementQuantity(productFiltered:CartProductEntity, cart: CartEntity, productId: String) {
        if(productFiltered.quantity > 1) {
            val quantity = productFiltered.quantity - 1
            cartProductRepository.addProductByCartProductId(cart.id, productId, quantity)
        }
    }

}