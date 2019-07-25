package com.example.courseondemand.home_fragment_list;

import java.io.Serializable;

public class Bank implements Serializable {
    private String bankName, bankNumber, ownerName;
    private int bankCode;

    public Bank(String bankName, String bankNumber, String ownerName, int bankCode) {
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.ownerName = ownerName;
        this.bankCode = bankCode;
    }

//    public Bank() {
//    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }
}
