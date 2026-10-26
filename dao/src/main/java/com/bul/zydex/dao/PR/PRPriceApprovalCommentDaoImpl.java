/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRPriceApprovalComment;
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
public class PRPriceApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements PRPriceApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
        return PRPriceApprovalComment.class;
    }

    @Override
    public PRPriceApprovalComment readByApproveId(int approveId) {
       String query = "";
        PRPriceApprovalComment prPriceApprovalComment = new PRPriceApprovalComment();
        query += " FROM PRPriceApprovalComment a"
                + " WHERE a.prApprovalId = '" + approveId + "' order by a.id desc";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            prPriceApprovalComment = (PRPriceApprovalComment) list.get(0);
        }
        return prPriceApprovalComment;
    }

  

}
