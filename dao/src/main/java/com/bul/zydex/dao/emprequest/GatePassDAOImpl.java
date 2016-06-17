/*
 * 
 * Author Vinita
 */
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.GatePass;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class GatePassDAOImpl<T> extends GenericsDAOImpl<T> implements GatePassDAO<T> {

    @Override
    protected Class getDomainClass() {
        return GatePass.class;
    }

    public boolean isExist(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        query += ""
                + " From GatePass a "
                + " WHERE a.assetDescription = '" + gatePass.getAssetDescription() + "'"
                + " And a.assetIdentityNo = '" + gatePass.getAssetIdentityNo() + "'"
                + " And a.destination = '" + gatePass.getDestination() + "'"
                + " And a.materialCarryingPersonName = '" + gatePass.getMaterialCarryingPersonName() + "'"
                + " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H') = STR_TO_DATE('" + gatePass.getRequestDate() + " 00:00','%d/%m/%Y %H')";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<?> readByEmpId(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        String condition = "";

        if (null != gatePass.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + gatePass.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != gatePass.getSecurityRemark()) {
            condition += " AND  a.status = " + gatePass.getSecurityRemark();
        }
        if (!"".equals(gatePass.getApproveDate()) && null != gatePass.getApproveDate()
                && !"".equals(gatePass.getRequestDate()) && null != gatePass.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.materialOutDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + gatePass.getApproveDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + gatePass.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += "Select a.id, b.employeeId, b.employeeName,a.assetDescription, a.gatePassType,a.materialOutDateTime,a.expectedReturnDateTime, b.id ,a.status, c.employeeName, d.employeeName"
                + " From GatePass a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " left join a.employeeMasterByApproverId c "
                + " left join a.employeeMasterBySecurityApproverId d "
                + " where a.employeeMasterByEmployeeMasterId = " + gatePass.getEmployeeMasterByEmployeeMasterId().getId()
                + condition
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        query += "Select a.id, b.employeeId, b.employeeName, a.assetDescription, a.gatePassType,a.materialOutDateTime, b.id ,a.status"
                + " From GatePass a "
                + " left join a.employeeMasterByEmployeeMasterId b "
                + " where a.status in (1,8,10,17,18)"
                + " And b.reportingManagerLevel1 = " + gatePass.getEmployeeMasterByApproverId().getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByapproverId(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        String condition = "";

        if (null != gatePass.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + gatePass.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != gatePass.getSecurityRemark()) {
            condition += " AND  a.status = " + gatePass.getSecurityRemark();
        }
        if (!"".equals(gatePass.getApproveDate()) && null != gatePass.getApproveDate()
                && !"".equals(gatePass.getRequestDate()) && null != gatePass.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.materialOutDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + gatePass.getApproveDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + gatePass.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(gatePass.getReason()) && null != gatePass.getReason()) {
            condition += " AND c.id = " + gatePass.getReason();
        }
        if (!"".equals(gatePass.getRejectRemark()) && null != gatePass.getRejectRemark()) {
            condition += " AND d.id = " + gatePass.getRejectRemark();
        }
        query += "Select a.id, b.employeeId, b.employeeName,a.assetDescription, a.gatePassType,a.materialOutDateTime,"
                + " b.id ,a.status,f.employeeName ,e.employeeName,"
                + " case when (a.status in(2,9))"
                + " then f.employeeName ELSE e.employeeName END as approver"
                + " From GatePass a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " left join a.employeeMasterByApproverId e "
                + " left join a.employeeMasterBySecurityApproverId f "
                + " where 1=1" + condition
                + "Order by a.id Desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readforReturn(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        query += "Select a.id, b.employeeId, b.employeeName,a.assetDescription, a.gatePassType,a.materialOutDateTime,a.expectedReturnDateTime, b.id ,a.status,c.employeeId, c.employeeName"
                + " From GatePass a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " left join a.employeeMasterByApproverId c "
                + " where a.gatePassType = 1 "
                + " And a.status = 4 "
                + " And a.returnFlag = 0 "
                + " Order by STR_TO_DATE(a.expectedReturnDateTime,'%d/%m/%Y %H:%i') desc ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        String condition = "";

        if (null != gatePass.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + gatePass.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != gatePass.getSecurityRemark()) {
            condition += " AND  a.status = " + gatePass.getSecurityRemark();
        }
        if (!"".equals(gatePass.getApproveDate()) && null != gatePass.getApproveDate()
                && !"".equals(gatePass.getRequestDate()) && null != gatePass.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.materialOutDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + gatePass.getApproveDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + gatePass.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " Select a.id, b.employeeId, b.employeeName,a.assetDescription, a.gatePassType,a.materialOutDateTime,a.expectedReturnDateTime, b.id ,a.status"
                + " From GatePass a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                //                + " Order by STR_TO_DATE(a.materialOutDateTime,'%d/%m/%Y %H:%i') desc "
                + " Where 1=1 " + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        String condition = "";

        if (null != gatePass.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + gatePass.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != gatePass.getSecurityRemark()) {
            condition += " AND  a.status = " + gatePass.getSecurityRemark();
        }
        if (!"".equals(gatePass.getApproveDate()) && null != gatePass.getApproveDate()
                && !"".equals(gatePass.getRequestDate()) && null != gatePass.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.materialOutDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + gatePass.getApproveDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + gatePass.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(gatePass.getReason()) && null != gatePass.getReason()) {
            condition += " AND c.id = " + gatePass.getReason();
        }
        if (!"".equals(gatePass.getRejectRemark()) && null != gatePass.getRejectRemark()) {
            condition += " AND d.id = " + gatePass.getRejectRemark();
        }

        query += " Select a.id, b.employeeId, b.employeeName,a.assetDescription, a.gatePassType,a.materialOutDateTime,a.expectedReturnDateTime, b.id ,a.status"
                + " From GatePass a "
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByGatePassPendingRequest(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        query += " From GatePass a "
                + " where a.employeeMasterByEmployeeMasterId = " + gatePass.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,6,7,8,9,10,16,17,18,19)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByGatePassApproverPendingRequest(T object) {
        GatePass gatePass = (GatePass) object;
        String query = "";
        query += " Select a.id,b.employeeName"
                + " From GatePass a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId =b.id"
                + " and b.reportingManagerLevel1=" + gatePass.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,8,10,17,18)";
        return getHibernateTemplate().find(query);
    }

    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMasterByEmployeeMasterId"
                + " From GatePass a"
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

}
