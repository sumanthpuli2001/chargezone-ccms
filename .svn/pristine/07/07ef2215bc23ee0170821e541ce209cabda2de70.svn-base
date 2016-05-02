/*
 * 
 * Author Vinita
 */
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VisitorManagement;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class VisitorManagementDAOImpl<T> extends GenericsDAOImpl<T> implements VisitorManagementDAO<T> {

    @Override
    protected Class getDomainClass() {
        return VisitorManagement.class;
    }

    @Override
    public List<?> readByEmpId(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += " Select  a.visitorName,a.visitorOrganization, a.incomingDateTime, a.status ,a.id ,b.employeeName"
                + " From VisitorManagement a "
                + " left join a.employeeMasterBySecurityApproveId b"
                + " where a.employeeMasterByEmployeeMasterId = " + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                //                + " And a.status in (1,6,4,16) "
                + " Order by a.status desc limit 5 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += "Select a.id, b.employeeId, b.employeeName, a.visitorName, a.incomingDateTime, b.id ,a.status"
                + " From VisitorManagement a "
                + " left join a.employeeMasterByEmployeeMasterId b "
                + " where a.status in (1,7,8,10,17,18) "
                + " And b.reportingManagerLevel1 = " + visitorManagement.getEmployeeMasterByApproverId().getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByapproverId(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += "Select a.id, b.employeeId, b.employeeName, a.visitorName, a.incomingDateTime, b.id ,a.status,c.employeeName"
                + "  From VisitorManagement a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " left join a.employeeMasterBySecurityApproveId c"
//                + " left join a.employeeMasterByApproverId c "
                   + " where a.status in (1,2,8)" ;
//                   + " where a.status in (1,5,6,10)" ;
        List list =getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        String condition = "";

        if (null != visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != visitorManagement.getSecurityRemark()) {
            condition += " AND  a.status = " + visitorManagement.getSecurityRemark();
        }
        if (!"".equals(visitorManagement.getApproverDate()) && null != visitorManagement.getApproverDate()
                && !"".equals(visitorManagement.getRequestDate()) && null != visitorManagement.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.incomingDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + visitorManagement.getApproverDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + visitorManagement.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " Select a.visitorName,a.visitorOrganization, a.incomingDateTime, a.status ,a.id ,c.employeeName"
//                + "a.visitorName,a.visitorOrganization, a.incomingDateTime, a.status "
                + " From VisitorManagement a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " left join a.employeeMasterBySecurityApproveId c"
                + " Where 1=1 " + condition;
        List list =getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSearchRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        String condition = "";

        if (null != visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != visitorManagement.getSecurityRemark()) {
            condition += " AND  a.status = " + visitorManagement.getSecurityRemark();
        }
        if (!"".equals(visitorManagement.getApproverDate()) && null != visitorManagement.getApproverDate()
                && !"".equals(visitorManagement.getRequestDate()) && null != visitorManagement.getRequestDate()) {
            condition += " AND STR_TO_DATE(a.incomingDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + visitorManagement.getApproverDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + visitorManagement.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(visitorManagement.getReason()) && null != visitorManagement.getReason()) {
            condition += " AND c.id = " + visitorManagement.getReason();
        }
        if (!"".equals(visitorManagement.getRejectRemark()) && null != visitorManagement.getRejectRemark()) {
            condition += " AND d.id = " + visitorManagement.getRejectRemark();
        }

        query += " Select a.id, b.employeeId, b.employeeName, a.visitorName, a.incomingDateTime, b.id ,a.status,e.employeeName  "
//                + "b.employeeId, b.employeeName ,a.visitorName,a.visitorOrganization, a.incomingDateTime, a.status "
                + " From VisitorManagement a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " left join a.employeeMasterBySecurityApproveId e"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;
        List list=getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readVisitorManagementPendingRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += " From VisitorManagement a "
                + " where a.employeeMasterByEmployeeMasterId="+visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";
        return getHibernateTemplate().find(query);
    }
    @Override
    public List<?> readVisitorManagementApproverPendingRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += "Select a.id,b.employeeName"
                + " From VisitorManagement a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1="+visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,5,6,10)";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public List<?> readEmpIdFromTabId(int id){
     String query = "";
     query +=" select a.employeeMasterByEmployeeMasterId"
       + " From VisitorManagement a"
        + " where a.id = " +id ;
      return getHibernateTemplate().find(query);
}
}
