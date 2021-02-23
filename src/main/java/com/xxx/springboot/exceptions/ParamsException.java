package com.xxx.springboot.exceptions;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 16:12
 * @Description:com.xxx.springboot.exceptions
 * @version:v1.0.0
 */

public class ParamsException extends RuntimeException {

    private String msg = "参数异常";
    private Integer code = 300;

    public ParamsException() {
        super("参数异常!");
    }

    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ParamsException(Integer code) {
        super("参数异常");
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}