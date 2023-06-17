package com.note.model.note.dao;

import com.note.model.note.vo.Note;
import com.note.model.note.vo.param.NoteParam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author Wu
 * @Date 2023/6/16 15:34
 * @Description
 */
@Repository
public interface NoteDao {
    Integer addNode(Note note);

    ArrayList<Note> selectNote(NoteParam noteParam);
    Integer selectNoteCount(NoteParam noteParam);
}
