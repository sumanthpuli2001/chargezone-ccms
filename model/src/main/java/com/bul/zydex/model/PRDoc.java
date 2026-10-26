/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-5
 */
public class PRDoc {
    
    private int id;
    private String prNo;    
    private String docName; 
    private String refNo;
    private String docTitle; 
    private int attachmentRequired;
    
    public PRDoc() {
    }

    public PRDoc(int id, String prNo, String docName, String refNo, String docTitle, int attachmentRequired) {
        this.id = id;
        this.prNo = prNo;
        this.docName = docName;
        this.refNo = refNo;
        this.docTitle = docTitle;
        this.attachmentRequired = attachmentRequired;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public int getAttachmentRequired() {
        return attachmentRequired;
    }

    public void setAttachmentRequired(int attachmentRequired) {
        this.attachmentRequired = attachmentRequired;
    }
    
    
    
}
