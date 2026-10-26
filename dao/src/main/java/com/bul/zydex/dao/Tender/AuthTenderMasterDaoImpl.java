/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderMaster;
import com.bul.zydex.model.AuthTenderVendor;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class AuthTenderMasterDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderMasterDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderMaster.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorLiveTender(String username) {
        String query = "";
        query += " select b.refNo, b.rfqNo, a.title, a.docCost, a.emd, a.announceDate, a.submitLastdate, a.tenderPhase FROM AuthTenderMaster a, AuthTenderVendor b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.refNo = b.refNo"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AuthTenderMaster readByVendorRefNo(String refNo, String username) {
        AuthTenderMaster authTenderMaster = new AuthTenderMaster();
        String query = "";
        query += " FROM AuthTenderMaster a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            authTenderMaster = (AuthTenderMaster) list.get(0);
        }
        return authTenderMaster;
    }
    
    @Override
    public AuthTenderMaster readByRefNo1(String refNo) {
        AuthTenderMaster authTenderMaster = new AuthTenderMaster();
        String query = "";
        query += " FROM AuthTenderMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            authTenderMaster = (AuthTenderMaster) list.get(0);
        }
        return authTenderMaster;
    }

    @Override
    public List unauthorizeTender(String username, String location, String department) {
        String query = "";
        query += " FROM AuthTenderMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.authorizeFlag = '1'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void authorizeTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAuthorizeUserName='"+username+"', "
                + " a.tenderAuthorizePerson='"+full_name+"', "
                + " a.tenderAuthorizeContactNo='"+contact_no+"', "
                + " a.authorizeFlag='1' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void recycleTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAuthorizeUserName='"+username+"', "
                + " a.tenderAuthorizePerson='"+full_name+"', "
                + " a.tenderAuthorizeContactNo='"+contact_no+"', "
                + " a.authorizeFlag='2' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void rejectTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAuthorizeUserName='"+username+"', "
                + " a.tenderAuthorizePerson='"+full_name+"', "
                + " a.tenderAuthorizeContactNo='"+contact_no+"', "
                + " a.authorizeFlag='5' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAuthorizeUserName='"+username+"', "
                + " a.tenderAuthorizePerson='"+full_name+"', "
                + " a.tenderAuthorizeContactNo='"+contact_no+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List recycleTenderList(String username, String location, String department) {
        String query = "";
        query += " FROM AuthTenderMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.authorizeFlag = '2'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List rejectTenderList(String username, String location, String department) {
        String query = "";
        query += " FROM AuthTenderMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.authorizeFlag = '5'"
                + " and STR_TO_DATE(a.submitLastdate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void recycleTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAdmin='"+username+"', "
                + " a.contactPerson='"+full_name+"', "
                + " a.tenderAdminContactNumber='"+contact_no+"', "
                + " a.authorizeFlag='0' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updateTenderData(String refNo, String title1, String category_id1, String value1, String emd1, String doc_cost1, String type1, String contact_person1, String location1, String announce_date1, String collection_lastdate1, String submit_lastdate1, String work_desc1, String tender_remark1, String tender_admin1, String tender_admin_contact_number1, String tender_authorize_person1, String tender_authorize_contact_no1, int authorize_flag1, String tender_authorize_user_name1, int re_autho_flag1, int is_in_autho_table1, int vendor_flag1, int item_flag1, int email_flag1, String authorize_date1, int return_flag1, int delete_flag1, int tender_phase1, int open_bid_flag1, String department1, String pr_no1) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title1+"', "
                + " a.value='"+category_id1+"', "
                + " a.value='"+value1+"', "
                    + " a.emd='"+emd1+"', "
                    + " a.docCost='"+doc_cost1+"', "
                    + " a.type='"+type1+"', "
                    + " a.contactPerson='"+contact_person1+"', "
                    + " a.location='"+location1+"', "
                    + " a.announceDate='"+announce_date1+"', "
                    + " a.collectionLastdate='"+collection_lastdate1+"', "
                    + " a.submitLastdate='"+submit_lastdate1+"', "
                    + " a.workDesc='"+work_desc1+"', "
                    + " a.tenderRemark='"+tender_remark1+"', "
                    + " a.tenderAdmin='"+tender_admin1+"', "
                    + " a.tenderAdminContactNumber='"+tender_admin_contact_number1+"', "
                    + " a.tenderAuthorizePerson='"+tender_authorize_person1+"', "
                    + " a.tenderAuthorizeContactNo='"+tender_authorize_contact_no1+"', "
                    + " a.authorizeFlag='"+authorize_flag1+"', "
                    + " a.tenderAuthorizeUserName='"+tender_authorize_user_name1+"', "
                    + " a.reAuthoFlag='"+re_autho_flag1+"', "
                    + " a.isInAuthoTable='"+is_in_autho_table1+"', "
                    + " a.vendorFlag='"+vendor_flag1+"', "
                + " a.itemFlag='"+item_flag1+"', "
                + " a.emailFlag='"+email_flag1+"', "
                + " a.deleteFlag='"+return_flag1+"', "
                + " a.tenderRemark='"+delete_flag1+"', "
                + " a.tenderPhase='"+tender_phase1+"', "
                + " a.openBidFlag='"+open_bid_flag1+"', "
                + " a.department='"+department1+"', "
                + " a.prNo='"+pr_no1+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void authTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAdmin='"+username+"', "
                + " a.contactPerson='"+full_name+"', "
                + " a.tenderAdminContactNumber='"+contact_no+"', "
                + " a.authorizeFlag='1' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void authTenderSave(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        String query = "";
            query += " update AuthTenderMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.submitLastdate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.tenderRemark='"+remark+"', "
                + " a.tenderAdmin='"+username+"', "
                + " a.contactPerson='"+full_name+"', "
                + " a.tenderAdminContactNumber='"+contact_no+"' "
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
