package com.notter.rest.note.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.notter.db.entity.TagEntity;
import com.notter.db.entity.NoteEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Note {

    Integer id;
    Integer categoryId;
    String name;
    String description;
    List<TagEntity> tags;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Comment> comments;

    LocalDateTime updatedAt;
    LocalDateTime createdAt;

    public Note(NoteEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tags = entity.getTags();

        this.updatedAt = entity.getUpdatedAt();
        this.createdAt = entity.getCreatedAt();

        var category = entity.getCategory();
        if (category != null) {
            this.categoryId = category.getId();
        }
    }
}
