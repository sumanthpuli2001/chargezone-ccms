/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CommMasterAttachment;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class CommMasterAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements CommMasterAttachmentDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return CommMasterAttachment.class;
    }

    @Override
    public List readByCommId(String tender_no, String username, String subject) {
        String query = "";
        query += " FROM CommMasterAttachment a"
                + " WHERE a.tenderNo = '" + tender_no + "' and a.vendorCode = '"+username+"' and a.subject = '"+subject+"'";
        return getHibernateTemplate().find(query);
    }
}
