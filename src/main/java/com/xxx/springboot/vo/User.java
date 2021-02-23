package com.xxx.springboot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 15:24
 * @Description:com.xxx.springboot.vo
 * @version:v1.0.0
 */
@ApiModel(description = "用户实体对象")
public class User implements Serializable {   //Ehcache(4)实现序列化接口

    @ApiModelProperty(value = "用户id主键")
    private Integer userId; //

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空!")  //校验注解
    private String userName; //

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "密码不能为空!")  //校验注解
    @Length(min = 6, max = 12, message = "密码长度至少6位不超过12位")
    private String password; //

    @ApiModelProperty(value = "用户性别")
    private char sex; //

    @ApiModelProperty(value = "用户邮箱")
    @Email   //不是必填,填了就必须满足邮箱格式
    private String email; //

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
