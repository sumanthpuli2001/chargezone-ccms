/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ElectricalContractor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ElectricalContractor;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Sumanth
 */
public class ElectricalContractorDaoImpl<T> extends GenericsDAOImpl<T> implements ElectricalContractorDao<T> {

    @Override
    protected Class getDomainClass() {
        return ElectricalContractor.class;
    }

    @Override
    public List readByVendorInformationId(String vendorInformationid) {
        String query = "SELECT a";
        query += " FROM ElectricalContractor a"
                + " left join a.vendorInformation d"
                + " where d.id =" + vendorInformationid;

        List list1 = getHibernateTemplate().find(query);
        return list1;

    }

    @Override
    public void deleteByVendorInformationId(String VInformationId) {
        String query = "";
        query += " delete from ElectricalContractor a"
                + " WHERE a.vendorInformation.id = '" + VInformationId + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }
}
