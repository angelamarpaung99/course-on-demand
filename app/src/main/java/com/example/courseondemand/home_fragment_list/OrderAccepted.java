package com.example.courseondemand.home_fragment_list;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class OrderAccepted implements Parcelable {
    public String id;
    public String name, university, lesson, major,duration, day, start, ends,packet, person, price, url;

    public OrderAccepted() {
    }

    public OrderAccepted(String id, String name, String university, String lesson, String major, String duration, String day, String start, String ends, String packet, String person, String price, String url) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.lesson = lesson;
        this.major = major;
        this.duration = duration;
        this.day = day;
        this.start = start;
        this.ends = ends;
        this.packet = packet;
        this.person = person;
        this.price = price;
        this.url = url;
    }


    protected OrderAccepted(Parcel in) {
        id = in.readString();
        name = in.readString();
        university = in.readString();
        lesson = in.readString();
        major = in.readString();
        duration = in.readString();
        day = in.readString();
        start = in.readString();
        ends = in.readString();
        packet = in.readString();
        person = in.readString();
        price = in.readString();
        url = in.readString();
    }

    public static final Creator<OrderAccepted> CREATOR = new Creator<OrderAccepted>() {
        @Override
        public OrderAccepted createFromParcel(Parcel in) {
            return new OrderAccepted(in);
        }

        @Override
        public OrderAccepted[] newArray(int size) {
            return new OrderAccepted[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(university);
        parcel.writeString(lesson);
        parcel.writeString(major);
        parcel.writeString(duration);
        parcel.writeString(day);
        parcel.writeString(start);
        parcel.writeString(ends);
        parcel.writeString(packet);
        parcel.writeString(person);
        parcel.writeString(price);
        parcel.writeString(url);
    }
}
