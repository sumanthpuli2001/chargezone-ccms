/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormApprovalComment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
	return AocFormApprovalComment.class;
    }

    @Override
    public AocFormApprovalComment readByApproveId(int approvalid) {
	String query = "";
	AocFormApprovalComment aocFormApprovalComment = new AocFormApprovalComment();
	query += " FROM AocFormApprovalComment a"
		+ " WHERE a.aocFormApproval = '" + approvalid + "' order by a.id desc";
	List list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    aocFormApprovalComment = (AocFormApprovalComment) list.get(0);
	}
	return aocFormApprovalComment;
    }

    @Override
    public List readByIds(String id) {
	String query = "";
	query += " FROM AocFormApprovalComment a"
		+ " WHERE a.aocForm = '" + id + "'";
		
	return getHibernateTemplate().find(query);

    }

}
