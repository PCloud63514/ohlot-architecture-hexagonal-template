package ohlot.account.handler

import ohlot.account.model.exception.InvalidAccountProfileFormatException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
private class AccountExceptionHandler {
    @ExceptionHandler
    fun handle(exception: InvalidAccountProfileFormatException): ResponseEntity<Any> {
        return ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)
    }
}
