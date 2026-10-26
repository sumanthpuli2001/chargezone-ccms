/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormApprovalComment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CrcFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CrcFormApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements CrcFormApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
	return CrcFormApprovalComment.class;
    }

    @Override
    public CrcFormApprovalComment readByApproveId(int approvalid) {
	CrcFormApprovalComment crcFormApprovalComment = new CrcFormApprovalComment();
	String query = "";

	query += " FROM CrcFormApprovalComment a"
		+ " WHERE a.crcFormApproval = '" + approvalid + "' "
		+ " order by a.id desc";

	List list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    crcFormApprovalComment = (CrcFormApprovalComment) list.get(0);

	}
	return crcFormApprovalComment;

    }

    @Override
    public List readBycrcformid(int crcformid) {

	String query = "";
	query += " FROM CrcFormApprovalComment a"
		+ " WHERE a.crcFormApproval = '" + crcformid + "'";
	return getHibernateTemplate().find(query);

    }

    @Override
    public List readBycrcFormApprovalid(int crcFormApprovalid) {
	String query = "";
	query += " FROM CrcFormApprovalComment a"
		+ " WHERE a.crcFormApproval = '" + crcFormApprovalid + "'";
	return getHibernateTemplate().find(query);
    }

}
