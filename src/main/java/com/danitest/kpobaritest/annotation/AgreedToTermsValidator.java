package com.danitest.kpobaritest.annotation;


import com.danitest.kpobaritest.exception.CustomBadRequestException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgreedToTermsValidator implements ConstraintValidator<AgreedToTerms, Boolean> {

    private String message;

    @Override
    public void initialize(AgreedToTerms constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (value == null || !value) {
                throw new CustomBadRequestException(message);
            }
            return true;
        } catch (CustomBadRequestException ex) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ex.getMessage())
                    .addConstraintViolation();
            return false;
        }
    }
}
