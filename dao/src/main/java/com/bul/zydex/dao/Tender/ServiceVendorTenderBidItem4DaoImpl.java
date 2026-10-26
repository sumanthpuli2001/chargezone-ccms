/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceVendorTenderBidItem4;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem4DaoImpl<T> extends GenericsDAOImpl<T> implements ServiceVendorTenderBidItem4Dao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ServiceVendorTenderBidItem4.class;
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem4 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String security_name) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem4 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.securityName = '"+security_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String security_name, String security, String wage, String per, String total, String allowance, String allowance_total, String uniform, String service, String total_per_day, String total_per_month, String total_per_year, String per_day, String per_month, String per_year, String total_per_day_pp, String total_per_day_per_pp) {
        String query = "";
        query += " update ServiceVendorTenderBidItem4 a"
                + " set a.wages='"+wage+"', "
                + " a.percentage='"+per+"', "
                + " a.perTotal='"+total+"', "
                + " a.allowance ='"+allowance+"', "
                + " a.allowanceTotal='"+allowance_total+"', "
                + " a.uCharges='"+uniform+"', "
                + " a.sCharges='"+service+"', "
                + " a.tPDPP='"+total_per_day+"', "
                + " a.tPMPP='"+total_per_month+"', "
                + " a.tPYPP='"+total_per_year+"', "
                + " a.tPD='"+per_day+"', "
                + " a.tPM='"+per_month+"', "
                + " a.tDY='"+per_year+"', "
                + " a.perDayPerPerson='"+total_per_day_pp+"', "
                + " a.perDayPerDay="+total_per_day_per_pp+" "
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.securityName = '"+security_name+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
