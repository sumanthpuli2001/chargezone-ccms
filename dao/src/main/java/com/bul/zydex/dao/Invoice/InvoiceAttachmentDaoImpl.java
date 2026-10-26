/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Invoice;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.InvoiceAttachment;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class InvoiceAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements InvoiceAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return InvoiceAttachment.class;
    }

    @Override
    public List readByPoId(String poId, String username) {
        String query = " "
                + " from InvoiceAttachment a "
                + " where  a.poId = '" + poId + "'"
                + " and  a.vendorCode = '" + username + "' ";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByPoIdAndStatus(String id, String vendorCode, int status) {
        String query = " "
                + " from InvoiceAttachment a "
                + " where  a.poId = '" + id + "'"
                + " and  a.vendorCode = '" + vendorCode + "' "
                + " and a.status !=" + status;
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public boolean readByRecycleStatus(int poId, int status1) {

        String hql = "SELECT COUNT(a.id) FROM InvoiceAttachment a "
                + "WHERE a.poId = ? AND a.status = ?";

        List<?> result = getHibernateTemplate().find(hql, poId, status1);

        return !result.isEmpty() && ((Number) result.get(0)).longValue() > 0;
    }

    @Override
    public boolean readByGrnRecycleStatus(int poId, int status1) {
        String hql = "SELECT COUNT(a.id) FROM InvoiceAttachment a "
                + "WHERE a.poId = ? AND a.grnStatus = ?";

        List<?> result = getHibernateTemplate().find(hql, poId, status1);

        return !result.isEmpty() && ((Number) result.get(0)).longValue() > 0;
    }

    @Override
    public boolean readByFinancialRecycleStatus(int poId, int status1) {
        String hql = "SELECT COUNT(a.id) FROM InvoiceAttachment a "
                + "WHERE a.poId = ? AND a.financialStatus = ?";

        List<?> result = getHibernateTemplate().find(hql, poId, status1);

        return !result.isEmpty() && ((Number) result.get(0)).longValue() > 0;
    }

}
