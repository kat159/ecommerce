package com.ecommerce.common.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerRangeConstraintValidator implements ConstraintValidator<IntegerRange, Integer> {

    private int min;
    private int max;
    @Override
    public void initialize(IntegerRange constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) { // can be null
            return true;
        }
        return value >= min && value <= max;
    }
}
