/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorRequestApprovalUser;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements VendorRequestApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
     return  VendorRequestApprovalUser.class;
    }

    @Override
    public VendorRequestApprovalUser appval(String username) {
String query = "";
	VendorRequestApprovalUser vendorRequestApprovalUser = new VendorRequestApprovalUser();
	query += "SELECT b FROM  VendorRequestApproval a, VendorRequestApprovalUser b WHERE  a.id = b.vendorRequestApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus =0 and a.currentApproval = b.level ";
	List list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    vendorRequestApprovalUser = (VendorRequestApprovalUser) list.get(0);

	}
	return vendorRequestApprovalUser;    }

    @Override
    public List appval(int formid) {
String query = "";
	query += " FROM VendorRequestApprovalUser a"
		+ " WHERE a.vendorRequestApprovalId = '" + formid + "'";
	return getHibernateTemplate().find(query);
        }

    
    
}
