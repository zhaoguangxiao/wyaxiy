package com.woyacy.service.impl;

import com.woyacy.bean.UserBean;
import com.woyacy.dao.UserMapper;
import com.woyacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserBean> selectAll() {
        return userMapper.getKey();
    }
}
