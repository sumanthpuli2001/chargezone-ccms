/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorAttachment;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorAttachment.class;
    }

    @Override
    public List readAttachment(String refNo, String vendor_code, String attachment_type) {
        String query = "";
        query += " FROM VendorAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"' and a.attachmentType = '"+attachment_type+"'";
        return getHibernateTemplate().find(query);
    }
}
