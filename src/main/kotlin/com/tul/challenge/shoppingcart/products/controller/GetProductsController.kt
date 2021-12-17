package com.tul.challenge.shoppingcart.products.controller

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tul.challenge.shoppingcart.products.service.GetAllProductsService
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class GetProductsController(private val getAllProductsService: GetAllProductsService): ProductAbstractController() {
    @GetMapping
    fun getAll(): ResponseEntity<List<Product>> {
        val products:List<Product> = getAllProductsService.invoke()
        return ResponseEntity(products, HttpStatus.OK)
    }
}

 data class Product(open val id: UUID, open val sku: UUID, open val description: String, open val name: String, open val cost: Float, val discount: Boolean, val disabled: Boolean)
