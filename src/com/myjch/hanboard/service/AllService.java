package com.myjch.hanboard.service;

import com.myjch.hanboard.service.usermodule.UserService;
import com.myjch.hanboard.service.usermodule.support.UserSupport;

/**
 * Created by Administrator on 2016/3/23.
 */
public class AllService {

    public static final UserService userService = new UserSupport();
}
