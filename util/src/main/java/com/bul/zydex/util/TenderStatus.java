/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

/**
 *
 * @author admin
 */
public class TenderStatus {
   
    private int id;
    private String refNo;
    private int tenderPhase;
    private int vendor_total;
    private int total_bid;
    private int total_regret;
    private String pre_bid_open_flag;
    private String pre_bid_approve_flag;
    private String tech_bid_open_flag;
    private String tech_bid_approve_flag;
    private String price_bid_open_flag;
    private int tender_id;
    private String title="";
    private String pr_no="";
    private String tender_date="";
    private String tender_due_date="";
    private String emd="";
    private String created_by="";
    private String bid_status="";
    private String bid_amount="";
    
    public TenderStatus() {
    }
    
    public TenderStatus(int id, String refNo, int tender_id, String title, String pr_no, String tender_date, String tender_due_date, String emd, String created_by, int tenderPhase, int vendor_total, int total_bid, int total_regret, String pre_bid_open_flag, String pre_bid_approve_flag, String tech_bid_open_flag, String tech_bid_approve_flag, String price_bid_open_flag, String bid_status, String bid_amount) {
        this.id = id;
        this.refNo = refNo;
        this.tenderPhase = tenderPhase;
        this.vendor_total = vendor_total;
        this.total_bid = total_bid;
        this.tender_id = tender_id;
        this.title = title;
        this.pr_no = pr_no;
        this.tender_date = tender_date;
        this.tender_due_date = tender_due_date;
        this.emd = emd;
        this.created_by = created_by;
        this.total_regret = total_regret;
        this.pre_bid_open_flag = pre_bid_open_flag;
        this.pre_bid_approve_flag = pre_bid_approve_flag;
        this.tech_bid_open_flag = tech_bid_open_flag;
        this.tech_bid_approve_flag = tech_bid_approve_flag;
        this.price_bid_open_flag = price_bid_open_flag;
        this.bid_status = bid_status;
        this.bid_amount = bid_amount;
    }

    public int getId() {
        return id;
    }

    public TenderStatus setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderStatus setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public int getTender_id() {
        return tender_id;
    }

    public TenderStatus setTender_id(int tender_id) {
        this.tender_id = tender_id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TenderStatus setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPr_no() {
        return pr_no;
    }

    public TenderStatus setPr_no(String pr_no) {
        this.pr_no = pr_no;
        return this;
    }

    public String getTender_date() {
        return tender_date;
    }

    public TenderStatus setTender_date(String tender_date) {
        this.tender_date = tender_date;
        return this;
    }

    public String getTender_due_date() {
        return tender_due_date;
    }

    public TenderStatus setTender_due_date(String tender_due_date) {
        this.tender_due_date = tender_due_date;
        return this;
    }

    public String getEmd() {
        return emd;
    }

    public TenderStatus setEmd(String emd) {
        this.emd = emd;
        return this;
    }

    public String getCreated_by() {
        return created_by;
    }

    public TenderStatus setCreated_by(String created_by) {
        this.created_by = created_by;
        return this;
    }
    
    
    public int getTenderPhase() {
        return tenderPhase;
    }

    public TenderStatus setTenderPhase(int tenderPhase) {
        this.tenderPhase = tenderPhase;
        return this;
    }
    
    public int getVendor_total() {
        return vendor_total;
    }

    public TenderStatus setVendor_total(int vendor_total) {
        this.vendor_total = vendor_total;
        return this;
    }

    public int getTotal_bid() {
        return total_bid;
    }

    public TenderStatus setTotal_bid(int total_bid) {
        this.total_bid = total_bid;
        return this;
    }

    public int getTotal_regret() {
        return total_regret;
    }

    public TenderStatus setTotal_regret(int total_regret) {
        this.total_regret = total_regret;
        return this;
    }

    public String getPre_bid_open_flag() {
        return pre_bid_open_flag;
    }

    public TenderStatus setPre_bid_open_flag(String pre_bid_open_flag) {
        this.pre_bid_open_flag = pre_bid_open_flag;
        return this;
    }

    public String getPre_bid_approve_flag() {
        return pre_bid_approve_flag;
    }

    public TenderStatus setPre_bid_approve_flag(String pre_bid_approve_flag) {
        this.pre_bid_approve_flag = pre_bid_approve_flag;
        return this;
    }

    public String getTech_bid_open_flag() {
        return tech_bid_open_flag;
    }

    public TenderStatus setTech_bid_open_flag(String tech_bid_open_flag) {
        this.tech_bid_open_flag = tech_bid_open_flag;
        return this;
    }

    public String getTech_bid_approve_flag() {
        return tech_bid_approve_flag;
    }

    public TenderStatus setTech_bid_approve_flag(String tech_bid_approve_flag) {
        this.tech_bid_approve_flag = tech_bid_approve_flag;
        return this;
    }

    public String getPrice_bid_open_flag() {
        return price_bid_open_flag;
    }

    public TenderStatus setPrice_bid_open_flag(String price_bid_open_flag) {
        this.price_bid_open_flag = price_bid_open_flag;
        return this;
    }

    public String getBid_status() {
        return bid_status;
    }

    public TenderStatus setBid_status(String bid_status) {
        this.bid_status = bid_status;
        return this;
    }

    public String getBid_amount() {
        return bid_amount;
    }

    public TenderStatus setBid_amount(String bid_amount) {
        this.bid_amount = bid_amount;
        return this;
    }
    
    
    
}
