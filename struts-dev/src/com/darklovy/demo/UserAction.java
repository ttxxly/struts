package com.darklovy.demo;


import com.darklovy.demo.servlet.ServletAction1;

/**
 * struts2的请求处理类
 * public String xxXX() {}
 */
public class UserAction extends ServletAction1 {

    /**
     * 每次请求都会重新创建一个新的Action对象，不存在线程安全问题
     */
    public UserAction() {
        System.out.println("实例化了==================");
    }

    private String message;

    // 普通参数如果只是封装页面的数据，只需要提供setter方法就OK。
    // 如果参数是复合型参数必须提供对象的setter和getterr方法

    /*private String account;
    private String password;

    public void setAccount(String account) {
        this.account = account;
    }



    public void setPassword(String password) {
        this.password = password;
    }*/

    // 在strtus2的Action不能够定义带get，set前缀的方法
    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public String hello() {
        this.message = "success";
        return "success";
    }

    public String add() {
        this.message = "addUser";
        // System.out.println(account + "," + password);
        System.out.println(user.getAccount() + "," + user.getPassword());
        this.request.put("req", "request对象中数据");
        this.session.put("ses", "session存储的数据");
        return "success";
    }

    public String del() {
        this.message = "delUser";
        return "success";
    }

    public String query() {
        this.message = "queryUser";
        return "query";
    }


    /*public String hello() {
        return "success";
    }*/
}
