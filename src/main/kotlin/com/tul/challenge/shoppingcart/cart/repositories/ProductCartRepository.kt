package com.tul.challenge.shoppingcart.cart.repositories

import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface ProductCartRepository: JpaRepository<CartProductEntity, String> {
    @Query("SELECT p FROM CartProductEntity p WHERE p.cart.id = :id")
    fun getCartProductEntityBy(@Param("id") id:String): List<CartProductEntity>

    @Transactional
    @Modifying
    @Query("DELETE FROM CartProductEntity p WHERE p.cart.id = :id and p.product.id = :productId")
    fun deleteProductByCartProductId(@Param("id") id:String, @Param("productId") productId:String)

    @Transactional
    @Modifying
    @Query("UPDATE CartProductEntity p set p.quantity = :quantity where p.cart.id = :cartId and p.product.id = :productId")
    fun addProductByCartProductId(@Param("cartId") id:String, @Param("productId") productId:String,  @Param("quantity") quantity:Int)


}