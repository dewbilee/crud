package com.management.crud.common.annotation;

import com.management.crud.common.validator.NoDuplicateElementsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoDuplicateElementsValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoDuplicateElements {

    String message() default "List contains duplicate elements";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}