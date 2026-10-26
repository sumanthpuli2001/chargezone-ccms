/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorBuyerApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorBuyerApproval;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VendorBuyerApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements VendorBuyerApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorBuyerApproval.class;
    }

    @Override
    public VendorBuyerApproval readByVendorInvtId(int vendorInvtId) {

        VendorBuyerApproval vendorBuyerApproval = new VendorBuyerApproval();
        String query = "";
        query += " FROM VendorBuyerApproval a"
                + " WHERE a.vInvitationId = '" + vendorInvtId + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorBuyerApproval = (VendorBuyerApproval) list.get(0);
        }
        return vendorBuyerApproval;

    }

    @Override
    public List readByVendorInvtIdList(int vendorInvtId) {
        String query = "";
        query += " FROM VendorBuyerApproval a"
                + " WHERE a.vInvitationId = '" + vendorInvtId + "'";
        return getHibernateTemplate().find(query);

    }
}
