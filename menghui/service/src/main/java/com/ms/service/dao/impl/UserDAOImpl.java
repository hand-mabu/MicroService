package com.ms.service.dao.impl;

import com.ms.service.dao.IUserDAO;
import com.ms.service.entity.User;
import com.ms.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘梦辉
 * @description
 * @date 2019/7/18
 */
@Service
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
