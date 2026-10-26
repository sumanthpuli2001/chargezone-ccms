/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.dao.Invoice.InvoiceAttachmentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class InvoiceAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements InvoiceAttachmentService<T> {

    private InvoiceAttachmentDao<T> invoiceAttachmentDao;

    public InvoiceAttachmentDao<T> getInvoiceAttachmentDao() {
        return invoiceAttachmentDao;
    }

    public void setInvoiceAttachmentDao(InvoiceAttachmentDao<T> invoiceAttachmentDao) {
        this.invoiceAttachmentDao = invoiceAttachmentDao;
        setGenericsDAO(invoiceAttachmentDao);
    }

    @Override
    public List readByPoId(String poId, String username) {
        return invoiceAttachmentDao.readByPoId(poId, username);
    }

    @Override
    public List readByPoIdAndStatus(String id, String vendorCode, int status) {
        return invoiceAttachmentDao.readByPoIdAndStatus(id, vendorCode, status);
    }

    @Override
    public boolean readByRecycleStatus(int poId, int status1) {
        return invoiceAttachmentDao.readByRecycleStatus(poId, status1);
    }

    @Override
    public boolean readByGrnRecycleStatus(int poId, int status1) {
        return invoiceAttachmentDao.readByGrnRecycleStatus(poId, status1);
    }

    @Override
    public boolean readByFinancialRecycleStatus(int poId, int status1) {
        return invoiceAttachmentDao.readByFinancialRecycleStatus(poId, status1);
    }

}
