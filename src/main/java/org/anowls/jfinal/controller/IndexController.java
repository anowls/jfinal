package org.anowls.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.anowls.jfinal.service.AllService;
import org.anowls.jfinal.validator.LoginValidator;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/22.
 */
public class IndexController extends Controller {

    private static Logger logger = Logger.getLogger(IndexController.class);

    public void index() {
        logger.info("access index");
        setAttr("serverTime", new Date());
        setAttr("hello", "hello world!!!");
        render("login.ftl");
    }

    @Before(LoginValidator.class)
    public void login() {
        String userEmail = getPara("userEmail");
        String userPasswd = getPara("userPasswd");
        AllService.userService.signUp(userEmail, userPasswd, this);
    }
}
