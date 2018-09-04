package com.sms.core.common.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sms.core.common.action.BaseAction;

/**
 * 方法拦截器(可以配置哪些方法需要别拦截，哪些方法不需要被拦截器)
 *
 * 拦截器和过滤器区别：
 * 过滤器是过滤所有请求的匹配资源（JSP，HTML）
 * 拦截器只会拦截框架中接纳的请求后缀。
 */
public class FilterInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("======= in ============");
        Object action = actionInvocation.getAction();
        System.out.println(action);


        // 获取登录的session中用户对象
        Object obj = actionInvocation.getInvocationContext().getSession().get(BaseAction.CURRENT_USER);

        String result = Action.LOGIN;
        if (obj != null) {
            // 已经登录,让其直接调用action中的方法
            result = actionInvocation.invoke();
        }

        return result;
    }
}
