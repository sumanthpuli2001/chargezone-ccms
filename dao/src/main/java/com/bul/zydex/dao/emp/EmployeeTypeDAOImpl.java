/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeTypeMaster;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class EmployeeTypeDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeTypeMaster.class;
    }

    @Override
    public List<?> readByName(String name) {
        String query = "";
        query += "From EmployeeTypeMaster a "
                //                + " Where a.level like '%" + name + "'";
                + " Where a.typeOfEmployee ='" + name + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByID(int readByID) {
        String query = "";
        query += "From EmployeeTypeMaster a "
              + " Where a.id =" + readByID ;
        return getHibernateTemplate().find(query);
    }

}
