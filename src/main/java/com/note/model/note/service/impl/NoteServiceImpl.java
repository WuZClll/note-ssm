package com.note.model.note.service.impl;

import com.note.model.note.dao.NoteDao;
import com.note.model.note.service.NoteService;
import com.note.model.note.vo.Note;
import com.note.model.note.vo.param.NoteParam;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author Wu
 * @Date 2023/6/16 15:46
 * @Description
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;


    @Override
    public Boolean addNote(Note note) {
        Integer integer = noteDao.addNode(note);
        return integer >= 1;
    }

    @Override
    public  ArrayList<Note> selectNote(NoteParam noteParam) {
        noteParam.setPage((noteParam.getPage() - 1) * noteParam.getLimit());
        ArrayList<Note> notes = noteDao.selectNote(noteParam);
        return notes;
    }

    @Override
    public Integer selectNoteCount(NoteParam noteParam) {
        Integer count = noteDao.selectNoteCount(noteParam);
        return count;
    }
}
