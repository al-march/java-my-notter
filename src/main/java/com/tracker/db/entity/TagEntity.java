package com.tracker.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity(name = "tag")
@Getter
@Setter
public class TagEntity extends BaseEntity {
    @NotBlank(message = "Обязательное поле")
    String name;

    @ManyToOne
    private UserEntity user;
}
