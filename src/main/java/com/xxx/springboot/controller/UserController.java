package com.xxx.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.xxx.springboot.model.ResultInfo;
import com.xxx.springboot.query.UserQuery;
import com.xxx.springboot.service.UserService;
import com.xxx.springboot.vo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 15:32
 * @Description:com.xxx.springboot.controller
 * @version:v1.0.0
 */


@RestController
@Api(tags = "用户模块管理")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("user/uname/{userName}")
    @ApiOperation(value = "方法上,方法的说明")
    public User queryUserByUserName(@PathVariable String userName) {
        System.out.println("参数的值---->" + userName);
        return userService.queryUserByUserName(userName);

    }

    @GetMapping("user/{userId}")
    public User queryUserByUserId(@PathVariable Integer userId) {
        return userService.queryById(userId);
    }

    @PutMapping("user")
    public ResultInfo savaUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        userService.saveUser(user);
        return resultInfo;
    }

    @PostMapping("user")
    public ResultInfo updateUser(@RequestBody User user) {
        ResultInfo resultInfo = new ResultInfo();
        userService.update(user);
        return resultInfo;
    }

    @DeleteMapping("user/{userId}")
    public ResultInfo deleteUser(@PathVariable Integer userId) {
        ResultInfo resultInfo = new ResultInfo();
        userService.delete(userId);
        return resultInfo;
    }

    @GetMapping("user/list")
    public PageInfo<User> queryUsersByParams(UserQuery userQuery) {

        return userService.queryUserByParams(userQuery);

    }


    @PostMapping("user02")
    @ApiOperation(value = "用户模块,数据校验测试添加用户")
    public ResultInfo savaUser02(@Valid User user) {//对形参值进行参数校验
        ResultInfo resultInfo = new ResultInfo();
        userService.saveUser(user);
        return resultInfo;
    }

}
