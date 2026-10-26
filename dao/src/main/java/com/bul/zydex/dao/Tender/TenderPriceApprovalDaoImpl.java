/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalUser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderPriceApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements TenderPriceApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return TenderPriceApproval.class;
    }

    @Override
    public List approvaList(String username) {

        String query = "";
        query += " FROM TenderPriceApproval a, TenderPriceApprovalUser b WHERE  a.id  =  b.tenderApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByIds(String id) {
        String query = "";
        query += " FROM TenderPriceApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByTenRefNo(String refNo) {
        String query = "";
        query += " FROM TenderPriceApproval a"
                + " WHERE a.tenderNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public TenderPriceApproval readByRefNo(String refNo) {
        String query = "";
        TenderPriceApproval tenderPriceApproval = new TenderPriceApproval();

        query += " FROM TenderPriceApproval a"
                + " WHERE a.tenderNo = '" + refNo + "' and (a.approvalStatus=0 or a.approvalStatus=1 or a.approvalStatus=2) ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApproval = (TenderPriceApproval) list.get(0);
        }
        return tenderPriceApproval;
    }

    @Override
    public boolean isExist(String refNo) {

        boolean flag = false;

        String query = "";

        query += " SELECT a FROM TenderPriceApproval a"
                + " WHERE a.tenderNo = '" + refNo + "' and (a.approvalStatus=0 or a.approvalStatus=1 or a.approvalStatus=2) ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }

        return flag;
    }

    @Override
    public TenderPriceApproval readByList(String refNo) {
        String query = "";
        TenderPriceApproval tenderPriceApproval = new TenderPriceApproval();

        query += " FROM TenderPriceApproval a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.approvalStatus!=3 order by a.id desc";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApproval = (TenderPriceApproval) list.get(0);
        }
        return tenderPriceApproval;
    }

    @Override
    public TenderPriceApproval readByRrecycleList(String refNo) {
        String query = "";
        TenderPriceApproval tenderPriceApproval = new TenderPriceApproval();

        query += " FROM TenderPriceApproval a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.approvalStatus=3 order by a.id desc";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApproval = (TenderPriceApproval) list.get(0);
        }
        return tenderPriceApproval;
    }

}
