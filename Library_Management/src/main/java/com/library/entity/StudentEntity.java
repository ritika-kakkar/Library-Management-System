package com.library.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Student_details")
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

//    ({ "studentName", "classEnrolled", "rollNum", "bookIssued", "issuedOn"})

    @Id
    @Column(name = "Student_name")
    private String studentName;

    @Column(name = "Class_Enrolled")
    private String classEnrolled;

    @Column(name = "rollNum")
    private String rollNum;

    @Column(name = "bookIssued")
    private String bookIssued;

    @Column(name = "issuedOn")
    private String issuedOn;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassEnrolled() {
        return classEnrolled;
    }

    public void setClassEnrolled(String classEnrolled) {
        this.classEnrolled = classEnrolled;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getBookIssued() {
        return bookIssued;
    }

    public void setBookIssued(String bookIssued) {
        this.bookIssued = bookIssued;
    }

    public String getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }
}
