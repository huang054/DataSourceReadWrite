package com.plugin.wirteRead.service;

import com.plugin.wirteRead.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemberService {

    List<User> find(String name);
}
