package com.tul.challenge.shoppingcart.cart.builders

import com.tul.challenge.shoppingcart.products.entities.ProductEntity
import java.util.*

object ProductEntityBuilder {
    private val _id: String = UUID.randomUUID().toString()
    private val _sku: String = UUID.randomUUID().toString()
    private var _name: String = "Test"
    private var _description: String = "Long Test"
    private var _cost: Float = 1.00F
    private var _discount:Boolean = false
    private var _disabled:Boolean  = false


    fun build() = ProductEntity( _id, _sku, _name, _description, _cost, _discount, _disabled)

    fun name(value: String):ProductEntityBuilder {
        this._name = value
        return this
    }
    fun description(value: String):ProductEntityBuilder {
        this._description = value
        return this
    }
    fun cost(value: Float):ProductEntityBuilder{
        this._cost = value
        return this
    }
    fun discount(value: Boolean):ProductEntityBuilder {
        this._discount = value
        return this
    }
    fun disabled(value: Boolean):ProductEntityBuilder {
        this._disabled = value
        return this
    }
}