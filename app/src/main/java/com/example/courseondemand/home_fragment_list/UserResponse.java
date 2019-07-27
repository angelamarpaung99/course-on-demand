package com.example.courseondemand.home_fragment_list;

import java.io.Serializable;

public class UserResponse implements Serializable {
    public String email, gender, major, name, phone, picture,timestamp, university, username;
    public Long balance, role;

    public UserResponse() {
    }

    public UserResponse(String email, String gender, String major, String name, String phone, String picture, String timestamp, String university, String username, Long balance, Long role) {
        this.email = email;
        this.gender = gender;
        this.major = major;
        this.name = name;
        this.phone = phone;
        this.picture = picture;
        this.timestamp = timestamp;
        this.university = university;
        this.username = username;
        this.balance = balance;
        this.role = role;
    }

    static class Bank implements Serializable{
        public String bankName, bankNumber, ownerName;
        public Long bankCode;

        public Bank() {
        }

        public Bank(String bankName, String bankNumber, String ownerName, Long bankCode) {
            this.bankName = bankName;
            this.bankNumber = bankNumber;
            this.ownerName = ownerName;
            this.bankCode = bankCode;
        }
    }
}
