package com.sms.core.common.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Action类的父类（构建一个父类用来统一管理器子类）
 */
public abstract class BaseAction extends ActionSupport implements RequestAware,SessionAware {
    // 定义存储当前用户的key
    public static final String CURRENT_USER = "current_user";

    protected Map<String, Object> request;
    protected Map<String, Object> session;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    /**
     * 定义获取当当前用户的方法
     * @return
     */
    protected Object getCurrentUser() {
        return session.get(CURRENT_USER);
    }
}
