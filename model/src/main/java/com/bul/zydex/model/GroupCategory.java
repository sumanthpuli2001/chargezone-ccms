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
public class GroupCategory {
    private int id;
    private int groupMasterId;
    private String groupCatogryName;

    public GroupCategory() {
    }

    public GroupCategory(int id, int groupMasterId, String groupCatogryName) {
        this.id = id;
        this.groupMasterId = groupMasterId;
        this.groupCatogryName = groupCatogryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupMasterId() {
        return groupMasterId;
    }

    public void setGroupMasterId(int groupMasterId) {
        this.groupMasterId = groupMasterId;
    }

    public String getGroupCatogryName() {
        return groupCatogryName;
    }

    public void setGroupCatogryName(String groupCatogryName) {
        this.groupCatogryName = groupCatogryName;
    }
    
}
