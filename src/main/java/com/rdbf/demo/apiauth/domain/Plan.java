package com.rdbf.demo.apiauth.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plan {
//    private String planId;
//    private People people;
//    private String title;
//    private SimpleDateFormat startDate;
//    private SimpleDateFormat endDate;
//    private String place;
//    private String label;
//    private String body;
//    private Boolean share;
//
//    public Plan(String planId, People people, String title, SimpleDateFormat startDate,SimpleDateFormat endDate,String place,String label,String body,Boolean share) {
//        this.planId = planId;
//        this.people = people;
//        this.title = title;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.place = place;
//        this.label = label;
//        this.body = body;
//        this.share = share;
//    }

    private int planId;
    private String personName;
    private String title;
    private Date startDate;
    private Date endDate;
    private String label;
    private String body;
    private Boolean share;
    private String place;

    public Plan(int planId, String personName, String title, Date startDate,Date endDate,String label,String body,Boolean share,String place) {
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

    public int getPlanId() { return planId; }
    public void setPlanId(int planId) {
        this.planId = planId;
    }

//    public People getPeople() { return this.people; }
//    public void setPersonName(People people) { this.people = people; }
    public String getPersonName() {
    return personName;
}
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
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
