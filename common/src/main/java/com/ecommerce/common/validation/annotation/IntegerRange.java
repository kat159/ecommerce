package com.ecommerce.common.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Null;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IntegerRangeConstraintValidator.class })
public @interface IntegerRange {

    String message() default "{com.ecommerce.common.validation.annotation.IntegerRange.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int min() default 0;
    int max() default 0;
}
