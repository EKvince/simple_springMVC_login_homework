package com.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.User.DBConn;
import com.User.DB;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 王令
 * @version 1.0
 * @date 2021/5/24 15:38
 */

@Controller
//@RequestMapping(value = "/user")
public class LoginController {

    @RequestMapping(value = "login2" )
    public String login2(Model model, HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        DBConn db =new DBConn();
        int res = db.checkUser(username,password);
        System.out.println(res);
        if(res==1) {
            return "welcome";
        }
        else
            return "fail";
    }

    @RequestMapping(value = "login" )
    public String login(Model model, HttpServletRequest request){
            return "loginForm";
    }

}
