package com.note.model.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.note.model.user.service.UserService;
import com.note.model.user.vo.User;
import com.note.utils.JsonResult;
import lombok.val;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Wu
 * @Date 2023/6/16 15:44
 * @Description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    static List<Object> list1000 = new ArrayList<>();
    static List<Object> list = new ArrayList<>();

    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(@Param("username") String username, @Param("password") String password, HttpSession session) {
        User login = userService.login(username, password);
        if (login != null) {
            session.setAttribute("username", username);
            return new JsonResult(JsonResult.SUCCESS, login, "登陆成功");
        } else {
            return new JsonResult(JsonResult.FALL, null, "登陆失败");
        }
    }

    @PostMapping("/getUserName")
    @ResponseBody
    public String getUserName(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return username;
    }


    @PostMapping("/doRegister")
    @ResponseBody
    public JsonResult doRegister(User user) {
        if (!userService.moreUserName(user.getUsername())) {
            return new JsonResult(JsonResult.FALL, null, "用户名已存在");
        }
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        Boolean register = userService.doRegister(user);
        if (register) {
            return new JsonResult(JsonResult.SUCCESS, null, "注册成功");
        } else {
            return new JsonResult(JsonResult.FALL, null, "注册失败");
        }
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public JsonResult changePassword(@Param("password") String password, HttpSession session) {
        String username = (String) session.getAttribute("username");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Integer integer = userService.changePwd(user);
        if (integer >= 1) {
            return new JsonResult(JsonResult.SUCCESS, integer, "修改成功");
        } else {
            return new JsonResult(JsonResult.FALL, null, "修改失败");
        }
    }

}
