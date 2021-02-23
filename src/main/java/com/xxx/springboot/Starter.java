package com.xxx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 15:35
 * @Description:com.xxx.springboot
 * @version:v1.0.0
 */

@SpringBootApplication
@MapperScan("com.xxx.springboot.dao")
@EnableCaching   //Ehcache(3)开启缓存
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class);


    }

}
