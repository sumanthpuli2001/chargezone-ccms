/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TechnicalMultiAttachment;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TechnicalMultiAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements TechnicalMultiAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return TechnicalMultiAttachment.class;
    }

    @Override
    public List readByRefNoVendorCode(String ref_no, String vendorCode) {
        String query = "";
        query += " FROM TechnicalMultiAttachment a"
                + " WHERE a.refNo = '" + ref_no + "' AND a.vendorCode ='" + vendorCode + "'";
        return getHibernateTemplate().find(query);
    }
}
