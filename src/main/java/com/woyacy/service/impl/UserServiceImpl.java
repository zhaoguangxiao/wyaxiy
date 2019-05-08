package com.woyacy.service.impl;

import com.woyacy.bean.UserBean;
import com.woyacy.dao.UserMapper;
import com.woyacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean findUserByNameAndPwd(UserBean userBean) {
        return userMapper.selectUserByNameAndPwd(userBean) > 0 ?true :false;
    }
}
