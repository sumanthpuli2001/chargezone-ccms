/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TechnicalTenderPriceApprovalComment;
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
public class TechnicalTenderPriceApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements TechnicalTenderPriceApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
        return TechnicalTenderPriceApprovalComment.class;
    }

    @Override
    public List readByRefNo(int technical_tender_price_approval_id) {
        String query = "";
        query += " FROM TechnicalTenderPriceApprovalComment a"
                + " WHERE a.tenderApprovalId = '" + technical_tender_price_approval_id + "' order by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public TechnicalTenderPriceApprovalComment readByApproveId(int approveId) {
        String query = "";
        TechnicalTenderPriceApprovalComment technicalTenderPriceApprovalComment = new TechnicalTenderPriceApprovalComment();
        query += " FROM TechnicalTenderPriceApprovalComment a"
                + " WHERE a.tenderApprovalId = '" + approveId + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            technicalTenderPriceApprovalComment = (TechnicalTenderPriceApprovalComment) list.get(0);
        }
        return technicalTenderPriceApprovalComment;
    }

   
}
