package com.note.model.user.vo;

import lombok.*;

/**
 * @Author Wu
 * @Date 2023/6/16 17:04
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
