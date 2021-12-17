package com.tul.challenge.shoppingcart.products.domain

import com.tul.challenge.shoppingcart.products.controller.Product
import java.util.*

object ProductValidator {
    fun validate(product: Product) {
        validateSKU(product.sku.toString())
        validateName(product.name)
        validateDescripction(product.description)
        validateCost(product.cost)
    }

    private fun validateSKU(sku: String) {
        try{
            UUID.fromString(sku)
        } catch(e: Exception) {
            throw SkuNotValidException("The SKU is not valid, please use the UUID format")
        }
    }

    private fun validateName(name: String) {
        if(name == null || name.equals("")) {
            throw NameNotValidException("The name must be declared")
        }
    }

    private fun validateDescripction(description: String) {
        if(description == null || description.equals("")) {
            throw DescriptionNotValidException("The description must be declared")
        }
    }

    private fun validateCost(cost: Float) {
        if(cost == null || cost.equals(0) || cost.equals(0.0)) {
            throw CostNotValidException("The cost must be declared and can't be zero")
        }
    }
}