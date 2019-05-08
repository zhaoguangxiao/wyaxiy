package com.woyacy.dao;

import com.woyacy.bean.UserBean;

public interface UserMapper {

    public int selectUserByNameAndPwd(UserBean userBean);

}
