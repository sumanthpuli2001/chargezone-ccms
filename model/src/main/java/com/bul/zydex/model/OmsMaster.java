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
public class OmsMaster {

    private int id;
    private String ticketId;
    private String prNumber;
    private String dateTime;
    private String omsPrId;
    private int prFlag;
    /*  0-Pr Not Created, 1-Draft, 2-Created-Send For Approval, 3-PR Approved, 4-PR Reject, 5-PR Rework, 6-7 reserved,
     8-Tender Created, 9-10 reserved
     11-PriceBid open, 12-13 reserved, 14-po Create
     */

    public OmsMaster() {
    }

    public OmsMaster(int id, String ticketId, String prNumber, String dateTime, int prFlag, String omsPrId) {
        this.id = id;
        this.ticketId = ticketId;
        this.prNumber = prNumber;
        this.dateTime = dateTime;
        this.prFlag = prFlag;
        this.omsPrId = omsPrId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getPrNumber() {
        return prNumber;
    }

    public void setPrNumber(String prNumber) {
        this.prNumber = prNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getPrFlag() {
        return prFlag;
    }

    public void setPrFlag(int prFlag) {
        this.prFlag = prFlag;
    }

    public String getOmsPrId() {
        return omsPrId;
    }

    public void setOmsPrId(String omsPrId) {
        this.omsPrId = omsPrId;
    }

}
