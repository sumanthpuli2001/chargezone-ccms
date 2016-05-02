/*
 * 
 * Author Vinita
 */

package com.bul.zydex.dao.emprequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ItServiceRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class ItServiceRequestDAOImpl<T> extends GenericsDAOImpl<T> implements ItServiceRequestDAO<T>{

    @Override
    protected Class getDomainClass() {
        return ItServiceRequest.class;
    }

     public boolean isExist(T object) {
           ItServiceRequest itServiceRequest = (ItServiceRequest) object;
          String query = "";
          query += ""
                + " From ItServiceRequest a "
                + " where a.employeeMasterByEmployeeMasterId = " +  itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.itRequestType = " + itServiceRequest.getItRequestType().getId()
                + " and a.status = " + itServiceRequest.getStatus();
                  
//                + " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') = STR_TO_DATE('" +hrServiceRequest.getRequestDate() +  " 00:00','%d/%m/%Y %H:%i')";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
     }
    
    @Override
     public List<?> readByEmpId(T object) {
         ItServiceRequest itServiceRequest = (ItServiceRequest) object;
          String query = "";
        query += " SELECT a.id, a.itRequestType ,a.status "
                + " From ItServiceRequest a "
                + " where a.employeeMasterByEmployeeMasterId = " + itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
//                + " And a.status in (1,2,4,9) "
                + " Order by a.status desc limit 5 ";
        return getHibernateTemplate().find(query);
     }
     
    @Override
      public List<?> readByrequesteeId(T object) {
         ItServiceRequest itServiceRequest = (ItServiceRequest) object;
        String query = "";
        String condition = "";
            
           if (null != itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " +itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
//            if (null != itServiceRequest.getRejectRemark()) {
//            condition += " AND  a.status = " + itServiceRequest.getRejectRemark();
//        }
        if (!"".equals(itServiceRequest.getRequestDate()) && null != itServiceRequest.getRequestDate()
                && !"".equals(itServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) && null != itServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + itServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + itServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()+  " 00:00','%d/%m/%Y %H:%i') ";
        }
         if (!"".equals(itServiceRequest.getProblemDetail()) && null != itServiceRequest.getProblemDetail()) {
            condition += " AND c.id = " + itServiceRequest.getProblemDetail();
        }
        if (!"".equals(itServiceRequest.getItApproverDate()) && null != itServiceRequest.getItApproverDate()) {
            condition += " AND d.id = " + itServiceRequest.getItApproverDate();
        }
        
        query += " SELECT a.id, b.employeeId, b.employeeName,a.itRequestType , b.id ,a.status ,a.requestDate,a.itApproverDate "
                + " From ItServiceRequest a "
                + " left join a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
//                + " where a.status in (1,5,6,10) ";
                + " Where 1=1" + condition;
//                + " and a.employeeMasterByEmployeeMasterId = " + poolCarRequest.getEmployeeMasterByApproverId().getId() ;
        
         return getHibernateTemplate().find(query);
}
      
    @Override
    public List<?> readSearchEmpRequest(T object) {
         ItServiceRequest itServiceRequest = (ItServiceRequest) object;
          String query ="";
          String condition = "";
          
           if (null != itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " +itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
            if (null != itServiceRequest.getRejectRemark()) {
            condition += " AND  a.status = " + itServiceRequest.getRejectRemark();
        }
        if (!"".equals(itServiceRequest.getRequestDate()) && null != itServiceRequest.getRequestDate()
                && !"".equals(itServiceRequest.getItApproverDate()) && null != itServiceRequest.getItApproverDate()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + itServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + itServiceRequest.getItApproverDate() +  " 00:00','%d/%m/%Y %H:%i') ";
        }
          query += " Select a.id, a.itRequestType ,a.status "
                + " From ItServiceRequest a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " Where 1=1 " + condition;
            return getHibernateTemplate().find(query);
       }
      
    @Override
     public List<?> readSearchRequest(T object) {
             ItServiceRequest itServiceRequest = (ItServiceRequest) object;
             String query ="";
             String condition = "";
            
           if (null != itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " +itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        }
            if (null != itServiceRequest.getRejectRemark()) {
            condition += " AND  a.status = " + itServiceRequest.getRejectRemark();
        }
        if (!"".equals(itServiceRequest.getRequestDate()) && null != itServiceRequest.getRequestDate()
                && !"".equals(itServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) && null != itServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.requestDate,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + itServiceRequest.getRequestDate() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + itServiceRequest.getEmployeeMasterByEmployeeMasterId().getAdharCard()+  " 00:00','%d/%m/%Y %H:%i') ";
        }
         if (!"".equals(itServiceRequest.getProblemDetail()) && null != itServiceRequest.getProblemDetail()) {
            condition += " AND c.id = " + itServiceRequest.getProblemDetail();
        }
        if (!"".equals(itServiceRequest.getItApproverDate()) && null != itServiceRequest.getItApproverDate()) {
            condition += " AND d.id = " + itServiceRequest.getItApproverDate();
        }
        
          query += " Select  b.employeeId, b.employeeName,a.itRequestType ,a.status "
                + " From ItServiceRequest a"
                 + " LEFT JOIN a.employeeMasterByEmployeeMasterId b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;
            return getHibernateTemplate().find(query);
       }
        @Override
     public List<?> readByItServicePendingRequest(T object) {
         ItServiceRequest itServiceRequest = (ItServiceRequest) object;
          String query = "";
        query +=  " SELECT a.id, a.itRequestType ,a.status "
                + " From ItServiceRequest a "
                + " LEFT JOIN a.itRequestType b "
                + " where a.employeeMasterByEmployeeMasterId = " + itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status in (1,4,5,6,9,10)";
        return getHibernateTemplate().find(query);
     }
        @Override
     public List<?> readByItServiceApproverPendingRequest(T object){
         ItServiceRequest itServiceRequest = (ItServiceRequest) object;
          String query = "";
        query += " SELECT a.id,b.employeeName"
                + " From ItServiceRequest a,"
                + " EmployeeMaster b"
                + " where a.employeeMasterByEmployeeMasterId = b.id" 
                + " and b.reportingManagerLevel1="+ itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId()
                   + " and a.status in (1,5,6,10)";
        return getHibernateTemplate().find(query);
     }
    }
   
