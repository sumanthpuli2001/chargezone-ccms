/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorInfo;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorInfoDaoImpl<T> extends GenericsDAOImpl<T> implements VendorInfoDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorInfo.class;
    }

    @Override
    public List readData(String stno, String vatno, String panno) {
        String query = "";
        query += " FROM VendorInfo a"
                + " WHERE a.servicetaxno = '" + stno + "' or a.vatno = '" + vatno + "' or a.panno = '" + panno + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public VendorInfo readData1(String stno, String vatno, String panno) {
        VendorInfo vendorInfo = new VendorInfo();
        String query = "";
        query += " FROM VendorInfo a"
                + " WHERE a.servicetaxno = '" + stno + "' or a.vatno = '" + vatno + "' or a.panno = '" + panno + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorInfo = (VendorInfo) list.get(0);
        }
        return vendorInfo;
    }

    @Override
    public List searchVendor(String fname, String sfirm, String rdate, String cinno, String address, String pinno, String cperson, String officeno, String resino, String mobno, String faxno, String email1, String email2, String salesno, String stno, String cstno, String vatno, String panno, String tenderno) {
        String query = "";
        
        String condition="";
        if(!fname.equals(""))
        {
            condition = condition + " and a.fname = '"+fname+"'";
        }
        if(!sfirm.equals("Select"))
        {
            condition = condition + " and a.sfirm = '"+sfirm+"'";
        }
        if(!rdate.equals(""))
        {
            condition = condition + " and a.rdate = '"+rdate+"'";
        }
        if(!cinno.equals(""))
        {
            condition = condition + " and a.cinno = '"+cinno+"'";
        }
        if(!address.equals(""))
        {
            condition = condition + " and a.addr = '"+address+"'";
        }
        if(!pinno.equals(""))
        {
            condition = condition + " and a.pinno = '"+pinno+"'";
        }
        if(!cperson.equals(""))
        {
            condition = condition + " and a.cperson = '"+cperson+"'";
        }
        if(!officeno.equals(""))
        {
            condition = condition + " and a.officeno = '"+officeno+"'";
        }
        if(!resino.equals(""))
        {
            condition = condition + " and a.resino = '"+resino+"'";
        }
        if(!mobno.equals(""))
        {
            condition = condition + " and a.mobno = '"+mobno+"'";
        }
        if(!faxno.equals(""))
        {
            condition = condition + " and a.faxno = '"+faxno+"'";
        }
        if(!email1.equals(""))
        {
            condition = condition + " and a.emailid = '"+email1+"'";
        }
        if(!email2.equals(""))
        {
            condition = condition + " and a.alteremailid = '"+email2+"'";
        }
        if(!salesno.equals(""))
        {
            condition = condition + " and a.stno = '"+salesno+"'";
        }
        if(!stno.equals(""))
        {
            condition = condition + " and a.servicetaxno = '"+stno+"'";
        }
        if(!cstno.equals(""))
        {
            condition = condition + " and a.cstno = '"+cstno+"'";
        }
        if(!vatno.equals(""))
        {
            condition = condition + " and a.vatno = '"+vatno+"'";
        }
        if(!tenderno.equals(""))
        {
            condition = condition + " and a.tno = '"+tenderno+"'";
        }
        
        query += " FROM VendorInfo a"
                + " WHERE 1=1 "+ condition;
        return getHibernateTemplate().find(query);
    }
}
