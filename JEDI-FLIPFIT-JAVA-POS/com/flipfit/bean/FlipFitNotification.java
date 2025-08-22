package com.flipfit.bean;
/*
 *@Author : "Supraj Pulluru"
 *@ClassName: "FlipFitNotification"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.util.Date"
 */
public class FlipFitNotification {
    private String id;
    private String description;
    private String customerId;
    private String customerEmail;

    public FlipFitNotification() {
        super();
    }

    public FlipFitNotification(String id, String description, String customerId, String customerEmail) {
        this.id = id;
        this.description = description;
        this.customerId = customerId;
        this.customerEmail = customerEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
