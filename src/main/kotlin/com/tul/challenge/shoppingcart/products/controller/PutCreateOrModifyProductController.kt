package com.tul.challenge.shoppingcart.products.controller

import com.tul.challenge.shoppingcart.shared.controllers.dtos.ResponseDTO
import com.tul.challenge.shoppingcart.products.domain.ProductValidator
import com.tul.challenge.shoppingcart.products.service.CreateProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PutCreateOrModifyProductController(private val createProductService: CreateProductService): ProductAbstractController() {
    @PutMapping
    fun put(@Validated @RequestBody product: Product): ResponseEntity<Product> {
        ProductValidator.validate(product)
        createProductService.invoke(product)
        return ResponseEntity<Product>(product, HttpStatus.CREATED)
    }
}



