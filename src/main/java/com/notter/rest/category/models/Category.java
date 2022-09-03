package com.notter.rest.category.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.notter.db.entity.CategoryEntity;
import com.notter.rest.note.models.Note;
import lombok.Data;

import java.util.List;

@Data
public class Category {

    Integer userId;
    String name;
    String description;
    String prefix;

    @JsonInclude(Include.NON_NULL)
    List<Note> notes;

    public Category(CategoryEntity entity) {
        this.userId = entity.getUser().getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.prefix = entity.getPrefix();
    }
}
