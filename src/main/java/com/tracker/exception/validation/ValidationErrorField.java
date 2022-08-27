package com.tracker.exception.validation;

public record ValidationErrorField(
        String fieldName,
        String message
) {
}
