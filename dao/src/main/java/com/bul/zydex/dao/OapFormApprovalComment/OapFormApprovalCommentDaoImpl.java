/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormApprovalComment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapFormApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements OapFormApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
	  return OapFormApprovalComment.class;
    }

    @Override
    public OapFormApprovalComment readByApproveId(int approvalid) {
	 String query = "";
	 OapFormApprovalComment oapFormApprovalComment = new OapFormApprovalComment();
	  query += " FROM OapFormApprovalComment a"
		   + " WHERE a.oapFormApproval = '" + approvalid + "' order by a.id desc";
	 List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
	    oapFormApprovalComment =(OapFormApprovalComment) list.get(0);
	    
	}
	 return oapFormApprovalComment;
    }

    @Override
    public List readByIds(String id) {
	
	 String query = "";
	   query += " FROM OapFormApprovalComment a"
                + " WHERE a.oapForm = '" + id + "'";
        return getHibernateTemplate().find(query);
	
	
    }

    
}
