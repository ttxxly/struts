package com.darklovy.demo.servlet;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * 通过strtus2框架获取servlet的api中信息
 * 通过注入方式获取serveltAPi中信息
 */
public class ServletAction1 extends ActionSupport implements ApplicationAware, SessionAware, RequestAware {

    protected Map<String, Object> application;

    protected Map<String, Object> session;

    protected Map<String, Object> request;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
}
