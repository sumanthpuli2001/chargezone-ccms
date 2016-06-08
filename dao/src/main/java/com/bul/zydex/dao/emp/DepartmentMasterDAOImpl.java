/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DepartmentMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class DepartmentMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
        DepartmentMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return DepartmentMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        DepartmentMaster departmentMaster = (DepartmentMaster) object;
        List list = getHibernateTemplate().find("from DepartmentMaster where departmentName ='" + departmentMaster.getDepartmentName() + "'");
        boolean flag = false;
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    //this method is for count number of employees in each department if therre is employee in department
    //and want departmen if 0 employee is in department replace right join with left join.
    public List<?> countEmpByDepartmentList() {
        String hqryString = "select dm.departmentName, count(em.departmentMaster.id) from DepartmentMaster dm"
                + " left join dm.employeeMasters em"
                + " where (em.dateOfLeaving is null or em.dateOfLeaving = '') "
                + " or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()"
                + " group by dm.departmentName"
                + " order by dm.departmentName";

        List departmentWiseEmpCountList = getHibernateTemplate().find(hqryString);
        return departmentWiseEmpCountList;
    }

    @Override
    //this method is for count number of employees in each department who has resigned. 
    public List<?> countResignedEmpOfDept() {

//        String sqlString = "select concat(dm.department_name), count(concat(rm.emp_master_id)) from department_master dm"
//                + " left join employee_master em on dm.id = em.department_id "
//                + " left join resignation_master rm on rm.emp_master_id = em.id "
//                + " where STR_TO_DATE(em.date_of_leaving,'%d/%m/%Y') <= CURDATE() AND rm.status = 2"
//                + " group by dm.department_name"
//                + " order by dm.department_name";
        String strQuery = "select concat(c.department_name), count(concat(a.emp_master_id))"
                + " from resignation_master a "
                + " left join employee_master b on b.id=a.emp_master_id"
                + " left join department_master c on c.id=b.department_id"
                + " where STR_TO_DATE(a.relieving_date, '%d/%m/%Y') <= CURDATE() AND a.status = 4"
                + " group by c.department_name";
//        String hqryString = "select dm.departmentName, count(rm.employeeMaster.id) from DepartmentMaster dm"
//                + " left join dm.employeeMasters em "
//                + " left join em.resignationMasters rm"
//                + " where STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y') <= CURDATE() AND rm.status = 2"
//                + " group by dm.departmentName"
//                + " order by dm.departmentName";
//        return getHibernateTemplate().find(hqryString);
        Query query = getSession().createSQLQuery(strQuery);
        List<?> probationToconfirmationRequestDataList = query.list();
        return probationToconfirmationRequestDataList;

    }

    @Override
    //this method is for count number of employees in each department if therre is employee in department
    //and want departmen if 0 employee is in department replace right join with left join.
    public List<?> countEmpByDepartmentList2() {
        String hqryString = "select dm.departmentName, count(em.departmentMaster.id),dm.id from DepartmentMaster dm"
                + " left join dm.employeeMasters em"
                + " where (em.dateOfLeaving is null or em.dateOfLeaving = '') "
                + " or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()"
                + " group by dm.departmentName"
                + " order by dm.departmentName";
        List departmentWiseEmpCountList = getHibernateTemplate().find(hqryString);
        return departmentWiseEmpCountList;
    }

    @Override
    public List<?> readByName(String departmentName) {
        String query = "";
        query += "From DepartmentMaster a "
                //                + " Where a.departmentName like '%" + departmentName + "'";
                + " Where lower(trim(a.departmentName)) ='" + departmentName + "'";
        return getHibernateTemplate().find(query);
    }

}
