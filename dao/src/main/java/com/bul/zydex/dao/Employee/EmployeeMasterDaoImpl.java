/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Employee;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Aman Bahukhandi
 */
public class EmployeeMasterDaoImpl<T> extends GenericsDAOImpl<T> implements EmployeeMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeMaster.class;
    }

    @Override
    public Boolean readByRifId(String rfId) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + rfId + "'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public EmployeeMaster read(String empCode) {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.employeeCode = '" + empCode + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;
    }

    @Override
    public void deleteByEmpCode(String checkedValues) {
        String query = "";
        query += " delete FROM EmployeeMaster a"
                + " WHERE a.employeeCode = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readShift(String code) {
        String query = "";
        query = " Select a.shiftType from EmployeeMaster a where a.employeeCode='" + code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public EmployeeMaster readByRfIdValue(String empCode) {
        EmployeeMaster employeeMaster = null;

        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + empCode + "'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return null;
        } else {
            employeeMaster = (EmployeeMaster) list.get(0);
        }
        return employeeMaster;

    }

    @Override
    public List readByDrow() {
        String query = "";
        query = " Select a from EmployeeMaster a where a.dRow = 'N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrowDisable() {
        String query = "";
        query = " Select a from EmployeeMaster a where a.dRow = 'Y'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRfId(String rfId) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + rfId + "'";
        return getHibernateTemplate().find(query);
    }
    @Override
    public List readByRFid(String rfId) {
        String query = "Select a.employeeCode,a.rfId";
        query += " FROM EmployeeMaster a"
                + " WHERE a.rfId = '" + rfId + "'";
        return getHibernateTemplate().find(query);
    }

}
