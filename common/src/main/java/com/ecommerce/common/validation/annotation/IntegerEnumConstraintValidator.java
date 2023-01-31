package com.ecommerce.common.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class IntegerEnumConstraintValidator implements ConstraintValidator<IntegerEnum, Integer> {

    private Set<Integer> set;

    @Override
    public void initialize(IntegerEnum constraintAnnotation) {
        set = new HashSet<>();
        int[] values = constraintAnnotation.values();
        set.add(null); // can be null
        for (int value : values) {
            set.add(value);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
