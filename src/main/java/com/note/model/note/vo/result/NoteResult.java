package com.note.model.note.vo.result;

import com.note.model.note.vo.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Wu
 * @Date 2023/6/17 14:40
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteResult {
    private final int code = 0;
    private String msg;
    private int count;
    private List<Note> data;

}
