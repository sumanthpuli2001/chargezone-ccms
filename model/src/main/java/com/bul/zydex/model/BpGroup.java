/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class BpGroup {

    private Integer id;
    private String bpGroupName;
    private String accountGroup;
    private String discription;

    public BpGroup() {
    }

    public BpGroup(Integer id, String bpGroupName, String accountGroup, String discription) {
        this.id = id;
        this.bpGroupName = bpGroupName;
        this.accountGroup = accountGroup;
        this.discription = discription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBpGroupName() {
        return bpGroupName;
    }

    public void setBpGroupName(String bpGroupName) {
        this.bpGroupName = bpGroupName;
    }

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    
    
}
