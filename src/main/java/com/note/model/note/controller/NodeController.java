package com.note.model.note.controller;

import com.note.model.note.service.NoteService;
import com.note.model.note.vo.Note;
import com.note.model.note.vo.param.NoteParam;
import com.note.model.note.vo.result.NoteResult;
import com.note.utils.JsonResult;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @Author Wu
 * @Date 2023/6/16 15:44
 * @Description
 */
@Controller
@RequestMapping("/note")
public class NodeController {

    @Autowired
    NoteService noteService;

    @PostMapping("/addNote")
    @ResponseBody
    public JsonResult addNote(Note note, HttpSession session) {
        UUID uuid = UUID.randomUUID();
        note.setId(uuid.toString());
        String name = (String) session.getAttribute("username");
        note.setName(name);
        if ("".equals(name) || name == null) {
            return new JsonResult(JsonResult.FALL, null, "登陆过期，请重新登录");
        }
        LocalDate now = LocalDate.now();
        note.setCreateDate(now);
        Boolean flag = noteService.addNote(note);
        if (flag) {
            return new JsonResult(JsonResult.SUCCESS, null, "添加成功");
        } else {
            return new JsonResult(JsonResult.FALL, null, "添加失败");
        }
    }

    @GetMapping("/listNote")
    @ResponseBody
    public NoteResult listNote(NoteParam noteParam, HttpSession session) {
        String name = (String) session.getAttribute("username");
        if ("".equals(name) || name == null) {
            return new NoteResult();
        }
        ArrayList<Note> notes = noteService.selectNote(noteParam);
        Integer count = noteService.selectNoteCount(noteParam);
        NoteResult noteResult = new NoteResult(notes, count);
        return noteResult;
    }
}
