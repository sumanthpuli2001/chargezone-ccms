/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class PolicyCreate implements java.io.Serializable{
    
    private Integer id;
    private String name;
    private PolicyDropDown policyDropDown;
    private String attachment;
    private Integer status;
    
    public PolicyCreate(){
        
    } 

    public PolicyCreate(Integer id, String name, PolicyDropDown policyDropDown, String attachment, Integer status) {
        this.id = id;
        this.name = name;
        this.policyDropDown = policyDropDown;
        this.attachment = attachment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PolicyDropDown getPolicyDropDown() {
        return policyDropDown;
    }

    public void setPolicyDropDown(PolicyDropDown policyDropDown) {
        this.policyDropDown = policyDropDown;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

}
