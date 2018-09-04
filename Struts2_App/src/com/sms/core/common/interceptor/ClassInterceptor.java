package com.sms.core.common.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sms.core.common.action.BaseAction;

/**
 * 1、继承一个接口AbstractInterceptor(用于对一个类中所有方法进行拦截处理)
 */
public class ClassInterceptor extends AbstractInterceptor {

    /**
     * 执行Action请求的拦截处理
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    public String intercept(ActionInvocation actionInvocation) throws Exception {
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
