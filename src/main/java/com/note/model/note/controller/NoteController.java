package com.note.model.note.controller;

import com.note.model.note.service.NoteService;
import com.note.model.note.vo.Note;
import com.note.model.note.vo.param.NoteParam;
import com.note.model.note.vo.result.NoteResult;
import com.note.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @Author Wu
 * @Date 2023/6/16 15:44
 * @Description
 */
@Controller
@RequestMapping("/note")
public class NoteController {

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
        LocalDateTime now = LocalDateTime.now();

        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        note.setCreateDate(formattedDateTime);
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
            return new NoteResult("登陆过期", -1, null);
        }
        noteParam.setName(name);
        ArrayList<Note> notes = noteService.selectNote(noteParam);
        Integer count = noteService.selectNoteCount(noteParam);
        NoteResult noteResult = new NoteResult("查询成功", count, notes);
        return noteResult;
    }

    @GetMapping("/delNote")
    @ResponseBody
    public JsonResult listNote(String id, HttpSession session) {
        String name = (String) session.getAttribute("username");
        if ("".equals(name) || name == null) {
            return new JsonResult(JsonResult.FALL, null, "登陆过期");
        }
        Integer integer = noteService.delNote(id);
        if (integer > 0) {
            return new JsonResult(JsonResult.SUCCESS, integer, "删除成功");
        } else {
            return new JsonResult(JsonResult.FALL, integer, "没有数据被删除");
        }
    }

    @PostMapping("/editNote")
    @ResponseBody
    public JsonResult editNote(Note note, HttpSession session) {
        String name = (String) session.getAttribute("username");
        if ("".equals(name) || name == null) {
            return new JsonResult(JsonResult.FALL, null, "登陆过期");
        }
        LocalDateTime now = LocalDateTime.now();

        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        note.setUpdateDate(formattedDateTime);
        Integer integer = noteService.editNote(note);
        if (integer > 0) {
            return new JsonResult(JsonResult.SUCCESS, integer, "修改成功");
        } else {
            return new JsonResult(JsonResult.FALL, integer, "没有数据被修改");
        }
    }

}
