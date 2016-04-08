package com.myjch.hanboard.service.usermodule.support;

import com.jfinal.core.Controller;
import com.myjch.hanboard.model.BlogUser;
import com.myjch.hanboard.service.usermodule.UserService;

/**
 * Created by Administrator on 2016/3/23.
 */
public class UserSupport implements UserService {

    @Override
    public void signUp(String userEmail, String userPasswd, Controller controller) {
        BlogUser first = BlogUser.blogUser.findFirst("select user_id from blog_user where user_email=? and user_passwd=?", userEmail, userPasswd);
        if(first == null){
            controller.setAttr("message","账户或密码错误");
            controller.renderJson();
        }else{
            controller.render("index.ftl");
        }
    }

}
