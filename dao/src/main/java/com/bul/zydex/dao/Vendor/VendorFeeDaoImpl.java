/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorFee;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorFeeDaoImpl<T> extends GenericsDAOImpl<T> implements VendorFeeDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorFee.class;
    }

    @Override
    public VendorFee readByVendorRefNo(String refNo, String username) {
        VendorFee vendorFee = new VendorFee();
        String query = "";
        query += " FROM VendorFee a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorFee = (VendorFee) list.get(0);
        }
        return vendorFee;
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorFee a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String doc_cost, String fee_date, String fee_drawee_bank, String fee_attach, String fee_cheque_no) {
        String query = "";
        if(fee_attach != "")
        {
            query += " update VendorFee a"
                + " set a.feeDate='"+fee_date+"', "
                + " a.feeAmount='"+doc_cost+"', "
                + " a.draweeBank='"+fee_drawee_bank+"', "
                + " a.attachment='"+fee_attach+"', "
                + " a.chequeNo='"+fee_cheque_no+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        }
        else
        {
            query += " update VendorFee a"
                + " set a.feeDate='"+fee_date+"', "
                + " a.feeAmount='"+doc_cost+"', "
                + " a.draweeBank='"+fee_drawee_bank+"', "
                + " a.chequeNo='"+fee_cheque_no+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        }
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }
}
