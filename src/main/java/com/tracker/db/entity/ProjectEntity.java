package com.tracker.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "project")
@Getter
@Setter
public class ProjectEntity extends BaseEntity {
    String name;
    String description;

    @ManyToOne
    private UserEntity user;

    @OneToMany(
            mappedBy = "project",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    List<TaskEntity> tasks;
}
