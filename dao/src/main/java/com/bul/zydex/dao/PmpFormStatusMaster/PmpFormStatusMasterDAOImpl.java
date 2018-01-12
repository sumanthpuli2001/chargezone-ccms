/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PmpFormStatusMaster;

import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public class PmpFormStatusMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PmpFormStatusMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PmpFormStatusMaster.class;
    }

    @Override
    public List<?> readByPmpformstatusStatus(String employeeId) {

        String query = "";

        query += "  "
                + "FROM PmpFormStatusMaster a "
                //                + " WHERE a.behaviorsYear =" + year
                + " where a.employeeMaster = " + employeeId;
//                + "FROM AppraisalPerformanceMaster a "
//                + " WHERE a.employeeMaster = " + employeeId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> delete1(String employeeId) {
      String query = "";

        query += "  "
                + " select a"
                +" FROM PmpFormStatusMaster a "
                //                + " WHERE a.behaviorsYear =" + year
                + " where a.employeeMaster = " + employeeId;
//                + "FROM AppraisalPerformanceMaster a "
//                + " WHERE a.employeeMaster = " + employeeId;
        return getHibernateTemplate().find(query);
    }

}
