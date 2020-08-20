package com.rdbf.demo.apiauth.domain;

import java.text.SimpleDateFormat;

public class Plan {
    private String planId;
    private String personName;
    private String title;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;
    private String place;
    private String label;
    private String body;
    private Boolean share;

    public Plan(String planId, String personName, String title, SimpleDateFormat startDate,SimpleDateFormat endDate,String place,String label,String body,Boolean share) {
        this.planId = planId;
        this.personName = personName;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.label = label;
        this.body = body;
        this.share = share;
    }

    public String getPlanId() { return planId; }
    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) { this.personName = personName; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }
    public void setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }
    public void setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
    }

    public String getPlace() { return place; }
    public void setPlace(String Place) {
        this.place = place;
    }

    public String getLabel() { return label; }
    public void setLabel(String Label) {
        this.label = label;
    }

    public String getBody(){ return body;}
    public void setBody(String body){ this.body = body;}

    public Boolean getShare() {
        return share;
    }
    public void setShare(Boolean share) { this.share = share; }


}
