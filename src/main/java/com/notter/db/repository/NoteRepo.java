package com.notter.db.repository;

import com.notter.db.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepo extends JpaRepository<NoteEntity, Integer> {
    @Query("SELECT t FROM note t WHERE t.user.id = ?1")
    List<NoteEntity> getAllByUser(Integer userId);

    @Query("SELECT t FROM note t WHERE t.user.id = ?1 AND t.id = ?2")
    NoteEntity getOneByUser(Integer userId, Integer noteId);

    @Query("SELECT t FROM note t WHERE t.category.id = ?1")
    List<NoteEntity> getByProject(Integer projectId);
}
