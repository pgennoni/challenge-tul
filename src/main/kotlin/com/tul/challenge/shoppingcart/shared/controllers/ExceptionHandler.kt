package com.tul.challenge.shoppingcart.shared.controllers

import com.tul.challenge.shoppingcart.cart.domain.CartCompletedException
import com.tul.challenge.shoppingcart.cart.domain.CartNotFoundException
import com.tul.challenge.shoppingcart.cart.domain.EmptyRequestIdException
import com.tul.challenge.shoppingcart.products.domain.CantDeleteException
import com.tul.challenge.shoppingcart.shared.controllers.dtos.ResponseErrorDTO
import com.tul.challenge.shoppingcart.products.domain.CostNotValidException
import com.tul.challenge.shoppingcart.products.domain.DescriptionNotValidException
import com.tul.challenge.shoppingcart.products.domain.NameNotValidException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleAll(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        val apiError = ResponseErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(CostNotValidException::class)
    fun handleCostNotValidException(ex: CostNotValidException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.BAD_REQUEST, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(NameNotValidException::class)
    fun handleNameNotValidException(ex: NameNotValidException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.BAD_REQUEST, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(DescriptionNotValidException::class)
    fun handleDescriptionNotValidException(ex: DescriptionNotValidException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.BAD_REQUEST, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(CartNotFoundException::class)
    fun handleCartNotFoundException(ex: CartNotFoundException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.NOT_FOUND, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(CartCompletedException::class)
    fun cartCompletedException(ex: CartCompletedException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.CONFLICT, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(EmptyRequestIdException::class)
    fun handleEmptyRequestIdException(ex: EmptyRequestIdException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.BAD_REQUEST, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(CantDeleteException::class)
    fun handleCantDeleteException(ex: EmptyRequestIdException, request: WebRequest): ResponseEntity<ResponseErrorDTO> {
        val apiError = ResponseErrorDTO(HttpStatus.BAD_REQUEST, ex.localizedMessage, "error occurred")
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

}