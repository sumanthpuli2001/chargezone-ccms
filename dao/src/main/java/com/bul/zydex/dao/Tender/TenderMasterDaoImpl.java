/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.LiveTender;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class TenderMasterDaoImpl<T> extends GenericsDAOImpl<T> implements TenderMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return TenderMaster.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorLiveTender(String username) {
        String query = "";
        query += " select b.refNo, b.rfqNo, a.title, a.docCost, a.emd, a.announceDate, a.submitLastdate, a.tenderPhase, a.tenderType FROM TenderMaster a, TenderVendor b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.refNo = b.refNo and a.authorizeFlag=1"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public TenderMaster readByVendorRefNo(String refNo, String username) {
        TenderMaster tenderMaster = new TenderMaster();
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderMaster = (TenderMaster) list.get(0);
        }
        return tenderMaster;
    }

    @Override
    public TenderMaster readRefNo(String refNo) {
        TenderMaster tenderMaster = new TenderMaster();
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderMaster = (TenderMaster) list.get(0);
        }
        return tenderMaster;
    }

    @Override
    public List unauthorizeTender(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //+ " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.authorizeFlag = '0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void authorizeTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String query = "";
        query += " update TenderMaster a"
                + " set a.title='" + title + "', "
                + " a.value='" + value + "', "
                + " a.emd='" + emd + "', "
                + " a.docCost='" + docCost + "', "
                + " a.categoryId='" + categoryId + "', "
                + " a.submitLastdate='" + submitLastdate + "', "
                + " a.workDesc='" + workDesc + "', "
                + " a.prNo='" + prNo + "', "
                + " a.tenderRemark='" + remark + "', "
                + " a.tenderAuthorizeUserName='" + username + "', "
                + " a.tenderAuthorizePerson='" + full_name + "', "
                + " a.tenderAuthorizeContactNo='" + contact_no + "', "
                + " a.authorizeFlag='1', "
                + " a.authorizeDate='" + formattedDate + "', "
                + " a.isInAuthoTable='0' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void recycleTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.title='" + title + "', "
                + " a.value='" + value + "', "
                + " a.emd='" + emd + "', "
                + " a.docCost='" + docCost + "', "
                + " a.categoryId='" + categoryId + "', "
                + " a.submitLastdate='" + submitLastdate + "', "
                + " a.workDesc='" + workDesc + "', "
                + " a.prNo='" + prNo + "', "
                + " a.tenderRemark='" + remark + "', "
                + " a.tenderAuthorizeUserName='" + username + "', "
                + " a.tenderAuthorizePerson='" + full_name + "', "
                + " a.tenderAuthorizeContactNo='" + contact_no + "', "
                + " a.authorizeFlag='2' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void rejectTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.title='" + title + "', "
                + " a.value='" + value + "', "
                + " a.emd='" + emd + "', "
                + " a.docCost='" + docCost + "', "
                + " a.categoryId='" + categoryId + "', "
                + " a.submitLastdate='" + submitLastdate + "', "
                + " a.workDesc='" + workDesc + "', "
                + " a.prNo='" + prNo + "', "
                + " a.tenderRemark='" + remark + "', "
                + " a.tenderAuthorizeUserName='" + username + "', "
                + " a.tenderAuthorizePerson='" + full_name + "', "
                + " a.tenderAuthorizeContactNo='" + contact_no + "', "
                + " a.authorizeFlag='5' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.title='" + title + "', "
                + " a.value='" + value + "', "
                + " a.emd='" + emd + "', "
                + " a.docCost='" + docCost + "', "
                + " a.categoryId='" + categoryId + "', "
                + " a.submitLastdate='" + submitLastdate + "', "
                + " a.workDesc='" + workDesc + "', "
                + " a.prNo='" + prNo + "', "
                + " a.tenderRemark='" + remark + "', "
                + " a.tenderAuthorizeUserName='" + username + "', "
                + " a.tenderAuthorizePerson='" + full_name + "', "
                + " a.tenderAuthorizeContactNo='" + contact_no + "' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List recycleTenderList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //+ " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.authorizeFlag = '2'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List rejectTenderList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                // + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.authorizeFlag = '5'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void recycleTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.title='" + title + "', "
                + " a.value='" + value + "', "
                + " a.emd='" + emd + "', "
                + " a.docCost='" + docCost + "', "
                + " a.categoryId='" + categoryId + "', "
                + " a.submitLastdate='" + submitLastdate + "', "
                + " a.workDesc='" + workDesc + "', "
                + " a.prNo='" + prNo + "', "
                + " a.tenderRemark='" + remark + "', "
                + " a.tenderAdmin='" + username + "', "
                + " a.contactPerson='" + full_name + "', "
                + " a.tenderAdminContactNumber='" + contact_no + "', "
                + " a.authorizeFlag='1' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List liveTenderList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                // + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAdmin = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveTenderList1(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //  + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAdmin = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void authTender(String refNo) {
        String query = "";
        query += " update TenderMaster a"
                + " set "
                + " a.isInAuthoTable='1' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTenderData(String refNo, String title1, String category_id1, String value1, String emd1, String doc_cost1, String type1, String contact_person1, String location1, String announce_date1, String collection_lastdate1, String submit_lastdate1, String work_desc1, String tender_remark1, String tender_admin1, String tender_admin_contact_number1, String tender_authorize_person1, String tender_authorize_contact_no1, int authorize_flag1, String tender_authorize_user_name1, int re_autho_flag1, int is_in_autho_table1, int vendor_flag1, int item_flag1, int email_flag1, String authorize_date1, int return_flag1, int delete_flag1, int tender_phase1, int open_bid_flag1, String department1, String pr_no1) {
        String query = "";
        query += " update AuthTenderMaster a"
                + " set a.title='" + title1 + "', "
                + " a.value='" + category_id1 + "', "
                + " a.value='" + value1 + "', "
                + " a.emd='" + emd1 + "', "
                + " a.docCost='" + doc_cost1 + "', "
                + " a.type='" + type1 + "', "
                + " a.contactPerson='" + contact_person1 + "', "
                + " a.location='" + location1 + "', "
                + " a.announceDate='" + announce_date1 + "', "
                + " a.collectionLastdate='" + collection_lastdate1 + "', "
                + " a.submitLastdate='" + submit_lastdate1 + "', "
                + " a.workDesc='" + work_desc1 + "', "
                + " a.tenderRemark='" + tender_remark1 + "', "
                + " a.tenderAdmin='" + tender_admin1 + "', "
                + " a.tenderAdminContactNumber='" + tender_admin_contact_number1 + "', "
                + " a.tenderAuthorizePerson='" + tender_authorize_person1 + "', "
                + " a.tenderAuthorizeContactNo='" + tender_authorize_contact_no1 + "', "
                + " a.authorizeFlag='1', "
                + " a.tenderAuthorizeUserName='" + tender_authorize_user_name1 + "', "
                + " a.reAuthoFlag='0', "
                + " a.isInAuthoTable='0', "
                + " a.vendorFlag='" + vendor_flag1 + "', "
                + " a.itemFlag='" + item_flag1 + "', "
                + " a.emailFlag='" + email_flag1 + "', "
                + " a.deleteFlag='" + return_flag1 + "', "
                + " a.tenderRemark='" + delete_flag1 + "', "
                + " a.tenderPhase='" + tender_phase1 + "', "
                + " a.openBidFlag='" + open_bid_flag1 + "', "
                + " a.department='" + department1 + "', "
                + " a.prNo='" + pr_no1 + "' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List pastTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'";
                + " WHERE 1=1";
        if (tender_no.equals("")) {
        } else {
            query += " and a.refNo = '" + tender_no + "'";
        }

        if (tender_title.equals("")) {
        } else {
            query += " and a.title = '" + tender_title + "'";
        }
        if (open_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= STR_TO_DATE('" + open_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= STR_TO_DATE('" + open_to_date + "','%d-%m-%Y ')";
        }

        if (close_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= STR_TO_DATE('" + close_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= STR_TO_DATE('" + close_to_date + "','%d-%m-%Y ')";
        }

        query += " and a.authorizeFlag = '1' and a.openBidFlag='1' and a.deleteFlag='0' and a.openBidStatus=0 and a.auditFlag=0"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorOpenTender() {
        String query = "";
        query += " select b.refNo, b.rfqNo, a.title, a.docCost, a.emd, a.announceDate, a.submitLastdate, a.tenderPhase FROM TenderMaster a, TenderVendor b"
                //              + " WHERE b.vendorCode = '" + username + "'"
                + " where a.refNo = b.refNo"
                + " and a.authorizeFlag='1' and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List allLiveTender() {
        String query = "";
        query += " FROM TenderMaster a "
                //              + " WHERE b.vendorCode = '" + username + "'"
                + " where authorizeFlag='1' and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateEmailFlag(String refNo) {
        String query = "";
        query += " update TenderMaster a"
                + " set "
                + " a.emailFlag='1' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateAuthEmailFlag(String refNo) {
        String query = "";
        query += " update TenderMaster a"
                + " set "
                + " a.emailFlag='0' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List unauthorizeEmailTender(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //  + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.emailFlag = '1'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveTenderAuthorizerList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //  + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAuthorizeUserName = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveTenderAuthorizerList1(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAuthorizeUserName = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readOpenLiveTender() {
        String query = "";
        query += " Select b.tenderno, b.description, a.location, a.submitLastdate, b.tenderdoc FROM TenderMaster a, LiveTender b"
                + " WHERE a.authorizeFlag = '1'"
                + " and a.refNo = b.tenderno"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List allLiveParticipateTender(String username) {
        String query = "";
        query += " Select a.refNo, a.location, a.submitLastdate, b.techApproveFlag FROM TenderMaster a, VendorTenderBid b"
                + " WHERE a.authorizeFlag = '1' and b.vendorCode='" + username + "'"
                + " and a.refNo = b.refNo and b.revision!=0"
                + " and (STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now() or STR_TO_DATE(a.collectionLastdate,'%d-%m-%Y %H:%i:%s') >= now())";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateDate(String refNo, String submitLastdate) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.submitLastdate='" + submitLastdate + "' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateBidOpenFlag(String refNo) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.openBidFlag='1' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateCloseTender(String tender_no, String remark) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.deleteFlag='1', "
                + " a.deleteRemark='" + remark + "' "
                + " WHERE a.refNo = '" + tender_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List liveTenderUnautorizeList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAdmin = '" + username + "'"
                + " and a.authorizeFlag = '0'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List receiveBIdList1() {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now()"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0' order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorReviseTenderList(String username) {
        String query = "";
        query += " select a.refNo, a.title, a.docCost, a.emd, a.announceDate, a.submitLastdate, a.tenderPhase, a.tenderType, a.openBidFlag FROM TenderMaster a, VendorTenderBid b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.refNo = b.refNo and a.authorizeFlag=1 and b.bidOpenFlag=1 "
                + " and STR_TO_DATE(b.reviseDateTime,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateCondition(String refNo, String deliveryLocation, String deliveryPeriod, String termsOfPayment, String validityPeriod, String modeOfTransport, String incoTerms, String insurance, String freight) {
        String query = "";
        query += " update TenderMaster a"
                + " set a.deliveryLocation='" + deliveryLocation + "', "
                + " a.deliveryPeriod='" + deliveryPeriod + "', "
                + " a.termsOfPayment='" + termsOfPayment + "', "
                + " a.validityPeriod='" + validityPeriod + "', "
                + " a.modeOfTransport='" + modeOfTransport + "', "
                + " a.incoTerms='" + incoTerms + "', "
                + " a.insurance='" + insurance + "', "
                + " a.freight='" + freight + "' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List holdTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'";
                + " WHERE a.department = '" + department + "'";
        if (tender_no.equals("")) {
        } else {
            query += " and a.refNo = '" + tender_no + "'";
        }
        if (tender_title.equals("")) {
        } else {
            query += " and a.title = '" + tender_title + "'";
        }
        if (open_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE('" + open_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE('" + open_to_date + "','%d-%m-%Y ')";
        }

        if (close_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE('" + close_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE('" + close_to_date + "','%d-%m-%Y ')";
        }

        query += " and a.closeFlag = '2' and a.openBidFlag='1'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List finalTenderList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'";
                + " WHERE 1=1";
        if (tender_no.equals("")) {
        } else {
            query += " and a.refNo = '" + tender_no + "'";
        }
        if (tender_title.equals("")) {
        } else {
            query += " and a.title = '" + tender_title + "'";
        }
        if (open_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= STR_TO_DATE('" + open_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= STR_TO_DATE('" + open_to_date + "','%d-%m-%Y ')";
        }

        if (close_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= STR_TO_DATE('" + close_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= STR_TO_DATE('" + close_to_date + "','%d-%m-%Y ')";
        }

        query += " and a.openBidStatus='1'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List auditTenderList() {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.closeFlag = '1'"
                + " and a.auditFlag = '0'";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List receiveAdminBIdList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //  + " WHERE a.location = '" + location + "'"
                //  + " WHERE a.department = '"+ department+"'"
                + " WHERE a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0' and openBidStatus='1' order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getUserList() {
        String query = "";
        query += " FROM TenderMaster a"
                // + " WHERE a.location = '" + location + "'"
                + " group by a.contactPerson";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorLiveTender1(String username) {

        String query = "";
        query += " select b.refNo, b.refNo, a.title, a.docCost, a.emd, a.announceDate, a.collectionLastdate, a.tenderPhase, a.tenderType FROM TenderMaster a, VendorTenderBid b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.refNo = b.refNo and a.authorizeFlag=1 and b.techApproveFlag=1"
                + " and STR_TO_DATE(a.collectionLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List liveTenderAuthorizerList3(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //  + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAuthorizeUserName = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '1'"
                + " and STR_TO_DATE(a.collectionLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveTenderAuthorizerList4(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAuthorizeUserName = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '1'"
                + " and STR_TO_DATE(a.collectionLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveTenderList3(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                // + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAdmin = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '0'"
                + " and STR_TO_DATE(a.collectionLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveTenderList4(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                //  + " WHERE a.location = '" + location + "'"
                + " WHERE a.department = '" + department + "'"
                + " and a.tenderAdmin = '" + username + "'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0'"
                + " and a.techBidOpenFlag = '0'"
                + " and STR_TO_DATE(a.collectionLastdate,'%d-%m-%Y %H:%i:%s') <= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorTechnicalReviseTenderList(String username) {
        String query = "";
        query += " select a.refNo, a.title, a.docCost, a.emd, a.announceDate, a.submitLastdate, a.tenderPhase, a.tenderType, a.openBidFlag FROM TenderMaster a, VendorTechnicalBid b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.refNo = b.refNo and a.authorizeFlag=1"
                + " and b.bidOpenFlag=1 and (b.bidApproveFlag!=1 or b.bidApproveFlag is null) and b.reviseBidFlag=0";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorTechnicalList(String username) {
        String query = "";
        query += " select b.refNo, b.rfqNo, a.title, a.docCost, a.emd, a.announceDate, a.submitLastdate, a.tenderPhase, a.tenderType FROM TenderMaster a, TenderVendor b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.refNo = b.refNo and a.authorizeFlag=1"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public TenderMaster readByPRNo(String pr_no) {
        TenderMaster tenderMaster = new TenderMaster();
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.prNo = '" + pr_no + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderMaster = (TenderMaster) list.get(0);
        }
        return tenderMaster;
    }

    @Override
    public List readByMonth(String from_date) {

        LocalDate today = LocalDate.now();                // 2025-09-23
        LocalDate fromDate = today.minusMonths(11).withDayOfMonth(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String from_date1 = fromDate.format(formatter);

        String query = "";
        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'),'%b-%y') "
                + " FROM TenderMaster a "
                + " WHERE STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= STR_TO_DATE('" + from_date1 + "', '%d-%m-%Y') "
                + " GROUP BY DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'), '%Y-%m') "
                + " ORDER BY STR_TO_DATE(a.announceDate,'%d-%m-%Y %T') ASC";

        List<?> list = getHibernateTemplate().find(query);

        return list;

    }

    @Override
    public int readyByopenfalg() {
        String query = "Select count(a)";
        query += " FROM TenderMaster a"
                + " WHERE a.openBidStatus = '1' ";

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public List readNextTwoDayTender(String todaydate, String submitLastdate) {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE ";
        //  + " and a.department = '"+ department+"'";

        query += " STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE('" + todaydate + "','%d-%m-%Y') and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE('" + submitLastdate + "','%d-%m-%Y')";

        query += " and a.authorizeFlag = '1' and a.openBidFlag='0'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now() order by a.refNo desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public int readByDate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from TenderMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'";
            } else {
                query += " WHERE a.department ='" + Department + "'";
            }
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readByDate2(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from TenderMaster a "
                + " WHERE a.openBidStatus = '1' ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s')) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y')) ";
            } else {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y')) ";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "' ";
            } else {
                query += " AND a.department ='" + Department + "' ";
            }
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readByDate1(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "select COUNT(a) from TenderMaster a where a.deleteFlag = 0";

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                    + "BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " AND a.openBidStatus = '0'";
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                    + "BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                    + " AND a.openBidStatus = '0'";
        }

        if (!Department.equals("--select--")) {
            query += " AND a.department = '" + Department + "'"
                    + " AND a.openBidStatus = '0'";
        }

// Execute query
        Long count = (Long) this.getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByflagzero() {
        String query = "Select count(a)";
        query += " FROM TenderMaster a"
                + " WHERE a.openBidStatus = '0'"
                + "and deleteFlag = 0";
        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();

    }

    @Override
    public List readBycontactper() {
        String query = "";
        query += "SELECT a.contactPerson, "
                + "COUNT(a), "
                + "SUM(CASE WHEN a.openBidFlag = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN a.openBidFlag = 1 THEN 1 ELSE 0 END) "
                + "FROM TenderMaster a "
                + "GROUP BY a.contactPerson "
                + "ORDER BY COUNT(a) DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public int countAllPr() {
        String query = "Select count(a) from TenderMaster a";

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();

    }

    @Override
    public int countAllPrFilterUser(String username) {
        String query = "SELECT COUNT(a) FROM TenderMaster a WHERE a.tenderAdmin = :username";

        Long count = (Long) this.getHibernateTemplate()
                .findByNamedParam(query, "username", username)
                .get(0);

        return count.intValue();

    }

    @Override
    public int readyByopenfalgFilterUser(String username) {
        String query = "SELECT COUNT(a) FROM TenderMaster a WHERE a.openBidFlag = '1' AND a.tenderAdmin = :username";

        Long count = (Long) this.getHibernateTemplate()
                .findByNamedParam(query, "username", username)
                .get(0);

        return count.intValue();
    }

    @Override
    public int readByflagzeroFilterUser(String username) {
        String query = "SELECT COUNT(a) FROM TenderMaster a WHERE a.openBidFlag = '0' AND a.tenderAdmin = :username";

        Long count = (Long) this.getHibernateTemplate()
                .findByNamedParam(query, "username", username)
                .get(0);

        return count.intValue();
    }

    @Override
    public List readByMonthFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'),'%b-%y') "
                + " FROM TenderMaster a";

        if (!Filter.equals("--select--")) {
            query += " WHERE STR_TO_DATE(a.announceDate, '%d-%m-%Y %T') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %T')"
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %T')";
        }

        if (!Fromdate.equals("") && !Todate.equals("")) {
            if (query.contains("WHERE")) {
                query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y')"
                        + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
            } else {
                query += " WHERE STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y')"
                        + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
            }
        }

        if (!Department.equals("--select--")) {
            if (query.contains("WHERE")) {
                query += " AND a.department = '" + Department + "'";
            } else {
                query += " WHERE a.department = '" + Department + "'";
            }
        }

        query += " Group BY substring(DATE_FORMAT(STR_TO_DATE(announceDate,'%d-%m-%Y %T'),'%T %d-%m-%Y'),13)";
        query += " ORDER BY a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List readBycontactperFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += "SELECT a.contactPerson, "
                + "COUNT(a), "
                + "SUM(CASE WHEN a.openBidFlag = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN a.openBidFlag = 1 THEN 1 ELSE 0 END) "
                + ", DATE_FORMAT(STR_TO_DATE(announceDate,'%d-%m-%Y %T'),'%M-%Y')FROM TenderMaster a ";

        boolean whereAdded = false;
        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('"
                    + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d-%m-%Y'))";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d-%m-%Y'))";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'";
            } else {
                query += " WHERE a.department ='" + Department + "'";
            }
        }

        query += " GROUP BY a.contactPerson ";

        query += " ORDER BY COUNT(a) DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public int countAllPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += "select COUNT(a) FROM TenderMaster a, PRMaster b ";
        query += " WHERE (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "')  AND a.prNo = b.prNo";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department ='" + Department + "'";
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readyByopenfalgFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += " select COUNT(a) FROM TenderMaster a, PRMaster b ";
        query += " WHERE (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "') AND a.prNo = b.prNo AND a.openBidFlag = '1'";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department ='" + Department + "'";
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readByflagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += " select COUNT(a) FROM TenderMaster a, PRMaster b ";
        query += " WHERE(b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "') AND a.prNo = b.prNo AND a.openBidFlag = '0'";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department ='" + Department + "'";
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public List readBycontactperFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += " SELECT a.contactPerson, "
                + " COUNT(a), "
                + " SUM(CASE WHEN a.openBidFlag = 0 THEN 1 ELSE 0 END), "
                + " SUM(CASE WHEN a.openBidFlag = 1 THEN 1 ELSE 0 END), "
                + " DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'),'%M-%Y') ";

        query += " FROM TenderMaster a, PRMaster b ";
        query += " WHERE (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "') AND a.prNo = b.prNo";

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('"
                    + Fromdate + "', '%d-%m-%Y') "
                    + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department ='" + Department + "'";
        }

        query += " GROUP BY a.contactPerson ";

        query += " ORDER BY COUNT(a) DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBycontactperGraphUser(String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "SELECT a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, a.projectId "
                + "FROM TenderMaster a, PRMaster b "
                + "WHERE a.prNo = b.prNo "
                + "AND a.contactPerson = :contact ";

        if (Value != null && !Value.isEmpty()) {
            if (Value.equals("Zero")) {
                query += " AND a.openBidFlag IN (0,1)";
            }
            if (Value.equals("One")) {
                query += " AND a.openBidFlag='0'";
            }
            if (Value.equals("Two")) {
                query += " AND a.openBidFlag='1'";
            }
        }

        if (username != null && !username.isEmpty()) {
            query += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
        }

        if (Filter != null && !Filter.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate, '%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE(:formattedStartDate, '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE(:formattedDate, '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE(:Fromdate, '%d-%m-%Y') "
                    + "AND STR_TO_DATE(:Todate, '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = :department";
        }

        Query hibQuery = getSession().createQuery(query);
        hibQuery.setParameter("contact", ContactPerson);

        if (username != null && !username.isEmpty()) {
            hibQuery.setParameter("username", username);
        }

        if (Filter != null && !Filter.isEmpty()) {
            hibQuery.setParameter("formattedStartDate", formattedStartDate);
            hibQuery.setParameter("formattedDate", formattedDate);
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            hibQuery.setParameter("Fromdate", Fromdate);
            hibQuery.setParameter("Todate", Todate);
        }

        if (Department != null && !Department.isEmpty()) {
            hibQuery.setParameter("department", Department);
        }

        query += " ORDER BY a.refNo DESC ";
        return hibQuery.list();

    }

    @Override
    public List readByMonthFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";

        query += " SELECT COUNT(*), DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'),'%b-%y') ";

        query += " FROM TenderMaster a, PRMaster b ";
        query += " WHERE (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "') AND a.prNo = b.prNo ";

        if (!Filter.equals("--select--")) {
            query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s') ";
        }

        if (!Fromdate.equals("") && !Todate.equals("")) {
            query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('"
                    + Fromdate + "', '%d-%m-%Y') "
                    + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y') ";
        }

        if (!Department.equals("")) {
            query += " AND a.department = '" + Department + "' ";
        }

        query += " GROUP BY DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'), '%Y-%m') ";
        query += " ORDER BY STR_TO_DATE(a.announceDate, '%d-%m-%Y %T') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List readByMonthGraphUser(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "Select a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, a.projectId ";

        query += " FROM TenderMaster a, PRMaster b ";
        query += " WHERE a.prNo = b.prNo ";

        if (username != null && !username.isEmpty()) {
            query += " AND (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + StartDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + EndDate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.refNo DESC";

//        query += " GROUP BY DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'), '%M-%Y')";
//        query += " ORDER BY DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'), '%M-%Y') DESC";
        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List totalTender(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "Select a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, b.prAdmin, b.authorizeDate, b.projectId ";

        query += " FROM TenderMaster a, PRMaster b ";
        query += " WHERE a.prNo = b.prNo ";

        if (username != null && !username.isEmpty()) {
            query += " AND (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }
        query += " ORDER BY a.refNo DESC";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalTenderClosed(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "SELECT a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, "
                + "b.prAdmin, b.authorizeDate, a.projectId, "
                + "(SELECT MIN(CAST(c1.finalTotal AS int)) "
                + " FROM VendorTenderBid c1 WHERE c1.refNo = a.refNo) AS lowestBid, "
                + "(SELECT MIN(c2.vendorCode) "
                + " FROM VendorTenderBid c2 "
                + " WHERE c2.refNo = a.refNo "
                + "   AND CAST(c2.finalTotal AS int) = ("
                + "       SELECT MIN(CAST(c3.finalTotal AS int)) "
                + "       FROM VendorTenderBid c3 WHERE c3.refNo = a.refNo)) AS vendorCode "
                + "FROM TenderMaster a, PRMaster b "
                + "WHERE a.prNo = b.prNo AND a.openBidFlag = '1'";

        if (username != null && !username.isEmpty()) {
            query += " AND (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.refNo DESC";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalLiveTender(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "Select a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, b.prAdmin, b.authorizeDate, a.projectId ";

        query += " FROM TenderMaster a, PRMaster b ";
        query += " WHERE a.prNo = b.prNo AND a.openBidStatus = '0' and a.deleteFlag=0";

        if (username != null && !username.isEmpty()) {
            query += " AND (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + " STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.refNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readPrRegister() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        cal.add(Calendar.MONTH, -3);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo, b.announceDate, b.authorizeDate,b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate,  b.prReworkDate,b.tenderCreaterDate, a.title, b.prComment, a.submitLastdate, b.finalCloseDate, "
                + "c.poNo, c.poDate, c.poValue, c.vendorCode "
                + "FROM TenderMaster a, PRMaster b, PoDetails c "
                + "WHERE a.prNo = b.prNo "
                + "AND b.prNo = c.prNo "
                + "AND STR_TO_DATE(b.announceDate, '%d-%m-%Y %H:%i:%s') BETWEEN "
                + "STR_TO_DATE('" + fromDate + " 00:00:00', '%d-%m-%Y %H:%i:%s') "
                + "AND STR_TO_DATE('" + toDate + " 23:59:59', '%d-%m-%Y %H:%i:%s') "
                + "ORDER BY a.refNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readPrRegisterUnCommon() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        cal.add(Calendar.MONTH, -3);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo, b.announceDate, b.authorizeDate,b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate, b.prReworkDate, b.tenderCreaterDate, "
                + "a.title, b.prComment, a.submitLastdate, b.finalCloseDate  "
                + "FROM TenderMaster a, PRMaster b "
                + "WHERE a.prNo = b.prNo "
                + "AND b.prNo NOT IN (SELECT prNo FROM PoDetails) "
                + "AND STR_TO_DATE(b.announceDate, '%d-%m-%Y %H:%i:%s') BETWEEN "
                + "STR_TO_DATE('" + fromDate + " 00:00:00', '%d-%m-%Y %H:%i:%s') "
                + "AND STR_TO_DATE('" + toDate + " 23:59:59', '%d-%m-%Y %H:%i:%s') "
                + "ORDER BY a.refNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalTenderClosedByForce(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "SELECT a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, "
                + "b.prAdmin, b.authorizeDate, a.projectId, a.deleteRemark "
                + "FROM TenderMaster a, PRMaster b "
                + "WHERE a.prNo = b.prNo AND a.deleteFlag = '1'";

        if (username != null && !username.isEmpty()) {
            query += " AND (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.refNo DESC";
        return getHibernateTemplate().find(query);
    }

    @Override
    public int readytenderclosedByForce(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += " select COUNT(a) FROM TenderMaster a, PRMaster b ";
        query += " WHERE (b.prAdmin = '" + username + "' OR b.prAuthorizeUser = '" + username + "') AND a.prNo = b.prNo AND a.deleteFlag = '1'";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department ='" + Department + "'";
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readyBydeleteFlag() {
        String query = "Select count(a)";
        query += " FROM TenderMaster a, PRMaster b"
                + " WHERE a.deleteFlag = '1'"
                + "and a.prNo = b.prNo";

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readBydeleteFlagFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "select COUNT(a) from TenderMaster a, PRMaster b"
                + " where a.deleteFlag = 1"
                + "and a.prNo = b.prNo";

        if (!Filter.equals("--select--")) {
            query += " AND (a.announceDate BETWEEN '" + formattedStartDate + "' and '" + formattedDate + "')";
        }

        if (!Fromdate.equals("")) {
            query += " AND (a.announceDate BETWEEN '" + Fromdate + "' and '" + Todate + "')";
        }

        if (!Department.equals("--select--")) {
            query += " AND a.department = '" + Department + "'";
        }

        Long count = (Long) this.getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List getPastTenderPagination(int start, int length, String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        String hql = "FROM TenderMaster a WHERE 1=1 ";

        hql += " and a.authorizeFlag = '1' and a.openBidFlag='1' and a.deleteFlag='0' and a.openBidStatus=0 and a.auditFlag=0 ";

        hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now() ";

        if (tender_no != null && !tender_no.trim().equals("")) {

            hql += " AND lower(a.refNo) LIKE :refNo ";
        }

        if (tender_title != null && !tender_title.trim().equals("")) {

            hql += " AND lower(a.title) LIKE :title ";
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:open_from_date,'%d-%m-%Y') ";
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:open_to_date,'%d-%m-%Y') ";
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:close_from_date,'%d-%m-%Y') ";
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:close_to_date,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.trim().equals("")) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.prNo) LIKE :searchValue "
                    + " OR lower(a.emd) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + ")";
        }

        if (orderColumn == null || orderColumn.trim().equals("")) {
            orderColumn = "id";
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (tender_no != null && !tender_no.trim().equals("")) {
            query.setParameter("refNo", "%" + tender_no.toLowerCase() + "%");
        }

        if (tender_title != null && !tender_title.trim().equals("")) {
            query.setParameter("title", "%" + tender_title.toLowerCase() + "%");
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {
            query.setParameter("open_from_date", open_from_date);
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {
            query.setParameter("open_to_date", open_to_date);
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {
            query.setParameter("close_from_date", close_from_date);
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {
            query.setParameter("close_to_date", close_to_date);
        }

        if (searchValue != null && !searchValue.trim().equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);

        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getTotalPastTenderCount() {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(*) "
                + "FROM TenderMaster a "
                + "WHERE 1=1 ";

        hql += "and a.authorizeFlag = '1' and a.openBidFlag='1' and a.deleteFlag='0' and a.openBidStatus=0 and a.auditFlag=0";

        hql += " AND STR_TO_DATE(a.submitLastdate,"
                + "'%d-%m-%Y %H:%i:%s') <= now() ";

        Query query = session.createQuery(hql);

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public int getFilteredPastTenderCount(String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(*) "
                + "FROM TenderMaster a "
                + "WHERE 1=1 ";

        hql += " and a.authorizeFlag = '1' and a.openBidFlag='1' and a.deleteFlag='0' and a.openBidStatus=0 and a.auditFlag=0";

        hql += " AND STR_TO_DATE(a.submitLastdate,"
                + "'%d-%m-%Y %H:%i:%s') <= now() ";

        if (tender_no != null && !tender_no.trim().equals("")) {
            hql += " AND lower(a.refNo) LIKE :refNo ";
        }

        if (tender_title != null && !tender_title.trim().equals("")) {
            hql += " AND lower(a.title) LIKE :title ";
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:open_from_date,'%d-%m-%Y') ";
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:open_to_date,'%d-%m-%Y') ";
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:close_from_date,'%d-%m-%Y') ";
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:close_to_date,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.trim().equals("")) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.prNo) LIKE :searchValue "
                    + " OR lower(a.emd) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (tender_no != null && !tender_no.trim().equals("")) {
            query.setParameter("refNo", "%" + tender_no.toLowerCase() + "%");
        }

        if (tender_title != null && !tender_title.trim().equals("")) {
            query.setParameter("title", "%" + tender_title.toLowerCase() + "%");
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {
            query.setParameter("open_from_date", open_from_date);
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {
            query.setParameter("open_to_date", open_to_date);
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {
            query.setParameter("close_from_date", close_from_date);
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {
            query.setParameter("close_to_date", close_to_date);
        }

        if (searchValue != null && !searchValue.trim().equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public List getFinalTenderPagination(int start, int length, String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        String hql = "FROM TenderMaster a WHERE 1=1 ";

        hql += " AND a.openBidStatus = '1' ";

        hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now() ";

        if (tender_no != null && !tender_no.trim().equals("")) {

            hql += " AND lower(a.refNo) LIKE :refNo ";
        }

        if (tender_title != null && !tender_title.trim().equals("")) {

            hql += " AND lower(a.title) LIKE :title ";
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:open_from_date,'%d-%m-%Y') ";
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:open_to_date,'%d-%m-%Y') ";
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:close_from_date,'%d-%m-%Y') ";
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:close_to_date,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.trim().equals("")) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.prNo) LIKE :searchValue "
                    + " OR lower(a.emd) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + ")";
        }

        if (orderColumn == null || orderColumn.trim().equals("")) {
            orderColumn = "id";
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (tender_no != null && !tender_no.trim().equals("")) {
            query.setParameter("refNo", "%" + tender_no.toLowerCase() + "%");
        }

        if (tender_title != null && !tender_title.trim().equals("")) {
            query.setParameter("title", "%" + tender_title.toLowerCase() + "%");
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {
            query.setParameter("open_from_date", open_from_date);
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {
            query.setParameter("open_to_date", open_to_date);
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {
            query.setParameter("close_from_date", close_from_date);
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {
            query.setParameter("close_to_date", close_to_date);
        }

        if (searchValue != null && !searchValue.trim().equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);

        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getTotalFinalTenderCount() {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(*) "
                + "FROM TenderMaster a "
                + "WHERE 1=1 ";

        hql += " AND a.openBidStatus = '1' ";

        hql += " AND STR_TO_DATE(a.submitLastdate,"
                + "'%d-%m-%Y %H:%i:%s') <= now() ";

        Query query = session.createQuery(hql);

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public int getFilteredFinalTenderCount(String searchValue, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(*) "
                + "FROM TenderMaster a "
                + "WHERE 1=1 ";

        hql += " AND a.openBidStatus = '1' ";

        hql += " AND STR_TO_DATE(a.submitLastdate,"
                + "'%d-%m-%Y %H:%i:%s') <= now() ";

        if (tender_no != null && !tender_no.trim().equals("")) {
            hql += " AND lower(a.refNo) LIKE :refNo ";
        }

        if (tender_title != null && !tender_title.trim().equals("")) {
            hql += " AND lower(a.title) LIKE :title ";
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:open_from_date,'%d-%m-%Y') ";
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:open_to_date,'%d-%m-%Y') ";
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:close_from_date,'%d-%m-%Y') ";
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {

            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:close_to_date,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.trim().equals("")) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.prNo) LIKE :searchValue "
                    + " OR lower(a.emd) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (tender_no != null && !tender_no.trim().equals("")) {
            query.setParameter("refNo", "%" + tender_no.toLowerCase() + "%");
        }

        if (tender_title != null && !tender_title.trim().equals("")) {
            query.setParameter("title", "%" + tender_title.toLowerCase() + "%");
        }

        if (open_from_date != null && !open_from_date.trim().equals("")) {
            query.setParameter("open_from_date", open_from_date);
        }

        if (open_to_date != null && !open_to_date.trim().equals("")) {
            query.setParameter("open_to_date", open_to_date);
        }

        if (close_from_date != null && !close_from_date.trim().equals("")) {
            query.setParameter("close_from_date", close_from_date);
        }

        if (close_to_date != null && !close_to_date.trim().equals("")) {
            query.setParameter("close_to_date", close_to_date);
        }

        if (searchValue != null && !searchValue.trim().equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public List receiveTechBIdList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0' and a.tenderPhase=2"
                + " and a.openBidFlag = '0' and openBidStatus='0' order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getReceiveTechBidListPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql
                = "FROM TenderMaster a "
                + "WHERE a.authorizeFlag='1' "
                + "AND a.deleteFlag='0' "
                + "AND a.tenderPhase=2 "
                + "AND a.openBidFlag='0' "
                + "AND a.openBidStatus='0' "
                + "AND ( "
                + "      a.tenderAdmin = :username "
                + "      OR EXISTS ( "
                + "           SELECT 1 "
                + "           FROM TenderCommittee tc "
                + "           WHERE tc.tenderNo = a.refNo "
                + "           AND tc.userId = :username "
                + "      ) "
                + "    ) ";

        if (searchValue != null && !searchValue.trim().isEmpty()) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + ")";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        query.setParameter("username", userName);

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();

    }

    @Override
    public int getReceiveTechBidListCount(String username) {

        Session session = getSessionFactory().openSession();

        String hql
                = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a "
                + "WHERE a.authorizeFlag='1' "
                + "AND a.deleteFlag='0' "
                + "AND a.tenderPhase=2 "
                + "AND a.openBidFlag='0' "
                + "AND a.openBidStatus='0' "
                + "AND ( "
                + "      a.tenderAdmin = :username "
                + "      OR EXISTS ( "
                + "           SELECT 1 "
                + "           FROM TenderCommittee tc "
                + "           WHERE tc.tenderNo = a.refNo "
                + "           AND tc.userId = :username "
                + "      ) "
                + "    )";

        Query query = session.createQuery(hql);

        query.setParameter("username", username);

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public int getFilteredReceiveTechBidListCount(String username, String searchValue) {

        Session session = getSessionFactory().openSession();

        String hql
                = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a "
                + "WHERE a.authorizeFlag='1' "
                + "AND a.deleteFlag='0' "
                + "AND a.tenderPhase=2 "
                + "AND a.openBidFlag='0' "
                + "AND a.openBidStatus='0' "
                + "AND ( "
                + "      a.tenderAdmin = :username "
                + "      OR EXISTS ( "
                + "           SELECT 1 "
                + "           FROM TenderCommittee tc "
                + "           WHERE tc.tenderNo = a.refNo "
                + "           AND tc.userId = :username "
                + "      ) "
                + "    ) ";

        if (searchValue != null && !searchValue.trim().isEmpty()) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        query.setParameter("username", username);

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter(
                    "searchValue",
                    "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public List receiveBidBuyer(String username) {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.tenderAdmin = '" + username + "'"
                + " and a.authorizedBuyerFlag = '1'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List getReceiveBidBuyerPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        String hql = "FROM TenderMaster a ";

        hql += " WHERE a.tenderAdmin = '" + userName + "'"
                + " and a.authorizedBuyerFlag = '1'";

        if (searchValue != null && !searchValue.trim().equals("")) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.tenderPhase) LIKE :searchValue "
                    + ")";
        }

        if (orderColumn == null || orderColumn.trim().equals("")) {
            orderColumn = "id";
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.trim().equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);

        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getReceiveBidBuyerCount(String userName) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) "
                + " FROM TenderMaster a ";

        hql += " WHERE a.tenderAdmin = '" + userName + "'"
                + " and a.authorizedBuyerFlag = '1'";

        Query query = session.createQuery(hql);

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public int getFilteredReceiveBidBuyerCount(String searchValue, String userName) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) "
                + " FROM TenderMaster a ";

        hql += " WHERE a.tenderAdmin = '" + userName + "'"
                + " and a.authorizedBuyerFlag = '1'";

        if (searchValue != null && !searchValue.trim().equals("")) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.tenderPhase) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (searchValue != null && !searchValue.trim().equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public List receiveBIdList(String username, String location, String department) {
        String query = "";
        query += " FROM TenderMaster a"
                + " WHERE a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and a.openBidFlag = '0' and openBidStatus='0' order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getReceiveCommercialBidPagination(int start, int length, String userName, String searchValue, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        String hql
                = "FROM TenderMaster a "
                + "WHERE a.authorizeFlag='1' "
                + "AND a.deleteFlag='0' "
                + "AND a.openBidFlag='0' "
                + "AND a.openBidStatus='0' "
                + "AND ( "
                + "     a.tenderAdmin = :username "
                + "     OR EXISTS ( "
                + "         SELECT 1 "
                + "         FROM TenderCommittee tc "
                + "         WHERE tc.tenderNo = a.refNo "
                + "         AND tc.userId = :username "
                + "     ) "
                + ") ";

        if (searchValue != null && !searchValue.trim().isEmpty()) {

            hql += " AND ( "
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " ) ";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        query.setParameter("username", userName);

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter(
                    "searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getReceiveCommercialBidCount(String userName) {

        Session session = getSessionFactory().openSession();

        String hql
                = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a "
                + "WHERE a.authorizeFlag='1' "
                + "AND a.deleteFlag='0' "
                + "AND a.openBidFlag='0' "
                + "AND a.openBidStatus='0' "
                + "AND ( "
                + "     a.tenderAdmin = :username "
                + "     OR EXISTS ( "
                + "         SELECT 1 "
                + "         FROM TenderCommittee tc "
                + "         WHERE tc.tenderNo = a.refNo "
                + "         AND tc.userId = :username "
                + "     ) "
                + ")";

        Query query = session.createQuery(hql);
        query.setParameter("username", userName);

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public int getFilteredReceiveCommercialBidCount(String userName, String searchValue) {

        Session session = getSessionFactory().openSession();

        String hql
                = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a "
                + "WHERE a.authorizeFlag='1' "
                + "AND a.deleteFlag='0' "
                + "AND a.openBidFlag='0' "
                + "AND a.openBidStatus='0' "
                + "AND ( "
                + "     a.tenderAdmin = :username "
                + "     OR EXISTS ( "
                + "         SELECT 1 "
                + "         FROM TenderCommittee tc "
                + "         WHERE tc.tenderNo = a.refNo "
                + "         AND tc.userId = :username "
                + "     ) "
                + ")";

        if (searchValue != null && !searchValue.trim().isEmpty()) {

            hql += " AND ( "
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " ) ";
        }

        Query query = session.createQuery(hql);

        query.setParameter("username", userName);

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public List pastTenderTechnicalList(String location, String username, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        String query = "";
        query += " select a FROM TenderMaster a, TenderCommittee b"
                //   + " WHERE a.location = '" + location + "'";
                + " WHERE a.tenderPhase = 2";
        if (tender_no.equals("")) {
        } else {
            query += " and a.refNo = '" + tender_no + "'";
        }

        if (tender_title.equals("")) {
        } else {
            query += " and a.title = '" + tender_title + "'";
        }
        if (open_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= STR_TO_DATE('" + open_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= STR_TO_DATE('" + open_to_date + "','%d-%m-%Y ')";
        }

        if (close_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= STR_TO_DATE('" + close_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= STR_TO_DATE('" + close_to_date + "','%d-%m-%Y ')";
        }

        query += " and a.authorizeFlag = '1' and a.openBidFlag='1' and a.deleteFlag='0' and a.auditFlag=0"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now() and a.refNo = b.tenderNo"
                + " and b.userId= '" + username + "' and b.bidType=2 and b.bidOpenStatus=1";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List getPastTenderTechnicalPagination(int start, int length, String userName, String searchValue, String tenderNo, String tenderTitle, String openFromDate, String openToDate, String closeFromDate, String closeToDate, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT a "
                + "FROM TenderMaster a, TenderCommittee b "
                + "WHERE a.refNo = b.tenderNo "
                + "AND a.tenderPhase = 2 "
                + "AND a.authorizeFlag = '1' "
                + "AND a.openBidFlag = '1' "
                + "AND a.deleteFlag = '0' "
                + "AND a.auditFlag = 0 "
                + "AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now() "
                + "AND b.userId = :userName "
                + "AND b.bidType = 2 "
                + "AND b.bidOpenStatus = 1 ";

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            hql += " AND lower(a.refNo) LIKE :refNo ";
        }

        if (tenderTitle != null && !tenderTitle.trim().isEmpty()) {
            hql += " AND lower(a.title) LIKE :title ";
        }

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') >= "
                    + "STR_TO_DATE(:openFromDate,'%d-%m-%Y') ";
        }

        if (openToDate != null && !openToDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') <= "
                    + "STR_TO_DATE(:openToDate,'%d-%m-%Y') ";
        }

        if (closeFromDate != null && !closeFromDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= "
                    + "STR_TO_DATE(:closeFromDate,'%d-%m-%Y') ";
        }

        if (closeToDate != null && !closeToDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= "
                    + "STR_TO_DATE(:closeToDate,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.trim().isEmpty()) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.prNo) LIKE :searchValue "
                    + " OR lower(a.emd) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + ")";
        }

        if (orderColumn == null || orderColumn.trim().isEmpty()) {
            orderColumn = "id";
        }

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        query.setParameter("userName", userName);

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            query.setParameter("refNo", "%" + tenderNo.toLowerCase() + "%");
        }

        if (tenderTitle != null && !tenderTitle.trim().isEmpty()) {
            query.setParameter("title", "%" + tenderTitle.toLowerCase() + "%");
        }

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            query.setParameter("openFromDate", openFromDate);
        }

        if (openToDate != null && !openToDate.trim().isEmpty()) {
            query.setParameter("openToDate", openToDate);
        }

        if (closeFromDate != null && !closeFromDate.trim().isEmpty()) {
            query.setParameter("closeFromDate", closeFromDate);
        }

        if (closeToDate != null && !closeToDate.trim().isEmpty()) {
            query.setParameter("closeToDate", closeToDate);
        }

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int getPastTenderTechnicalCount(String userName) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a, TenderCommittee b "
                + "WHERE a.refNo = b.tenderNo "
                + "AND a.tenderPhase = 2 "
                + "AND a.authorizeFlag = '1' "
                + "AND a.openBidFlag = '1' "
                + "AND a.deleteFlag = '0' "
                + "AND a.auditFlag = 0 "
                + "AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now() "
                + "AND b.userId = :userName "
                + "AND b.bidType = 2 "
                + "AND b.bidOpenStatus = 1 ";

        Query query = session.createQuery(hql);
        query.setParameter("userName", userName);

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public int getFilteredPastTenderTechnicalCount(String userName, String searchValue, String tenderNo, String tenderTitle, String openFromDate, String openToDate, String closeFromDate, String closeToDate) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a, TenderCommittee b "
                + "WHERE a.refNo = b.tenderNo "
                + "AND a.tenderPhase = 2 "
                + "AND a.authorizeFlag = '1' "
                + "AND a.openBidFlag = '1' "
                + "AND a.deleteFlag = '0' "
                + "AND a.auditFlag = 0 "
                + "AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= now() "
                + "AND b.userId = :userName "
                + "AND b.bidType = 2 "
                + "AND b.bidOpenStatus = 1 ";

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            hql += " AND lower(a.refNo) LIKE :refNo ";
        }

        if (tenderTitle != null && !tenderTitle.trim().isEmpty()) {
            hql += " AND lower(a.title) LIKE :title ";
        }

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') >= "
                    + "STR_TO_DATE(:openFromDate,'%d-%m-%Y') ";
        }

        if (openToDate != null && !openToDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') <= "
                    + "STR_TO_DATE(:openToDate,'%d-%m-%Y') ";
        }

        if (closeFromDate != null && !closeFromDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= "
                    + "STR_TO_DATE(:closeFromDate,'%d-%m-%Y') ";
        }

        if (closeToDate != null && !closeToDate.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') <= "
                    + "STR_TO_DATE(:closeToDate,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.trim().isEmpty()) {

            hql += " AND ("
                    + " lower(a.refNo) LIKE :searchValue "
                    + " OR lower(a.title) LIKE :searchValue "
                    + " OR lower(a.prNo) LIKE :searchValue "
                    + " OR lower(a.emd) LIKE :searchValue "
                    + " OR lower(a.contactPerson) LIKE :searchValue "
                    + " OR lower(a.announceDate) LIKE :searchValue "
                    + " OR lower(a.submitLastdate) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        query.setParameter("userName", userName);

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            query.setParameter("refNo", "%" + tenderNo.toLowerCase() + "%");
        }

        if (tenderTitle != null && !tenderTitle.trim().isEmpty()) {
            query.setParameter("title", "%" + tenderTitle.toLowerCase() + "%");
        }

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            query.setParameter("openFromDate", openFromDate);
        }

        if (openToDate != null && !openToDate.trim().isEmpty()) {
            query.setParameter("openToDate", openToDate);
        }

        if (closeFromDate != null && !closeFromDate.trim().isEmpty()) {
            query.setParameter("closeFromDate", closeFromDate);
        }

        if (closeToDate != null && !closeToDate.trim().isEmpty()) {
            query.setParameter("closeToDate", closeToDate);
        }

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count.intValue();
    }

    @Override
    public List tenderReportList(String location, String department, String tender_no, String tender_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        String query = "";
        query += " FROM TenderMaster a"
                //   + " WHERE a.location = '" + location + "'";
                + " WHERE a.department = '" + department + "'";
        if (tender_no.equals("")) {
        } else {
            query += " and a.refNo = '" + tender_no + "'";
        }
        if (tender_title.equals("")) {
        } else {
            query += " and a.title = '" + tender_title + "'";
        }
        if (open_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= STR_TO_DATE('" + open_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= STR_TO_DATE('" + open_to_date + "','%d-%m-%Y ')";
        }

        if (close_from_date.equals("")) {
        } else {
            query += " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') >= STR_TO_DATE('" + close_from_date + "','%d-%m-%Y ') and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y') <= STR_TO_DATE('" + close_to_date + "','%d-%m-%Y ')";
        }

        query += " ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List tenderReportPaginationList(String location, String department, String tenderNo, String projectName, String open_from_date, String open_to_date, String close_from_date, String close_to_date, int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT a FROM TenderMaster a"
                + " WHERE a.department = :department";

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            hql += " AND lower(a.refNo) LIKE :tenderNo";
        }
        if (projectName != null && !projectName.trim().isEmpty()) {
            hql += " AND lower(a.title) LIKE :projectName";
        }
        if (open_from_date != null && !open_from_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s')"
                    + " >= STR_TO_DATE(:openFromDate,'%d-%m-%Y')";
        }
        if (open_to_date != null && !open_to_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s')"
                    + " <= STR_TO_DATE(CONCAT(:openToDate,' 23:59:59'),'%d-%m-%Y %H:%i:%s')";
        }
        if (close_from_date != null && !close_from_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s')"
                    + " >= STR_TO_DATE(:closeFromDate,'%d-%m-%Y')";
        }
        if (close_to_date != null && !close_to_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s')"
                    + " <= STR_TO_DATE(CONCAT(:closeToDate,' 23:59:59'),'%d-%m-%Y %H:%i:%s')";
        }
        if (searchValue != null && !searchValue.trim().isEmpty()) {
            hql += " AND ("
                    + " lower(a.refNo)          LIKE :searchValue"
                    + " OR lower(a.title)       LIKE :searchValue"
                    + " OR lower(a.prNo)        LIKE :searchValue"
                    + " OR lower(a.emd)         LIKE :searchValue"
                    + " OR lower(a.contactPerson)   LIKE :searchValue"
                    + " OR lower(a.announceDate)    LIKE :searchValue"
                    + " OR lower(a.submitLastdate)  LIKE :searchValue"
                    + ")";
        }

        if (orderColumn == null || orderColumn.trim().isEmpty()) {
            orderColumn = "id";
        }
        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        }

        hql += " ORDER BY a." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);
        query.setParameter("department", department);

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            query.setParameter("tenderNo", "%" + tenderNo.toLowerCase() + "%");
        }
        if (projectName != null && !projectName.trim().isEmpty()) {
            query.setParameter("projectName", "%" + projectName.toLowerCase() + "%");
        }
        if (open_from_date != null && !open_from_date.trim().isEmpty()) {
            query.setParameter("openFromDate", open_from_date);
        }
        if (open_to_date != null && !open_to_date.trim().isEmpty()) {
            query.setParameter("openToDate", open_to_date);
        }
        if (close_from_date != null && !close_from_date.trim().isEmpty()) {
            query.setParameter("closeFromDate", close_from_date);
        }
        if (close_to_date != null && !close_to_date.trim().isEmpty()) {
            query.setParameter("closeToDate", close_to_date);
        }
        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int tenderReportCount(String location, String department) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) FROM TenderMaster a"
                + " WHERE a.department = :department";

        Query query = session.createQuery(hql);
        query.setParameter("department", department);

        Long count = (Long) query.uniqueResult();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int tenderReportFilteredCount(String location, String department, String tenderNo, String projectName, String open_from_date, String open_to_date, String close_from_date, String close_to_date, String searchValue) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) FROM TenderMaster a"
                + " WHERE a.department = :department";

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            hql += " AND lower(a.refNo) LIKE :tenderNo";
        }
        if (projectName != null && !projectName.trim().isEmpty()) {
            hql += " AND lower(a.title) LIKE :projectName";
        }
        if (open_from_date != null && !open_from_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s')"
                    + " >= STR_TO_DATE(:openFromDate,'%d-%m-%Y')";
        }
        if (open_to_date != null && !open_to_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s')"
                    + " <= STR_TO_DATE(CONCAT(:openToDate,' 23:59:59'),'%d-%m-%Y %H:%i:%s')";
        }
        if (close_from_date != null && !close_from_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s')"
                    + " >= STR_TO_DATE(:closeFromDate,'%d-%m-%Y')";
        }
        if (close_to_date != null && !close_to_date.trim().isEmpty()) {
            hql += " AND STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s')"
                    + " <= STR_TO_DATE(CONCAT(:closeToDate,' 23:59:59'),'%d-%m-%Y %H:%i:%s')";
        }
        if (searchValue != null && !searchValue.trim().isEmpty()) {
            hql += " AND ("
                    + " lower(a.refNo)          LIKE :searchValue"
                    + " OR lower(a.title)       LIKE :searchValue"
                    + " OR lower(a.prNo)        LIKE :searchValue"
                    + " OR lower(a.emd)         LIKE :searchValue"
                    + " OR lower(a.contactPerson)   LIKE :searchValue"
                    + " OR lower(a.announceDate)    LIKE :searchValue"
                    + " OR lower(a.submitLastdate)  LIKE :searchValue"
                    + ")";
        }

        Query query = session.createQuery(hql);
        query.setParameter("department", department);

        if (tenderNo != null && !tenderNo.trim().isEmpty()) {
            query.setParameter("tenderNo", "%" + tenderNo.toLowerCase() + "%");
        }
        if (projectName != null && !projectName.trim().isEmpty()) {
            query.setParameter("projectName", "%" + projectName.toLowerCase() + "%");
        }
        if (open_from_date != null && !open_from_date.trim().isEmpty()) {
            query.setParameter("openFromDate", open_from_date);
        }
        if (open_to_date != null && !open_to_date.trim().isEmpty()) {
            query.setParameter("openToDate", open_to_date);
        }
        if (close_from_date != null && !close_from_date.trim().isEmpty()) {
            query.setParameter("closeFromDate", close_from_date);
        }
        if (close_to_date != null && !close_to_date.trim().isEmpty()) {
            query.setParameter("closeToDate", close_to_date);
        }
        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List behalfOfDate(String date) {
        String query = "select a.refNo,a.announceDate, a.contactPerson, a.tenderAdmin";
        query += " FROM TenderMaster a"
                + " where a.announceDate like '%" + date + "%'";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List behalfOfRefNo(String refNo, String date1) {
        String query = "Select a.refNo, a.contactPerson, a.tenderAdmin ,b.vendorCode ,b.vendorName";
        query += " FROM TenderMaster a,TenderVendor b"
                + " WHERE b.refNo = a.refNo"
                + " and a.announceDate like '%" + date1 + "%' ";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List tenderDailyReportPaginationList(int start, int length, String searchValue, String openFromDate, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT a.refNo, a.contactPerson, "
                + "a.tenderAdmin, b.vendorCode, b.vendorName "
                + "FROM TenderMaster a, TenderVendor b "
                + "WHERE a.refNo = b.refNo ";

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            hql += " AND a.announceDate LIKE :openFromDate ";
        }

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            hql += "AND ("
                    + "LOWER(a.refNo) LIKE :searchValue "
                    + "OR LOWER(a.contactPerson) LIKE :searchValue "
                    + "OR LOWER(a.tenderAdmin) LIKE :searchValue "
                    + "OR LOWER(b.vendorCode) LIKE :searchValue "
                    + "OR LOWER(b.vendorName) LIKE :searchValue "
                    + ") ";
        }

        hql += "ORDER BY " + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            query.setParameter("openFromDate", "%" + openFromDate.trim() + "%");
        }

        if (searchValue != null && !searchValue.trim().isEmpty()) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();
    }

    @Override
    public int tenderDailyReportCount(String openFromDate) {

        Session session = getSessionFactory().openSession();

        String hql = "SELECT COUNT(a.id) "
                + "FROM TenderMaster a, TenderVendor b "
                + "WHERE a.refNo = b.refNo ";

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            hql += " AND a.announceDate LIKE :openFromDate ";
        }

        Query query = session.createQuery(hql);

        if (openFromDate != null && !openFromDate.trim().isEmpty()) {
            query.setParameter("openFromDate", "%" + openFromDate.trim() + "%");
        }

        Long count = (Long) query.uniqueResult();
        return count.intValue();
    }

    @Override
    public int tenderDailyReportFilteredCount(String openFromDate, String searchValue) {

        Session session = getSessionFactory().openSession();

        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a, TenderVendor b "
                    + "WHERE a.refNo = b.refNo ";

            if (openFromDate != null && !openFromDate.trim().isEmpty()) {
                hql += " AND a.announceDate LIKE :openFromDate ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "LOWER(a.refNo) LIKE :searchValue "
                        + "OR LOWER(a.contactPerson) LIKE :searchValue "
                        + "OR LOWER(a.tenderAdmin) LIKE :searchValue "
                        + "OR LOWER(b.vendorCode) LIKE :searchValue "
                        + "OR LOWER(b.vendorName) LIKE :searchValue "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (openFromDate != null && !openFromDate.trim().isEmpty()) {
                query.setParameter("openFromDate", "%" + openFromDate.trim() + "%");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            return count != null ? count.intValue() : 0;

        } finally {
            session.close();
        }
    }

    @Override
    public List gettenderCreatedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.refNo, a.title, a.categoryId, a.type,a.contactPerson ,a.announceDate,b.prAdmin,b.authorizeDate ,b.projectId  "
                    + " FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(b.projectId)   LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int gettenderCreatedCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id) FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo ";

            Query query = session.createQuery(hql);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredtenderCreatedCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo ";
            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(b.projectId)   LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getliveTenderPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.refNo, a.title, a.categoryId, a.type,a.contactPerson ,a.announceDate,b.prAdmin,b.authorizeDate ,a.projectId  "
                    + " FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo AND a.openBidStatus = '0' and a.deleteFlag=0";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(a.projectId)   LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getliveTenderCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id) "
                    + " FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo AND a.openBidStatus = '0' and a.deleteFlag=0";

            Query query = session.createQuery(hql);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredliveTenderCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo AND a.openBidStatus = '0' and a.deleteFlag=0";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(b.projectId)   LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List gettenderClosedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.refNo, a.title, a.categoryId, a.type,a.contactPerson ,a.announceDate,b.prAdmin,b.authorizeDate ,a.projectId , "
                    + "(SELECT MIN(CAST(c1.finalTotal AS int)) "
                    + " FROM VendorTenderBid c1 WHERE c1.refNo = a.refNo) AS lowestBid, "
                    + "(SELECT MIN(c2.vendorCode) "
                    + " FROM VendorTenderBid c2 "
                    + " WHERE c2.refNo = a.refNo "
                    + "   AND CAST(c2.finalTotal AS int) = ("
                    + "       SELECT MIN(CAST(c3.finalTotal AS int)) "
                    + "       FROM VendorTenderBid c3 WHERE c3.refNo = a.refNo)) AS vendorCode "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo "
                    + "AND a.openBidStatus = '1' ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(a.projectId)   LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int gettenderClosedCount() {

        Session session = getSessionFactory().openSession();
        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a "
                    + "WHERE a.openBidStatus = '1' ";

            Query query = session.createQuery(hql);

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return count.intValue();

    }

    @Override
    public int getFilteredtenderClosedCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a "
                    + "WHERE a.openBidStatus = '1' ";

            if (username != null && !username.trim().isEmpty()) {
                hql += "AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null
                    && !Department.trim().isEmpty()
                    && !"--select--".equals(Department)) {

                hql += "AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null
                    && !Filter.trim().isEmpty()
                    && !"--select--".equals(Filter)
                    && formattedStartDate != null
                    && !formattedStartDate.isEmpty()
                    && formattedDate != null
                    && !formattedDate.isEmpty()) {

                hql += "AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty()
                    && Todate != null && !Todate.isEmpty()) {

                hql += "AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                hql += "AND ("
                        + "lower(a.refNo) LIKE :search "
                        + "OR lower(a.title) LIKE :search "
                        + "OR lower(a.categoryId) LIKE :search "
                        + "OR lower(a.type) LIKE :search "
                        + "OR lower(a.contactPerson) LIKE :search "
                        + "OR str(a.announceDate) LIKE :search "
                        + "OR lower(b.prAdmin) LIKE :search "
                        + "OR str(b.authorizeDate) LIKE :search "
                        + "OR lower(a.projectId) LIKE :search"
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("username", username);
            }

            if (Department != null
                    && !Department.trim().isEmpty()
                    && !"--select--".equals(Department)) {

                query.setParameter("Department",
                        "%" + Department.toLowerCase() + "%");
            }

            if (Filter != null
                    && !Filter.trim().isEmpty()
                    && !"--select--".equals(Filter)
                    && formattedStartDate != null
                    && !formattedStartDate.isEmpty()
                    && formattedDate != null
                    && !formattedDate.isEmpty()) {

                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            if (Fromdate != null && !Fromdate.isEmpty()
                    && Todate != null && !Todate.isEmpty()) {

                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search",
                        "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return count.intValue();

    }

    @Override
    public List gettotalTenderClosedByForcePagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.refNo, a.title, a.categoryId, a.type,a.contactPerson ,a.announceDate,b.prAdmin,b.authorizeDate ,a.projectId ,a.deleteRemark "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo AND a.deleteFlag = '1'";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(a.projectId)   LIKE :search "
                        + "OR lower(a.deleteRemark)   LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int gettotalTenderClosedByForceCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo AND a.deleteFlag = '1'";

            Query query = session.createQuery(hql);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredtotalTenderClosedByForceCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo AND a.deleteFlag = '1'";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(b.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR str(a.announceDate)   LIKE :search "
                        + "OR lower(b.prAdmin)   LIKE :search "
                        + "OR str(b.authorizeDate)   LIKE :search "
                        + "OR lower(b.projectId)   LIKE :search "
                        + "OR lower(a.deleteRemark)   LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getmonthWiseTenderListPrGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, b.projectId "
                    + " FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :prAdmin OR b.prAuthorizeUser = :prAuthorizeUser) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR lower(a.projectId)   LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getmonthWiseTenderListPrGraphUserCount(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id)     FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo ";

            Query query = session.createQuery(hql);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredmonthWiseTenderListPrGraphUserCount(String searchValue, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM TenderMaster a, PRMaster b "
                    + " WHERE a.prNo = b.prNo ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :prAdmin OR b.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.categoryId)      LIKE :search "
                        + "OR lower(a.type)  LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR lower(a.projectId)   LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getContactperGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.refNo, a.title, a.categoryId, a.type, a.contactPerson, a.announceDate, a.projectId "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo "
                    + "AND a.contactPerson = :contact ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("Zero")) {
                    hql += " AND a.openBidFlag IN (0,1)";
                }
                if (Value.equals("One")) {
                    hql += " AND a.openBidFlag='0'";
                }
                if (Value.equals("Two")) {
                    hql += " AND a.openBidFlag='1'";
                }
            }

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)          LIKE :search "
                        + "OR lower(a.title)         LIKE :search "
                        + "OR lower(a.categoryId)    LIKE :search "
                        + "OR lower(a.type)          LIKE :search "
                        + "OR lower(a.contactPerson) LIKE :search "
                        + "OR lower(a.announceDate)  LIKE :search "
                        + "OR lower(a.projectId)     LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("contact", ContactPerson);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("username", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getContactperGraphUserCount(String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter, String formattedDate,String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo "
                    + "AND a.contactPerson = :contact ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("Zero")) {
                    hql += " AND a.openBidFlag IN (0,1)";
                }
                if (Value.equals("One")) {
                    hql += " AND a.openBidFlag='0'";
                }
                if (Value.equals("Two")) {
                    hql += " AND a.openBidFlag='1'";
                }
            }

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contact", ContactPerson);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("username", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredContactperGraphUserCount(String searchValue, String ContactPerson, String Value, String username, String Fromdate, String Todate, String Filter,String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM TenderMaster a, PRMaster b "
                    + "WHERE a.prNo = b.prNo "
                    + "AND a.contactPerson = :contact ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("Zero")) {
                    hql += " AND a.openBidFlag IN (0,1)";
                }
                if (Value.equals("One")) {
                    hql += " AND a.openBidFlag='0'";
                }
                if (Value.equals("Two")) {
                    hql += " AND a.openBidFlag='1'";
                }
            }

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (b.prAdmin = :username OR b.prAuthorizeUser = :username) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.refNo)          LIKE :search "
                        + "OR lower(a.title)         LIKE :search "
                        + "OR lower(a.categoryId)    LIKE :search "
                        + "OR lower(a.type)          LIKE :search "
                        + "OR lower(a.contactPerson) LIKE :search "
                        + "OR lower(a.announceDate)  LIKE :search "
                        + "OR lower(a.projectId)     LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contact", ContactPerson);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("username", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

}
