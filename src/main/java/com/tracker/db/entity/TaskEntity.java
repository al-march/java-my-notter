package com.tracker.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "task")
@Getter
@Setter
public class TaskEntity extends BaseEntity {
    String name;

    @Lob
    String description;

    @ManyToOne
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    ProjectEntity project;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    List<TagEntity> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    List<CommentEntity> comments;
}
