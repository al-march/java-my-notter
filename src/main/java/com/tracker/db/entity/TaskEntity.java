package com.tracker.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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
}
