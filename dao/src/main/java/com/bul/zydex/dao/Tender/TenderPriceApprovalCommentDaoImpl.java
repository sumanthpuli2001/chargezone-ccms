/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.model.TenderPriceApprovalUser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderPriceApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements TenderPriceApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
        return TenderPriceApprovalComment.class;
    }

    @Override
    public TenderPriceApprovalComment approvaList1(String username) {
        String query = "";
        TenderPriceApprovalComment tenderPriceApprovalComment = new TenderPriceApprovalComment();

        query += "SELECT b FROM TenderPriceApproval a, TenderPriceApprovalUser b WHERE  a.id  =  b.tenderApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApprovalComment = (TenderPriceApprovalComment) list.get(0);
        }
        return tenderPriceApprovalComment;

    }

    @Override
    public TenderPriceApprovalComment readByApproveId(int approveId) {
        String query = "";
        TenderPriceApprovalComment tenderPriceApprovalComment = new TenderPriceApprovalComment();
        query += " FROM TenderPriceApprovalComment a"
                + " WHERE a.tenderApprovalId = '" + approveId + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApprovalComment = (TenderPriceApprovalComment) list.get(0);
        }
        return tenderPriceApprovalComment;
    }

    @Override
    public List readByRefNo(int tender_price_approval_id) {
        String query = "";
        query += " FROM TenderPriceApprovalComment a"
                + " WHERE a.tenderApprovalId = '" + tender_price_approval_id + "' order by a.id";
        return getHibernateTemplate().find(query);
    }

}
