package com.sms.core.user.action;

import com.sms.core.common.action.BaseAction;
import com.sms.core.entity.UserInfo;
import com.sms.core.user.ex.UserException;

public class UserAction extends BaseAction {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    /**
     * 登录的实现action方法
     * @return
     */
    public String login() {
        System.out.println("========Action======");
        if ("admin".equals(user.getAccount()) && "123".equals(user.getPassword())) {
            session.put(CURRENT_USER, user.getAccount());
            return SUCCESS;
        } else {
            throw new UserException("用户登录出现异常");
        }
    }

    /**
     * 这个方法的使用必须是登录后才能使用，如果没有登录直接跳转到登录页面进行登录操作
     * @return
     */
    public String add() {
        this.message = "新增用户信息对象";
        return  SUCCESS;
    }
}
