/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ProjectManagementMaster;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aman
 */
public class ProjectManagementDAOImpl<T> extends GenericsDAOImpl<T> implements ProjectManagementDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ProjectManagementMaster.class;
    }

    @Override
    public List<?> readProjectMList() {
        String query = "";
        query = " Select a.id,a.projectCode,a.name,a.plannedDate,a.deadline "
                + "FROM ProjectManagementMaster a ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readManagerEmployeeDepart(T object) {
        ProjectManagementMaster projectManagementMaster = (ProjectManagementMaster) object;
        List<?> list = new ArrayList();
        if (null != projectManagementMaster.getManager() && !"".equals(projectManagementMaster.getManager())) {
            String query = "";
            query += " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role, d.id"
                    + " FROM EmployeeMaster a"
                    + " LEFT JOIN a.designationMaster b "
                    + " LEFT JOIN a.departmentMaster c "
                    + " LEFT JOIN a.userMaster d "
                    + " WHERE a.id= " + projectManagementMaster.getManager() + "";

            list = getHibernateTemplate().find(query);
        }
        return list;
    }

    @Override
    public List<?> deleteProjectManagement(String projectId) {
        String query = "";
        query = " Select a "
                + " FROM ProjectManagementMaster a "
                + " Where a.id = " + projectId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readProjectEmployee(int projectEmpid) {
        String query = "";
        query = "Select a.id , c.id , pm.id , pm.projectCode,pm.name,pm.plannedDate,pm.deadline "
                + "FROM TaskEmployeeDepartment a"
                + " LEFT JOIN a.createTask c"
                + " LEFT JOIN c.projectManagementMaster pm"
                + " Where a.employeeMaster=" + projectEmpid;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
