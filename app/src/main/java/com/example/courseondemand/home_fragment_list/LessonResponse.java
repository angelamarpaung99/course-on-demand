package com.example.courseondemand.home_fragment_list;

import java.io.Serializable;

public class LessonResponse implements Serializable {
    public String lessonMajor;
    public String lessonName;

    public LessonResponse(String lessonMajor, String lessonName) {
        this.lessonMajor = lessonMajor;
        this.lessonName = lessonName;
    }

    public String getLessonMajor() {
        return lessonMajor;
    }

    public void setLessonMajor(String lessonMajor) {
        this.lessonMajor = lessonMajor;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
