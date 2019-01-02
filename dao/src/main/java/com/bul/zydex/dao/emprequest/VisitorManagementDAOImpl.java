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
        query += " Select  a.visitorName,a.visitorOrganization, a.incomingDateTime, a.status ,a.id ,b.employeeName, a.requestDate"
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
        query += "Select a.id, b.employeeId, b.employeeName, a.visitorName, a.incomingDateTime, b.id ,a.status,c.employeeName, a.requestDate"
                + "  From VisitorManagement a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " left join a.employeeMasterBySecurityApproveId c"
                //                + " left join a.employeeMasterByApproverId c "
                + " where a.status in (1,2,8)"
                + "Order by a.id desc";
//                   + " where a.status in (1,5,6,10)" ;
        List list = getHibernateTemplate().find(query);
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
        List list = getHibernateTemplate().find(query);
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

        query += " Select a.id, b.employeeId, b.employeeName, a.visitorName, a.incomingDateTime, b.id ,a.status,e.employeeName, a.requestDate  "
                //                + "b.employeeId, b.employeeName ,a.visitorName,a.visitorOrganization, a.incomingDateTime, a.status "
                + " From VisitorManagement a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " left join a.employeeMasterBySecurityApproveId e"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition
                + "Order by a.id desc";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readVisitorManagementPendingRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += " From VisitorManagement a "
                + " where a.employeeMasterByEmployeeMasterId=" + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public int countVisitorManagementPendingRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        int i = 0;
        query += "select count(a.id) "
                + " From VisitorManagement a "
                + " where a.employeeMasterByEmployeeMasterId=" + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            long l = (long) list.get(0);
            i = (int) l;
        }
        return i;
    }

    @Override
    public List<?> readVisitorManagementApproverPendingRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        query += "Select a.id,b.employeeName"
                + " From VisitorManagement a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,5,6,10)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public int countVisitorManagementApproverPendingRequest(T object) {
        VisitorManagement visitorManagement = (VisitorManagement) object;
        String query = "";
        int i = 0;
        query += "Select count(a.id)"
                + " From VisitorManagement a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + visitorManagement.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,5,6,10)";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            long l = (long) list.get(0);
            i = (int) l;
        }
        return i;
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        String query = "";
        query += " select a.employeeMasterByEmployeeMasterId"
                + " From VisitorManagement a"
                + " where a.id = " + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchEmpRequestForSessionEmployee(Integer empId, String startDate, String endDate, String status) {
        String query = "";
        String condition = "";

        if (null != empId && !empId.equals("")) {
            condition += " AND  b.id = " + empId;
        }
        if (null != status && !status.equals("")) {
            condition += " AND  v.status = " + Integer.parseInt(status);
        }
        if ((!"".equals(startDate) && null != startDate) && (!"".equals(endDate) && null != endDate)) {
            condition += " AND STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + startDate + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + endDate + " 00:00','%d/%m/%Y %H:%i') ";
        }

        query += " Select v.id, b.employeeId, v.visitorName, "
                + " c.employeeName, g.departmentName, h.zydexLocation, v.visitorComingFrom, v.requestDate, "
                + " CASE WHEN v.incomingDateTime is null or v.incomingDateTime = '' THEN '-' ELSE v.incomingDateTime END, "
                + " CASE WHEN v.meetingOffDate is null or v.meetingOffDate = '' THEN '-' ELSE v.meetingOffDate END, "
                + " CASE WHEN v.outgoingDateTime is null or v.outgoingDateTime = '' THEN '-' ELSE v.outgoingDateTime END, "
                + " CONCAT(ABS(MOD(TIMESTAMPDIFF(DAY,STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'D: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(HOUR,STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'H: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(MINUTE,STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')), 60)),'M'), v.status, "
                //                + " (hour(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')))-(hour(STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'))), v.status, e.employeeId, "
                + " CONCAT(ABS(MOD(TIMESTAMPDIFF(DAY,STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'D: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(HOUR,STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'H: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(MINUTE,STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')), 60)),'M'), v.visitorOrganization "
                //                + " (hour(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')))-(hour(STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'))) "
                + " From VisitorManagement v "
                + " left join v.employeeMasterByEmployeeMasterId b "
                + " left join v.visitorVisitsToEmployeeId c "
                + " left join c.departmentMaster g"
                + " left join v.zydexLocationMaster h "
                + " Where 1 = 1 " + condition
                + " Order by v.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByapproverId(String employeeId, String designationId, String departmentId, String startDate, String endDate, String status) {
        String query = "";
        String condition = "";

        if (null != employeeId && !employeeId.equals("")) {
            condition += " AND  b.id = " + Integer.parseInt(employeeId);
        }
        if (null != departmentId && !departmentId.equals("")) {
            condition += " AND  i.id = " + Integer.parseInt(departmentId);
        }
        if (null != designationId && !designationId.equals("")) {
            condition += " AND f.id = " + Integer.parseInt(designationId);
        }
        if (null != status && !status.equals("")) {
            condition += " AND  v.status = " + Integer.parseInt(status);
        }
        if ((!"".equals(startDate) && null != startDate) && (!"".equals(endDate) && null != endDate)) {
            condition += " AND STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + startDate + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + endDate + " 00:00','%d/%m/%Y %H:%i') ";
        }

        query += " Select v.id, concat(b.employeeName ,'(',i.departmentName,')'), v.visitorName, "
                + " c.employeeName, g.departmentName, f.designationName, h.zydexLocation,  v.visitorComingFrom, v.requestDate, "
                + " CASE WHEN v.incomingDateTime is null or v.incomingDateTime = '' THEN '-' ELSE v.incomingDateTime END, "
                + " CASE WHEN v.outgoingDateTime is null or v.outgoingDateTime = '' THEN '-' ELSE v.outgoingDateTime END, "
                + " (hour(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')))-(hour(STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'))), v.status, e.employeeId, "
                + " CASE WHEN v.meetingOffDate is null or v.meetingOffDate = '' THEN '-' ELSE v.meetingOffDate END, "
                + " (hour(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')))-(hour(STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'))*60 + minute(STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'))), b.id, "
                + " v.reason, v.visitorOrganization, v.visitorContactDetail, v.accesories, "
                + " CONCAT(ABS(MOD(TIMESTAMPDIFF(DAY,STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'D: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(HOUR,STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'H: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(MINUTE,STR_TO_DATE(v.incomingDateTime,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')), 60)),'M'), "
                + " CONCAT(ABS(MOD(TIMESTAMPDIFF(DAY,STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'D: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(HOUR,STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')),24)),'H: ', "
                + "  ABS(MOD(TIMESTAMPDIFF(MINUTE,STR_TO_DATE(v.meetingOffDate,'%d/%m/%Y %H:%i'),STR_TO_DATE(v.outgoingDateTime,'%d/%m/%Y %H:%i')), 60)),'M') "
                + " From VisitorManagement v "
                + " left join v.employeeMasterByEmployeeMasterId b "
                + " left join v.employeeMasterBySecurityApproveId e "
                + " left join v.visitorVisitsToEmployeeId c "
                + " left join c.departmentMaster g"
                + " left join b.departmentMaster i"
                + " left join b.designationMaster f"
                + " left join v.zydexLocationMaster h "
                + " Where 1 = 1 " + condition
                + " Order by v.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> getDetailsByContactNo(String contactNo) {
         String sqlQuery = "SELECT v FROM VisitorManagement v where v.visitorContactDetail = '" + contactNo.trim() + "' order by id desc limit 1";
        return getHibernateTemplate().find(sqlQuery);
    }
}
