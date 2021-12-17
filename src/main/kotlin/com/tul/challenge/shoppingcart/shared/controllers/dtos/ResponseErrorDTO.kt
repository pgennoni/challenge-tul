package com.tul.challenge.shoppingcart.shared.controllers.dtos

import org.springframework.http.HttpStatus

data class ResponseErrorDTO(
        var status: HttpStatus,
        var clientMessage: String,
        var errors: List<String>,
){
    constructor(status: HttpStatus, clientMessage: String, error: String, developerMessage: String? = null) :
            this(status, clientMessage, arrayListOf<String>(error))
}
