package com.example.courseondemand.home_fragment_list;

public class Packet {
    private int meet,person;

    public Packet(int meet, int person) {
        this.meet = meet;
        this.person = person;
    }

    public Packet() {
    }

    public int getMeet() {
        return meet;
    }

    public void setMeet(int meet) {
        this.meet = meet;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}
