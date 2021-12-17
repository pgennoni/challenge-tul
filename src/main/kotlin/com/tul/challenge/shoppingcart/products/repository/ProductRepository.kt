package com.tul.challenge.shoppingcart.products.repository

import com.tul.challenge.shoppingcart.products.controller.Product
import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional

@Repository
interface ProductRepository: JpaRepository<ProductEntity, String>{
    @Transactional
    @Modifying
    @Query("update ProductEntity p set p.disabled = true where p.id = :id")
    fun deleteProductById(@Param("id") id:String)
}