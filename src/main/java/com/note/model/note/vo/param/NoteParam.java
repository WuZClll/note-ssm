package com.note.model.note.vo.param;

import com.note.model.note.vo.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author Wu
 * @Date 2023/6/17 14:19
 * @Description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteParam {
    private String id;
    private String title;
    private String context;
    private String createDate;
    private String name;
    private String updateDate;
    private int limit;
    private int page;
}
