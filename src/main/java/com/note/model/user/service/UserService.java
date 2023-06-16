package com.note.model.user.service;/**
 * @Author Wu
 * @Date 2023/6/16 15:45
 * @Description TODO
 */

import com.note.model.user.vo.User;

/**
 * @Author Wu
 * @Date 2023/6/16 15:45
 * @Description
 */
public interface UserService {
    User login(String username, String password);

    Boolean doRegister(User user);
}
