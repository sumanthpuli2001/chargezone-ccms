/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorFinancialDetailsHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorFinancialDetailsHistory;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class VendorFinancialDetailsHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements VendorFinancialDetailsHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorFinancialDetailsHistory.class;

    }

    @Override
    public VendorFinancialDetailsHistory readByVendorinfoId(int id) {

        String query = "";
        VendorFinancialDetailsHistory vendorFinancialDetailsHistory = new VendorFinancialDetailsHistory();
        query += " FROM VendorFinancialDetailsHistory a"
                + " WHERE a.vendorInfoId = '" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorFinancialDetailsHistory = (VendorFinancialDetailsHistory) list.get(0);
        }
        return vendorFinancialDetailsHistory;

    }

    @Override
    public List readByVendorFinancialDetailsHistory() {

        String query = "SELECT a.id,b.id,a.dateTime,a.history,b.companyName,b.vendorEmailId ";
        query += " FROM VendorFinancialDetailsHistory a,VendorInformation b "
                + " WHERE a.vendorInfoId=b.id "
                + " order by a.id asc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByVendorinfoIds(int id) {
        String query = "FROM VendorFinancialDetailsHistory a "
                + "WHERE a.vendorInfoId = '" + id + "' "
                + "ORDER BY a.id ASC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendorFinanHistoryinfoid(String vendorInfoid) {

        String query = "SELECT a.id,b.id,a.dateTime,a.history,b.companyName,b.vendorEmailId ";
        query += " FROM VendorFinancialDetailsHistory a,VendorInformation b "
                + " WHERE a.vendorInfoId= '" + vendorInfoid + "' "
                + " And a.vendorInfoId=b.id"
                + " order by a.id asc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public VendorFinancialDetailsHistory VendorFinancialDetailsHistory(int id) {

        String query = "FROM VendorFinancialDetailsHistory a "
                + "WHERE a.vendorInfoId = ? "
                + "AND a.history = ?";

        List<?> list = getHibernateTemplate().find(query, id, "R0");

        if (!list.isEmpty()) {
            return (VendorFinancialDetailsHistory) list.get(0);
        }

        return new VendorFinancialDetailsHistory();

    }

}
