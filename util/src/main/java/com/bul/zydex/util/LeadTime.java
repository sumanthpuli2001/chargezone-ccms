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
public class LeadTime {

    private int id;
    private String refNo="";
    private String pr_no="";
    private int tenderPhase;
    private String title="";
    private String tender_date="";
    private String tender_authorize_date="";
    private String tender_due_date="";
    private String tender_bid_date="";
    private String pre_bid_open_date="";
    private String tech_bid_open_date="";
    private String price_bid_open_date="";
    private String date_diff1="";
    private String date_diff2="";
    private String date_diff3="";
    private String date_diff4="";
    private String date_diff5="";
    private String date_diff6="";
    
    public LeadTime() {
    }
    
    public LeadTime(int id, String refNo, String pr_no, int tenderPhase, String title, String tender_date, String tender_authorize_date, String tender_due_date, String tender_bid_date, String pre_bid_open_date, String tech_bid_open_date, String price_bid_open_date, String date_diff1, String date_diff2, String date_diff3, String date_diff4, String date_diff5, String date_diff6) {
        this.id = id;
        this.refNo = refNo;
        this.pr_no = pr_no;
        this.tenderPhase = tenderPhase;
        this.title = title;
        this.tender_date = tender_date;
        this.tender_authorize_date = tender_authorize_date;
        this.tender_due_date = tender_due_date;
        this.tender_bid_date = tender_bid_date;
        this.pre_bid_open_date = pre_bid_open_date;
        this.tech_bid_open_date = tech_bid_open_date;
        this.price_bid_open_date = price_bid_open_date;
        this.date_diff1 = date_diff1;
        this.date_diff2 = date_diff2;
        this.date_diff3 = date_diff3;
        this.date_diff4 = date_diff4;
        this.date_diff5 = date_diff5;
        this.date_diff6 = date_diff6;
    }

    public int getId() {
        return id;
    }

    public LeadTime setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public LeadTime setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getPr_no() {
        return pr_no;
    }

    public LeadTime setPr_no(String pr_no) {
        this.pr_no = pr_no;
        return this;
    }

    public int getTenderPhase() {
        return tenderPhase;
    }

    public LeadTime setTenderPhase(int tenderPhase) {
        this.tenderPhase = tenderPhase;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LeadTime setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTender_date() {
        return tender_date;
    }

    public LeadTime setTender_date(String tender_date) {
        this.tender_date = tender_date;
        return this;
    }

    public String getTender_authorize_date() {
        return tender_authorize_date;
    }

    public LeadTime setTender_authorize_date(String tender_authorize_date) {
        this.tender_authorize_date = tender_authorize_date;
        return this;
    }

    public String getTender_due_date() {
        return tender_due_date;
    }

    public LeadTime setTender_due_date(String tender_due_date) {
        this.tender_due_date = tender_due_date;
        return this;
    }

    public String getPre_bid_open_date() {
        return pre_bid_open_date;
    }

    public LeadTime setPre_bid_open_date(String pre_bid_open_date) {
        this.pre_bid_open_date = pre_bid_open_date;
        return this;
    }

    public String getTech_bid_open_date() {
        return tech_bid_open_date;
    }

    public LeadTime setTech_bid_open_date(String tech_bid_open_date) {
        this.tech_bid_open_date = tech_bid_open_date;
        return this;
    }

    public String getPrice_bid_open_date() {
        return price_bid_open_date;
    }

    public LeadTime setPrice_bid_open_date(String price_bid_open_date) {
        this.price_bid_open_date = price_bid_open_date;
        return this;
    }

    public String getDate_diff1() {
        return date_diff1;
    }

    public LeadTime setDate_diff1(String date_diff1) {
        this.date_diff1 = date_diff1;
        return this;
    }

    public String getDate_diff2() {
        return date_diff2;
    }

    public LeadTime setDate_diff2(String date_diff2) {
        this.date_diff2 = date_diff2;
        return this;
    }

    public String getDate_diff3() {
        return date_diff3;
    }

    public LeadTime setDate_diff3(String date_diff3) {
        this.date_diff3 = date_diff3;
        return this;
    }

    public String getDate_diff4() {
        return date_diff4;
    }

    public LeadTime setDate_diff4(String date_diff4) {
        this.date_diff4 = date_diff4;
        return this;
    }

    public String getDate_diff5() {
        return date_diff5;
    }

    public LeadTime setDate_diff5(String date_diff5) {
        this.date_diff5 = date_diff5;
        return this;
    }

    public String getTender_bid_date() {
        return tender_bid_date;
    }

    public LeadTime setTender_bid_date(String tender_bid_date) {
        this.tender_bid_date = tender_bid_date;
        return this;
    }

    public String getDate_diff6() {
        return date_diff6;
    }

    public LeadTime setDate_diff6(String date_diff6) {
        this.date_diff6 = date_diff6;
        return this;
    }
    
    
}
