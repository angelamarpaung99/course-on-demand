package com.example.courseondemand.home_fragment_list;

public class Teach {
    private String teachDuration, day, startTime, endTime, teachPeriod;

    public Teach(String teachDuration, String day, String startTime, String endTime, String teachPeriod) {
        this.teachDuration = teachDuration;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teachPeriod = teachPeriod;
    }

    public Teach() {
    }

    public String getTeachDuration() {
        return teachDuration;
    }

    public void setTeachDuration(String teachDuration) {
        this.teachDuration = teachDuration;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTeachPeriod() {
        return teachPeriod;
    }

    public void setTeachPeriod(String teachPeriod) {
        this.teachPeriod = teachPeriod;
    }
}
