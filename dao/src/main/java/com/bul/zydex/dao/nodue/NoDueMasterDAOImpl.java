/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.nodue;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.NoDueMaster;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class NoDueMasterDAOImpl<T> extends GenericsDAOImpl<T> implements NoDueMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return NoDueMaster.class;
    }

    @Override
    public List<?> readNoDueApprovalList() {
        String query = "";
        query += " "
                + " FROM NoDueMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE a.status=0 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readNoDueReturnList(int id) {
        String query = "";
        query += " "
                + " SELECT a.id,b.id,b.employeeName,a.status "
                + " FROM NoDueMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.id=" + id + " and (a.status in (0,1,2,3,4,5,6,7)) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readNoDueStatusList(T object) {
        NoDueMaster noDueMaster = (NoDueMaster) object;
        String query = "";
        query += " "
                + " FROM NoDueMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.id= '" + noDueMaster.getEmployeeMasterByEmpId().getId() + "'";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApprovedList(int id) {
        String query = "";
        query += " "
                + " FROM NoDueMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.id=" + id + " and a.status=2 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readExistingemployee(int id) {
        String query = "";
        query += " select a.id"
                + " FROM NoDueMaster a "
                + " WHERE a.employeeMasterByEmpId=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readforemp(T object) {
        NoDueMaster noDueMaster = (NoDueMaster) object;
        String query = "";
        query += " "
                + " SELECT a.id,b.employeeId,b.employeeName,a.status,b.id "
                + " FROM NoDueMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.id= '" + noDueMaster.getEmployeeMasterByEmpId().getId() + "'"
                + " And a.status in (0,1,2,3,4,5,6,7) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readSearchRequest(T object) {
        NoDueMaster noDueMaster = (NoDueMaster) object;
        String query = "";
        String condition = "";

        if (null != noDueMaster.getEmployeeMasterByEmpId().getId()) {
            condition += " AND  b.id = " + noDueMaster.getEmployeeMasterByEmpId().getId();
        }
        if (!"".equals(noDueMaster.getAdvanceAmount()) && null != noDueMaster.getAdvanceAmount()) {
            condition += " AND c.id = " + noDueMaster.getAdvanceAmount();
        }
        if (!"".equals(noDueMaster.getAdvanceAmountRemark()) && null != noDueMaster.getAdvanceAmountRemark()) {
            condition += " AND d.id = " + noDueMaster.getAdvanceAmountRemark();
        }

        query += " Select  b.employeeId, b.employeeName , a.status "
                + " From  ResignationMaster f "
                + " LEFT JOIN a.employeeMasterByEmpId b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where b.id = e.employeeMasterByEmpId.id = f.employeeMasterByEmpId.id " + condition;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMasterByEmpId"
                + " FROM NoDueMaster a "
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> getNoDueByEmpId(final int empId) {
        String query = "";
        query += " "
                + " FROM NoDueMaster a "
//                + " left join a.employeeMasterByEmpId b "
                + " WHERE a.employeeMasterByEmpId.id = " + empId;

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

}
