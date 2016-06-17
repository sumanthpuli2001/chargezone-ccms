/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.exitInterview;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ExitInterviewMaster;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ExitInterviewMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ExitInterviewMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ExitInterviewMaster.class;
    }

    @Override
    public List<?> readExitApprovalList(int appId, int tabId) {
        String query = "";
        query += " "
                + " Select a.id,b.id,b.employeeName as EmpName,a.status,b.employeeId"
                + " FROM ExitInterviewMaster a "
                + " LEFT JOIN a.employeeMasterByEmpId b"
                + " WHERE b.reportingManagerLevel1='" + appId + "' and  a.id='" + tabId + "' "
                + " and a.status in (0) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExitReturnList(int empId) {
        String query = "";
        query += " "
                + " Select a.id,c.id,c.employeeName as EmpName,a.status,b.id "
                + " FROM ExitInterviewMaster a "
                + " LEFT JOIN a.employeeMasterByApproverId b"
                + " LEFT JOIN a.employeeMasterByEmpId c"
                + " WHERE c.id='" + empId + "' "
                + " and a.status in (0,1,2,3,4,5,6,7)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByEmployeeId(int empId) {
        String query = "";
        query += ""
                + " Select b.id,b.employeeName as EmpName,a.status,a.dateOfSubmit,a.id "
                + " FROM ExitInterviewMaster a "
                + " LEFT JOIN a.employeeMasterByEmpId b"
                + " WHERE b.reportingManagerLevel1=" + empId;
//                + " or b.reportingManagerLevel2=" + empId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExitApproval2List(int appId, int tabId) {
        String query = "";
        query += " "
                + " Select a.id,b.id,b.employeeName as EmpName,a.status "
                + " FROM ExitInterviewMaster a "
                + " LEFT JOIN a.employeeMasterByEmpId b"
                + " WHERE b.reportingManagerLevel2='" + appId + "' and a.id='" + tabId + "'"
                + " and a.status in (0,3,5)";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExitStatusList(T object) {
        ExitInterviewMaster exitInterviewMaster = (ExitInterviewMaster) object;
        String query = "";
        query += " "
                + " SELECT a.status "
                + " FROM ExitInterviewMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.id= '" + exitInterviewMaster.getEmployeeMasterByEmpId().getId() + "'";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApprovedList(int empId) {
        String query = "";
        query += " "
                + " FROM ExitInterviewMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.id=" + empId
                + " and a.status in (2,4) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readApproveList(T object) {
        ExitInterviewMaster exitInterviewMaster = (ExitInterviewMaster) object;
        String query = "";
        query += " "
                + " FROM ExitInterviewMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE b.reportingManagerLevel1 = '" + exitInterviewMaster.getEmployeeMasterByApproverId().getId();
//                + "'"
//                + " or b.reportingManagerLevel2 = '" + exitInterviewMaster.getEmployeeMasterByApproverId().getId() + "'"

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readforHR(T object) {
        ExitInterviewMaster exitInterviewMaster = (ExitInterviewMaster) object;
        String query = "";
        query += " Select a.id,b.id,b.employeeName,a.status,b.employeeId "
                + " FROM ExitInterviewMaster a "
                + " left join a.employeeMasterByEmpId b "
                + " WHERE a.status in (1)"
                + " Order By a.id desc";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExistingEmp(int empId) {
        String query = "";
        query += " Select a.id"
                + " FROM ExitInterviewMaster a "
                + " WHERE a.employeeMasterByEmpId =" + empId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> reademp(T object) {
        ExitInterviewMaster exitInterviewMaster = (ExitInterviewMaster) object;
        String query = "";
        query += " Select a.id,a.employeeMasterByEmpId.employeeId,a.employeeMasterByEmpId.employeeName,a.status,a.employeeMasterByEmpId.id "
                + " FROM ExitInterviewMaster a "
                + " WHERE a.employeeMasterByEmpId = " + exitInterviewMaster.getEmployeeMasterByEmpId().getId()
                + " and a.status in (0,1,2,3,4)";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMasterByEmpId"
                + " From ExitInterviewMaster a"
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

    public List<?> readlist() {
        String query = "";
        query += " "
                + " Select a.id,b.id,b.employeeName as EmpName,a.status,b.employeeId"
                + " FROM ExitInterviewMaster a "
                + " LEFT JOIN a.employeeMasterByEmpId b"
                + " WHERE a.status in (1) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
