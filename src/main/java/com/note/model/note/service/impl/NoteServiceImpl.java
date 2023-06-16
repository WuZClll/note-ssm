package com.note.model.note.service.impl;

import com.note.model.note.dao.NoteDao;
import com.note.model.note.service.NoteService;
import com.note.model.note.vo.Note;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
