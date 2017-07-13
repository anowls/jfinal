package org.anowls.jfinal.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * Created by Administrator on 2016/3/22.
 */
public class LoginValidator extends Validator {
    @Override
    protected void validate(Controller c) {
        validateRequiredString("userEmail", "nameMsg", "请输入用户名");
        validateRequiredString("userPasswd", "passMsg", "请输入密码");
    }

    @Override
    protected void handleError(Controller c) {
        c.renderJson();
    }
}
