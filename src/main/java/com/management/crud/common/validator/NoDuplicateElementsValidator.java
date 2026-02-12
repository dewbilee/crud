package com.management.crud.common.validator;

import com.management.crud.common.annotation.NoDuplicateElements;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoDuplicateElementsValidator
        implements ConstraintValidator<NoDuplicateElements, List<?>> {

    @Override
    public boolean isValid(List<?> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        Set<?> set = new HashSet<>(value);
        return set.size() == value.size();
    }
}