package com.darklovy.demo;

/**
 * struts2的请求处理类
 * public String xxXX() {}
 */
public class TestAction {

    /**
     * 每次请求都会重新创建一个新的Action对象，不存在线程安全问题
     */
    public TestAction() {
        System.out.println("实例化了==================");
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public String hello() {
        this.message = "success";
        return "success";
    }

    public String add() {
        this.message = "add";
        return "add";
    }

    public String del() {
        this.message = "del";
        return "success";
    }

    public String query() {
        this.message = "query";
        return "query";
    }


    /*public String hello() {
        return "success";
    }*/
}
