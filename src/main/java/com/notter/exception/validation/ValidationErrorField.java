package com.notter.exception.validation;

public record ValidationErrorField(
        String fieldName,
        String message
) {
}
