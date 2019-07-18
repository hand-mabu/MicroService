package com.ms.service.mapper;

import com.ms.service.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUser(@Param("id") int id);
}