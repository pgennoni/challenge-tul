package com.tul.challenge.shoppingcart.shared.validators

import com.tul.challenge.shoppingcart.cart.domain.IDNotValidException
import java.util.*

object IdValidator {
    fun validateId(id: String) {
        try {
            UUID.fromString(id)
        } catch(e: Exception) {
            throw IDNotValidException("The id must be with UUID format")
        }
    }
}