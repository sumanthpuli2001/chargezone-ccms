/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.LastWorkExpDeatils;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LastWorkExpDeatils;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class LastWorkExpDeatilsDaoImpl<T> extends GenericsDAOImpl<T> implements LastWorkExpDeatilsDao<T> {

    @Override
    protected Class getDomainClass() {
        return LastWorkExpDeatils.class;
    }

    @Override
    public List readByVendorinvitId(int i10) {

        String query = "";
        query += " FROM LastWorkExpDeatils a"
                + " WHERE a.vendorInformationId = '" + i10 + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByAllData(String vInfoId, String compName, String contPerson, String mobNo, String emaile, String designatione, String storedFileName) {
        String query = "";
        query += " FROM LastWorkExpDeatils a"
                + " WHERE a.vendorInformationId = '" + vInfoId + "'"
                + " And a.companyName = '" + compName + "'"
                + " And a.contactPersonName = '" + contPerson + "'"
                + " And a.mobileNumber = '" + mobNo + "'"
                + " And a.email = '" + emaile + "'"
                + " And a.designation = '" + designatione + "'"
                + " And a.attchment = '" + storedFileName + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByFileNameData(int lwId, String vInfoId, String storedFileName) {
        String query = "";
        query += " FROM LastWorkExpDeatils a"
                + " WHERE a.id != '" + lwId + "' "
                + " AND a.vendorInformationId = '" + vInfoId + "'"
                + " And a.attchment = '" + storedFileName + "'";
        return getHibernateTemplate().find(query);
    }

}
