package com.example.mois_user.domain.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ErrorUtil {

    private static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage);
        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    public static ResponseEntity<Object> getErrorResponse(BindingResult result) {
        Map<String, String> errors = getErrors(result);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
