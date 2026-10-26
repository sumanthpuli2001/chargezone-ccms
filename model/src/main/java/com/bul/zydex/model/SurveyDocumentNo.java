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
public class SurveyDocumentNo {
    private Integer id;
    private String DocumentNo;

    public SurveyDocumentNo() {
    }

    public SurveyDocumentNo(Integer id, String DocumentNo) {
        this.id = id;
        this.DocumentNo = DocumentNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentNo() {
        return DocumentNo;
    }

    public void setDocumentNo(String DocumentNo) {
        this.DocumentNo = DocumentNo;
    }
    
}
