/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.travel;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PolicyDeviationForAir;
import com.bul.zydex.model.TravelRequestMaster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author AJAY
 */
public class TravelRequestMasterDAOImpl<T> extends GenericsDAOImpl<T> implements TravelRequestMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TravelRequestMaster.class;
    }

    @Override
    public List<?> readTotalRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";

        query += ""
                + " FROM TravelRequestMaster a"
                + " Where a.employeeMasterByEmployeeMasterId=" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
//                + " and a.status=5"; 

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> requestDetail(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "";
        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y-%H:%i') BETWEEN STR_TO_DATE('" + travelRequestMaster.getStartDateTime() + "','%d/%m/%Y-%H:%i') AND STR_TO_DATE('"
                    + travelRequestMaster.getEndDateTime() + "','%d/%m/%Y-%H:%i')";
//            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }

        query += " Select a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.status, a.id,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.employeeName ELSE c.employeeName END as approver ,b.employeeId ,b.employeeName"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id c"
                + " LEFT JOIN a.employeeMasterByApprover2Id d"
                + " Where b.id=" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + " AND a.status !=7" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readFromManager(int reportingId1) {
//        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " Select b.employeeId, b.employeeName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.id, c.id, a.status, a.dateOfSubmit, d.id, e.id"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.userMaster c"
                + " LEFT JOIN a.employeeMasterByApprover1Id d "
                + " LEFT JOIN a.employeeMasterByApprover2Id e "
                + " Where d.id=" + reportingId1
                + " or e.id=" + reportingId1
                + " AND a.status IN(0,4)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readFromAdmin(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "";

        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId()) {
            if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()) {
                condition += " AND  b.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            }
        }
        if (!"".equals(travelRequestMaster.getCashRequired()) && null != travelRequestMaster.getCashRequired()) {
            condition += " AND x.id = " + travelRequestMaster.getCashRequired();
        }
        if (!"".equals(travelRequestMaster.getDateOfSubmit()) && null != travelRequestMaster.getDateOfSubmit()) {
            condition += " AND z.id = " + travelRequestMaster.getDateOfSubmit();
        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }

        query += " Select b.employeeId, b.employeeName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.id, b.id, a.status, "
                + " case when (a.status=5 and a.travelType ='International')"
                + " then e.employeeName ELSE d.employeeName END as approver, a.dateOfSubmit"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id d"
                + " LEFT JOIN a.employeeMasterByApprover2Id e"
                + " LEFT JOIN b.departmentMaster x "
                + " LEFT JOIN b.designationMaster z "
                + " LEFT JOIN b.userMaster c"
                + " where 1=1 " + condition
                + " Order By a.id desc";
//                + " Where a.status IN(3,6)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readFromApprover1(int reportingId1) {
//        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " Select b.employeeId, b.employeeName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.id, c.id, a.status, a.dateOfSubmit, d.id, e.id"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.userMaster c"
                + " LEFT JOIN a.employeeMasterByApprover1Id d "
                + " LEFT JOIN a.employeeMasterByApprover2Id e "
                + " Where b.reportingManagerLevel1=" + reportingId1
                + " AND a.status IN(0,4)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readFromApprover2(int reportingId1) {
//        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";

        query += " Select b.employeeId, b.employeeName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.id, c.id, a.status, a.dateOfSubmit, d.id, e.id"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.userMaster c"
                + " LEFT JOIN a.employeeMasterByApprover1Id d "
                + " LEFT JOIN a.employeeMasterByApprover2Id e "
                + " Where b.reportingManagerLevel2=" + reportingId1
                + " AND a.status IN(0,4)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readOwnRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "";
        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }
        query += " Select b.employeeId, b.employeeName, c.departmentName, d.designationName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.status, a.id "
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where a.employeeMasterByEmployeeMasterId=" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + " AND a.status !=7" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readAllTravelRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "";

        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (!"".equals(travelRequestMaster.getCashRequired()) && null != travelRequestMaster.getCashRequired()) {
            condition += " AND c.id = " + travelRequestMaster.getCashRequired();
        }
        if (!"".equals(travelRequestMaster.getDateOfSubmit()) && null != travelRequestMaster.getDateOfSubmit()) {
            condition += " AND d.id = " + travelRequestMaster.getDateOfSubmit();
        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }
        query += " Select b.employeeId, b.employeeName, c.departmentName, d.designationName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.status, a.id "
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPendingTravelRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        query += " Select a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.status, a.id "
                + " FROM TravelRequestMaster a"
                + " Where a.employeeMasterByEmployeeMasterId =" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status=0";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readApproverPendingTravelRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        query += " Select a.id,b.employeeName"
                + " FROM TravelRequestMaster a,"
                + " EmployeeMaster b"
                + " Where a.employeeMasterByEmployeeMasterId =b.id"
                + " and b.reportingManagerLevel1=" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status=0";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readApprover2PendingTravelRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        query += " Select a.id,b.employeeName"
                + " FROM TravelRequestMaster a,"
                + " EmployeeMaster b"
                + " Where a.employeeMasterByEmployeeMasterId =b.id"
                + " and b.reportingManagerLevel2=" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + " and a.status=0";

        return getHibernateTemplate().find(query);
    }

    /**
     *
     * @param reportingManagerLevel1_id
     * @return
     * @throws ParseException
     */
    @Override
    public List<?> readTravelRequestByReportingLevel1(T object, String reportingManagerLevel1_id) throws ParseException {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();
        String hqlQuery = "";
        String condition = "";

        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
//        if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()) {
//            condition += " AND  b.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
//        }
        if (!"".equals(travelRequestMaster.getCashRequired()) && null != travelRequestMaster.getCashRequired()) {
            condition += " AND c.id = " + travelRequestMaster.getCashRequired();
        }
        if (!"".equals(travelRequestMaster.getDateOfSubmit()) && null != travelRequestMaster.getDateOfSubmit()) {
            condition += " AND d.id = " + travelRequestMaster.getDateOfSubmit();
        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }

        hqlQuery = "Select a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,b.id"
                + "  FROM TravelRequestMaster a"
                + " Left Join a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "//                + " where str_to_date(DATE_FORMAT(CURDATE(),'%d/%m/%Y'),'%d/%m/%Y') <= str_to_date(DATE_FORMAT(date_add(str_to_date(a.dateOfSubmit,'%d/%m/%Y'), INTERVAL  15 DAY),'%d/%m/%Y'),'%d/%m/%Y')"
                + " where a.status IN(0,4)"
                + " and b.reportingManagerLevel1='" + reportingManagerLevel1_id + "'" + condition;
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[8];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 15);
            Date output = c.getTime();
            if (output.equals(today) || today.before(output)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readTravelRequestByReportingLevel2(String reportingManagerLevel2_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();

        String hqlQuery = "Select a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,b.id"
                + "  FROM TravelRequestMaster a"
                + " Left Join a.employeeMasterByEmployeeMasterId b" //                + " where str_to_date(DATE_FORMAT(CURDATE(),'%d/%m/%Y'),'%d/%m/%Y') <= str_to_date(DATE_FORMAT(date_add(str_to_date(a.dateOfSubmit,'%d/%m/%Y'), INTERVAL  15 DAY),'%d/%m/%Y'),'%d/%m/%Y')"
                + " where a.status IN(0,4)"
                + " and b.reportingManagerLevel2='" + reportingManagerLevel2_id + "'";
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[8];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 30);
            Date output = c.getTime();
            c.setTime(date);
            c.add(Calendar.DATE, 15);
            Date pastDate = c.getTime();
            if ((today.equals(output) || today.before(output)) && output.after(pastDate)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readTravelRequestByReportingLevel3(String reportingManagerLevel3_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();

        String hqlQuery = "Select a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,b.id"
                + "  FROM TravelRequestMaster a"
                + " Left Join a.employeeMasterByEmployeeMasterId b" //                + " where str_to_date(DATE_FORMAT(CURDATE(),'%d/%m/%Y'),'%d/%m/%Y') <= str_to_date(DATE_FORMAT(date_add(str_to_date(a.dateOfSubmit,'%d/%m/%Y'), INTERVAL  15 DAY),'%d/%m/%Y'),'%d/%m/%Y')"
                + " where a.status IN(0,4)"
                + " and b.reportingManagerLevel3='" + reportingManagerLevel3_id + "'";
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[8];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 45);
            Date output = c.getTime();
            c.setTime(date);
            c.add(Calendar.DATE, 30);
            Date pastDate = c.getTime();
            if ((today.equals(output) || today.before(output)) && output.after(pastDate)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readTravelRequestByReportingLevel4(String reportingManagerLevel4_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();

        String hqlQuery = "Select a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,b.id"
                + "  FROM TravelRequestMaster a"
                + " Left Join a.employeeMasterByEmployeeMasterId b" //                + " where str_to_date(DATE_FORMAT(CURDATE(),'%d/%m/%Y'),'%d/%m/%Y') <= str_to_date(DATE_FORMAT(date_add(str_to_date(a.dateOfSubmit,'%d/%m/%Y'), INTERVAL  15 DAY),'%d/%m/%Y'),'%d/%m/%Y')"
                + " where a.status IN(0,4)"
                + " and b.reportingManagerLevel4='" + reportingManagerLevel4_id + "'";
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[8];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 60);
            Date output = c.getTime();
            c.setTime(date);
            c.add(Calendar.DATE, 45);
            Date pastDate = c.getTime();
            if ((today.equals(output) || today.before(output)) && output.after(pastDate)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readAllTravelRequestAdmin(T object, String maangerId) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "";

        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()) {
            condition += " AND  b.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
        }
        if (!"".equals(travelRequestMaster.getCashRequired()) && null != travelRequestMaster.getCashRequired()) {
            condition += " AND c.id = " + travelRequestMaster.getCashRequired();
        }
        if (!"".equals(travelRequestMaster.getDateOfSubmit()) && null != travelRequestMaster.getDateOfSubmit()) {
            condition += " AND d.id = " + travelRequestMaster.getDateOfSubmit();
        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }
        query += " Select b.employeeId, b.employeeName, c.departmentName, d.designationName, a.travelType, a.travelRequestNo, a.startDateTime, a.endDateTime, a.status, a.id "
                + " ,case when (a.status=5 and a.travelType ='International')"
                + " then z.employeeName ELSE x.employeeName END as approver "
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id x"
                + " LEFT JOIN a.employeeMasterByApprover2Id z"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where b.reportingManagerLevel1='" + maangerId + "' and 1=1" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTravelEmployeePastRequest(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        query += " "
                + " FROM TravelRequestMaster a "
                + "where a.employeeMasterByEmployeeMasterId=" + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readlastapprove(int TabId, String loginId) {
        String query = "";
        query += " Select c.id ,a.id,c.employeeId, c.employeeName, a.travelType,a.travelRequestNo,"
                + " a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit ,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then e.id ELSE d.id END as approverId ,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then e.employeeName ELSE d.employeeName END as approver, "
                + " b.id ,b.returnFlag"
                + " FROM TravelRequestMaster a "
                + " LEFT JOIN a.travelApproverHistories b"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId c"
                + " LEFT JOIN a.employeeMasterByApprover1Id d"
                + " LEFT JOIN a.employeeMasterByApprover2Id e"
                + " where b.travelRequestMaster = " + TabId
                + " and b.employeeMasterByTravelApproverId = " + loginId
                + " Order by b.travelApproveHistoryDate desc"
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForCEO(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";

        query += " Select b.employeeId, b.employeeName, a.travelType, a.travelRequestNo,"
                + " a.startDateTime, a.endDateTime, a.id, b.id, a.status,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then e.employeeName ELSE d.employeeName END as approver,a.dateOfSubmit"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id d"
                + " LEFT JOIN a.employeeMasterByApprover2Id e"
                + " LEFT JOIN b.userMaster c"
                + " Where a.travelType like '%International%'"
                + " and a.status IN(6,5)"
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForRequestResult1(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "Where 1=1";

        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId()) {
            if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()) {
                condition += " AND  b.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            }
        }
//        if (!"".equals(travelRequestMaster.getCashRequired()) && null != travelRequestMaster.getCashRequired()) {
//            condition += " AND c.id = " + travelRequestMaster.getCashRequired();
//        }
//        if (!"".equals(travelRequestMaster.getDateOfSubmit()) && null != travelRequestMaster.getDateOfSubmit()) {
//            condition += " AND d.id = " + travelRequestMaster.getDateOfSubmit();
//        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }

        query += " Select b.id,a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,"
                + " a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.id ELSE c.id END as approverId ,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.employeeName ELSE c.employeeName END as approver "
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id c"
                + " LEFT JOIN a.employeeMasterByApprover2Id d " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readExpensePendingList(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";

        query += " Select a.id,b.employeeId, b.employeeName, a.travelRequestNo, a.travelType, a.startDateTime, a.endDateTime,b.id"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " where a.status=5"
                + " order by a.id desc ";

        return getHibernateTemplate().find(query);
    }

    public List<?> searchTravelApproveOfEmployeeByCurrentMonthWise(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "select"
                + "    case"
                + "                when"
                + "            (select"
                + "                    sm.weekof"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    'WO' as sunday"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1)"
                + "        when"
                + "            (select"
                + "                    d.title"
                + "                from"
                + "                    holiday_master d,"
                + "                    employee_master emp"
                + "                where"
                + "                    emp.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and emp.company_location = d.location_id and DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                            '%d/%m/%Y') between DATE_FORMAT(STR_TO_DATE(d.holiday_from_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y') and DATE_FORMAT(STR_TO_DATE(d.holiday_to_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    concat(d.title)"
                + "                from"
                + "                    holiday_master d,"
                + "                    employee_master emp"
                + "                where"
                + "                    emp.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and emp.company_location = d.location_id and DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                            '%d/%m/%Y') between DATE_FORMAT(STR_TO_DATE(d.holiday_from_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y') and DATE_FORMAT(STR_TO_DATE(d.holiday_to_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y')"
                + "                limit 1)"
                + " when"
                + " (SELECT"
                + "                    CONCAT('1') AS travelDay"
                + "                FROM"
                + "                    travel_approver_history t,"
                + "                    travel_request_master tr"
                + "                WHERE"
                + "                        tr.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + "                        AND t.travel_request_master_id = tr.id"
                + "                        AND t.travel_approve_status = 5"
                + "                        and tr.status=5"
                + "                        AND DATE_FORMAT(STR_TO_DATE(t.travel_approve_history_date, '%d/%m/%Y %H:%i'),"
                + "                            '%m') = DATE_FORMAT(STR_TO_DATE('" + travelRequestMaster.getStartDateTime() + "', '%Y-%m-%d'),"
                + "                            '%m')"
                + "                        AND STR_TO_DATE(selected_date, '%Y-%m-%d') BETWEEN STR_TO_DATE(tr.start_date_time, '%d/%m/%Y') AND STR_TO_DATE(tr.end_date_time, '%d/%m/%Y')limit 1) is not null"
                + " then"
                + " (SELECT"
                + "                    CONCAT('1') AS travelDay"
                + "                FROM"
                + "                    travel_approver_history t,"
                + "                    travel_request_master tr"
                + "                WHERE"
                + "                  tr.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + "                        AND t.travel_request_master_id = tr.id"
                + "                        AND t.travel_approve_status = 5"
                + "                        and tr.status=5"
                + "                        AND DATE_FORMAT(STR_TO_DATE(t.travel_approve_history_date, '%d/%m/%Y %H:%i'),"
                + "                            '%m') = DATE_FORMAT(STR_TO_DATE('" + travelRequestMaster.getStartDateTime() + "', '%Y-%m-%d'),"
                + "                            '%m')"
                + "                        AND STR_TO_DATE(selected_date, '%Y-%m-%d') BETWEEN STR_TO_DATE(tr.start_date_time, '%d/%m/%Y') AND STR_TO_DATE(tr.end_date_time, '%d/%m/%Y')limit 1)"
                + " else 'AB'"
                + "    end"
                + " from"
                + "    (select"
                + "        adddate('1970-01-01', t4 * 10000 + t3 * 1000 + t2 * 100 + t1 * 10 + t0) selected_date"
                + "    from"
                + "        (select 0 t0 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0, (select 0 t1 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1, (select 0 t2 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2, (select 0 t3 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3, (select 0 t4 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v"
                + " where selected_date between '" + travelRequestMaster.getStartDateTime() + "' and '" + travelRequestMaster.getEndDateTime() + "'";

        Query query1 = getSession().createSQLQuery(query);
        List results = query1.list();
        return query1.list();
    }

    public List<?> searchTravelApproveOfEmployeeByPreviousMonthWise(T object) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "select"
                + "    case"
                + "                when"
                + "            (select"
                + "                    sm.weekof"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    'WO' as sunday"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1)"
                + "        when"
                + "            (select"
                + "                    d.title"
                + "                from"
                + "                    holiday_master d,"
                + "                    employee_master emp"
                + "                where"
                + "                    emp.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and emp.company_location = d.location_id and DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                            '%d/%m/%Y') between DATE_FORMAT(STR_TO_DATE(d.holiday_from_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y') and DATE_FORMAT(STR_TO_DATE(d.holiday_to_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    concat(d.title)"
                + "                from"
                + "                    holiday_master d,"
                + "                    employee_master emp"
                + "                where"
                + "                    emp.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId() + " and emp.company_location = d.location_id and DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                            '%d/%m/%Y') between DATE_FORMAT(STR_TO_DATE(d.holiday_from_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y') and DATE_FORMAT(STR_TO_DATE(d.holiday_to_date, '%d/%m/%Y'),"
                + "                            '%d/%m/%Y')"
                + "                limit 1)"
                + " when"
                + " (SELECT"
                + "                    CONCAT('1') AS travelDay"
                + "                FROM"
                + "                    travel_approver_history t,"
                + "                    travel_request_master tr"
                + "                WHERE"
                + "                        tr.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + "                        AND t.travel_request_master_id = tr.id"
                + "                        AND t.travel_approve_status = 5"
                + "                        and tr.status=5"
                + "                        AND DATE_FORMAT(STR_TO_DATE(t.travel_approve_history_date, '%d/%m/%Y %H:%i'),"
                + "                            '%m') = DATE_FORMAT(STR_TO_DATE('" + travelRequestMaster.getStartDateTime() + "', '%Y-%m-%d'),"
                + "                            '%m')"
                + "                        AND STR_TO_DATE(selected_date, '%Y-%m-%d') BETWEEN STR_TO_DATE(tr.start_date_time, '%d/%m/%Y') AND STR_TO_DATE(tr.end_date_time, '%d/%m/%Y')limit 1) is not null"
                + " then"
                + " (SELECT"
                + "                    CONCAT('1') AS travelDay"
                + "                FROM"
                + "                    travel_approver_history t,"
                + "                    travel_request_master tr"
                + "                WHERE"
                + "                  tr.employee_master_id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()
                + "                        AND t.travel_request_master_id = tr.id"
                + "                        AND t.travel_approve_status = 5"
                + "                        and tr.status=5"
                + "                        AND DATE_FORMAT(STR_TO_DATE(t.travel_approve_history_date, '%d/%m/%Y %H:%i'),"
                + "                            '%m') = DATE_FORMAT(STR_TO_DATE('" + travelRequestMaster.getStartDateTime() + "', '%Y-%m-%d'),"
                + "                            '%m')"
                + "                        AND STR_TO_DATE(selected_date, '%Y-%m-%d') BETWEEN STR_TO_DATE(tr.start_date_time, '%d/%m/%Y') AND STR_TO_DATE(tr.end_date_time, '%d/%m/%Y')limit 1)"
                + " else 'AB'"
                + "    end"
                + " from"
                + "    (select"
                + "        adddate('1970-01-01', t4 * 10000 + t3 * 1000 + t2 * 100 + t1 * 10 + t0) selected_date"
                + "    from"
                + "        (select 0 t0 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0, (select 0 t1 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1, (select 0 t2 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2, (select 0 t3 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3, (select 0 t4 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v"
                + " where selected_date between '" + travelRequestMaster.getAdminRemark() + "' and '" + travelRequestMaster.getEmpRemark() + "'";

        Query query1 = getSession().createSQLQuery(query);
        List results = query1.list();
        return query1.list();
    }

    @Override
    public List<?> readApprovedTravelRequest() {
        String query = "";

        query += " Select b.employeeId, b.employeeName, c.departmentName, d.designationName, a.travelType, a.travelRequestNo, a.id, b.id, a.cashAdvanceStatus"
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " Where a.status=5 and a.cashRequired='Yes'"
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTravelRequestForEscalation() {
        String query = "";

        query += " "
                + " FROM TravelRequestMaster a"
                + " Where a.status=0";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readForRequestResultForDashboard(T object) {
        String query = "";
        query += " Select b.id,a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,"
                + " a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.id ELSE c.id END as approverId ,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.employeeName ELSE c.employeeName END as approver "
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id c"
                + " LEFT JOIN a.employeeMasterByApprover2Id d "
                + " WHERE a.status!=5";

        return getHibernateTemplate().find(query);
    }

    public List<?> readListForApprover(T object, int id) {
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) object;
        String query = "";
        String condition = "Where 1=1";

        if (!"".equals(travelRequestMaster.getTravelType()) && null != travelRequestMaster.getTravelType()) {
            condition += " AND a.travelType = '" + travelRequestMaster.getTravelType() + "'";
        }
        if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId()) {
            if (null != travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId()) {
                condition += " AND  b.id = " + travelRequestMaster.getEmployeeMasterByEmployeeMasterId().getId();
            }
        }
//        if (!"".equals(travelRequestMaster.getCashRequired()) && null != travelRequestMaster.getCashRequired()) {
//            condition += " AND c.id = " + travelRequestMaster.getCashRequired();
//        }
//        if (!"".equals(travelRequestMaster.getDateOfSubmit()) && null != travelRequestMaster.getDateOfSubmit()) {
//            condition += " AND d.id = " + travelRequestMaster.getDateOfSubmit();
//        }
        if (!"".equals(travelRequestMaster.getStartDateTime()) && null != travelRequestMaster.getStartDateTime()
                && !"".equals(travelRequestMaster.getEndDateTime()) && null != travelRequestMaster.getEndDateTime()) {
            condition += " AND a.startDateTime BETWEEN '" + travelRequestMaster.getStartDateTime() + "' AND '" + travelRequestMaster.getEndDateTime() + "' ";
        }

        query += " Select b.id,a.id,b.employeeId, b.employeeName, a.travelType,a.travelRequestNo,"
                + " a.startDateTime,a.endDateTime,a.status, a.dateOfSubmit,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.id ELSE c.id END as approverId ,"
                + " case when (a.status=5 and a.travelType ='International')"
                + " then d.employeeName ELSE c.employeeName END as approver "
                + " FROM TravelRequestMaster a"
                + " LEFT JOIN a.employeeMasterByEmployeeMasterId b"
                + " LEFT JOIN a.employeeMasterByApprover1Id c"
                + " LEFT JOIN a.employeeMasterByApprover2Id d "
                + "  Where (b.reportingManagerLevel1='" + id + "'"
                + " or b.reportingManagerLevel2='" + id + "'"
                + " or b.reportingManagerLevel3='" + id + "'"
                + " or b.reportingManagerLevel4='" + id + "'"
                + " or b.reportingManagerLevel5='" + id + "')";

        return getHibernateTemplate().find(query);
    }

}
