/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class ProjectProfile {
    private int id;
    private String projectProfile;

    public ProjectProfile() {
    }

    public ProjectProfile(int id, String projectProfile) {
        this.id = id;
        this.projectProfile = projectProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectProfile() {
        return projectProfile;
    }

    public void setProjectProfile(String projectProfile) {
        this.projectProfile = projectProfile;
    }
    
    
}
