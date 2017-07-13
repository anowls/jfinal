package org.anowls.jfinal.service;

import org.anowls.jfinal.service.usermodule.UserService;
import org.anowls.jfinal.service.usermodule.support.UserSupport;

/**
 * Created by Administrator on 2016/3/23.
 */
public class AllService {

    public static final UserService userService = new UserSupport();
}
