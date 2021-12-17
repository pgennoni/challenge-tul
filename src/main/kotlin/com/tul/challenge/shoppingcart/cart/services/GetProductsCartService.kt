package com.tul.challenge.shoppingcart.cart.services

import com.tul.challenge.shoppingcart.cart.domain.Item
import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import com.tul.challenge.shoppingcart.cart.mappers.ItemListFillerFromProductsCart
import com.tul.challenge.shoppingcart.cart.mappers.ProductsCartToItemMapper
import com.tul.challenge.shoppingcart.cart.repositories.CartRepository
import com.tul.challenge.shoppingcart.cart.repositories.ProductCartRepository
import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetProductsCartService(private val productCartRepository: ProductCartRepository) {

    fun getProducts(cartId: String): List<Item> {
        val productsCart = productCartRepository.getCartProductEntityBy(cartId)

        return ItemListFillerFromProductsCart.fill(productsCart)
    }
}


