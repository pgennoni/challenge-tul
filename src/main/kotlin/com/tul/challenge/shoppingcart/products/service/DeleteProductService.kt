package com.tul.challenge.shoppingcart.products.service

import com.tul.challenge.shoppingcart.products.domain.CantDeleteException
import com.tul.challenge.shoppingcart.products.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class DeleteProductService(private val repository: ProductRepository) {
    fun invoke(id: String) {
        try{
            repository.deleteProductById(id)
        }catch (exception: Exception) {
            exception.printStackTrace()
            throw CantDeleteException("Can't delete this product")
        }
    }

}