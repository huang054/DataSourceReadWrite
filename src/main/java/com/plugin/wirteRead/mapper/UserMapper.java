package com.plugin.wirteRead.mapper;

import com.plugin.wirteRead.annotation.Master;
import com.plugin.wirteRead.model.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserMapper {

@Master
    List<User> select(@Param("name") String name);
}
