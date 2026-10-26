/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class ApApprovalUser {
    
    private int id;
    private ApApprovalSetting apApprovalSetting;
    private String userId;
    private int level;
    
    public ApApprovalUser() {
    }
    
    public ApApprovalUser(int id, ApApprovalSetting apApprovalSetting, String userId, int level) {
        this.id = id;
        this.apApprovalSetting = apApprovalSetting;
        this.userId = userId;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public ApApprovalUser setId(int id) {
        this.id = id;
        return this;
    }

    public ApApprovalSetting getApApprovalSetting() {
        return apApprovalSetting;
    }

    public ApApprovalUser setApApprovalSetting(ApApprovalSetting apApprovalSetting) {
        this.apApprovalSetting = apApprovalSetting;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ApApprovalUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public ApApprovalUser setLevel(int level) {
        this.level = level;
        return this;
    }
    
    
}
