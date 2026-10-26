/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class TenderFollowup {
    
    private int id;
    private String activityDate;
    private String activity;
    private String person;
    private String tenderNo;
    private String location;
    private String personFullname;
    
    public TenderFollowup() {
    }
    
    public TenderFollowup(int id, String activityDate, String activity, String person, String tenderNo, String location, String personFullname) {
        this.id = id;
        this.activityDate = activityDate;
        this.activity = activity;
        this.person = person;
        this.tenderNo = tenderNo;
        this.location = location;
        this.personFullname = personFullname;
    }

    public int getId() {
        return id;
    }

    public TenderFollowup setId(int id) {
        this.id = id;
        return this;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public TenderFollowup setActivityDate(String activityDate) {
        this.activityDate = activityDate;
        return this;
    }

    public String getActivity() {
        return activity;
    }

    public TenderFollowup setActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public String getPerson() {
        return person;
    }

    public TenderFollowup setPerson(String person) {
        this.person = person;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public TenderFollowup setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public TenderFollowup setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getPersonFullname() {
        return personFullname;
    }

    public TenderFollowup setPersonFullname(String personFullname) {
        this.personFullname = personFullname;
        return this;
    }
    
    
    
}
