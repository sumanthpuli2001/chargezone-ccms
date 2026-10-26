/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.dao.Invoice.InvoiceMasterDao;
import com.bul.zydex.model.InvoiceMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InvoiceMasterServiceImpl<T> extends GenericsServiceImpl<T> implements InvoiceMasterService<T> {

    private InvoiceMasterDao<T> invoiceMasterDao;

    public InvoiceMasterDao<T> getInvoiceMasterDao() {
        return invoiceMasterDao;
    }

    public void setInvoiceMasterDao(InvoiceMasterDao<T> invoiceMasterDao) {
        this.invoiceMasterDao = invoiceMasterDao;
        setGenericsDAO(invoiceMasterDao);
    }

    @Override
    public List readByPoNoAndVendorCode(String poNo, String username) {
        return invoiceMasterDao.readByPoNoAndVendorCode(poNo, username);
    }

    @Override
    public InvoiceMaster readByPoNoAndVendorCode1(String poNo, String vendorCode) {
        return invoiceMasterDao.readByPoNoAndVendorCode1(poNo, vendorCode);
    }

    @Override
    public InvoiceMaster readByPoId(int id, String vendorCode) {
        return invoiceMasterDao.readByPoId(id, vendorCode);
    }

}
