package com.notter.rest.note.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentDto {
    @NotBlank(message = "Обязательное поле")
    String content;
}
