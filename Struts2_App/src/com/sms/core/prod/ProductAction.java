package com.sms.core.prod;

import com.sms.core.common.action.BaseAction;

public class ProductAction extends BaseAction {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String queryProd() {
        this.message = "产品查询";
        return SUCCESS;
    }
}
