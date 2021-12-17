package com.tul.challenge.shoppingcart.products.controller

import com.tul.challenge.shoppingcart.shared.controllers.dtos.ResponseDTO
import com.tul.challenge.shoppingcart.products.service.DeleteProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeleteProductController(private val deleteProductService: DeleteProductService): ProductAbstractController() {
    @DeleteMapping("/{id}")
    fun delete(@Validated @PathVariable id: String): ResponseEntity<ResponseDTO> {
        deleteProductService.invoke(id)
        return ResponseEntity<ResponseDTO>(ResponseDTO("Deleted", HttpStatus.OK.value()), HttpStatus.OK)
    }
}