package com.brainstrom.onestoreframework.cloud;

/**
 * Created by Tej on 01-Jun-15.
 */
public class SendNotificationFrame {
    String message, title, payId, ammount;

    public SendNotificationFrame(String message, String title, String payId, String ammount) {
        this.ammount = ammount;
        this.message = message;
        this.payId = payId;
        this.title = title;
    }

    public String getAmmount() {
        return ammount;
    }

    public String getMessage() {
        return message;
    }

    public String getPayId() {
        return payId;
    }

    public String getTitle() {
        return title;
    }
}
