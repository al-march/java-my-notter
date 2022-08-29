package com.tracker.db.repository;

import com.tracker.db.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {
    @Query("SELECT t FROM task t WHERE t.user.id = ?1")
    List<TaskEntity> getAllByUser(Integer userId);

    @Query("SELECT t FROM task t WHERE t.user.id = ?1 AND t.id = ?2")
    TaskEntity getOneByUser(Integer userId, Integer taskId);

    @Query("SELECT t FROM task t WHERE t.project.id = ?1")
    List<TaskEntity> getByProject(Integer projectId);
}
