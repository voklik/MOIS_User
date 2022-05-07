package com.example.mois_user.annotation;

import com.example.mois_user.validation.PasswordMatchesValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface PasswordMatches {

    String message() default "Passwords do not match";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};

}