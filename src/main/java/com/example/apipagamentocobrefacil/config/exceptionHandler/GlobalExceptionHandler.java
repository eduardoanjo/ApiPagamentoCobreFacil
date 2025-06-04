package com.example.apipagamentocobrefacil.config.exceptionHandler;

import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpMessageNotReadableException.class, EntityNotFoundException.class})
    public ResponseEntity<ApiError> genericException(Exception ex) {
        var apiError = buildApiError(ex, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ApiError> feignException(Exception ex) {
        var apiError = buildApiError(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    private static ApiError buildApiError(Exception ex, HttpStatus status) {
        return ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .errors(List.of(ex.getMessage()))
                .build();
    }
}
