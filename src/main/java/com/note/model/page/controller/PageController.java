package com.note.model.page.controller;

import com.note.model.user.service.UserService;
import com.note.model.user.vo.User;
import com.note.utils.JsonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author Wu
 * @Date 2023/6/16 15:44
 * @Description
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public String login() {
        return "/note/layui/page/register.html";
    }

}
