package com.vvv.controllers;

import com.vvv.models.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @RequestMapping("/loginAction")
    public String login(HttpServletRequest request, User user, HttpSession session, Model model){
        String success = loginUser(user);

        if (!"SUCCESS".equals(success)){
            request.setAttribute("errorMsg",success);
            return "login";
        }else {
             model.addAttribute("successMsg","登录成功！");
             model.addAttribute("name",user.getUsername());
             return "redirect:main";
        }

    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    private String loginUser(User user){
        if (isRelogin(user)){
            return "SUCCESS";
        }
        return shiroLogin(user);
    }

    private boolean isRelogin(User user){
       Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            return true;
        }
        return false;
    }

    private String shiroLogin(User user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword().toCharArray(),null);
        token.setRememberMe(true);

        try{
            SecurityUtils.getSubject().login(token);
        }catch (UnknownAccountException ex){
            return "用户不存在或者密码错误！";
        }catch (IncorrectCredentialsException ex){
            return "用户不存在或者密码错误！";
        }catch (AuthenticationException ex){
            return ex.getMessage();
        }catch (Exception ex){
            return "internal error!";
        }
        return "SUCCESS";
    }

}
