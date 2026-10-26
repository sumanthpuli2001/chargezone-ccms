/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class ProjectType {

    private int id;
    private String projectType;

    public ProjectType() {
    }

    public ProjectType(int id, String projectType) {
	this.id = id;
	this.projectType = projectType;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getProjectType() {
	return projectType;
    }

    public void setProjectType(String projectType) {
	this.projectType = projectType;
    }

}
