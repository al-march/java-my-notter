package com.tracker.rest.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ProjectDto {
    @NotBlank(message = "Обязательное поле")
    String name;
    @NotBlank(message = "Обязательное поле")
    String prefix;
    String description;
}
