/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorRequestApprovalComment;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorRequestApprovalCommentDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorRequestApprovalComment.class;
    }

    @Override
    public VendorRequestApprovalComment readByApproveId(int approvalid) {
 String query = "";
	 VendorRequestApprovalComment vendorRequestApprovalComment = new VendorRequestApprovalComment();
	  query += " FROM VendorRequestApprovalComment a"
		   + " WHERE a.vendorRequestApprovalId = '" + approvalid + "' order by a.id desc";
	 List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
	    vendorRequestApprovalComment =(VendorRequestApprovalComment) list.get(0);
	    
	}
	 return vendorRequestApprovalComment;    }

}
