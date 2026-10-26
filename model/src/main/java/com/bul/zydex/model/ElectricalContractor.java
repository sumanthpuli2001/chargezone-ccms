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
public class ElectricalContractor {

    private int id;
    private int vendorCriteriaMasterId;
    private String criteria;
    private String selectionCriteria;
    private String comment;
    private String attachment;
    private String score;
    private VendorInformation vendorInformation;
    private String response;
    private String technicalComment;
    private String compulsaryFlag;

    public ElectricalContractor() {
    }

    public ElectricalContractor(int id, int vendorCriteriaMasterId, String criteria, String selectionCriteria, String comment, String attachment, String score, VendorInformation vendorInformation, String response, String technicalComment, String compulsaryFlag) {
        this.id = id;
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
        this.criteria = criteria;
        this.selectionCriteria = selectionCriteria;
        this.comment = comment;
        this.attachment = attachment;
        this.score = score;
        this.vendorInformation = vendorInformation;
        this.response = response;
        this.technicalComment = technicalComment;
        this.compulsaryFlag = compulsaryFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorCriteriaMasterId() {
        return vendorCriteriaMasterId;
    }

    public void setVendorCriteriaMasterId(int vendorCriteriaMasterId) {
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(String selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public VendorInformation getVendorInformation() {
        return vendorInformation;
    }

    public void setVendorInformation(VendorInformation vendorInformation) {
        this.vendorInformation = vendorInformation;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTechnicalComment() {
        return technicalComment;
    }

    public void setTechnicalComment(String technicalComment) {
        this.technicalComment = technicalComment;
    }

    public String getCompulsaryFlag() {
        return compulsaryFlag;
    }

    public void setCompulsaryFlag(String compulsaryFlag) {
        this.compulsaryFlag = compulsaryFlag;
    }

}
