package com.tul.challenge.shoppingcart.cart.mappers

interface Mapper<O, E> {
    fun fromEntity(entity: E):O
    fun toEntity(domain: O):E
}