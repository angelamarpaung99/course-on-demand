package com.example.courseondemand.home_fragment_list;

public class Order {
    private User tentor, student;
    private int status;
    private long entryDate;
    private Lesson lesson;
    private Teach teach;
    private Packet packet;
    private Payment payment;

    public Order(User tentor, User student, int status, long entryDate, Lesson lesson, Teach teach, Packet packet, Payment payment) {
        this.tentor = tentor;
        this.student = student;
        this.status = status;
        this.entryDate = entryDate;
        this.lesson = lesson;
        this.teach = teach;
        this.packet = packet;
        this.payment = payment;
    }

    public Order() {
    }

    public User getTentor() {
        return tentor;
    }

    public void setTentor(User tentor) {
        this.tentor = tentor;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(long entryDate) {
        this.entryDate = entryDate;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teach getTeach() {
        return teach;
    }

    public void setTeach(Teach teach) {
        this.teach = teach;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
