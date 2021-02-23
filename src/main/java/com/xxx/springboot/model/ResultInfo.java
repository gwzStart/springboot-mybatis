package com.xxx.springboot.model;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 16:39
 * @Description:com.xxx.springboot.model
 * @version:v1.0.0
 */
public class ResultInfo {

    private Integer code = 200; //
    private String msg = "操作成功";

    private Object result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
