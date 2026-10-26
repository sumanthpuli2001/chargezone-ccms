/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderCommittee;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class TenderCommitteeDaoImpl<T> extends GenericsDAOImpl<T> implements TenderCommitteeDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderCommittee.class;
    }

    @Override
    public List readByRefNo(String ref_no, String bid_type) {
        String query = "";
        query += " FROM TenderCommittee a"
                + " WHERE a.tenderNo = '" + ref_no + "' and a.bidType = " + bid_type + "";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefUser(String ref_no, String employee_code, String bid_type) {
        String query = "";
        query += " FROM TenderCommittee a"
                + " WHERE a.tenderNo = '" + ref_no + "' and a.userId = '" + employee_code + "' and a.bidType = " + bid_type + "";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateStatus(String refNo, String username1, String bid_type) {
        LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
        String query = "";
            query += " update TenderCommittee a"
                + " set a.bidOpenDate='"+formattedDate+"', "
                + " a.bidOpenStatus=1 "
                + " WHERE a.tenderNo = '" + refNo + "'  and a.userId = '" + username1 + "' and a.bidType= '" + bid_type + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        String query = "";
            query += " update TenderCommittee a"
                + " set a.tenderNo = '"+refNo+"'"
                + " WHERE a.tenderNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRefNoUser(String refNo, String username) {
        String query = "";
        query += " FROM TenderCommittee a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.userId = '" + username + "'";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public void deleteBYRefNo(String ref_no, String bid_type) {
        String query = "";
        query += " DELETE FROM TenderCommittee a"
                + " WHERE a.tenderNo = '" + ref_no + "' and a.bidType = " + bid_type + "";
       Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRefNoUser1(String refNo, String username) {
        String query = "";
        query += " FROM TenderCommittee a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.userId = '" + username + "' and a.bidOpenStatus=0";
        return getHibernateTemplate().find(query);
    }
}
