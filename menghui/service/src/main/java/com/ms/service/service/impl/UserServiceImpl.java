package com.ms.service.service.impl;

import com.ms.service.dao.IUserDAO;
import com.ms.service.entity.User;
import com.ms.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘梦辉
 * @description
 * @date 2019/7/18
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
}
