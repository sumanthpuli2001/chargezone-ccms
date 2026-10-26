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
public class OapMultiAttachment {

    private int id;
    private OapForm oapForm;
    private String attachment;
    private String description;

    public OapMultiAttachment() {
    }

    public OapMultiAttachment(int id, OapForm oapForm, String attachment, String description) {
        this.id = id;
        this.oapForm = oapForm;
        this.attachment = attachment;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OapForm getOapForm() {
        return oapForm;
    }

    public void setOapForm(OapForm oapForm) {
        this.oapForm = oapForm;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    

}
