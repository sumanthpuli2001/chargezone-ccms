/*
 * 
 * Author Vinita
 */
package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.HrServiceRequest;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class HrServiceRequestDAOImpl<T> extends GenericsDAOImpl<T> implements HrServiceRequestDAO<T> {

    @Override
    protected Class getDomainClass() {
        return HrServiceRequest.class;
    }

    @Override
    public boolean isExist(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        query += ""
                + " From HrServiceRequest a "
                + " where a.employeeMasterByEmployeeMasterId = " + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.queryType = " + hrServiceRequest.getQueryType().getId()
                + " and a.status = " + hrServiceRequest.getStatus();

//                + " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') = STR_TO_DATE('" +hrServiceRequest.getRequestDate() +  " 00:00','%d/%m/%Y %H:%i')";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<?> readByEmpId(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        String condition = "";

        if (null != hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (!"".equals(hrServiceRequest.getRequestDate()) && null != hrServiceRequest.getRequestDate()
                && !"".equals(hrServiceRequest.getHrApproveDate()) && null != hrServiceRequest.getHrApproveDate()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + hrServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + hrServiceRequest.getHrApproveDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " SELECT a.id, a.queryType ,b.id,a.details "
                + " From HrServiceRequest a "
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                //                + " where a.employeeMasterByEmployeeMasterId = " +  hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " Where 1=1 "
                + condition
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        String condition = "";

        if (null != hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (!"".equals(hrServiceRequest.getRequestDate()) && null != hrServiceRequest.getRequestDate()
                && !"".equals(hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) && null != hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + hrServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(hrServiceRequest.getDetails()) && null != hrServiceRequest.getDetails()) {
            condition += " AND c.id = " + hrServiceRequest.getDetails();
        }
        if (!"".equals(hrServiceRequest.getHrApproveDate()) && null != hrServiceRequest.getHrApproveDate()) {
            condition += " AND d.id = " + hrServiceRequest.getHrApproveDate();
        }
//        Select  b.employeeId, b.employeeName,a.queryType,a.status
        query += " SELECT a.id, b.employeeId, b.employeeName,  a.queryType , b.id ,a.status,a.requestDate,a.hrApproveDate "
                + " From HrServiceRequest a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition
                + "Order by a.id Desc";
//                + " where a.status in (1,5,6,10) ";
//                + " and a.employeeMasterByEmployeeMasterId = " + poolCarRequest.getEmployeeMasterByApproverId().getId() ;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        String condition = "";

        if (null != hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != hrServiceRequest.getRejectRemark()) {
            condition += " AND  a.status = " + hrServiceRequest.getRejectRemark();
        }
        if (!"".equals(hrServiceRequest.getRequestDate()) && null != hrServiceRequest.getRequestDate()
                && !"".equals(hrServiceRequest.getHrApproveDate()) && null != hrServiceRequest.getHrApproveDate()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + hrServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + hrServiceRequest.getHrApproveDate() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        query += " Select a.queryType,a.status "
                + " From HrServiceRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " Where 1=1 " + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        String condition = "";

        if (null != hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (null != hrServiceRequest.getRejectRemark()) {
            condition += " AND  a.status = " + hrServiceRequest.getRejectRemark();
        }
        if (!"".equals(hrServiceRequest.getRequestDate()) && null != hrServiceRequest.getRequestDate()
                && !"".equals(hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) && null != hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + hrServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard() + " 00:00','%d/%m/%Y %H:%i') ";
        }
        if (!"".equals(hrServiceRequest.getDetails()) && null != hrServiceRequest.getDetails()) {
            condition += " AND c.id = " + hrServiceRequest.getDetails();
        }
        if (!"".equals(hrServiceRequest.getHrApproveDate()) && null != hrServiceRequest.getHrApproveDate()) {
            condition += " AND d.id = " + hrServiceRequest.getHrApproveDate();
        }

        query += " Select  b.employeeId, b.employeeName,a.queryType,a.status "
                + " From HrServiceRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readHrServicePendingRequest(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        query += " SELECT a.id, a.queryType ,a.status"
                + " From HrServiceRequest a"
                + " LEFT JOIN a.queryType b"
                + " where a.employeeMasterByEmployeeMasterId=" + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public int countHrServicePendingRequest(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        int i = 0;
        query += " SELECT count(a.id)"
                + " From HrServiceRequest a"
                + " LEFT JOIN a.queryType b"
                + " where a.employeeMasterByEmployeeMasterId=" + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            long l = (long) list.get(0);
            i = (int) l;
        }
        return i;
    }

    @Override
    public List<?> readHrServiceApproverPendingRequest(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        query += " SELECT a.id,b.employeeName"
                + " From HrServiceRequest a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,5,6,10)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public int countHrServiceApproverPendingRequest(T object) {
        HrServiceRequest hrServiceRequest = (HrServiceRequest) object;
        String query = "";
        int i = 0;
        query += " SELECT count(a.id)"
                + " From HrServiceRequest a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId=b.id"
                + " and b.reportingManagerLevel1=" + hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,5,6,10)";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            long l = (long) list.get(0);
            i = (int) l;
        }
        return i;
    }
}
