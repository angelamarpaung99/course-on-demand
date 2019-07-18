package com.example.courseondemand.home_fragment_list;

public class Lesson {
    private String lessonId, lessonName, lessonMajor;

    public Lesson(String lessonId, String lessonName, String lessonMajor) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.lessonMajor = lessonMajor;
    }

    public Lesson() {
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonMajor() {
        return lessonMajor;
    }

    public void setLessonMajor(String lessonMajor) {
        this.lessonMajor = lessonMajor;
    }
}
