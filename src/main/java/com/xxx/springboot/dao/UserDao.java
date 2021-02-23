package com.xxx.springboot.dao;

import com.xxx.springboot.query.UserQuery;
import com.xxx.springboot.vo.User;

import java.util.List;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 15:23
 * @Description:com.xxx.springboot.dao
 * @version:v1.0.0
 */

public interface UserDao {

    User queryUserByUserName(String userName);

    int save(User user);

    int update(User user);

    User queryById(Integer userId);

    List<User> selectByParams(UserQuery userQuery);

    int delete(Integer userId);

}
