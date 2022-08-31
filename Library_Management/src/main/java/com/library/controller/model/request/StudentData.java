package com.library.controller.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

@JsonPropertyOrder({ "studentName", "classEnrolled", "rollNum", "bookIssued", "issuedOn"})
public class StudentData {

    @JsonProperty("studentName")
    @ApiModelProperty(notes = "The name of the Student ", example = "Ritika")
    private String studentName;

    @JsonProperty("classEnrolled")
    @ApiModelProperty(notes = "The class of the Student ", example = "XII")
    private String classEnrolled;

    @JsonProperty("rollNum")
    @ApiModelProperty(notes = "The Roll Num of the Student ", example = "00027")
    private String rollNum;

    @JsonProperty("bookIssued")
    @ApiModelProperty(notes = "The Book issued from Library ", example = "2 States")
    private String bookIssued;

    @JsonProperty("issuedOn")
    @ApiModelProperty(notes = "Book Issued on which date", example = "")
    private DateTime issuedOn;

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

    public DateTime getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(DateTime issuedOn) {
        this.issuedOn = issuedOn;
    }
}
