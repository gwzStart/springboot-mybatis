package com.xxx.springboot.service;

import com.xxx.springboot.Starter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 18:35
 * @Description:com.xxx.springboot.service
 * @version:v1.0.0
 */
//service测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
public class TestUserService {

    private Logger log = LoggerFactory.getLogger(TestUserService.class);

    @Resource
    private UserService userService;

    @Before
    public void before() {
        System.out.println("单元测试开始");
    }

    @Test
    public void test01(){
        log.info("用户记录:{}",userService.queryById(1));

    }



    @After
    public void after() {
        System.out.println("单元测试结束");
    }

}
