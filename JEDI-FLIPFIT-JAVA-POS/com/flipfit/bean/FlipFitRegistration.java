package com.flipfit.bean;

import java.util.Date;

public class FlipFitRegistration {
    public String RegistrationId;
    public Date RegistrationDate;
    public String email;

    public FlipFitRegistration() {
        super();
    }

    public FlipFitRegistration(String registrationId, Date registrationDate, String email) {
        RegistrationId = registrationId;
        RegistrationDate = registrationDate;
        this.email = email;
    }

    public String getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(String registrationId) {
        RegistrationId = registrationId;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}