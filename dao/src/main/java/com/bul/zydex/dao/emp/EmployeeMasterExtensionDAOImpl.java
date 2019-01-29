
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;

import com.bul.zydex.model.EmployeeMasterExtension;
import java.util.List;



public class EmployeeMasterExtensionDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeMasterExtensionDAO<T>
{

    @Override
    protected Class getDomainClass() {
        return EmployeeMasterExtension.class;
    }

    @Override
    public List<?> readByemployeeId(Integer id) {
         String query = "";
        query += "select a"
                + " FROM EmployeeMasterExtension a"
                + " where a.employeeMaster.id=" + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByemployeeId(int id) {
       String query = "";
        query += " Delete from EmployeeMasterExtension d "
                + " Where d.employeeMaster.id =" + id;

        getHibernateTemplate().bulkUpdate(query);
    }

//    @Override
//    public List<?> readByemployeeIdForExcel(Integer id) {
//        String query = "";
//        query += " select a.id,     b.ctcName,a.amount,a.status,a.month,a.year,a.id"
//                + " FROM EmployeeMasterExtension a "
//                + " where c.employeeMaster.id=" + id;
//
//        return getHibernateTemplate().find(query);
//    }

}
