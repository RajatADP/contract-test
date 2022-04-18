package com.service.creditcard.model;

public class CreditCardResponse {

    private Status status;

    public CreditCardResponse(Status status) {
        this.status = status;
    }

    public enum Status {
        GRANTED, REJECTED
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
