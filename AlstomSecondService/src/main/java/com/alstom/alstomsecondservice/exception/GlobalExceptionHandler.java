package com.alstom.alstomsecondservice.exception;

import com.alstom.alstomsecondservice.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest req, Exception ex) {
        String errorMessage = "An unexpected error occurred: " + ex.getMessage();
        logger.error(errorMessage);

        ErrorResponse errorResponse = new ErrorResponse(
                new Date().getTime(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Unexpected Error",
                errorMessage,
                req.getServletPath()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
