package com.example.courseondemand.home_fragment_list;

public class ListScheduleModel {

    private String id, tentor, day, lesson, start, duration;

    public ListScheduleModel(String id, String tentor, String day, String lesson, String start, String duration) {
        this.id = id;
        this.tentor = tentor;
        this.day = day;
        this.lesson = lesson;
        this.start = start;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTentor() {
        return tentor;
    }

    public void setTentor(String tentor) {
        this.tentor = tentor;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
