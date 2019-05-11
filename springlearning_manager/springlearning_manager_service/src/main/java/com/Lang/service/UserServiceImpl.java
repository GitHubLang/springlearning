package com.Lang.service;

import com.Lang.pojo.User;
import com.Lang.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Lang.mapper.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByName(String name) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andUsernameEqualTo(name);

        List<User> userList = userMapper.selectByExample(userExample);

        if(userList!=null)
        {
            return userList.get(0);
        }else return null;
    }
}
