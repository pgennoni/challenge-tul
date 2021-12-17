package com.tul.challenge.shoppingcart.products.entities

import com.tul.challenge.shoppingcart.cart.entities.CartEntity
import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name="PRODUCTS", schema = "kotlin_crud_db")
data class ProductEntity (
    @Id
    val id: String,
    @Column(nullable = false)
    val sku: String,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val description: String,
    @Column(nullable = false)
    val cost: Float,
    @Column(nullable = false)
    val discount:Boolean,
    @Column(nullable = false)
    val disabled:Boolean,
){
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    val cartProducts: List<CartProductEntity> = ArrayList()
}

