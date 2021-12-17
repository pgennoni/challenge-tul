package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.domain.CartAvailabilityChecker
import com.tul.challenge.shoppingcart.cart.domain.CartCompletedException
import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import com.tul.challenge.shoppingcart.cart.enums.State
import com.tul.challenge.shoppingcart.cart.mappers.ProductMapper
import com.tul.challenge.shoppingcart.cart.repositories.ProductCartRepository
import com.tul.challenge.shoppingcart.products.controller.Product
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddProductCartService(private val getCartService:GetCartService, private val productCartRepository: ProductCartRepository) {
    fun invoke(cartId: String, product: Product) {
        val cart = getCartService.invoke(cartId)
        CartAvailabilityChecker.check(cart)
        val productFiltered = cart.cartProducts.filter {UUID.fromString(it.product.id).equals(product.id) }
        insertNewProduct(productFiltered, cart, product)
        incrementQuantity(productFiltered, cart, product)
    }

    fun insertNewProduct(productFiltered:List<CartProductEntity>, cart: CartEntity, product: Product) {
        if(productFiltered.size == 0) {
            productCartRepository.save(CartProductEntity(UUID.randomUUID().toString(), cart, ProductMapper.toEntity(product), 1))
        }
    }
    fun incrementQuantity(productFiltered:List<CartProductEntity>, cart: CartEntity, product: Product) {
        if(productFiltered.size > 0) {
            val quantity = productFiltered.get(0).quantity + 1
            productCartRepository.addProductByCartProductId(cart.id, product.id.toString(), quantity)
        }
    }

}