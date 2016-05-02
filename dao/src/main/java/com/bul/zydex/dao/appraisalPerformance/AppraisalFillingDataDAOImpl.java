/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalFillingData;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalFillingDataDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalFillingDataDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalFillingData.class;  
    }

    public boolean isExist(String year) {
        String query = "";
        query += " FROM AppraisalFillingData a"
                + " WHERE a.year='" + year + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<?> readByCurrentYear(String cyear) {
         //EmployeeMaster employeeMaster = (EmployeeMaster) object;
//        AppraisalFillingData appraisalFillingData=(AppraisalFillingData) 
        String query = "";

        query += ""
                + "FROM AppraisalFillingData a"
                + " WHERE a.year =" + cyear;
                //+ " a.userMaster.id = " + employeeMaster.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
