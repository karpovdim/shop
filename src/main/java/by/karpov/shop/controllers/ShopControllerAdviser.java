package by.karpov.shop.controllers;

import by.karpov.shop.exeptions.ErrorResponse;
import by.karpov.shop.exeptions.NotFoundEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdviser {

    @ExceptionHandler(NotFoundEntityException.class)
    ResponseEntity<ErrorResponse> handle(NotFoundEntityException ex) {
        final var response = ErrorResponse.builder()
                .error(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .statusMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
