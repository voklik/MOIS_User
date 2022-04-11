package com.example.mois_user.validation;

import com.example.mois_user.annotation.PasswordMatches;
import com.example.mois_user.payload.request.SignUpRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignUpRequest userSignupRequest = (SignUpRequest) o;
        return userSignupRequest.getPassword().equals(userSignupRequest.getConfirmPassword());
    }

}