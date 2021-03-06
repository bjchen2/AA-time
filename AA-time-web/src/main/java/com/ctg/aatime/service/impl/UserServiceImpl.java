package com.ctg.aatime.service.impl;

import com.ctg.aatime.dao.UserDao;
import com.ctg.aatime.domain.User;
import com.ctg.aatime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pjmike
 * @create 2018-03-16 14:43
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    @Override
    public User findUserByOpenId(String openid) {
        return userDao.selectUserByOpenId(openid);
    }

    @Override
    public User selectUserByUid(Integer id) {
        return userDao.selectUserByUid(id);
    }

    @Override
    public void changeUserNickName(Integer id,String nickname) {
        userDao.updateUserNickName(id, nickname);
    }
}
