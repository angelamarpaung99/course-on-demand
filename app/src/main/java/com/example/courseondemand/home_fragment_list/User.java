package com.example.courseondemand.home_fragment_list;

import java.io.Serializable;

public class User implements Serializable {

    private String uid, username, name, phone, email, major, picture, university, gender;
    private Long balance, entryDate;
    private int role;
    private Bank bank;


//    public User() {
//    }

    public String getUid() {
        return uid;
    }

    public User(String uid, String username, String name, String phone, String email, String major, String picture, String university, String gender, Long balance, Long entryDate, int role, Bank bank) {
        this.uid = uid;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.major = major;
        this.picture = picture;
        this.university = university;
        this.gender = gender;
        this.balance = balance;
        this.entryDate = entryDate;
        this.role = role;
        this.bank = bank;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Long entryDate) {
        this.entryDate = entryDate;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
