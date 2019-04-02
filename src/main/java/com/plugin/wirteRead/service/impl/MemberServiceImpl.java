package com.plugin.wirteRead.service.impl;

import com.plugin.wirteRead.mapper.UserMapper;
import com.plugin.wirteRead.model.User;
import com.plugin.wirteRead.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> find(String name) {
        return userMapper.select(name);
    }
}
