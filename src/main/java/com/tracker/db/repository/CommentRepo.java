package com.tracker.db.repository;

import com.tracker.db.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {
}
