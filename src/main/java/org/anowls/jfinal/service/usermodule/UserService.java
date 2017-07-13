package org.anowls.jfinal.service.usermodule;

import com.jfinal.core.Controller;

/**
 * Created by Administrator on 2016/3/23.
 */
public interface UserService {

    void signUp(String userEmail, String userPasswd, Controller controller);
}
