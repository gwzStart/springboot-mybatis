package com.xxx.springboot.controller;

import com.xxx.springboot.Starter;
import com.xxx.springboot.service.TestUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 21:09
 * @Description:com.xxx.springboot.controller
 * @version:v1.0.0
 */
//控制器测试
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
@AutoConfigureMockMvc
public class TestUserController {

    private Logger log = LoggerFactory.getLogger(TestUserController.class);
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void before() {
        System.out.println("单元测试开始");
    }

    @Test
    public void test01() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/uname/mike")).andExpect(
                MockMvcResultMatchers.status().isOk()).andReturn();

       log.info("响应的状态:{}",result.getResponse().getStatus());
       log.info("响应的内容:{}",result.getResponse().getContentAsString());

    }



    @After
    public void after() {
        System.out.println("单元测试结束");
    }

}
