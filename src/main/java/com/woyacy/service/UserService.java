package com.woyacy.service;

import com.woyacy.bean.UserBean;

public interface UserService {

    public Boolean findUserByNameAndPwd(UserBean userBean);
}
