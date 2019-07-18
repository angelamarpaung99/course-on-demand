package com.example.courseondemand.home_fragment_list;

public class Payment {
    private String method;
    private Long price;

    public Payment(String method, Long price) {
        this.method = method;
        this.price = price;
    }

    public Payment() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
