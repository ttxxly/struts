package com.sms.core.pay;

import com.sms.core.common.action.BaseAction;

public class PayAction extends BaseAction {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String pay() {
        this.message = "支付订单";
        return SUCCESS;
    }
}
