package com.darklovy.demo.servlet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.util.Map;

/**
 * 通过strtus2框架获取servlet的api中信息
 */
public class ServletAction extends ActionSupport {
    /**
     * strtus2框架封装的servlet的APi一些特性
     * @return
     */
    public String hello() {

        // request对象
        ActionContext context = ActionContext.getContext();
        // session对象
        Map<String, Object> session = context.getSession();
        // application对象
        Map<String, Object> application = context.getApplication();

        return null;
    }

    /**
     * 获取到的真的servlet中的请求，响应，session，application对象
     * @return
     */
    public String hello1() {
        // pageContext
        PageContext pageContext = ServletActionContext.getPageContext();
        // request
        HttpServletRequest request = ServletActionContext.getRequest();
        // session
        HttpSession session = request.getSession();
        // application
        ServletContext servletContext = ServletActionContext.getServletContext();

        return null;
    }
}
