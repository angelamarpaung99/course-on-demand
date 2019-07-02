package com.example.courseondemand.home_fragment_list;

import java.io.Serializable;

public class ListScheduleModel implements Serializable {

    private String id, name, day, lesson, start,ends, duration, major, university, teachingduration, packet;
    private int price,person;

    public ListScheduleModel(String id, String name, String day, String lesson, String start, String ends, String duration, String major, String university, String teachingduration, String packet, int price, int person) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.lesson = lesson;
        this.start = start;
        this.ends = ends;
        this.duration = duration;
        this.major = major;
        this.university = university;
        this.teachingduration = teachingduration;
        this.packet = packet;
        this.price = price;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnds() {
        return ends;
    }

    public void setEnds(String ends) {
        this.ends = ends;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTeachingduration() {
        return teachingduration;
    }

    public void setTeachingduration(String teachingduration) {
        this.teachingduration = teachingduration;
    }

    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}
