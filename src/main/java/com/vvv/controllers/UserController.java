package com.vvv.controllers;

import com.vvv.models.User;
import com.vvv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/loginAction")
    public String login(HttpServletRequest request, User user, HttpSession session){
        User currentUser = userService.login(user);
        if (currentUser == null){
            request.setAttribute("errorMsg","用户名或密码错误");
            return "login";
        }else {
            session.setAttribute("currentUser",currentUser);
            return "redirect:main";
        }
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
