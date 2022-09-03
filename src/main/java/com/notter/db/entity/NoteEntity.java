package com.notter.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "note")
@Getter
@Setter
public class NoteEntity extends BaseEntity {
    String name;

    @Lob
    String description;

    @ManyToOne
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    CategoryEntity category;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    List<TagEntity> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    List<CommentEntity> comments;
}
