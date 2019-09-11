package com.cars24.omstaxation.validation;

import com.cars24.omstaxation.constant.AmountType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AmountTypeValidator implements ConstraintValidator<ValidateAmountType, String> {

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return (field != null && Arrays.stream(AmountType.values()).map(Enum::name).collect(Collectors.toList()).contains(field));
    }
}
