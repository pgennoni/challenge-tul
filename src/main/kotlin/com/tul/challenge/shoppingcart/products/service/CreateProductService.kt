package com.tul.challenge.shoppingcart.products.service

import com.tul.challenge.shoppingcart.cart.mappers.ProductMapper
import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import com.tul.challenge.shoppingcart.products.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateProductService(private val productRepository: ProductRepository) {
    fun invoke(product: Product) {
        val productEntity:ProductEntity = ProductMapper.toEntity(product)
        productRepository.save(productEntity)
    }
}