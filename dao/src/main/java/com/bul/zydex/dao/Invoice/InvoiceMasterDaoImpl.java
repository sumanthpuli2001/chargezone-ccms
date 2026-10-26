/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Invoice;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.InvoiceMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InvoiceMasterDaoImpl<T> extends GenericsDAOImpl<T> implements InvoiceMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return InvoiceMaster.class;
    }

    @Override
    public List readByPoNoAndVendorCode(String poNo, String username) {
        String query = " "
                + " from InvoiceMaster a "
                + " where  a.poNumber = '" + poNo + "'"
                + " and  a.vendorCode = '" + username + "' ";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public InvoiceMaster readByPoNoAndVendorCode1(String poNo, String vendorCode) {
        InvoiceMaster invoiceMaster = new InvoiceMaster();
        String query = " "
                + " from InvoiceMaster a "
                + " where  a.poNumber = '" + poNo + "'"
                + " and  a.vendorCode = '" + vendorCode + "' ";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            invoiceMaster = (InvoiceMaster) list.get(0);
        }
        return invoiceMaster;
    }

    @Override
    public InvoiceMaster readByPoId(int id, String vendorCode) {
        InvoiceMaster invoiceMaster = new InvoiceMaster();
        String query = " "
                + " from InvoiceMaster a "
                + " where  a.poId = '" + id + "'"
                + " and  a.vendorCode = '" + vendorCode + "' ";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            invoiceMaster = (InvoiceMaster) list.get(0);
        }
        return invoiceMaster;
    }

}
