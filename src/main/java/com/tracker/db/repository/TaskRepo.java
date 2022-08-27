package com.tracker.db.repository;

import com.tracker.db.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {
}
