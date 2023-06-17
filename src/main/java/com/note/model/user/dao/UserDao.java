package com.note.model.user.dao;

import com.note.model.user.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Wu
 * @Date 2023/6/16 15:34
 * @Description
 */
@Repository
public interface UserDao {
    User login(@Param("username") String username, @Param("password") String password);

    Integer register(User user);

    Integer getUserName(@Param("username") String username);

    Integer changePwd(User user);
}
