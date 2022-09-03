package com.notter.rest.category.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {
    @NotBlank(message = "Обязательное поле")
    String name;
    @NotBlank(message = "Обязательное поле")
    String prefix;
    String description;
}
