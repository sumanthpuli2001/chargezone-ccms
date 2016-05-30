package com.bul.zydex.dao.resignation;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ResignationMaster;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dhruv
 */
public class ResignationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ResignationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ResignationMaster.class;
    }

    @Override
    public List<?> readByEmpID(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id=" + id + " "
                + " and a.status in (0,1,2,3,4,5,6,7,8,10,11)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readRegStatusList(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " "
                + " SELECT a.status "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id= '" + resignationMaster.getEmployeeMaster().getId() + "'"
                + " and a.status != 9 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApprovedList(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b "
                + " WHERE b.id=" + id + " and a.status=2 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByResignationPendingRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " Select a.id,a.effectiveDatetime,a.status, a.employeeMaster.id, a.relievingDate"
                + " FROM ResignationMaster a"
                + " WHERE a.employeeMaster.id=" + resignationMaster.getEmployeeMaster().getId()
                + " and a.status in (0,1,2,3,4,5,6,7,8,10,11)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readforapprover(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " Select a.id,a.effectiveDatetime,a.status, b.id, b.employeeId,b.employeeName"
                + " FROM ResignationMaster a"
                + " left join a.employeeMaster b"
                + " WHERE b.reportingManagerLevel1 = " + resignationMaster.getEmployeeMaster().getId()
                + " and a.status in (0,3,5)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readforHR(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += " Select a.id,a.effectiveDatetime,a.status, b.id, b.employeeId,b.employeeName"
                + " FROM ResignationMaster a"
                + " left join a.employeeMaster b"
                + " WHERE a.status in (2,7,10,4)"
                + " and  (b.dateOfLeaving is null or b.dateOfLeaving = '') "
                + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()"
                + " GROUP BY a.id";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExistingList(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " WHERE a.employeeMaster.id=" + id
                + " and a.status != 9";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readmanager1(int id) {
        String query = "";
        query += " "
                + " FROM ResignationMaster a "
                + " left join a.employeeMaster b"
                + " WHERE b.reportingManagerLevel1= " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSearchRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        String condition = "";

        if (null != resignationMaster.getEmployeeMaster().getId()) {
            condition += " AND  a.id = " + resignationMaster.getEmployeeMaster().getId();
        }
        if (!"".equals(resignationMaster.getReason()) && null != resignationMaster.getReason()) {
            condition += " AND e.id = " + resignationMaster.getReason();
        }
        if (!"".equals(resignationMaster.getManagerComment()) && null != resignationMaster.getManagerComment()) {
            condition += " AND f.id = " + resignationMaster.getManagerComment();
        }

        query += " Select  a.employeeId, a.employeeName , b.status ,c.status,d.status,a.id,b.id,c.id ,d.id"
                //                + " (select em.employeeName from EmployeeMaster em where em.id = g.employeeMasterByApproverId)"
                + " From EmployeeMaster a "
                //                + " ExitInterviewMaster g "
                + " LEFT JOIN  a.resignationMasters b"
                + " LEFT JOIN  a.exitInterviewMastersForEmpId c"
                + " LEFT JOIN  a.noDueMastersForEmpId d"
                + " LEFT JOIN a.departmentMaster e"
                + " LEFT JOIN a.designationMaster f"
                + " Where (d.status in (0,1,2,3,4,5,6,7)"
                + " or c.status in (0,1,2) "
                + " or b.status in (0,1,2,3,4,5,6,7,9,10,11))" + condition
                + " group by a.id " ;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readmanagerSearchRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        String condition = "";

        query += " Select  a.employeeId,a.employeeName,b.status,c.status,b.effectiveDatetime,a.id,b.id,c.id "
                + " From EmployeeMaster  a "
                + " LEFT JOIN  a.resignationMasters b"
                + " LEFT JOIN  a.exitInterviewMastersForEmpId c"
                + " Where a.reportingManagerLevel1 = " + resignationMaster.getEmployeeMaster().getId()
                + " and (c.status in (0,1,2) "
                + " or b.status in (0,1,2,3,4,5,6,7,9,10,11))" + condition;

//                + " and (c.status in (0,1,2,3,4,5,6,7) "
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readresignationApproverPendingRequest(T object) {
        ResignationMaster resignationMaster = (ResignationMaster) object;
        String query = "";
        query += "Select a.id,b.employeeName"
                + " From resignationMasters a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + resignationMaster.getEmployeeMaster().getId()
                + " and a.status in (0)";
        return getHibernateTemplate().find(query);
    }

    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMaster"
                + " From ResignationMaster a"
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readResignedEmployees() {
        String query = "";
        query += " "
                + " SELECT a.id, a.employeeId, a.employeeName, c.departmentName, b.designationName, a.role"
                + " From ResignationMaster R"
                + " LEFT JOIN R.employeeMaster a "
                + " LEFT JOIN a.designationMaster b "
                + " LEFT JOIN a.departmentMaster c ";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> getFinallyResignedEmployees() {
        String query = "";
        query += " "
                + " From ResignationMaster R"
                + " where R.status = '4' ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
 