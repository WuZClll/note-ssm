package com.note.model.user.service.impl;

import com.note.model.user.dao.UserDao;
import com.note.model.user.service.UserService;
import com.note.model.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Wu
 * @Date 2023/6/16 15:46
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User login = userDao.login(username, password);
        return login;
    }

    @Override
    public Boolean doRegister(User user) {
        Integer register = userDao.register(user);
        return register>=1;
    }
}
