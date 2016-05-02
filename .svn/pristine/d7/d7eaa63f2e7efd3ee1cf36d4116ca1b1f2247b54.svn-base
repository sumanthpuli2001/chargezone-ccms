/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PoolCarRequest;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class PoolCarRequestDAOImpl<T> extends GenericsDAOImpl<T> implements PoolCarRequestDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PoolCarRequest.class;
    }

    @Override
    public boolean isExist(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        query += ""
                + " From PoolCarRequest a "
                + " where a.employeeMasterByEmployeeMasterId = " + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }

//   ---------------  searchApproverSubmit---------------
    @Override
    public List<?> readByrequesteeId(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        query += " SELECT a.id, b.employeeId, b.employeeName, a.startDateTime, a.endDateTime, b.id ,a.status "
                + "From PoolCarRequest a"
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " where a.status in (1,8,10,17,18) "
                + " And b.reportingManagerLevel1 = "+poolCarRequest.getEmployeeMasterByApproverId().getId()
                + " Order by a.id desc";
//                + " and a.employeeMasterByEmployeeMasterId = " + poolCarRequest.getEmployeeMasterByApproverId().getId() ;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByapproverId(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        String condition = "";

        if (null != poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != poolCarRequest.getAdminRemark()) {
            condition += " AND  a.status = " + poolCarRequest.getAdminRemark();
        }
        if (!"".equals(poolCarRequest.getStartDateTime()) && null != poolCarRequest.getStartDateTime()
                && !"".equals(poolCarRequest.getEndDateTime()) && null != poolCarRequest.getEndDateTime()) {
            condition += " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(poolCarRequest.getReason()) && null != poolCarRequest.getReason()) {
            condition += " AND c.id = " + poolCarRequest.getReason();
        }
        if (!"".equals(poolCarRequest.getRejectRemark()) && null != poolCarRequest.getRejectRemark()) {
            condition += " AND d.id = " + poolCarRequest.getRejectRemark();
        }
        query += " SELECT a.id, b.employeeId, b.employeeName, a.startDateTime, a.endDateTime, b.id ,a.status ,e.employeeId, e.employeeName,f.employeeName "
                + " From PoolCarRequest a"
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " left join a.employeeMasterByApproverId f "
                + " left join a.employeeMasterByAdminApproverId e "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " where 1=1"  + condition
                + " Order by a.id desc";
//                + " and a.employeeMasterByEmployeeMasterId = " + poolCarRequest.getEmployeeMasterByApproverId().getId() ;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmpId(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        String condition = "";
        if (null != poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != poolCarRequest.getAdminRemark()) {
            condition += " AND  a.status = " + poolCarRequest.getAdminRemark();
        }

        if (!"".equals(poolCarRequest.getStartDateTime()) && null != poolCarRequest.getStartDateTime()
                && !"".equals(poolCarRequest.getEndDateTime()) && null != poolCarRequest.getEndDateTime()) {
            condition += " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " Select a.startDateTime, a.endDateTime, a.status, a.id , c.employeeName, d.employeeName"
                + " From PoolCarRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                     + " left join a.employeeMasterByApproverId c "
                     + " left join a.employeeMasterByAdminApproverId d "
                + " where a.employeeMasterByEmployeeMasterId = " + poolCarRequest.getEmployeeMasterByAdminApproverId().getId()
                + condition
                  + " Order by a.id desc";
        return getHibernateTemplate().find(query);
    }

// -----------------------   Search Query---------------
    @Override
    public List<?> readSearchRequest(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        String condition = "";

        if (null != poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != poolCarRequest.getAdminRemark()) {
            condition += " AND  a.status = " + poolCarRequest.getAdminRemark();
        }
        if (!"".equals(poolCarRequest.getStartDateTime()) && null != poolCarRequest.getStartDateTime()
                && !"".equals(poolCarRequest.getEndDateTime()) && null != poolCarRequest.getEndDateTime()) {
            condition += " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(poolCarRequest.getReason()) && null != poolCarRequest.getReason()) {
            condition += " AND c.id = " + poolCarRequest.getReason();
        }
        if (!"".equals(poolCarRequest.getRejectRemark()) && null != poolCarRequest.getRejectRemark()) {
            condition += " AND d.id = " + poolCarRequest.getRejectRemark();
        }

        query += " Select  b.employeeId, b.employeeName ,a.startDateTime, a.endDateTime, a.status "
                + " From PoolCarRequest a "
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        String condition = "";
        if (null != poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != poolCarRequest.getAdminRemark()) {
            condition += " AND  a.status = " + poolCarRequest.getAdminRemark();
        }

        if (!"".equals(poolCarRequest.getStartDateTime()) && null != poolCarRequest.getStartDateTime()
                && !"".equals(poolCarRequest.getEndDateTime()) && null != poolCarRequest.getEndDateTime()) {
            condition += " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i') ";
        }
//        else if (!"".equals(poolCarRequest.getStartDateTime()) && null != poolCarRequest.getStartDateTime()) {
//            condition += " AND a.startDateTime >='" + poolCarRequest.getStartDateTime() + " 00:00:00' ";
//        }
//        else if (!"".equals(poolCarRequest.getEndDateTime()) && null != poolCarRequest.getEndDateTime()) {
//            condition += "AND a.endDateTime <='" + poolCarRequest.getEndDateTime() + "00:00' ";
//        }

        query += " Select a.startDateTime, a.endDateTime, a.status"
                + " From PoolCarRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                 + " Order by a.id desc"
                + " Where 1=1 " + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByPoolCarPendingRequest(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        query += " From PoolCarRequest a"
                + " where a.employeeMasterByEmployeeMasterId=" + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,6,7,8,9,10,16,17,18,19)"
                  + " Order by a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByApproverWisePoolCarPendingRequest(T object) {
        PoolCarRequest poolCarRequest = (PoolCarRequest) object;
        String query = "";
        query += " SELECT a.id,b.employeeName"
                + " From PoolCarRequest a,"
                + " EmployeeMaster b"
                + " Where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,8,10,17,18)"
                  + " Order by a.id desc";

        return getHibernateTemplate().find(query);
    }
    
    @Override
     public List<?> readEmpIdFromTabId(int id){
     String query = "";
     query +=" select a.employeeMasterByEmployeeMasterId"
        + " From PoolCarRequest a"
        + " where a.id = " +id ;
      return getHibernateTemplate().find(query);
}
}
