package com.example.mois_user.handler;

import com.example.mois_user.exception.InternalErrorException;
import com.example.mois_user.exception.UserAlreadyExistsException;
import com.example.mois_user.exception.UserNotFoundException;
import com.example.mois_user.payload.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Date;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponse handleUserNotFound(UserNotFoundException e) {
        return new MessageResponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse handleUserAlreadyExist(UserAlreadyExistsException e) {
        return new MessageResponse(new Date(), e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(InternalErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageResponse handleInternalError(UserAlreadyExistsException e) {
        return new MessageResponse(new Date(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageResponse handleIllegalArgException(UserAlreadyExistsException e) {
        return new MessageResponse(new Date(), e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}