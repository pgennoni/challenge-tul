package com.tul.challenge.shoppingcart.cart.entities

import com.tul.challenge.shoppingcart.cart.enums.State
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "carts", schema = "kotlin_crud_db")
class CartEntity (
        @Id
        val id:String,
        @Column(nullable = false)
        var state: State
) {
        @OneToMany(mappedBy = "cart")
        val cartProducts: List<CartProductEntity> = ArrayList()
}