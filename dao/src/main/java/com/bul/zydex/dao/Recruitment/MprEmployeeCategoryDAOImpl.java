/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprEmployeeCategory;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprEmployeeCategoryDAOImpl<T> extends GenericsDAOImpl<T> implements MprEmployeeCategoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return MprEmployeeCategory.class;
    }

    @Override
    public List<?> getByName(String Ctname) {
        String query = "";
        query += " select a.id"
                + " From MprEmployeeCategory a "
                + " where a.employeeCategory like '%" + Ctname + "%'";
        return getHibernateTemplate().find(query);
    }

}
