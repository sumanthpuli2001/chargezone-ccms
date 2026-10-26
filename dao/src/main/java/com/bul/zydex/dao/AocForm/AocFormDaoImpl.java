/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocForm;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class AocFormDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocForm.class;
    }

    @Override
    public List readByUser(String username) {

        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.userId = '" + username + "'"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List approvedList(String username) {
        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.userId = '" + username + "'"
                + " And a.flagStatus IN (4)"
                + " And a.assignedName =''";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List assignedName(String username) {
        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.assignedName = '" + username + "'"
                + " And a.flagStatus=4"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public AocForm readByformid(int id1) {

        String query = "";
        AocForm aocForm = new AocForm();
        query += " FROM AocForm a"
                + " WHERE a.id = '" + id1 + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            aocForm = (AocForm) list.get(0);
        }
        return aocForm;
    }

    @Override
    public List approvalStatus1(String username) {
        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.flagStatus IN (7, 11, 12, 13)"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List projectmanger(String username) {

        String query = "SELECT a.id,a.documentNo,a.hubDepoName,a.userId,a.clientProjectName,a.createdDate,a.flagStatus, "
                + "(SELECT b.id FROM KickOffForm b WHERE a.id = b.aocForm.id), "
                + "(SELECT b.flagStatus FROM KickOffForm b WHERE a.id = b.aocForm.id) "
                + "FROM AocForm a "
                + "WHERE a.projectCoordinater = ? "
                + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                + "AND ( "
                + "NOT EXISTS ( "
                + "SELECT 1 FROM DeliverableMulti z "
                + "WHERE z.aocId = a.id "
                + ") "
                + "OR EXISTS ( "
                + "SELECT 1 FROM DeliverableMulti z "
                + "WHERE z.aocId = a.id "
                + "AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                + ") "
                + ") "
                + "ORDER BY a.id DESC";

        return getHibernateTemplate().find(query, username);

    }

    @Override
    public List readByIds(String aocid) {
        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.id = '" + aocid + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readsearch(String aocdocumentNumber, String open_from_date, String open_to_date, String username, String projectName) {

        String query = "SELECT b "
                + " FROM AocForm a, KickOffForm b "
                + " WHERE a.id=b.aocForm.id"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d/%m/%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d/%m/%Y'))";
        }

        if (!aocdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + aocdocumentNumber + "'";
        }
        if (!projectName.equals("")) {
            query += " AND a.clientProjectName='" + projectName + "'";
        }

// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.createdDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readsearch8(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName) {

        String query = "SELECT a"
                + " FROM AocForm a"
                + " WHERE 1=1"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d/%m/%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d/%m/%Y'))";
        }

        if (!aocdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + aocdocumentNumber + "'";
        }
        if (!projectName.equals("")) {
            query += " AND a.clientProjectName='" + projectName + "'";
        }

//        query += " AND a.id NOT IN (SELECT aocForm.id FROM KickOffForm) ";
// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.createdDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readaocReportList(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        String query = "SELECT b "
                + " FROM AocForm a, KickOffForm b "
                + " WHERE a.id=b.aocForm.id"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d/%m/%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d/%m/%Y'))";
        }

        if (!aocdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + aocdocumentNumber + "'";
        }

        if (!projectName.equals("")) {
            query += " AND a.clientProjectName='" + projectName + "'";
        }

// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.createdDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readaocReportList8(String aocdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        String query = "SELECT a"
                + " FROM AocForm a"
                + " WHERE 1=1"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d/%m/%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d/%m/%Y'))";
        }

        if (!aocdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + aocdocumentNumber + "'";
        }

        if (!projectName.equals("")) {
            query += " AND a.clientProjectName='" + projectName + "'";
        }

//        query += " AND a.id NOT IN (SELECT aocForm.id FROM KickOffForm) ";
// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.createdDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List flagStatus() {
        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.flagStatus IN (7, 11, 12, 13) "
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List rights(int executive) {

        String query = "";
        query += " SELECT a FROM AocForm a"
                + " WHERE a.flagStatus = 4"
                + " AND a.assignedName = ''"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByUserproject(String username) {
        String query = "";
        query += " FROM AocForm a,DeliverableMulti b,KickOffForm c"
                + " WHERE a.projectCoordinater = '" + username + "'"
                + " AND b.flagStatus=1"
                + " AND a.id=b.aocId"
                + " AND c.documentNo IS NOT NULL"
                + " AND a.id=c.aocForm"
                + " order by a.id desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByflagstatuszero(String username) {
        String query = "";
        query += " FROM AocForm a"
                + " WHERE a.userId = '" + username + "'"
                + " AND a.flagStatus IN (0)"
                + " order by a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readAocForms(String Fromdate, String Todate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        cal.add(Calendar.MONTH, -12);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT b.id,b.documentNo,b.hubDepoName,b.clientProjectName,b.userId,b.mobileNo,b.createdDate,b.flagStatus,b.approvedBy,b.approvedDate,"
                + "DATEDIFF(STR_TO_DATE(b.createdDate, '%d/%m/%Y'), STR_TO_DATE(b.approvedDate, '%d/%m/%Y')) AS aocApprovalDays,"
                + "b.kickOffAssignBy,b.kickOffAsignDate,b.assignedName,"
                + "DATEDIFF(STR_TO_DATE(b.approvedDate, '%d/%m/%Y'), STR_TO_DATE(b.kickOffAsignDate, '%d/%m/%Y')) AS kickOffAssignDays,"
                + "b.kickOffFormCreatedDate,"
                + "DATEDIFF(STR_TO_DATE(b.kickOffAsignDate, '%d/%m/%Y'), STR_TO_DATE(b.kickOffFormCreatedDate, '%d/%m/%Y')) AS aocApprovalDays,"
                + "b.kickOffFormApprovedBy,b.kickOffFormApprovedDate,"
                + "DATEDIFF(STR_TO_DATE(b.kickOffFormCreatedDate, '%d/%m/%Y'), STR_TO_DATE(b.kickOffFormApprovedDate, '%d/%m/%Y')) AS aocApprovalDays"
                + " FROM AocForm b "
                + "WHERE 1=1 ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
        } else {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d-%m-%Y')";
        }
        query += "AND b.id NOT IN (SELECT aocId FROM DeliverableMulti) ";
        query += " ORDER BY b.id DESC";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readDeliverbleForms(String Fromdate, String Todate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        cal.add(Calendar.MONTH, -12);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT b.id,b.documentNo,b.hubDepoName,b.clientProjectName,b.userId,b.mobileNo,b.createdDate,b.flagStatus,b.approvedBy,b.approvedDate,"
                + "DATEDIFF(STR_TO_DATE(b.createdDate, '%d/%m/%Y'), STR_TO_DATE(b.approvedDate, '%d/%m/%Y')) AS aocApprovalDays,"
                + "b.kickOffAssignBy,b.kickOffAsignDate,b.assignedName,"
                + "DATEDIFF(STR_TO_DATE(b.approvedDate, '%d/%m/%Y'), STR_TO_DATE(b.kickOffAsignDate, '%d/%m/%Y')) AS kickOffAssignDays,"
                + "b.kickOffFormCreatedDate,"
                + "DATEDIFF(STR_TO_DATE(b.kickOffAsignDate, '%d/%m/%Y'), STR_TO_DATE(b.kickOffFormCreatedDate, '%d/%m/%Y')) AS aocApprovalDays,"
                + "b.kickOffFormApprovedBy,b.kickOffFormApprovedDate,"
                + "DATEDIFF(STR_TO_DATE(b.kickOffFormCreatedDate, '%d/%m/%Y'), STR_TO_DATE(b.kickOffFormApprovedDate, '%d/%m/%Y')) AS aocApprovalDays,"
                + "c.createdBy,c.createdDate,c.designCoordinator,c.deliverableCreatedDate,c.deliverableApprovedBy,c.deliverableApprovedDate,"
                + "b.projectCoordinater,c.projectManagerApprovedDate"
                + " FROM AocForm b, DeliverableMulti c "
                + "WHERE b.id=c.aocId ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
        } else {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d-%m-%Y')";
        }
        query += " ORDER BY b.id DESC";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readaocExcelReportList(String aocdocumentNumber, String open_from_date, String open_to_date) {

        String query = "SELECT a.documentNo,a.hubDepoName,a.clientProjectName,a.zeroDate,a.completionDate,a.chargingRatePerUnit,a.noOfCharger,a.noOfChargePoints,a.overallStationCapacityKw,a.userId,a.designation,a.createdDate,a.flagStatus,b.flagStatus "
                + " FROM AocForm a, KickOffForm b "
                + " WHERE a.id=b.aocForm.id"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d/%m/%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d/%m/%Y'))";
        }

        if (!aocdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + aocdocumentNumber + "'";
        }

// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.createdDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readaocExcelReportList8(String aocdocumentNumber, String open_from_date, String open_to_date) {

        String query = "SELECT a "
                + " FROM AocForm a"
                + " WHERE 1=1"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d/%m/%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d/%m/%Y'))";
        }

        if (!aocdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + aocdocumentNumber + "'";
        }

//        query += " AND a.id NOT IN (SELECT aocForm.id FROM KickOffForm) ";
// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.createdDate desc";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public int countAllProjectAoc() {
        String query = "SELECT COUNT(*) "
                + "FROM AocForm a, DeliverableMulti b "
                + "WHERE a.id = b.aocId "
                + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List readByMonthAoc(String from_date) {

        String query = "";
        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'),'%b-%y'),COALESCE(SUM(a.totalMegaWatt), 0) "
                + " FROM AocForm a "
                + " WHERE STR_TO_DATE(a.createdDate,'%d/%m/%Y') >= STR_TO_DATE('" + from_date + "', '%d/%m/%Y') "
                + " AND a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)"
                + " GROUP BY DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'), '%Y-%m') "
                + " ORDER BY STR_TO_DATE(a.createdDate,'%d/%m/%Y') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public int countAllProjectAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a) from AocForm a, DeliverableMulti b";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + "AND a.id = b.aocId "
                    + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                    + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";

            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.id = b.aocId "
                        + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                        + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.id = b.aocId "
                        + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                        + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List readByMonthAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        boolean hasPreset = Filter != null && !Filter.isEmpty()
                && !Filter.equals("--select--")
                && formattedStartDate != null && !formattedStartDate.isEmpty()
                && formattedDate != null && !formattedDate.isEmpty();

        boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty()
                && Todate != null && !Todate.isEmpty();

        String query = "SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'),'%b-%y') "
                + "FROM AocForm a WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

        if (hasPreset) {
            query += " AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y') ";
        } else if (hasExplicitRange) {
            query += " AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y') ";
        }

        query += ") ";

        query += " GROUP BY DATE_FORMAT(STR_TO_DATE(a.createdDate, '%d/%m/%Y'), '%b-%y')";
        query += " ORDER BY STR_TO_DATE(a.createdDate, '%d/%m/%Y') DESC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List monthWiseListAocGraphUser(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";

        query += " FROM AocForm a "
                + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";
        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y'))";
        }

        query += " ORDER BY a.documentNo DESC";
        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List countAllAocDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = " FROM AocForm a";

        if (Filter != null && !Filter.equals("")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        query += " ORDER BY a.documentNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByFlagFourDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM AocForm a WHERE a.flagStatus IN (4,6,7,11,12,13)";

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        query += " ORDER BY a.documentNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByPendingDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "FROM AocForm a WHERE a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13)";

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        query += " ORDER BY a.documentNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByMonthWiseAnalytics(String from_date5) {

        String query = "";
        query += " SELECT count(*) as totalCount, "
                + " SUM(a.noOfCharger) as totalChargers, "
                + " SUM(a.totalChargerCapacity) as totalCapacity, "
                + " SUM(a.totalKwRating) as totalKw, "
                + " (SUM(a.noOfCharger) + SUM(a.totalChargerCapacity) + SUM(a.totalKwRating)) as totalSum, "
                + " DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'),'%b-%y') as monthYear "
                + " FROM AocForm a "
                + " WHERE STR_TO_DATE(a.createdDate,'%d/%m/%Y') >= STR_TO_DATE('" + from_date5 + "', '%d/%m/%Y') "
                + " AND a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)"
                + " GROUP BY DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'), '%Y-%m') "
                + " ORDER BY STR_TO_DATE(a.createdDate,'%d/%m/%Y') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List noOfChargerDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM AocForm a "
                + " WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y') ";
        }
        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }
        query += " AND a.noOfCharger IS NOT NULL AND a.noOfCharger <> '' ";

        query += " ORDER BY a.documentNo DESC";

        List<Object[]> list = (List<Object[]>) (List<?>) getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List totalChargerCapacityDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM AocForm a "
                + " WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y') ";
        }
        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }
        query += " AND a.totalChargerCapacity IS NOT NULL AND a.totalChargerCapacity <> '' ";

        query += " ORDER BY a.documentNo DESC";

        List<Object[]> list = (List<Object[]>) (List<?>) getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List totalKwRatingDetailsAoc(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM AocForm a "
                + " WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y') ";
        }
        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }
        query += " AND a.totalKwRating IS NOT NULL AND a.totalKwRating <> '' ";

        query += " ORDER BY a.documentNo DESC";

        List<Object[]> list = (List<Object[]>) (List<?>) getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List readByMonthWiseEthanBurificationAoc(String from_date5) {

        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM aoc_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Ethan' "
                + "AND flag_status IN (4,5,6,7,8,9,10,11,12,13) "
                + "GROUP BY anchore_customer, "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";
        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;
    }

    @Override
    public List readByMonthWiseEquaBurificationAoc(String from_date5) {
        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM aoc_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Equator' "
                + "AND flag_status IN (4,5,6,7,8,9,10,11,12,13) "
                + "GROUP BY anchore_customer, "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";
        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;

    }

    @Override
    public List readByMonthWiseHubBurificationAoc(String from_date5) {

        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM aoc_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Hub' "
                + "AND flag_status IN (4,5,6,7,8,9,10,11,12,13) "
                + "GROUP BY anchore_customer, "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";
        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;

    }

    @Override
    public List readByMonthWiseCapexBurificationAoc(String from_date5) {
        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM aoc_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Co Capex OEM' "
                + "AND flag_status IN (4,5,6,7,8,9,10,11,12,13) "
                + "GROUP BY anchore_customer, "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";
        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;
    }

    @Override
    public List readByrejectedAocDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM AocForm a WHERE a.flagStatus IN (3)";

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        query += " ORDER BY a.documentNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByunfieldKOMDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM AocForm a "
                + " WHERE  a.flagStatus =4"
                + " And a.assignedName =''";

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        query += " ORDER BY a.documentNo DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByprojectCoorGraphUserPendingKOM(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String OapQuery = "FROM AocForm a "
                + " WHERE a.assignedName = '" + ContactPerson + "'"
                + " AND a.flagStatus = 4";

        if (Filter != null && !Filter.equals("")) {
            OapQuery += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            OapQuery += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        OapQuery += " ORDER BY a.documentNo DESC";

        return getHibernateTemplate().find(OapQuery);

    }

    @Override
    public List getAocCretedUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId, a.createdDate, a.flagStatus "
                    + "FROM AocForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (8, 9, 10, 100) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR (a.flagStatus = 0  AND lower('save as draft')      LIKE :search) "
                        + "OR (a.flagStatus = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle')            LIKE :search) "
                        + "OR (a.flagStatus = 3  AND lower('rejected')           LIKE :search) "
                        + "OR ((a.flagStatus = 4  OR a.flagStatus = 6  OR a.flagStatus = 7 "
                        + "  OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "  AND lower('approved') LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalAocCretedUserCount(String username) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (8, 9, 10, 100) ";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);

            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();

    }

    @Override
    public int getFilteredAocCretedUserCount(String username, String searchValue) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (8, 9, 10, 100) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR (a.flagStatus = 0  AND lower('save as draft')      LIKE :search) "
                        + "OR (a.flagStatus = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle')            LIKE :search) "
                        + "OR (a.flagStatus = 3  AND lower('rejected')           LIKE :search) "
                        + "OR ((a.flagStatus = 4  OR a.flagStatus = 6  OR a.flagStatus = 7 "
                        + "  OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "  AND lower('approved') LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();

    }

    @Override
    public List getAOCExectiveHeadPagination(int start, int length, String searchValue, int executive, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId, a.createdDate, a.flagStatus "
                    + "FROM AocForm a "
                    + " WHERE  a.flagStatus =4"
                    + " And a.assignedName =''";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR ((a.flagStatus = 4) "
                        + "  AND lower('approved') LIKE :search) "
                        + ")";
            }

            if (orderColumn != null && !orderColumn.trim().isEmpty()) {
                hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "asc");
            } else {
                hql += " ORDER BY a.id desc";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalAOCExectiveHeadCount(int executive) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + " WHERE  a.flagStatus =4"
                    + " And a.assignedName =''";

            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();

    }

    @Override
    public int getFilteredAOCExectiveHeadCount(int executive, String searchValue) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + " WHERE  a.flagStatus =4"
                    + " And a.assignedName =''";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR ((a.flagStatus = 4) "
                        + "  AND lower('approved') LIKE :search) "
                        + ")";
            }
            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();

    }

    @Override
    public List getassignedNamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String hql = "SELECT a.id, a.documentNo, a.userId, a.createdDate "
                    + "FROM AocForm a "
                    + " WHERE a.assignedName = '" + username + "'"
                    + " AND a.flagStatus = 4";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.userId)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "asc");

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalassignedNameCount(String username) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + " WHERE a.assignedName = '" + username + "'"
                    + " AND a.flagStatus = 4";

            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();

    }

    @Override
    public int getFilteredassignedNameCount(String username, String searchValue) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + " WHERE a.assignedName = '" + username + "'"
                    + " AND a.flagStatus = 4";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.userId)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();

    }

    @Override
    public List getAocDesignTeamPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo,a.hubDepoName,a.userId,a.createdDate,a.flagStatus,a.surveyRadio "
                    + " FROM AocForm a"
                    + " WHERE a.flagStatus IN (7, 11, 12, 13)";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo) LIKE :search "
                        + "OR lower(a.hubDepoName) LIKE :search "
                        + "OR lower(a.userId) LIKE :search "
                        + "OR str(a.createdDate) LIKE :search "
                        + "OR (a.flagStatus = 13  AND lower('deliverable rejected')      LIKE :search) "
                        + "OR (a.flagStatus IN (7,11,12) "
                        + "    AND 'approved' LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalAocDesignTeamCount(String username) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM AocForm a"
                    + " WHERE a.flagStatus IN (7, 11, 12, 13)";

            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;

    }

    @Override
    public int getFilteredAocDesignTeamCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM AocForm a"
                    + " WHERE a.flagStatus IN (7, 11, 12, 13)";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo) LIKE :search "
                        + "OR lower(a.hubDepoName) LIKE :search "
                        + "OR lower(a.userId) LIKE :search "
                        + "OR str(a.createdDate) LIKE :search "
                        + "OR (a.flagStatus = 13  AND lower('deliverable rejected')      LIKE :search) "
                        + "OR (a.flagStatus IN (7,11,12) "
                        + "    AND 'approved' LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getAocProjectmanagerPagination(int start, int length, String searchValue,
            String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.createdDate, a.flagStatus, "
                    + "(SELECT b.id FROM KickOffForm b WHERE a.id = b.aocForm.id), "
                    + "(SELECT b.flagStatus FROM KickOffForm b WHERE a.id = b.aocForm.id) "
                    + "FROM AocForm a "
                    + "WHERE a.projectCoordinater = :username " // ← ? → :username
                    + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                    + "AND ( "
                    + "  NOT EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z WHERE z.aocId = a.id "
                    + "  ) "
                    + "  OR EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z "
                    + "    WHERE z.aocId = a.id "
                    + "    AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                    + "    AND a.flagStatus NOT IN (8, 9, 10) "
                    + "  ) "
                    + ") ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "   lower(a.documentNo)       LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName) LIKE :search "
                        + "OR lower(str(a.createdDate))  LIKE :search "
                        + ")";
            }

            hql += " ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getTotalAocProjectmanagerCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            // ← Removed broken subqueries after COUNT; COUNT only needs the WHERE clause
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.projectCoordinater = :username " // ← ? → :username
                    + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                    + "AND ( "
                    + "  NOT EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z WHERE z.aocId = a.id "
                    + "  ) "
                    + "  OR EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z "
                    + "    WHERE z.aocId = a.id "
                    + "    AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                    + "    AND a.flagStatus NOT IN (8, 9, 10) "
                    + "  ) "
                    + ") ";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredAocProjectmanagerCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            // ← Removed broken subqueries after COUNT
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.projectCoordinater = :username " // ← ? → :username
                    + "AND a.flagStatus IN (4, 6, 7, 11, 12, 13) "
                    + "AND ( "
                    + "  NOT EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z WHERE z.aocId = a.id "
                    + "  ) "
                    + "  OR EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z "
                    + "    WHERE z.aocId = a.id "
                    + "    AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                    + "    AND a.flagStatus NOT IN (8, 9, 10) "
                    + "  ) "
                    + ") ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "   lower(a.documentNo)       LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName) LIKE :search "
                        + "OR lower(str(a.createdDate))  LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getUserprojectPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId, a.designation, a.createdDate, a.flagStatus, "
                    + "b.id, b.flagStatus, "
                    + "c.id, c.documentNo "
                    + "FROM AocForm a, DeliverableMulti b, KickOffForm c "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND b.flagStatus = 1 "
                    + "AND a.id = b.aocId "
                    + "AND c.documentNo IS NOT NULL "
                    + "AND a.id = c.aocForm "
                    + "AND b.flagStatus <> 5 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)          LIKE :search "
                        + "OR lower(c.documentNo)          LIKE :search "
                        + "OR lower(a.hubDepoName)         LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)              LIKE :search "
                        + "OR lower(a.designation)         LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getTotalUserprojectCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(DISTINCT a.id) "
                    + "FROM AocForm a, DeliverableMulti b, KickOffForm c "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND b.flagStatus = 1 "
                    + "AND a.id = b.aocId "
                    + "AND c.documentNo IS NOT NULL "
                    + "AND a.id = c.aocForm "
                    + "AND b.flagStatus <> 5 ";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredUserprojectCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(DISTINCT a.id) "
                    + "FROM AocForm a, DeliverableMulti b, KickOffForm c "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND b.flagStatus = 1 "
                    + "AND a.id = b.aocId "
                    + "AND c.documentNo IS NOT NULL "
                    + "AND a.id = c.aocForm "
                    + "AND b.flagStatus <> 5 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)          LIKE :search "
                        + "OR lower(c.documentNo)          LIKE :search "
                        + "OR lower(a.hubDepoName)         LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)              LIKE :search "
                        + "OR lower(a.designation)         LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getAocNetworkTeamPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, "
                    + "a.userId, a.designation, a.createdDate, a.flagStatus "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (7, 11, 12, 13) ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)          LIKE :search "
                        + "OR lower(a.hubDepoName)         LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)              LIKE :search "
                        + "OR lower(a.designation)         LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getTotalAocNetworkTeamCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (7, 11, 12, 13) ";

            Query query = session.createQuery(hql);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredAocNetworkTeamCount(String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (7, 11, 12, 13) ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)          LIKE :search "
                        + "OR lower(a.hubDepoName)         LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.userId)              LIKE :search "
                        + "OR lower(a.designation)         LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getAocReportPagination(int start, int length, String searchValue,
            String aocdocumentNumber, String projectName,
            String fromDate, String toDate,
            String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String sql = "SELECT a.id, a.document_no, a.hub_depo_name, a.client_project_name, "
                    + "a.user_id, a.created_date, a.flag_status, "
                    + "IFNULL(b.flag_status, '') AS kom_flag_status, "
                    + "a.zero_date, a.completion_date, a.charging_rate_per_unit, "
                    + "a.no_of_charger, a.no_of_charge_points, a.overall_capacity "
                    + "FROM aoc_form a "
                    + "LEFT JOIN kickoff_form b ON a.id = b.aoc_form_id "
                    + "WHERE 1 = 1 ";

            if (aocdocumentNumber != null && !aocdocumentNumber.trim().equals("")) {
                sql += " AND lower(a.document_no) LIKE :aocdocumentNumber ";
            }

            if (projectName != null && !projectName.trim().equals("")) {
                sql += " AND lower(a.client_project_name) LIKE :projectName ";
            }

            if (fromDate != null && !fromDate.trim().equals("")
                    && toDate != null && !toDate.trim().equals("")) {
                sql += " AND STR_TO_DATE(a.created_date,'%d/%m/%Y') "
                        + " BETWEEN STR_TO_DATE(:fromDate,'%d-%m-%Y') "
                        + " AND STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            } else if (fromDate != null && !fromDate.trim().equals("")) {
                sql += " AND STR_TO_DATE(a.created_date,'%d/%m/%Y') "
                        + " >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            } else if (toDate != null && !toDate.trim().equals("")) {
                sql += " AND STR_TO_DATE(a.created_date,'%d/%m/%Y') "
                        + " <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql += " AND ( "
                        + "  lower(a.document_no)              LIKE :search "
                        + "OR lower(a.hub_depo_name)           LIKE :search "
                        + "OR lower(a.client_project_name)     LIKE :search "
                        + "OR lower(a.user_id)                 LIKE :search "
                        + "OR lower(a.created_date)            LIKE :search "
                        + "OR lower(a.zero_date)               LIKE :search "
                        + "OR lower(a.completion_date)         LIKE :search "
                        + "OR lower(a.charging_rate_per_unit)  LIKE :search "
                        + "OR lower(a.no_of_charger)           LIKE :search "
                        + "OR lower(a.no_of_charge_points)     LIKE :search "
                        + "OR lower(a.overall_capacity)        LIKE :search "
                        + "OR (a.flag_status = 0   AND lower('save as draft')      LIKE :search) "
                        + "OR (a.flag_status = 1   AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flag_status = 2   AND lower('recycle')            LIKE :search) "
                        + "OR (a.flag_status = 3   AND lower('rejected')           LIKE :search) "
                        + "OR (a.flag_status = 100 AND lower('aoc deleted')        LIKE :search) "
                        + "OR ((a.flag_status = 4 OR a.flag_status = 6 OR a.flag_status = 7 "
                        + "  OR a.flag_status = 11 OR a.flag_status = 12 OR a.flag_status = 13) "
                        + "  AND lower('approved') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 0 AND lower('pending to approve') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 1 AND lower('approved')           LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 2 AND lower('recycle')            LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 3 AND lower('reject')             LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 4 AND lower('approved')           LIKE :search) "
                        + ") ";
            }

            sql += " ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            SQLQuery query = session.createSQLQuery(sql);

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            if (aocdocumentNumber != null && !aocdocumentNumber.trim().equals("")) {
                query.setParameter("aocdocumentNumber", "%" + aocdocumentNumber.toLowerCase() + "%");
            }
            if (projectName != null && !projectName.trim().equals("")) {
                query.setParameter("projectName", "%" + projectName.toLowerCase() + "%");
            }
            if (fromDate != null && !fromDate.trim().equals("")) {
                query.setParameter("fromDate", fromDate);
            }
            if (toDate != null && !toDate.trim().equals("")) {
                query.setParameter("toDate", toDate);
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getTotalAocReportCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM aoc_form a "
                    + "LEFT JOIN kickoff_form b ON a.id = b.aoc_form_id "
                    + "WHERE 1 = 1 ";

            SQLQuery query = session.createSQLQuery(sql);
            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredAocReportCount(String searchValue, String aocdocumentNumber,
            String projectName, String fromDate, String toDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM aoc_form a "
                    + "LEFT JOIN kickoff_form b ON a.id = b.aoc_form_id "
                    + "WHERE 1 = 1 ";

            if (aocdocumentNumber != null && !aocdocumentNumber.trim().equals("")) {
                sql += " AND lower(a.document_no) LIKE :aocdocumentNumber ";
            }

            if (projectName != null && !projectName.trim().equals("")) {
                sql += " AND lower(a.client_project_name) LIKE :projectName ";
            }

            if (fromDate != null && !fromDate.trim().equals("")
                    && toDate != null && !toDate.trim().equals("")) {
                sql += " AND STR_TO_DATE(a.created_date,'%d/%m/%Y') "
                        + " BETWEEN STR_TO_DATE(:fromDate,'%d-%m-%Y') "
                        + " AND STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            } else if (fromDate != null && !fromDate.trim().equals("")) {
                sql += " AND STR_TO_DATE(a.created_date,'%d/%m/%Y') "
                        + " >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            } else if (toDate != null && !toDate.trim().equals("")) {
                sql += " AND STR_TO_DATE(a.created_date,'%d/%m/%Y') "
                        + " <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql += " AND ( "
                        + "  lower(a.document_no)            LIKE :search "
                        + "OR lower(a.hub_depo_name)         LIKE :search "
                        + "OR lower(a.client_project_name)   LIKE :search "
                        + "OR lower(a.user_id)               LIKE :search "
                        + "OR lower(a.created_date)          LIKE :search "
                        + "OR (a.flag_status = 0   AND lower('save as draft')      LIKE :search) "
                        + "OR (a.flag_status = 1   AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flag_status = 2   AND lower('recycle')            LIKE :search) "
                        + "OR (a.flag_status = 3   AND lower('rejected')           LIKE :search) "
                        + "OR (a.flag_status = 100 AND lower('aoc deleted')        LIKE :search) "
                        + "OR ((a.flag_status = 4 OR a.flag_status = 6 OR a.flag_status = 7 "
                        + "  OR a.flag_status = 11 OR a.flag_status = 12 OR a.flag_status = 13) "
                        + "  AND lower('approved') LIKE :search) "
                        // FIXED: use IFNULL consistently (same as getAocReportPagination)
                        + "OR (IFNULL(b.flag_status, -1) = 0 AND lower('pending to approve') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 1 AND lower('approved')           LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 2 AND lower('recycle')            LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 3 AND lower('reject')             LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 4 AND lower('approved')           LIKE :search) "
                        + ") ";
            }

            SQLQuery query = session.createSQLQuery(sql);

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            if (aocdocumentNumber != null && !aocdocumentNumber.trim().equals("")) {
                query.setParameter("aocdocumentNumber", "%" + aocdocumentNumber.toLowerCase() + "%");
            }
            if (projectName != null && !projectName.trim().equals("")) {
                query.setParameter("projectName", "%" + projectName.toLowerCase() + "%");
            }
            if (fromDate != null && !fromDate.trim().equals("")) {
                query.setParameter("fromDate", fromDate);
            }
            if (toDate != null && !toDate.trim().equals("")) {
                query.setParameter("toDate", toDate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getMonthWiseGraphAOCPagination(int start, int length, String searchValue, String StartDate, String EndDate, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();

        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId,a.mobileNo, a.createdDate, a.flagStatus  "
                    + " FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                        + "AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y'))";

            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)           LIKE :search "
                        + "OR (a.flagStatus = 1 AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2 AND lower('recycle') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('save as draft') LIKE :search) "
                        + "OR ((a.flagStatus = 4 OR a.flagStatus = 6 OR a.flagStatus = 7 "
                        + "     OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getMonthWiseGraphAOCCount(String StartDate, String EndDate) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;

        try {
            String hql = "SELECT count(a.id) "
                    + " FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                        + "AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y'))";
            }

            count = (Long) session.createQuery(hql).uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return count.intValue();

    }

    @Override
    public int getFilteredMonthWiseGraphAOCCount(String search, String StartDate, String EndDate) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;

        try {
            String hql = "SELECT count(a.id) "
                    + " FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13)";

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)           LIKE :search "
                        + "OR (a.flagStatus = 1 AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2 AND lower('recycle') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('save as draft') LIKE :search) "
                        + "OR ((a.flagStatus = 4 OR a.flagStatus = 6 OR a.flagStatus = 7 "
                        + "     OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                        + "AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y'))";
            }

            Query query = session.createQuery(hql);

            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
            }

            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();
    }

    @Override
    public List getProjectCoorGraphUserPendingKOMPagination(int start, int length, String searchValue,
            String orderColumn, String orderDir, String ContactPerson,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, "
                    + "a.clientProjectName, a.createdDate, a.designation "
                    + "FROM AocForm a "
                    + "WHERE a.assignedName = :contactPerson "
                    + "AND a.flagStatus = 4 ";

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)          LIKE :search "
                        + "OR lower(a.hubDepoName)         LIKE :search "
                        + "OR lower(a.clientProjectName)   LIKE :search "
                        + "OR lower(a.createdDate)   LIKE :search "
                        + "OR lower(a.designation)   LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("fromdate", Fromdate);
                query.setParameter("todate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getProjectCoorGraphUserPendingKOMCount(String ContactPerson,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.assignedName = :contactPerson "
                    + "AND a.flagStatus = 4 ";

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("fromdate", Fromdate);
                query.setParameter("todate", Todate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getProjectCoorGraphUserPendingKOMCount(String searchValue, String ContactPerson,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.assignedName = :contactPerson "
                    + "AND a.flagStatus = 4 ";

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)        LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName) LIKE :search "
                        + "OR lower(a.createdDate)   LIKE :search "
                        + "OR lower(a.designation)   LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("fromdate", Fromdate);
                query.setParameter("todate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getProjectManagerTotalGraphUser1Pagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT d.id, d.documentNo, d.hubLocation, d.userId, d.projectName, "
                    + "d.flagStatus, c.id "
                    + "FROM KickOffForm d JOIN d.aocForm c "
                    + "WHERE c.projectCoordinater = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND d.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND d.flagStatus IN (1, 4) ";
                }
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(d.documentNo)  LIKE :search "
                        + "OR lower(d.hubLocation) LIKE :search "
                        + "OR lower(d.userId)      LIKE :search "
                        + "OR lower(d.projectName) LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("fromdate", Fromdate);
                query.setParameter("todate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getProjectManagerTotalGraphUser1Count(String ContactPerson, String Value,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(d.id) "
                    + "FROM KickOffForm d JOIN d.aocForm c "
                    + "WHERE c.projectCoordinater = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND d.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND d.flagStatus IN (1, 4) ";
                }
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("fromdate", Fromdate);
                query.setParameter("todate", Todate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getProjectManagerTotalGraphUser1Count(String searchValue, String ContactPerson,
            String Value, String Fromdate, String Todate, String Filter,
            String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(d.id) "
                    + "FROM KickOffForm d JOIN d.aocForm c "
                    + "WHERE c.projectCoordinater = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND d.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND d.flagStatus IN (1, 4) ";
                }
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(d.documentNo)  LIKE :search "
                        + "OR lower(d.hubLocation) LIKE :search "
                        + "OR lower(d.userId)      LIKE :search "
                        + "OR lower(d.projectName) LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("fromdate", Fromdate);
                query.setParameter("todate", Todate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getAocNoOfChargerDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, "
                    + "a.noOfCharger, a.mobileNo, a.createdDate "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.noOfCharger IS NOT NULL "
                    + "AND a.noOfCharger <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.noOfCharger)        LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getAocNoOfChargerDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.noOfCharger IS NOT NULL "
                    + "AND a.noOfCharger <> '' ";

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredAocNoOfChargerDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.noOfCharger IS NOT NULL "
                    + "AND a.noOfCharger <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)        LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName) LIKE :search "
                        + "OR lower(a.noOfCharger)       LIKE :search "
                        + "OR lower(a.mobileNo)          LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getAocTotalChargerCapacityPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, "
                    + "a.totalChargerCapacity, a.mobileNo, a.createdDate "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.totalChargerCapacity IS NOT NULL "
                    + "AND a.totalChargerCapacity <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)           LIKE :search "
                        + "OR lower(a.hubDepoName)          LIKE :search "
                        + "OR lower(a.clientProjectName)    LIKE :search "
                        + "OR lower(a.totalChargerCapacity) LIKE :search "
                        + "OR lower(a.mobileNo)             LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getAocTotalChargerCapacityCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.totalChargerCapacity IS NOT NULL "
                    + "AND a.totalChargerCapacity <> '' ";

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredAocTotalChargerCapacityCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.totalChargerCapacity IS NOT NULL "
                    + "AND a.totalChargerCapacity <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)           LIKE :search "
                        + "OR lower(a.hubDepoName)          LIKE :search "
                        + "OR lower(a.clientProjectName)    LIKE :search "
                        + "OR lower(a.totalChargerCapacity) LIKE :search "
                        + "OR lower(a.mobileNo)             LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getAocTotalKwRatingPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, "
                    + "a.totalKwRating, a.mobileNo, a.createdDate "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.totalKwRating IS NOT NULL "
                    + "AND a.totalKwRating <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)        LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName) LIKE :search "
                        + "OR lower(a.totalKwRating)     LIKE :search "
                        + "OR lower(a.mobileNo)          LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getAocTotalKwRatingCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.totalKwRating IS NOT NULL "
                    + "AND a.totalKwRating <> '' ";

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredAocTotalKwRatingCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            hql += "AND a.totalKwRating IS NOT NULL "
                    + "AND a.totalKwRating <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)        LIKE :search "
                        + "OR lower(a.hubDepoName)       LIKE :search "
                        + "OR lower(a.clientProjectName) LIKE :search "
                        + "OR lower(a.totalKwRating)     LIKE :search "
                        + "OR lower(a.mobileNo)          LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }
            if (Filter != null && !Filter.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            count = result != null ? ((Number) result).longValue() : 0L;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int countAllAoc() {
        String query = "SELECT COUNT(*) FROM AocForm a "
                + "WHERE a.flagStatus NOT IN (0,100)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int countAllAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a.id) from AocForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y')) "
                    + " AND a.flagStatus NOT IN (0,100) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus NOT IN (0,100) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) "
                        + " AND a.flagStatus NOT IN (0,100) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List getTotalAocPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId,a.mobileNo, a.createdDate, a.flagStatus "
                    + " FROM AocForm a "
                    + "WHERE a.flagStatus NOT IN (0,100)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)           LIKE :search "
                        + "OR (a.flagStatus = 1 AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2 AND lower('recycle') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('save as draft') LIKE :search) "
                        + "OR ((a.flagStatus = 4 OR a.flagStatus = 6 OR a.flagStatus = 7 "
                        + "     OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalAocCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM AocForm a "
                    + "WHERE a.flagStatus NOT IN (0,100)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredTotalAocCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + " FROM AocForm a "
                    + "WHERE a.flagStatus NOT IN (0,100)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)           LIKE :search "
                        + "OR (a.flagStatus = 1 AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2 AND lower('recycle') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('save as draft') LIKE :search) "
                        + "OR ((a.flagStatus = 4 OR a.flagStatus = 6 OR a.flagStatus = 7 "
                        + "     OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }
            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readByFlagFour() {
        String query = "SELECT COUNT(*)";
        query += " FROM AocForm a"
                + " WHERE a.flagStatus IN (4,6,7,11,12,13)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a.id) from AocForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND  a.flagStatus IN (4,6,7,11,12,13)";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND  a.flagStatus IN (4,6,7,11,12,13)";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND  a.flagStatus IN (4,6,7,11,12,13)";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List getTotalApprovedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId,a.mobileNo, a.createdDate, a.flagStatus "
                    + "FROM AocForm a WHERE a.flagStatus IN (4,6,7,11,12,13)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)           LIKE :search "
                        + "OR (a.flagStatus = 1 AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2 AND lower('recycle') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('save as draft') LIKE :search) "
                        + "OR ((a.flagStatus = 4 OR a.flagStatus = 6 OR a.flagStatus = 7 "
                        + "     OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "     AND lower('approved') LIKE :search) "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalApprovedAocCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a WHERE a.flagStatus IN (4,6,7,11,12,13)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredTotalApprovedAocCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a WHERE a.flagStatus IN (4,6,7,11,12,13)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + "OR (a.flagStatus = 1 AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2 AND lower('recycle') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('rejected') LIKE :search) "
                        + "OR (a.flagStatus = 3 AND lower('save as draft') LIKE :search) "
                        + "OR ((a.flagStatus = 4 "
                        + "     OR a.flagStatus = 6 "
                        + "     OR a.flagStatus = 7 "
                        + "     OR a.flagStatus = 11 "
                        + "     OR a.flagStatus = 12 "
                        + "     OR a.flagStatus = 13) "
                        + "    AND lower('approved') LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readBypendingAoc() {

        String query = "SELECT COUNT(*)";
        query += " FROM AocForm a"
                + " WHERE a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readBypendingAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a.id) from AocForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13)";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13)";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13)";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getTotalPendingAOCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId,a.mobileNo, a.createdDate "
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getTotalPendingAOCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT Count(a.id)"
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13) ";
            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredTotalPendingAOCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT Count(a.id)"
                    + "FROM AocForm a "
                    + "WHERE a.flagStatus NOT IN (0,100,3,4,6,7,11,12,13) ";
            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readByrejectedAoc() {
        String query = "SELECT COUNT(*) "
                + "FROM AocForm a "
                + "WHERE a.flagStatus =3";

        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();

    }

    @Override
    public int readByrejectedAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a.id) from AocForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus = 3 ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus = 3 ";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus = 3 ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getRejectedAOCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId,a.mobileNo, a.createdDate "
                    + "FROM AocForm a WHERE a.flagStatus IN (3)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getRejectedAOCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a WHERE a.flagStatus IN (3) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredRejectedAOCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) "
                    + "FROM AocForm a WHERE a.flagStatus IN (3) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int readByunfieldKOM() {

        String query = "SELECT COUNT(*) "
                + "FROM AocForm a "
                + " WHERE  a.flagStatus =4";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();

    }

    @Override
    public int readByunfieldKOMDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a.id) from AocForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus = 4 ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus = 4 ";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus = 4 ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getUnfieldKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.hubDepoName, a.clientProjectName, a.userId,a.mobileNo, a.createdDate "
                    + "FROM AocForm a "
                    + " WHERE  a.flagStatus = 4";
            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + ")";
            }

            hql += " ORDER BY a." + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }

    @Override
    public int getUnfieldKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT Count(a.id)"
                    + "FROM AocForm a "
                    + " WHERE  a.flagStatus = 4 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

    @Override
    public int getFilteredUnfieldKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT Count(a.id)"
                    + "FROM AocForm a "
                    + " WHERE  a.flagStatus = 4 ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)         LIKE :search "
                        + "OR lower(a.hubDepoName)        LIKE :search "
                        + "OR lower(a.clientProjectName)  LIKE :search "
                        + "OR lower(a.userId)             LIKE :search "
                        + "OR lower(a.mobileNo)           LIKE :search "
                        + "OR lower(a.createdDate)        LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            result = count != null ? count.intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

}
