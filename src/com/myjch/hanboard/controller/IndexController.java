package com.myjch.hanboard.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.myjch.hanboard.service.AllService;
import com.myjch.hanboard.validator.LoginValidator;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/22.
 */
public class IndexController extends Controller{

    public void index(){
        setAttr("serverTime",new Date());
        setAttr("hello", "hello world!!!");
        render("login.ftl");
    }

    @Before(LoginValidator.class)
    public void login(){
        String userEmail = getPara("userEmail");
        String userPasswd = getPara("userPasswd");
        AllService.userService.signUp(userEmail, userPasswd, this);
    }
}
