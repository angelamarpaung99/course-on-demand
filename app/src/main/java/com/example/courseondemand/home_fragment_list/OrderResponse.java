package com.example.courseondemand.home_fragment_list;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class OrderResponse implements Serializable  {
    @Exclude public String id;
    public Long entryDate;
    public OrderLesson lesson;
    public OrderPacket packet;
    public OrderPayment payment;
    public int status;
    public OrderUser student;
    public OrderTeach teach;
    public OrderUser tentor;

    public OrderResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderResponse(Long entryDate, OrderLesson lesson, OrderPacket packet, OrderPayment payment, int status, OrderUser student, OrderTeach teach, OrderUser tentor) {
        this.entryDate = entryDate;
        this.lesson = lesson;
        this.packet = packet;
        this.payment = payment;
        this.status = status;
        this.student = student;
        this.teach = teach;
        this.tentor = tentor;
    }


    static class OrderLesson implements Serializable {
        public String lessonId;
        public String lessonMajor;
        public String lessonName;

        public OrderLesson() {
        }

        public OrderLesson(String lessonId, String lessonMajor, String lessonName) {
            this.lessonId = lessonId;
            this.lessonMajor = lessonMajor;
            this.lessonName = lessonName;
        }
    }

    static class OrderPacket implements Serializable {
        public String meeting;
        public String person;

        public OrderPacket() {
        }

        public OrderPacket(String meeting, String person) {
            this.meeting = meeting;
            this.person = person;
        }

    }

    static class OrderPayment implements Serializable {
        public String method;
        public Long price;

        public OrderPayment() {
        }

        public OrderPayment(String method, Long price) {
            this.method = method;
            this.price = price;
        }
    }

    static class OrderUser implements Serializable{
        public String UID;
        public String major;
        public String name;
        public String picture;
        public String university;

        public OrderUser() {
        }

        public OrderUser(String UID, String major, String name, String picture, String university) {
            this.UID = UID;
            this.major = major;
            this.name = name;
            this.picture = picture;
            this.university = university;
        }


    }

    static class OrderTeach implements Serializable{
        public String day;
        public String endTime;
        public String startTime;
        public String teachDuration;
        public String teachPriod;

        public OrderTeach() {
        }

        public OrderTeach(String day, String endTime, String startTime, String teachDuration, String teachPriod) {
            this.day = day;
            this.endTime = endTime;
            this.startTime = startTime;
            this.teachDuration = teachDuration;
            this.teachPriod = teachPriod;
        }

    }
}
