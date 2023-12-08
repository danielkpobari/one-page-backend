package com.danitest.kpobaritest.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = AgreedToTermsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgreedToTerms {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

