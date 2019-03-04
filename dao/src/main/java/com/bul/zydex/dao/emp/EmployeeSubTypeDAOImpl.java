/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeSubType;
import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author Nishant
 */
public class EmployeeSubTypeDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeSubTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeSubType.class;
    }

    @Override
    public List<?> readByEmployeeTypeId(String typeId) {

        String query = ""
                + "From EmployeeSubType where employeeTypeMaster.id=" + typeId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByName(String name) {
        String query = "";
        query += "From EmployeeSubType a "
                //                + " Where a.level like '%" + name + "'";
                + " Where a.subType ='" + name + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByID(int empsubtypid) {
         String query = "";
        query += "From EmployeeSubType a "
              + " Where a.id =" + empsubtypid ;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeeTypeIdANDSubTypeName(int emptypid, String employeeSubtype) {
         String query = "";
        query += "From EmployeeSubType a "
              + " Where employeeTypeMaster.id =" + emptypid +" AND a.subType ='" + employeeSubtype + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readOrderNameWise() {
        String query = "";
        query += "From EmployeeSubType a "
              + " ORDER BY a.subType ASC ";
        return getHibernateTemplate().find(query);
    }

}
