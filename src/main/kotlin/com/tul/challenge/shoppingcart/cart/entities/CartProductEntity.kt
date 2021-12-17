package com.tul.challenge.shoppingcart.cart.entities

import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import java.util.*
import javax.persistence.*

@Entity
class CartProductEntity (
        @Id
        val id: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cart_id")
        val cart:CartEntity,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id")
        val product: ProductEntity,

        @Column(nullable = false)
        val quantity: Int,
)

