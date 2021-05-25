package com.hello.controller;

import com.User.DBConn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王令
 * @version 1.0
 * @date 2021/5/24 15:38
 */
@Controller
public class RegisterController {
    @RequestMapping(value = "register2" )
    public String register2(Model model, HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        DBConn db =new DBConn();
        db.saveRegister(username,password);
        return "Login";
    }

    @RequestMapping(value = "register" )
    public String register(Model model, HttpServletRequest request){

        return "registerForm";
    }

}
