package com.example.courseondemand.home_fragment_list;

public class OrderResponse {
    public Long entryDate;
    public OrderLesson lesson;
    public OrderPacket packet;
    public OrderPayment payment;
    public int status;
    public OrderUser student;
    public OrderTeach teach;
    public OrderUser tentor;

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

    public Long getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Long entryDate) {
        this.entryDate = entryDate;
    }

    public OrderLesson getLesson() {
        return lesson;
    }

    public void setLesson(OrderLesson lesson) {
        this.lesson = lesson;
    }

    public OrderPacket getPacket() {
        return packet;
    }

    public void setPacket(OrderPacket packet) {
        this.packet = packet;
    }

    public OrderPayment getPayment() {
        return payment;
    }

    public void setPayment(OrderPayment payment) {
        this.payment = payment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OrderUser getStudent() {
        return student;
    }

    public void setStudent(OrderUser student) {
        this.student = student;
    }

    public OrderTeach getTeach() {
        return teach;
    }

    public void setTeach(OrderTeach teach) {
        this.teach = teach;
    }

    public OrderUser getTentor() {
        return tentor;
    }

    public void setTentor(OrderUser tentor) {
        this.tentor = tentor;
    }

    class OrderLesson {
        public String lessonId;
        public String lessonMajor;
        public String lessonName;

        public OrderLesson(String lessonId, String lessonMajor, String lessonName) {
            this.lessonId = lessonId;
            this.lessonMajor = lessonMajor;
            this.lessonName = lessonName;
        }

        public String getLessonId() {
            return lessonId;
        }

        public void setLessonId(String lessonId) {
            this.lessonId = lessonId;
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

    class OrderPacket {
        public String meeting;
        public String person;

        public OrderPacket(String meeting, String person) {
            this.meeting = meeting;
            this.person = person;
        }

        public String getMeeting() {
            return meeting;
        }

        public void setMeeting(String meeting) {
            this.meeting = meeting;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }
    }

    class OrderPayment {
        public String method;
        public String price;

        public OrderPayment(String method, String price) {
            this.method = method;
            this.price = price;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    class OrderUser {
        public String UID;
        public String major;
        public String name;
        public String picture;
        public String university;

        public OrderUser(String UID, String major, String name, String picture, String university) {
            this.UID = UID;
            this.major = major;
            this.name = name;
            this.picture = picture;
            this.university = university;
        }

        public String getUID() {
            return UID;
        }

        public void setUID(String UID) {
            this.UID = UID;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
    }

    class OrderTeach {
        public String day;
        public String endTime;
        public String startTime;
        public String teachDuration;
        public String teachPriod;

        public OrderTeach(String day, String endTime, String startTime, String teachDuration, String teachPriod) {
            this.day = day;
            this.endTime = endTime;
            this.startTime = startTime;
            this.teachDuration = teachDuration;
            this.teachPriod = teachPriod;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getTeachDuration() {
            return teachDuration;
        }

        public void setTeachDuration(String teachDuration) {
            this.teachDuration = teachDuration;
        }

        public String getTeachPriod() {
            return teachPriod;
        }

        public void setTeachPriod(String teachPriod) {
            this.teachPriod = teachPriod;
        }
    }
}
