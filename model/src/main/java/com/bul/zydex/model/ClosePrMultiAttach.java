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
public class ClosePrMultiAttach {
    
    
    private int id;
    private String prNo;
    private String attachment;

    public ClosePrMultiAttach() {
    }

    public ClosePrMultiAttach(int id, String prNo, String attachment) {
        this.id = id;
        this.prNo = prNo;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    
    
  
    
}
