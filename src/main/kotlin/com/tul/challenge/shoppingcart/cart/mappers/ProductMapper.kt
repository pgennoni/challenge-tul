package com.tul.challenge.shoppingcart.cart.mappers

import com.tul.challenge.shoppingcart.cart.entities.CartProductEntity
import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import java.util.*

object ProductMapper: Mapper<Product, ProductEntity> {
    override fun fromEntity(entity: ProductEntity): Product {
        return Product(
                UUID.fromString(entity.id),
                UUID.fromString(entity.sku),
                entity.name,
                entity.description,
                entity.cost,
                entity.discount,
                entity.disabled
        )
    }

    override fun toEntity(domain: Product):ProductEntity {
        return ProductEntity(
                domain.id.toString(),
                domain.sku.toString(),
                domain.name,
                domain.description,
                domain.cost,
                domain.discount,
                domain.disabled
        )
    }


}