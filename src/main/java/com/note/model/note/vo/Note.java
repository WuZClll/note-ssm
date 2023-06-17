package com.note.model.note.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @Author Wu
 * @Date 2023/6/16 21:46
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Note {
    private String id;
    private String title;
    private String context;
    private String createDate;
    private String name;
    private String updateDate;
}
