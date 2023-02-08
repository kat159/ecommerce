package com.ecommerce.common.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class StringEnumConstraintValidator implements ConstraintValidator<StringEnum, String> {

    private Set<String> set;

    @Override
    public void initialize(StringEnum constraintAnnotation) {
        set = new HashSet<>();
        String[] values = constraintAnnotation.values();
        set.add(null); // can be null
        for (String value : values) {
            set.add(value);
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}