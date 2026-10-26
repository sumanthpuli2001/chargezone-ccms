/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffFormApprovalComment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KickOffFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffFormApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements KickOffFormApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {

	return KickOffFormApprovalComment.class;
    }

    @Override
    public KickOffFormApprovalComment readByApproveId(int approvalid) {
	KickOffFormApprovalComment kickOffFormApprovalComment = new KickOffFormApprovalComment();
	String query = "";
	query += " FROM KickOffFormApprovalComment a"
		+ " WHERE a.kickOffFormApproval = '" + approvalid + "' "
		+ " order by a.id desc";
	List list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    kickOffFormApprovalComment = (KickOffFormApprovalComment) list.get(0);
	}
	return kickOffFormApprovalComment;

    }

    @Override
    public List readByapproveId(int approvalid) {

	String query = "";
	query += " FROM KickOffFormApprovalComment a"
		+ " WHERE a.kickOffFormApproval = '" + approvalid + "'";
	return getHibernateTemplate().find(query);

    }
}
