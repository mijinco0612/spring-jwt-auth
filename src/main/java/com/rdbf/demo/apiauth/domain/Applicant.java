package com.rdbf.demo.apiauth.domain;
import java.time.LocalDateTime;

public class Applicant {
    private Integer applicantId;
    private String occupation;
    private String applicantName;
    private String applicantNameRuby;
    private LocalDateTime birthDay;
    private String gender;
    private String eMail;
    private String phoneNumber;
    private String desc;

    public Applicant(Integer applicantId, String occupation, String applicantName, String applicantNameRuby, LocalDateTime birthDay, String gender, String eMail, String phoneNumber, String desc) {
        this.applicantId = applicantId;
        this.occupation = occupation;
        this.applicantName = applicantName;
        this.applicantNameRuby = applicantNameRuby;
        this.birthDay = birthDay;
        this.gender = gender;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.desc = desc;
    }

    public Applicant() {
    }

    @Override
    public String toString() {
        return "データの中身"+this.applicantId+","+this.occupation+","+this.applicantName+","+this.applicantNameRuby+","+this.birthDay+","+this.gender+","+this.eMail+","+this.phoneNumber+","+this.desc;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantNameRuby() {
        return applicantNameRuby;
    }

    public void setApplicantNameRuby(String applicantNameRuby) {
        this.applicantNameRuby = applicantNameRuby;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

