/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.travel;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.PolicyDeviationForAir;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PolicyDeviationForAirDAOImpl<T> extends GenericsDAOImpl<T> implements PolicyDeviationForAirDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PolicyDeviationForAir.class;
    }

    @Override
    public List<?> readDetail(T object) {
        PolicyDeviationForAir policyDeviationForAir = (PolicyDeviationForAir) object;
        String query = "";

        query += " Select b.level,a.deviation, a.id"
                + " FROM PolicyDeviationForAir a"
                + " LEFT JOIN a.levelMaster b";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readlevelWise(String levelId) {
//        PolicyDeviationForAir policyDeviationForAir = (PolicyDeviationForAir) object;
        String query = "";

        query += "Select a.deviation"
                + " FROM PolicyDeviationForAir a"
                + " LEFT JOIN a.levelMaster b"
                + " WHERE b.level='" + levelId + "'";

        return getHibernateTemplate().find(query);
    }

}
