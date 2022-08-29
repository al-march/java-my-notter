package com.tracker.rest.tag.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TagDto {
    @NotBlank(message = "Обязательное поле")
    String name;
}
