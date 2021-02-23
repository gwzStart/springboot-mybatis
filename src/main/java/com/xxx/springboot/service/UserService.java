package com.xxx.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.springboot.dao.UserDao;
import com.xxx.springboot.query.UserQuery;
import com.xxx.springboot.utils.AssertUtil;
import com.xxx.springboot.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 15:30
 * @Description:com.xxx.springboot.service
 * @version:v1.0.0
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Cacheable(value = "users", key = "#userName")   ////Ehcache(6)添加注解
    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }

    @Cacheable(value = "users", key = "#userId")
    public User queryById(Integer userId) {
        AssertUtil.isTrue(true, "异常测试");
        return userDao.queryById(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)//声明式事务注解
    public void saveUser(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空!");
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()), "用户名密码不能为空!");
        AssertUtil.isTrue(null != userDao.queryUserByUserName(user.getUserName()), "该用户已存在");
        AssertUtil.isTrue(userDao.save(user) < 1, "用户添加失败");
    }

    @Transactional(propagation = Propagation.REQUIRED)//声明式事务注解
    public void update(User user) {
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空!");
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()), "用户名密码不能为空!");
        AssertUtil.isTrue(null == userDao.queryById(user.getUserId()), "用户不存在");
        User user1 = userDao.queryUserByUserName(user.getUserName());
        AssertUtil.isTrue(null != user1 && !(user1.getUserId().equals(user.getUserId())), "用户已存在!");

        AssertUtil.isTrue(userDao.update(user) < 1, "用户更新失败");
    }

    @Transactional(propagation = Propagation.REQUIRED)//声明式事务注解
    public void delete(Integer userId) {
        AssertUtil.isTrue(null == userId || null == userDao.queryById(userId), "用户不存在");
        AssertUtil.isTrue(userDao.delete(userId) < 1, "用户删除失败");
        userDao.delete(userId);
        int a = 1 / 0;//出现异常

    }

    @Cacheable(value = "users", key = "#userQuery.userName+'-'+#userQuery.pageNum+'-'+#userQuery.pageSize")
    public PageInfo<User> queryUserByParams(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        List<User> users = userDao.selectByParams(userQuery);
        return new PageInfo<User>(users);

    }


}
