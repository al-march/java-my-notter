package com.tracker.rest.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class TaskDto {
    @NotBlank(message = "Обязательное поле")
    String name;

    String description;

    @Min(value = 1, message = "Должно быть числом")
    Integer projectId;
}
