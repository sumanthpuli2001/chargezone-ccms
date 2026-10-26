/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorEmd;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorEmdDaoImpl<T> extends GenericsDAOImpl<T> implements VendorEmdDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorEmd.class;
    }

    @Override
    public VendorEmd readByVendorRefNo(String refNo, String username) {
        VendorEmd vendorEmd = new VendorEmd();
        String query = "";
        query += " FROM VendorEmd a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorEmd = (VendorEmd) list.get(0);
        }
        return vendorEmd;
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorEmd a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String emd, String emd_date, String emd_drawee_bank, String emd_attach, String cash_cheque, String emd_cheque_no) {
        String query = "";
        if(emd_attach != "")
        {
            query += " update VendorEmd a"
                + " set a.emdDate='"+emd_date+"', "
                + " a.emdAmount='"+emd+"', "
                + " a.draweeBank='"+emd_drawee_bank+"', "
                + " a.attachment='"+emd_attach+"', "
                + " a.cashCheque='"+cash_cheque+"', "
                + " a.chequeNo='"+emd_cheque_no+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        }
        else
        {
            query += " update VendorEmd a"
                + " set a.emdDate='"+emd_date+"', "
                + " a.emdAmount='"+emd+"', "
                + " a.draweeBank='"+emd_drawee_bank+"', "
                + " a.cashCheque='"+cash_cheque+"', "
                + " a.chequeNo='"+emd_cheque_no+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        }
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }
}
