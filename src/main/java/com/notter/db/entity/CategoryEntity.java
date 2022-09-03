package com.notter.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "category")
@Getter
@Setter
public class CategoryEntity extends BaseEntity {

    @NotBlank(message = "Обязательное поле")
    String name;
    @NotBlank(message = "Обязательное поле")
    String prefix;
    String description;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<NoteEntity> notes;
}
