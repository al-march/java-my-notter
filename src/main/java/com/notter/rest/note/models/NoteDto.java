package com.notter.rest.note.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class NoteDto {
    @NotBlank(message = "Обязательное поле")
    String name;

    String description;

    @Min(value = 1, message = "Должно быть числом")
    Integer projectId;
}
