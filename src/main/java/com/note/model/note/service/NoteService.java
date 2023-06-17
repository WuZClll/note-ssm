package com.note.model.note.service;
/**
 * @Author Wu
 * @Date 2023/6/16 15:45
 * @Description TODO
 */

import com.note.model.note.vo.Note;
import com.note.model.note.vo.param.NoteParam;

import java.util.ArrayList;

/**
 * @Author Wu
 * @Date 2023/6/16 15:45
 * @Description
 */
public interface NoteService {
    Boolean addNote(Note note);
    ArrayList<Note> selectNote(NoteParam noteParam);
    Integer selectNoteCount(NoteParam noteParam);

    Integer delNote(String id);

    Integer editNote(Note note);
}
