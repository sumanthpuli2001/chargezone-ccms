/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorRequestApproval;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements VendorRequestApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorRequestApproval.class;
    }

    @Override
    public List readByUserName(String username) {
        String query = " Select v.id,b.vendorRequestApprovalId,a.userId,a.approvalStatus , v.contactaName , v.email , v.company , a.id ,v.description";
        query += " FROM VendorRequestApproval a,VendorRequestApprovalUser b , VendorRequestDetails v "
                + " WHERE  a.id  = b.vendorRequestApprovalId "
                + " and v.id=a.vendorDetailsId "
                + " and b.userId = '" + username + "'"
                + " and a.approvalStatus = 0 "
                + " and a.currentApproval = b.level  order by a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public VendorRequestApproval readByDeltecodes(String id) {
VendorRequestApproval vendorRequestApproval = new VendorRequestApproval();
	String query = "";
	query += " FROM VendorRequestApproval a"
		+ " WHERE a.vendorDetailsId =  '" + id + "'";
	List list = getHibernateTemplate().find(query);

	if (!list.isEmpty()) {
	    vendorRequestApproval = (VendorRequestApproval) list.get(0);

	}
	return vendorRequestApproval;    }

}
