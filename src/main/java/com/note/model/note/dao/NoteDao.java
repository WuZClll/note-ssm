package com.note.model.note.dao;

import com.note.model.note.vo.Note;
import org.springframework.stereotype.Repository;

/**
 * @Author Wu
 * @Date 2023/6/16 15:34
 * @Description
 */
@Repository
public interface NoteDao {
    Integer addNode(Note note);
}
