package com.xxx.springboot.query;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 15:51
 * @Description:com.xxx.springboot.query
 * @version:v1.0.0
 */
public class UserQuery {

    private Integer pageNum = 1; //
    private Integer pageSize = 10; //
    private String userName; //


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
