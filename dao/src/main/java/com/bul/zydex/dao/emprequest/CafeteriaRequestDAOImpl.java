/*
 * 
 * Author Vinita
 */
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CafeteriaRequest;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class CafeteriaRequestDAOImpl<T> extends GenericsDAOImpl<T> implements CafeteriaRequestDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CafeteriaRequest.class;
    }

    @Override
    public List<?> readByEmpId(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        String condition = "";

        if (null != cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != cafeteriaRequest.getAdminRemark()) {
            condition += " AND  a.status = " + cafeteriaRequest.getAdminRemark();
        }
        if (!"".equals(cafeteriaRequest.getApproverDate()) && null != cafeteriaRequest.getApproverDate()
                && !"".equals(cafeteriaRequest.getRequestDate()) && null != cafeteriaRequest.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.orderDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + cafeteriaRequest.getApproverDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + cafeteriaRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " Select a.orderDateTime , a.status ,a.requestType ,a.requestFor,a.id , c.employeeName "
                + " From CafeteriaRequest a "
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByAdminApproverId c"
                + " Where 1=1 " + condition
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        query += "Select a.id, b.employeeId, b.employeeName, a.requestType, a.requestFor, b.id ,a.status"
                + " From CafeteriaRequest a "
                + " left join a.employeeMasterByEmployeeMasterId b "
                + " where a.status in (1,7,8,10,17,18) "
                + " And b.reportingManagerLevel1 = " + cafeteriaRequest.getEmployeeMasterByApproverId().getId();
//                 + "a.employeeMasterByApproverId = " + cafeteriaRequest.getEmployeeMasterByApproverId().getId()
//                 + " And 
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByapproverId(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        String condition = "";

        if (null != cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != cafeteriaRequest.getAdminRemark()) {
            condition += " AND  a.status = " + cafeteriaRequest.getAdminRemark();
        }
        if (!"".equals(cafeteriaRequest.getApproverDate()) && null != cafeteriaRequest.getApproverDate()
                && !"".equals(cafeteriaRequest.getRequestDate()) && null != cafeteriaRequest.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.orderDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + cafeteriaRequest.getApproverDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + cafeteriaRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(cafeteriaRequest.getReason()) && null != cafeteriaRequest.getReason()) {
            condition += " AND c.id = " + cafeteriaRequest.getReason();
        }
        if (!"".equals(cafeteriaRequest.getRejectRemark()) && null != cafeteriaRequest.getRejectRemark()) {
            condition += " AND d.id = " + cafeteriaRequest.getRejectRemark();
        }
//         Select  b.employeeId, b.employeeName ,a.orderDateTime , a.requestType ,a.requestFor, a.status
        query += "Select a.id, b.employeeId, b.employeeName,a.orderDateTime , a.requestType, a.requestFor, b.id ,a.status, e.employeeName "
                + " From CafeteriaRequest a "
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " LEFT JOIN a.employeeMasterByAdminApproverId e "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    //----------search-------------
    @Override
    public List<?> readSearchEmpRequest(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        String condition = "";

        if (null != cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != cafeteriaRequest.getAdminRemark()) {
            condition += " AND  a.status = " + cafeteriaRequest.getAdminRemark();
        }
        if (!"".equals(cafeteriaRequest.getApproverDate()) && null != cafeteriaRequest.getApproverDate()
                && !"".equals(cafeteriaRequest.getRequestDate()) && null != cafeteriaRequest.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.orderDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + cafeteriaRequest.getApproverDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + cafeteriaRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " Select a.orderDateTime , a.status ,a.requestType ,a.requestFor"
                + " From CafeteriaRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " Where 1=1 " + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        String condition = "";

        if (null != cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != cafeteriaRequest.getAdminRemark()) {
            condition += " AND  a.status = " + cafeteriaRequest.getAdminRemark();
        }
        if (!"".equals(cafeteriaRequest.getApproverDate()) && null != cafeteriaRequest.getApproverDate()
                && !"".equals(cafeteriaRequest.getRequestDate()) && null != cafeteriaRequest.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.orderDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + cafeteriaRequest.getApproverDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + cafeteriaRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(cafeteriaRequest.getReason()) && null != cafeteriaRequest.getReason()) {
            condition += " AND c.id = " + cafeteriaRequest.getReason();
        }
        if (!"".equals(cafeteriaRequest.getRejectRemark()) && null != cafeteriaRequest.getRejectRemark()) {
            condition += " AND d.id = " + cafeteriaRequest.getRejectRemark();
        }

        query += " Select  b.employeeId, b.employeeName ,a.orderDateTime , a.requestType ,a.requestFor, a.status "
                + " From CafeteriaRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByCafeTeriaPendingRequest(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        query += " From CafeteriaRequest a"
                + " Where a.employeeMasterByEmployeeMasterId=" + cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";
//                   + " and a.status in (1,6,7,8,9,10,16,17,18,19)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByCafeTeriaApproverPendingRequest(T object) {
        CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) object;
        String query = "";
        query += "Select a.id,b.employeeName"
                + " From CafeteriaRequest a,"
                + " EmployeeMaster b"
                + " Where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,5,6,10)";
//                  + " and a.status in (1,7,8,10,17,18)";
        return getHibernateTemplate().find(query);
    }

    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMasterByEmployeeMasterId"
                + " From CafeteriaRequest a"
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }
}
