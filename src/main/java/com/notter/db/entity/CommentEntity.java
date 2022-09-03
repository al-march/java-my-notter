package com.notter.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity(name = "comment")
@Getter
@Setter
public class CommentEntity extends BaseEntity {
    @Lob
    String content;

    @ManyToOne
    private UserEntity user;
}
