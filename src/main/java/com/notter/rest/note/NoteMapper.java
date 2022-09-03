package com.notter.rest.note;

import com.notter.db.entity.NoteEntity;
import com.notter.rest.note.models.Note;
import com.notter.rest.util.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class NoteMapper extends BaseMapper<NoteEntity, Note> {
    public Note one(NoteEntity entity) {
        return new Note(entity);
    }
}
