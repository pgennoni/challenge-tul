package com.tul.challenge.shoppingcart.products.service

import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import com.tul.challenge.shoppingcart.products.repository.ProductRepository
import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Consumer

@Service
class GetAllProductsService(private val productRepository: ProductRepository) {
    fun invoke(): List<Product> {
        var productsEntity = productRepository.findAll()
        return ProductListFiller.fill(productsEntity)
    }
}

object ProductListFiller {
    fun fill(productsEntity: MutableList<ProductEntity>): MutableList<Product> {
        val products:MutableList<Product> = ArrayList<Product>()
        val productsEntityFiltered = productsEntity.filter {it.disabled == false}
        for(productEntity in productsEntityFiltered) {
            products.add(Product(UUID.fromString(productEntity.id),UUID.fromString(productEntity.sku), productEntity.name, productEntity.description, productEntity.cost, productEntity.discount, productEntity.disabled))
        }
        return products
    }
}