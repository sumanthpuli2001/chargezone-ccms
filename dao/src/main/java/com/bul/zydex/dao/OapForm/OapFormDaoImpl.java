/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapForm;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapForm;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class OapFormDaoImpl<T> extends GenericsDAOImpl<T> implements OapFormDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapForm.class;
    }

    @Override
    public List readByIds(String id) {
        String query = "";
        query += " FROM OapForm a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByUser(String username) {
        String query = "";
        query += " FROM OapForm a"
                + " WHERE a.userId = '" + username + "'"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List approvedList(String username) {
        String query = "";
        query += " FROM OapForm a"
                + " WHERE a.userId = '" + username + "'"
                + " And a.flagStatus IN (4)"
                + " And a.assignedName =''"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List rights(int executive) {
        String query = "";
        query += " FROM OapForm a"
                + " WHERE  a.flagStatus =4"
                + " And a.assignedName =''"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List assignedName(String username) {
        String query = "";
        query += " "
                + " FROM OapForm a"
                + " WHERE a.assignedName = '" + username + "'"
                + " AND a.flagStatus = 4"
                + " ORDER BY a.id DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByusername(String username) {

        String query = "select b.id, b.documentNo, b.pcsName, b.flagStatus";
        query += " FROM OapForm a, CrcForm b"
                + " WHERE a.assignedName = '" + username + "'"
                + " and a.id=b.oapForm.id";
        return getHibernateTemplate().find(query);

    }

    @Override
    public OapForm readByformid(int id1) {
        String query = "";
        OapForm oapForm = new OapForm();
        query += " FROM OapForm a"
                + " WHERE a.id = '" + id1 + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            oapForm = (OapForm) list.get(0);
        }
        return oapForm;
    }

    @Override
    public List approvalStatus(String username) {

        String query = "";
        query += " FROM OapForm a"
                + " WHERE  a.flagStatus = 7 and a.partiallyApproveFlag IN (1, 11, 12) "
                + " or  a.flagStatus=14 and  a.partiallyApproveFlag IN (1,12)"
                + " or  a.flagStatus=3 and  a.partiallyApproveFlag IN (12)"
                + " or  a.flagStatus=4 and  a.partiallyApproveFlag IN (12)"
                + " order by a.id desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public OapForm ApprovalStatus() {
        String query = "";
        OapForm oapForm = new OapForm();
        query += " FROM OapForm a"
                + " WHERE a. a.flagStatus =7 ";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            oapForm = (OapForm) list.get(0);
        }
        return oapForm;
    }

    @Override
    public List projectmanger(String username) {

        String query = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.date, a.flagStatus, "
                + "(SELECT b.id FROM CrcForm b WHERE a.id = b.oapForm.id), "
                + "(SELECT b.flagStatus FROM CrcForm b WHERE a.id = b.oapForm.id) "
                + "FROM OapForm a "
                + "WHERE a.projectCoordinater = ? "
                + "AND a.flagStatus IN (7, 14) "
                + "AND ( "
                + "NOT EXISTS ( "
                + "SELECT 1 FROM DeliverableMulti z "
                + "WHERE z.oapId = a.id "
                + ") "
                + "OR EXISTS ( "
                + "SELECT 1 FROM DeliverableMulti z "
                + "WHERE z.oapId = a.id "
                + "AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                + ") "
                + ") "
                + "ORDER BY a.id DESC";

        return getHibernateTemplate().find(query, username);

    }

    @Override
    public List readsearch(String oapdocumentNumber, String open_from_date, String open_to_date, String username, String projectName) {
        String query = " SELECT b"
                + " FROM OapForm a, CrcForm b "
                + " WHERE a.id=b.oapForm.id"; // Always filter by username

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.date, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
        }

        if (!oapdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + oapdocumentNumber + "'";
        }
        if (!projectName.equals("")) {
            query += " AND a.projectName='" + projectName + "'";
        }

// Apply ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.date DESC";

// Execute the query
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readsearch8(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName) {
        String query = "SELECT a "
                + " FROM OapForm a "
                + " WHERE 1=1";

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.date, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
        }

        if (!oapdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + oapdocumentNumber + "'";
        }
        if (!projectName.equals("")) {
            query += " AND a.projectName='" + projectName + "'";
        }
//// Apply ORDER BY clause
//        query += "AND a.id NOT IN (SELECT oapForm.id FROM CrcForm) ";
        query += " ORDER BY a.documentNo desc, a.date DESC";

// Execute the query
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readoapReportList(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName) {

        String query = "SELECT b "
                + " FROM OapForm a, CrcForm b "
                + " WHERE a.id=b.oapForm.id"; // Always filter by username
        boolean hasCondition = false; // Track if any condition is applied

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.date, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
            hasCondition = true;
        }

        if (!oapdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + oapdocumentNumber + "'";
            hasCondition = true;
        }

        if (!projectName.equals("")) {
            query += " AND a.projectName='" + projectName + "'";
            hasCondition = true;
        }

// Ensure all data is fetched when no filters are applied
        if (!hasCondition) {
            query += " AND a.userId IS NOT NULL"; // This ensures the query remains valid
        }

// Corrected ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.date desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readoapReportList8(String oapdocumentNumber, String open_from_date, String open_to_date, String projectName) {

        String query = "SELECT a"
                + " FROM OapForm a"
                + " WHERE 1=1"; // Always filter by username
        boolean hasCondition = false; // Track if any condition is applied

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.date, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
            hasCondition = true;
        }

        if (!oapdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + oapdocumentNumber + "'";
            hasCondition = true;
        }
        if (!projectName.equals("")) {
            query += " AND a.projectName='" + projectName + "'";
            hasCondition = true;
        }
// Ensure all data is fetched when no filters are applied
        if (!hasCondition) {
            query += " AND a.userId IS NOT NULL"; // This ensures the query remains valid
        }
// Corrected ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.date desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readbyflagStatus() {
        String query = "";
        query += " FROM OapForm a"
                + " WHERE a.flagStatus IN (7, 11, 12, 13) "
                + "order by a.id desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByUserproject(String username) {
        String query = "";
        query += " FROM OapForm a,DeliverableMulti b,CrcForm c"
                + " WHERE a.projectCoordinater = '" + username + "'"
                + " AND b.flagStatus=1"
                + " AND a.id=b.oapId"
                + " AND c.documentNo IS NOT NULL"
                + " AND a.id=c.oapForm"
                + " AND b.flagStatus<>5"
                + " order by a.id desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readalldeliview(String username) {
        String query = "";
        query += " FROM OapForm a,DeliverableMulti b"
                + " WHERE a.userId = '" + username + "'"
                + " AND a.id=b.oapId";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByflagstatuszero(String username) {
        String query = "";
        query += " FROM OapForm a"
                + " WHERE a.userId = '" + username + "'"
                + " AND a.flagStatus IN (0)"
                + " order by a.id desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readOapForms(String Fromdate, String Todate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        cal.add(Calendar.MONTH, -12);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT b.id,b.documentNo,b.pcsName,b.projectName,b.department,b.createdDate,b.userId,b.flagStatus,b.approvedBy,b.approvedDate,b.crcAssignedBy,b.crcAssignedDate,b.assignedName,"
                + "DATEDIFF(STR_TO_DATE(b.createdDate, '%d/%m/%Y'), STR_TO_DATE(b.approvedDate, '%d/%m/%Y')) AS oapApprovalDays,"
                + "DATEDIFF(STR_TO_DATE(b.approvedDate, '%d/%m/%Y'), STR_TO_DATE(b.crcAssignedDate, '%d/%m/%Y')) AS crcAssignDays,"
                + "b.crcCreatedDate,"
                + "DATEDIFF(STR_TO_DATE(b.crcAssignedDate, '%d/%m/%Y'), STR_TO_DATE(b.crcCreatedDate, '%d/%m/%Y')) AS crcAssignDays,"
                + "b.crcApprovedBy,b.crcApprovedDate,"
                + "DATEDIFF(STR_TO_DATE(b.crcCreatedDate, '%d/%m/%Y'), STR_TO_DATE(b.crcApprovedDate, '%d/%m/%Y')) AS crcAssignDays"
                + " FROM OapForm b "
                + "WHERE 1=1 ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y')";
        } else {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d/%m/%Y')";
        }
        query += "AND b.id NOT IN (SELECT oapId FROM DeliverableMulti) ";
        query += " ORDER BY b.id DESC";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readDeliverbleForms(String Fromdate, String Todate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        cal.add(Calendar.MONTH, -12);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT b.id,b.documentNo,b.pcsName,b.projectName,b.department,b.createdDate,b.userId,b.flagStatus,b.approvedBy,b.approvedDate,b.crcAssignedBy,b.crcAssignedDate,b.assignedName,"
                + "DATEDIFF(STR_TO_DATE(b.createdDate, '%d/%m/%Y'), STR_TO_DATE(b.approvedDate, '%d/%m/%Y')) AS oapApprovalDays,"
                + "DATEDIFF(STR_TO_DATE(b.approvedDate, '%d/%m/%Y'), STR_TO_DATE(b.crcAssignedDate, '%d/%m/%Y')) AS crcAssignDays,"
                + "b.crcCreatedDate,"
                + "DATEDIFF(STR_TO_DATE(b.crcAssignedDate, '%d/%m/%Y'), STR_TO_DATE(b.crcCreatedDate, '%d/%m/%Y')) AS crcAssignDays,"
                + "b.crcApprovedBy,b.crcApprovedDate,"
                + "DATEDIFF(STR_TO_DATE(b.crcCreatedDate, '%d/%m/%Y'), STR_TO_DATE(b.crcApprovedDate, '%d/%m/%Y')) AS crcAssignDays,"
                + "c.createdBy,c.createdDate,c.designCoordinator,c.deliverableCreatedDate,c.deliverableApprovedBy,c.deliverableApprovedDate,"
                + "b.projectCoordinater,c.projectManagerApprovedDate"
                + " FROM OapForm b, DeliverableMulti c "
                + "WHERE b.id=c.oapId ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y')";
        } else {
            query += " AND STR_TO_DATE(b.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d/%m/%Y')";
        }
        query += " ORDER BY b.id DESC";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByoapexcelReport(String oapdocumentNumber, String open_from_date, String open_to_date) {
        String query = "SELECT a"
                + " FROM OapForm a, CrcForm b "
                + " WHERE a.id=b.oapForm.id"; // Always filter by username
        boolean hasCondition = false; // Track if any condition is applied

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.date, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
            hasCondition = true;
        }

        if (!oapdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + oapdocumentNumber + "'";
            hasCondition = true;
        }

// Ensure all data is fetched when no filters are applied
        if (!hasCondition) {
            query += " AND a.userId IS NOT NULL"; // This ensures the query remains valid
        }

// Corrected ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.date desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByoapexcelReport1(String oapdocumentNumber, String open_from_date, String open_to_date) {

        String query = "SELECT a"
                + " FROM OapForm a"
                + " WHERE 1=1"; // Always filter by username
        boolean hasCondition = false; // Track if any condition is applied

        if (!open_from_date.equals("")) {
            query += " AND (STR_TO_DATE(a.date, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + open_from_date + "', '%d-%m-%Y')"
                    + " AND STR_TO_DATE('" + open_to_date + "', '%d-%m-%Y'))";
            hasCondition = true;
        }

        if (!oapdocumentNumber.equals("")) {
            query += " AND a.documentNo='" + oapdocumentNumber + "'";
            hasCondition = true;
        }

// Ensure all data is fetched when no filters are applied
        if (!hasCondition) {
            query += " AND a.userId IS NOT NULL"; // This ensures the query remains valid
        }
// Corrected ORDER BY clause
        query += " ORDER BY a.documentNo desc, a.date desc";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List crcpartiallyapprove(String username) {
        String query = "";
        query += " SELECT a,c.id"
                + " FROM OapForm a, CrcForm c"
                + " WHERE a.id = c.oapForm.id"
                + " AND a.assignedName = '" + username + "'"
                + " AND c.flagStatus = 800"
                + " ORDER BY c.id DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public int countAllProjectOap() {

        String query = "SELECT COUNT(*) "
                + "FROM OapForm a, DeliverableMulti b "
                + "WHERE a.id = b.oapId "
                + "AND a.flagStatus IN (7,14) "
                + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List readByMontOap(String from_date1) {

        String query = "";

        query += " SELECT count(*), "
                + " DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'),'%b-%y'), "
                + " COALESCE(SUM(a.totalMegaWatt), 0) "
                + " FROM OapForm a "
                + " WHERE STR_TO_DATE(a.createdDate,'%d/%m/%Y') >= STR_TO_DATE('" + from_date1 + "', '%d/%m/%Y') "
                + " AND ( "
                + "     a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "     OR a.partiallyApproveFlag IN (1,12) "
                + " ) "
                + " GROUP BY DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'), '%Y-%m') "
                + " ORDER BY STR_TO_DATE(a.createdDate,'%d/%m/%Y') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public int countAllProjectOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from OapForm a, DeliverableMulti b";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + "AND a.id = b.oapId "
                    + "AND a.flagStatus IN (7,14) "
                    + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";

            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.id = b.oapId "
                        + "AND a.flagStatus IN (7,14) "
                        + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.id = b.oapId "
                        + "AND a.flagStatus IN (7,14) "
                        + "AND (b.flagStatus IS NULL OR b.flagStatus <> 6)";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List readByMontOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";

        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'),'%b-%y') ";
        query += " FROM OapForm a WHERE 1=1 ";

        if (!Filter.equals("--select--")) {
            query += " AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y') ";
        }

        if (!Fromdate.equals("") && !Todate.equals("")) {
            query += " AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y') ";
        }

        query += " GROUP BY DATE_FORMAT(STR_TO_DATE(a.createdDate, '%d/%m/%Y'), '%b-%y')";

        query += " ORDER BY STR_TO_DATE(a.createdDate, '%d/%m/%Y') DESC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List monthWiseListOapGraphUser(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "FROM OapForm a WHERE "
                + "(a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR a.partiallyApproveFlag IN (1,12)) ";

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
    public List readByAllOapDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = " FROM OapForm a";

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

        String query = "FROM OapForm a WHERE a.flagStatus IN (4,6,7,11,12,13)";

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
    public List readBypendingOapDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM OapForm a "
                + "WHERE a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                + "AND a.partiallyApproveFlag NOT IN (1,12)";

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
    public List<Object[]> readByProjectCoordinator() {

        // Query CrcForm
        List<Object[]> crcList = (List<Object[]>) (List<?>) getHibernateTemplate().find(
                "SELECT a.assignedName, "
                + "COUNT(b.id), "
                + "SUM(CASE WHEN b.flagStatus = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN b.flagStatus = 1 THEN 1 ELSE 0 END), "
                + "(SELECT COUNT(DISTINCT a2.id) "
                + "FROM OapForm a2 "
                + "WHERE a2.flagStatus = 4 "
                + "AND a2.assignedName = a.assignedName) "
                + "FROM CrcForm b "
                + "JOIN b.oapForm a "
                + "WHERE b.flagStatus NOT IN (5,6,7) "
                + "GROUP BY a.assignedName"
        );

// Query KickOffForm
        List<Object[]> kickOffList = (List<Object[]>) (List<?>) getHibernateTemplate().find(
                "SELECT a.assignedName, "
                + "COUNT(b.id), "
                + "SUM(CASE WHEN b.flagStatus = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN b.flagStatus IN (1, 4) THEN 1 ELSE 0 END), "
                + "(SELECT COUNT(DISTINCT a2.id) "
                + "FROM AocForm a2 "
                + "WHERE a2.flagStatus = 4 "
                + "AND a2.assignedName = a.assignedName) "
                + "FROM KickOffForm b "
                + "JOIN b.aocForm a "
                + "WHERE b.flagStatus NOT IN (5,6,7) "
                + "GROUP BY a.assignedName"
        );

        Map<String, long[]> combinedMap = new HashMap<>();

        for (Object[] row : crcList) {

            String assignedName = (String) row[0];

            combinedMap.put(assignedName, new long[]{
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue(),
                ((Number) row[4]).longValue(),
                0L
            });
        }

        for (Object[] row : kickOffList) {

            String assignedName = (String) row[0];

            long[] existing = combinedMap.getOrDefault(
                    assignedName,
                    new long[]{0L, 0L, 0L, 0L, 0L}
            );

            existing[0] += ((Number) row[1]).longValue();
            existing[1] += ((Number) row[2]).longValue();
            existing[2] += ((Number) row[3]).longValue();

            existing[4] += ((Number) row[4]).longValue();

            combinedMap.put(assignedName, existing);
        }

        List<Object[]> combinedList = new ArrayList<>();

        for (Map.Entry<String, long[]> entry : combinedMap.entrySet()) {

            long[] counts = entry.getValue();

            combinedList.add(new Object[]{
                entry.getKey(),
                counts[0],
                counts[1],
                counts[2],
                counts[3],
                counts[4]
            });
        }

        return combinedList;
    }

    @Override
    public List<Object[]> readByProjectManger() {
        // Query CrcForm
        List<Object[]> crcList = (List<Object[]>) (List<?>) getHibernateTemplate().find(
                "SELECT a.projectCoordinater, COUNT(b.id), "
                + "SUM(CASE WHEN b.flagStatus = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN b.flagStatus = 1 THEN 1 ELSE 0 END) "
                + "FROM CrcForm b JOIN b.oapForm a "
                + "WHERE a.projectCoordinater IS NOT NULL AND TRIM(a.projectCoordinater) <> '' "
                + "GROUP BY a.projectCoordinater"
        );

// Query KickOffForm
        List<Object[]> kickOffList = (List<Object[]>) (List<?>) getHibernateTemplate().find(
                "SELECT a.projectCoordinater, COUNT(b.id), "
                + "SUM(CASE WHEN b.flagStatus = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN b.flagStatus IN (1, 4) THEN 1 ELSE 0 END) "
                + "FROM KickOffForm b JOIN b.aocForm a "
                + "WHERE a.projectCoordinater IS NOT NULL AND TRIM(a.projectCoordinater) <> '' "
                + "GROUP BY a.projectCoordinater"
        );

// Merge results in Java (UNCHANGED)
        Map<String, long[]> combinedMap = new HashMap<>();

        for (Object[] row : crcList) {
            combinedMap.put((String) row[0], new long[]{
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue()
            });
        }

        for (Object[] row : kickOffList) {
            combinedMap.merge((String) row[0], new long[]{
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue()
            }, (oldVal, newVal) -> new long[]{
                oldVal[0] + newVal[0],
                oldVal[1] + newVal[1],
                oldVal[2] + newVal[2]
            });
        }

// Convert map to List<Object[]>
        List<Object[]> combinedList = new ArrayList<>();

        for (Map.Entry<String, long[]> entry : combinedMap.entrySet()) {
            long[] counts = entry.getValue();
            combinedList.add(new Object[]{entry.getKey(), counts[0], counts[1], counts[2]});
        }

// Return
        return combinedList;
    }

    @Override
    public List readByprojectCoordinatorGraphUser(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String crcQuery = "FROM CrcForm b JOIN b.oapForm a WHERE a.assignedName = :ContactPerson"
                + " AND b.flagStatus NOT IN (5,6,7)";

        if (Value != null && !Value.isEmpty()) {
            if (Value.equals("One")) {
                crcQuery += " AND b.flagStatus = 0";
            } else if (Value.equals("Two")) {
                crcQuery += " AND b.flagStatus = 1";
            } else if (Value.equals("Three")) {
                crcQuery += " AND b.flagStatus = 4";
            }
        }

        if (Filter != null && !Filter.equals("")) {
            crcQuery += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            crcQuery += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        List<Object[]> crcList = (List<Object[]>) (List<?>) getHibernateTemplate().findByNamedParam(
                "SELECT b, a, 'CRC' " + crcQuery,
                new String[]{"ContactPerson"},
                new Object[]{ContactPerson}
        );

        List<Object[]> combinedList = new ArrayList<>();
        combinedList.addAll(crcList);

        return combinedList;

    }

    @Override
    public List readByprojectCoordinatorGraphUser1(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String kickQuery = "FROM KickOffForm d JOIN d.aocForm c WHERE c.assignedName = :ContactPerson";

        if (Value != null && !Value.isEmpty()) {
            if (Value.equals("One")) {
                kickQuery += " AND d.flagStatus = 0";
            } else if (Value.equals("Two")) {
                kickQuery += " AND d.flagStatus IN (1,4)";
            }
        }

        if (Filter != null && !Filter.equals("")) {
            kickQuery += " AND (STR_TO_DATE(c.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            kickQuery += " AND (STR_TO_DATE(c.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        List<Object[]> kickList = (List<Object[]>) (List<?>) getHibernateTemplate().findByNamedParam(
                "SELECT d, c, 'KICKOFF' " + kickQuery,
                new String[]{"ContactPerson"},
                new Object[]{ContactPerson}
        );

        // ---------------- MERGE BOTH ----------------
        List<Object[]> combinedList = new ArrayList<>();
        combinedList.addAll(kickList);

        return combinedList;

    }

    @Override
    public List readByProjectManagerTotalGraphUser(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        // ---------------- CRC QUERY (all data) ----------------
        String crcQuery = "FROM CrcForm b JOIN b.oapForm a WHERE a.projectCoordinater = :ContactPerson";

        if (Value != null && !Value.isEmpty()) {
            if (Value.equals("One")) {
                crcQuery += " AND b.flagStatus = 0";
            } else if (Value.equals("Two")) {
                crcQuery += " AND b.flagStatus = 1";
            }
        }

        if (Filter != null && !Filter.equals("")) {
            crcQuery += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            crcQuery += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        List<Object[]> crcList = (List<Object[]>) (List<?>) getHibernateTemplate().findByNamedParam(
                "SELECT b, a, 'CRC' " + crcQuery,
                new String[]{"ContactPerson"},
                new Object[]{ContactPerson}
        );

        List<Object[]> combinedList = new ArrayList<>();
        combinedList.addAll(crcList);
//        combinedList.addAll(kickList);

        return combinedList;
    }

    @Override
    public List readByprojectCoorGraphUserPendingCRC(String ContactPerson, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String OapQuery = "FROM OapForm a "
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
    public List readByProjectManagerTotalGraphUser1(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        // ---------------- KICKOFF QUERY (all data) ----------------
        String kickQuery = "FROM KickOffForm d JOIN d.aocForm c WHERE c.projectCoordinater = :ContactPerson";

        if (Value != null && !Value.isEmpty()) {
            if (Value.equals("One")) {
                kickQuery += " AND d.flagStatus = 0";
            } else if (Value.equals("Two")) {
                kickQuery += " AND d.flagStatus IN (1,4)";
            }
        }

        if (Filter != null && !Filter.equals("")) {
            kickQuery += " AND (STR_TO_DATE(c.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            kickQuery += " AND (STR_TO_DATE(c.createdDate,'%d/%m/%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d/%m/%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d/%m/%Y'))";
        }

        List<Object[]> kickList = (List<Object[]>) (List<?>) getHibernateTemplate().findByNamedParam(
                "SELECT d, c, 'KICKOFF' " + kickQuery,
                new String[]{"ContactPerson"},
                new Object[]{ContactPerson}
        );

        // ---------------- MERGE BOTH ----------------
        List<Object[]> combinedList = new ArrayList<>();
//        combinedList.addAll(crcList);
        combinedList.addAll(kickList);

        return combinedList;
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
                + " FROM OapForm a "
                + " WHERE STR_TO_DATE(a.createdDate,'%d/%m/%Y') >= STR_TO_DATE('" + from_date5 + "', '%d/%m/%Y') "
                + " AND ( "
                + "     a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "     OR a.partiallyApproveFlag IN (1,12) "
                + " ) "
                + " GROUP BY DATE_FORMAT(STR_TO_DATE(a.createdDate,'%d/%m/%Y'), '%Y-%m') "
                + " ORDER BY STR_TO_DATE(a.createdDate,'%d/%m/%Y') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List noOfChargerDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM OapForm a WHERE "
                + "(a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR a.partiallyApproveFlag IN (1,12)) ";

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y') ";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                    + " STR_TO_DATE('" + formattedStartDate + "', '%d/%m/%Y') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d/%m/%Y') ";
        }

        query += " AND a.noOfCharger IS NOT NULL AND a.noOfCharger <> '' ";
        query += " ORDER BY a.documentNo DESC";

        List<Object[]> list = (List<Object[]>) (List<?>) getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List totalChargerCapacityDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM OapForm a WHERE "
                + "(a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR a.partiallyApproveFlag IN (1,12)) ";

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
    public List totalKwRatingDetailsOap(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM OapForm a WHERE "
                + "(a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR a.partiallyApproveFlag IN (1,12)) ";

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
    public List readByMonthWiseEthanBurification(String from_date5) {

        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM oap_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Ethan' "
                + "AND (flag_status IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR partially_approve_flag IN (1,12)) "
                + "GROUP BY anchore_customer, DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";

        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;

    }

    @Override
    public List readByMonthWiseEquaBurification(String from_date5) {

        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM oap_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Equator' "
                + "AND (flag_status IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR partially_approve_flag IN (1,12)) "
                + "GROUP BY anchore_customer, DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";

        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;

    }

    @Override
    public List readByMonthWiseHubBurification(String from_date5) {

        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM oap_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Hub' "
                + "AND (flag_status IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR partially_approve_flag IN (1,12)) "
                + "GROUP BY anchore_customer, DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";

        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;

    }

    @Override
    public List readByMonthWiseCapexBurification(String from_date5) {

        String sql
                = "SELECT anchore_customer, COUNT(*), "
                + "DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'),'%b-%y') AS month "
                + "FROM oap_form "
                + "WHERE STR_TO_DATE(created_date,'%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') "
                + "AND tenant = 'Co Capex OEM' "
                + "AND (flag_status IN (4,5,6,7,8,9,10,11,12,13,14) "
                + "OR partially_approve_flag IN (1,12)) "
                + "GROUP BY anchore_customer, DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') "
                + "ORDER BY DATE_FORMAT(STR_TO_DATE(created_date,'%d/%m/%Y'), '%Y-%m') ASC";

        List<?> list = getHibernateTemplate().execute(session -> {
            org.hibernate.SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, from_date5);
            return query.list();
        });

        return list;

    }

    @Override
    public OapForm readByprojCoordAndDeliFalgOne(String ProjectCodinator, int id) {

        OapForm oapForm = new OapForm();

        String query = "";
        query += "SELECT a FROM OapForm a, DeliverableMulti b"
                + " WHERE a.projectCoordinater = '" + ProjectCodinator + "'"
                + " AND b.id = '" + id + "'"
                + " AND b.flagStatus = 1";

        List list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            oapForm = (OapForm) list.get(0);
        }
        return oapForm;

    }

    @Override
    public List<OapForm> oapEthanWiseClick(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String label, String count, String MonthName1) {

        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT * ");
        sql.append(" FROM oap_form c ");
        sql.append(" WHERE c.tenant = 'Ethan' ");
        sql.append(" AND c.anchore_customer = :label ");

        sql.append(" AND DATE_FORMAT( ");
        sql.append(" STR_TO_DATE(c.created_date,'%d/%m/%Y'), ");
        sql.append(" '%b-%y') = :month ");

        sql.append(" AND ( ");
        sql.append(" c.flag_status IN (4,5,6,7,8,9,10,11,12,13,14) ");
        sql.append(" OR c.partially_approve_flag IN (1,12) ");
        sql.append(" ) ");

        if (Filter != null && !Filter.trim().isEmpty()) {

            sql.append(" AND STR_TO_DATE(c.created_date,'%d/%m/%Y') ");
            sql.append(" BETWEEN ");
            sql.append(" STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') ");
            sql.append(" AND ");
            sql.append(" STR_TO_DATE(:formattedDate, '%d/%m/%Y') ");
        }

        if (StartDate != null
                && !StartDate.trim().isEmpty()
                && EndDate != null
                && !EndDate.trim().isEmpty()) {

            sql.append(" AND STR_TO_DATE(c.created_date,'%d/%m/%Y') ");
            sql.append(" BETWEEN ");
            sql.append(" STR_TO_DATE(:startDate, '%d/%m/%Y') ");
            sql.append(" AND ");
            sql.append(" STR_TO_DATE(:endDate, '%d/%m/%Y') ");
        }

        sql.append(" ORDER BY ");
        sql.append(" STR_TO_DATE(c.created_date,'%d/%m/%Y') ASC ");

        final String finalSql = sql.toString();

        List<OapForm> list = (List<OapForm>) getHibernateTemplate().execute(session -> {

            org.hibernate.SQLQuery query = session.createSQLQuery(finalSql);

            query.addEntity(OapForm.class);

            query.setParameter("label", label);

            query.setParameter("month", MonthName1);

            if (Filter != null && !Filter.trim().isEmpty()) {

                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            if (StartDate != null
                    && !StartDate.trim().isEmpty()
                    && EndDate != null
                    && !EndDate.trim().isEmpty()) {

                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
            }

            return query.list();
        });

        return list;
    }

    @Override
    public List readByrejectedOapDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM OapForm a "
                + "WHERE a.flagStatus IN (3) ";

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
    public List readByunfieldCRCDashboadDateformateDashBoard(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "FROM OapForm a "
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
    public List getOapCretedUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, a.flagStatus "
                    + "FROM OapForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (8, 9, 10, 100) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR (a.flagStatus = 0  AND lower('save as draft')      LIKE :search) "
                        + "OR (a.flagStatus = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle')            LIKE :search) "
                        + "OR (a.flagStatus = 3  AND lower('rejected')           LIKE :search) "
                        + "OR (a.flagStatus = 5  AND lower('rejected crc')       LIKE :search) "
                        + "OR (a.flagStatus = 14 AND lower('reverse approved')   LIKE :search) "
                        + "OR ((a.flagStatus = 4  OR a.flagStatus = 6  OR a.flagStatus = 7 "
                        + "  OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "  AND lower('approved') LIKE :search) "
                        + ")";
            }

            if (orderColumn != null && !orderColumn.trim().isEmpty()) {
                hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "asc");
            } else {
                hql += " ORDER BY a.id desc";
            }

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
    public int getTotalOapCretedUserCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
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
    public int getFilteredOapCretedUserCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE a.userId = :username "
                    + "AND a.flagStatus NOT IN (8, 9, 10, 100) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR (a.flagStatus = 0  AND lower('save as draft')      LIKE :search) "
                        + "OR (a.flagStatus = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle')            LIKE :search) "
                        + "OR (a.flagStatus = 3  AND lower('rejected')           LIKE :search) "
                        + "OR (a.flagStatus = 5  AND lower('rejected crc')       LIKE :search) "
                        + "OR (a.flagStatus = 14 AND lower('reverse approved')   LIKE :search) "
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
    public List getOAPExectiveHeadPagination(int start, int length, String searchValue, int executive, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, a.flagStatus "
                    + "FROM OapForm a "
                    + " WHERE  a.flagStatus =4"
                    + " And a.assignedName =''";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
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
    public int getTotalOAPExectiveHeadCount(int executive) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
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
    public int getFilteredOAPExectiveHeadCount(int executive, String searchValue) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + " WHERE  a.flagStatus =4"
                    + " And a.assignedName =''";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
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

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate "
                    + "FROM OapForm a "
                    + " WHERE a.assignedName = '" + username + "'"
                    + " AND a.flagStatus = 4";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
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
    public int getTotalassignedNameCount(String username) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
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
                    + "FROM OapForm a "
                    + " WHERE a.assignedName = '" + username + "'"
                    + " AND a.flagStatus = 4";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
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
    public List getCrcPartiallyApprovePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, c.id "
                    + " FROM OapForm a, CrcForm c"
                    + " WHERE a.id = c.oapForm.id "
                    + " AND a.assignedName = :username"
                    + " AND c.flagStatus = 800";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)               LIKE :search "
                        + "OR lower(a.pcsName)                  LIKE :search "
                        + "OR lower(str(a.projectName))          LIKE :search "
                        + "OR lower(a.department)               LIKE :search "
                        + "OR lower(str(a.createdDate))          LIKE :search "
                        + ")";
            }

            if (orderColumn != null && !orderColumn.trim().isEmpty()) {
                hql += " ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "asc");
            } else {
                hql += " ORDER BY a.id desc";
            }

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
    public int getTotalCrcPartiallyApproveCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM OapForm a, CrcForm c"
                    + " WHERE a.id = c.oapForm.id "
                    + " AND a.assignedName = :username"
                    + " AND c.flagStatus = 800";

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
    public int getFilteredCrcPartiallyApproveCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM OapForm a, CrcForm c"
                    + " WHERE a.id = c.oapForm.id "
                    + " AND a.assignedName = :username"
                    + " AND c.flagStatus = 800";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)               LIKE :search "
                        + "OR lower(a.pcsName)                  LIKE :search "
                        + "OR lower(str(a.projectName))          LIKE :search "
                        + "OR lower(a.department)               LIKE :search "
                        + "OR lower(str(a.createdDate))          LIKE :search "
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
        return count != null ? count.intValue() : 0;
    }

    @Override
    public List getOapDesignTeamPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, a.flagStatus, a.partiallyApproveFlag, a.surveyRadio, a.userId "
                    + " FROM OapForm a"
                    + " WHERE ("
                    + "   (a.flagStatus = 7  AND a.partiallyApproveFlag IN (1, 11, 12)) "
                    + "OR (a.flagStatus = 14 AND a.partiallyApproveFlag IN (1, 12)) "
                    + "OR (a.flagStatus = 3  AND a.partiallyApproveFlag IN (12)) "
                    + "OR (a.flagStatus = 4  AND a.partiallyApproveFlag IN (12)) "
                    + ") "
                    + "AND a.flagStatus NOT IN (8, 9, 10) "
                    + "AND a.partiallyApproveFlag NOT IN (15) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(str(a.createdDate)) LIKE :search "
                        + "OR (a.flagStatus = 7  AND a.partiallyApproveFlag IN (1, 11, 12) AND lower('approved') LIKE :search) "
                        + "OR (a.flagStatus = 14 AND a.partiallyApproveFlag IN (1, 12)     AND lower('approved') LIKE :search) "
                        + "OR (a.flagStatus = 3  AND a.partiallyApproveFlag IN (12)        AND lower('approved') LIKE :search) "
                        + "OR (a.flagStatus = 4  AND a.partiallyApproveFlag IN (12)        AND lower('approved') LIKE :search) "
                        + "OR (a.partiallyApproveFlag = 13 AND lower('deliverable rejected') LIKE :search) "
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
    public int getTotalOapDesignTeamCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM OapForm a"
                    + " WHERE ("
                    + "   (a.flagStatus = 7  AND a.partiallyApproveFlag IN (1, 11, 12)) "
                    + "OR (a.flagStatus = 14 AND a.partiallyApproveFlag IN (1, 12)) "
                    + "OR (a.flagStatus = 3  AND a.partiallyApproveFlag IN (12)) "
                    + "OR (a.flagStatus = 4  AND a.partiallyApproveFlag IN (12)) "
                    + ") "
                    + "AND a.flagStatus NOT IN (8, 9, 10) "
                    + "AND a.partiallyApproveFlag NOT IN (15) ";

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
    public int getFilteredOapDesignTeamCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + " FROM OapForm a"
                    + " WHERE ("
                    + "   (a.flagStatus = 7  AND a.partiallyApproveFlag IN (1, 11, 12)) "
                    + "OR (a.flagStatus = 14 AND a.partiallyApproveFlag IN (1, 12)) "
                    + "OR (a.flagStatus = 3  AND a.partiallyApproveFlag IN (12)) "
                    + "OR (a.flagStatus = 4  AND a.partiallyApproveFlag IN (12)) "
                    + ") "
                    + "AND a.flagStatus NOT IN (8, 9, 10) "
                    + "AND a.partiallyApproveFlag NOT IN (15) ";

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(str(a.createdDate)) LIKE :search "
                        + "OR (a.flagStatus = 7  AND a.partiallyApproveFlag IN (1, 11, 12) AND lower('approved') LIKE :search) "
                        + "OR (a.flagStatus = 14 AND a.partiallyApproveFlag IN (1, 12)     AND lower('approved') LIKE :search) "
                        + "OR (a.flagStatus = 3  AND a.partiallyApproveFlag IN (12)        AND lower('approved') LIKE :search) "
                        + "OR (a.flagStatus = 4  AND a.partiallyApproveFlag IN (12)        AND lower('approved') LIKE :search) "
                        + "OR (a.partiallyApproveFlag = 13 AND lower('deliverable rejected') LIKE :search) "
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
    public List getOapProjectmanagerPagination(int start, int length, String searchValue,
            String username, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.createdDate, a.flagStatus, "
                    + "(SELECT b.id FROM CrcForm b WHERE a.id = b.oapForm.id), "
                    + "(SELECT b.flagStatus FROM CrcForm b WHERE a.id = b.oapForm.id) "
                    + "FROM OapForm a "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND a.flagStatus IN (7, 14) "
                    + "AND ( "
                    + "  NOT EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z WHERE z.oapId = a.id "
                    + "  ) "
                    + "  OR EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z "
                    + "    WHERE z.oapId = a.id "
                    + "    AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                    + "    AND a.flagStatus NOT IN (8, 9, 10) "
                    + "  ) "
                    + ") ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "   lower(a.documentNo)          LIKE :search "
                        + "OR lower(a.pcsName)             LIKE :search "
                        + "OR lower(a.projectName)         LIKE :search "
                        + "OR lower(str(a.createdDate))    LIKE :search "
                        + ")";
            }

            hql += " ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("username", username);   // ← was missing
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
    public int getTotalOapProjectmanagerCount(String username) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND a.flagStatus IN (7, 14) "
                    + "AND ( "
                    + "  NOT EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z WHERE z.oapId = a.id "
                    + "  ) "
                    + "  OR EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z "
                    + "    WHERE z.oapId = a.id "
                    + "    AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                    + "    AND a.flagStatus NOT IN (8, 9, 10) "
                    + "  ) "
                    + ") ";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);   // ← was missing
            count = (Long) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count != null ? count.intValue() : 0;
    }

    @Override
    public int getFilteredOapProjectmanagerCount(String username, String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND a.flagStatus IN (7, 14) "
                    + "AND ( "
                    + "  NOT EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z WHERE z.oapId = a.id "
                    + "  ) "
                    + "  OR EXISTS ( "
                    + "    SELECT 1 FROM DeliverableMulti z "
                    + "    WHERE z.oapId = a.id "
                    + "    AND (z.flagStatus IS NULL OR z.flagStatus <> 6) "
                    + "    AND a.flagStatus NOT IN (8, 9, 10) "
                    + "  ) "
                    + ") ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "   lower(a.documentNo)          LIKE :search "
                        + "OR lower(a.pcsName)             LIKE :search "
                        + "OR lower(a.projectName)         LIKE :search "
                        + "OR lower(str(a.createdDate))    LIKE :search "
                        + ")";
            }

            Query query = session.createQuery(hql);
            query.setParameter("username", username);   // ← was missing
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
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.mobileNo, "
                    + "a.department, a.createdDate, a.userId, a.flagStatus, "
                    + "b.id, b.flagStatus, "
                    + "c.id, c.documentNo "
                    + "FROM OapForm a, DeliverableMulti b, CrcForm c "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND b.flagStatus = 1 "
                    + "AND a.id = b.oapId "
                    + "AND c.documentNo IS NOT NULL "
                    + "AND a.id = c.oapForm "
                    + "AND b.flagStatus <> 5 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(c.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.mobileNo)    LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.userId)      LIKE :search "
                        + ") ";
            }

            hql += "ORDER BY a.id " + (orderDir != null ? orderDir : "desc");

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
                    + "FROM OapForm a, DeliverableMulti b, CrcForm c "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND b.flagStatus = 1 "
                    + "AND a.id = b.oapId "
                    + "AND c.documentNo IS NOT NULL "
                    + "AND a.id = c.oapForm "
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
                    + "FROM OapForm a, DeliverableMulti b, CrcForm c "
                    + "WHERE a.projectCoordinater = :username "
                    + "AND b.flagStatus = 1 "
                    + "AND a.id = b.oapId "
                    + "AND c.documentNo IS NOT NULL "
                    + "AND a.id = c.oapForm "
                    + "AND b.flagStatus <> 5 ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(c.documentNo)  LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.mobileNo)    LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.userId)      LIKE :search "
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
    public List getNetworkTeamPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.mobileNo, "
                    + "a.department, a.createdDate, a.userId, a.flagStatus "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus IN (7, 11, 12, 13) ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.mobileNo)    LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.userId)      LIKE :search "
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
    public int getTotalNetworkTeamCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
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
    public int getFilteredNetworkTeamCount(String searchValue) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus IN (7, 11, 12, 13) ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.mobileNo)    LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.userId)      LIKE :search "
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
    public List getOapReportPagination(int start, int length, String searchValue, String oapdocumentNumber, String projectName, String fromDate, String toDate, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String sql = "SELECT a.id, a.document_no, a.pcs_name, a.project_name, a.department, a.created_date, a.flag_status, IFNULL(b.flag_status, '') AS crc_flag_status, a.partially_approve_flag, "
                    + "a.time_line_from_date, a.time_line_to_date, a.charging_rate_per_unit, "
                    + "a.no_of_charger, a.no_of_charge_points, a.overall_capacity "
                    + "FROM oap_form a "
                    + "LEFT JOIN crc_form b ON a.document_no = b.oap_number "
                    + "WHERE 1 = 1 ";

            if (oapdocumentNumber != null && !oapdocumentNumber.trim().equals("")) {
                sql += " AND lower(a.document_no) LIKE :oapdocumentNumber ";
            }

            if (projectName != null && !projectName.trim().equals("")) {
                sql += " AND lower(a.project_name) LIKE :projectName ";
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
                sql += "AND ("
                        + "  lower(a.document_no)   LIKE :search "
                        + "OR lower(a.pcs_name)     LIKE :search "
                        + "OR lower(a.project_name) LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR lower(a.created_date)  LIKE :search "
                        + "OR lower(a.time_line_from_date)  LIKE :search "
                        + "OR lower(a.time_line_to_date)  LIKE :search "
                        + "OR lower(a.charging_rate_per_unit)  LIKE :search "
                        + "OR lower(a.no_of_charger)  LIKE :search "
                        + "OR lower(a.no_of_charge_points)  LIKE :search "
                        + "OR lower(a.overall_capacity)  LIKE :search "
                        + "OR (a.flag_status = 0  AND lower('save as draft') LIKE :search) "
                        + "OR (a.flag_status = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flag_status = 2  AND lower('recycle') LIKE :search) "
                        + "OR (a.flag_status = 3  AND lower('rejected') LIKE :search) "
                        + "OR (a.flag_status = 5  AND lower('rejected crc') LIKE :search) "
                        + "OR (a.flag_status = 14 AND lower('Approved') LIKE :search) "
                        + "OR (a.flag_status = 100 AND lower('OAP Deleted') LIKE :search) "
                        + "OR ((a.flag_status = 4  OR a.flag_status = 6  OR a.flag_status = 7 "
                        + "OR a.flag_status = 11 OR a.flag_status = 12 OR a.flag_status = 13) AND lower('approved') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 0  AND lower('pending to approve') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 3  AND lower('rejected') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 10 AND lower('rework') LIKE :search) "
                        + "OR ((IFNULL(b.flag_status, -1) = 4 OR IFNULL(b.flag_status, -1) = 1) AND lower('approved') LIKE :search) "
                        + "OR ((IFNULL(b.flag_status, -1) = 2 OR IFNULL(b.flag_status, -1) = 800) AND lower('partially approved') LIKE :search) "
                        + ") ";
            }

            sql += "ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            SQLQuery query = session.createSQLQuery(sql);

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            if (oapdocumentNumber != null && !oapdocumentNumber.equals("")) {
                query.setParameter("oapdocumentNumber", "%" + oapdocumentNumber.toLowerCase() + "%");
            }

            if (projectName != null && !projectName.equals("")) {
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
    public int getTotalOapReportCount() {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM oap_form a "
                    + "LEFT JOIN crc_form b ON a.document_no = b.oap_number "
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
    public int getFilteredOapReportCount(String searchValue, String oapdocumentNumber, String projectName, String fromDate, String toDate) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String sql = "SELECT COUNT(a.id) "
                    + "FROM oap_form a "
                    + "LEFT JOIN crc_form b ON a.document_no = b.oap_number "
                    + "WHERE 1 = 1 ";

            if (oapdocumentNumber != null && !oapdocumentNumber.trim().equals("")) {
                sql += " AND lower(a.document_no) LIKE :oapdocumentNumber ";
            }

            if (projectName != null && !projectName.trim().equals("")) {
                sql += " AND lower(a.project_name) LIKE :projectName ";
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
                sql += "AND ("
                        + "  lower(a.document_no)   LIKE :search "
                        + "OR lower(a.pcs_name)     LIKE :search "
                        + "OR lower(a.project_name) LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR lower(a.created_date)  LIKE :search "
                        + "OR lower(a.time_line_from_date)  LIKE :search "
                        + "OR lower(a.time_line_to_date)  LIKE :search "
                        + "OR lower(a.charging_rate_per_unit)  LIKE :search "
                        + "OR lower(a.no_of_charger)  LIKE :search "
                        + "OR lower(a.no_of_charge_points)  LIKE :search "
                        + "OR lower(a.overall_capacity)  LIKE :search "
                        + "OR (a.flag_status = 0  AND lower('save as draft') LIKE :search) "
                        + "OR (a.flag_status = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flag_status = 2  AND lower('recycle') LIKE :search) "
                        + "OR (a.flag_status = 3  AND lower('rejected') LIKE :search) "
                        + "OR (a.flag_status = 5  AND lower('rejected crc') LIKE :search) "
                        + "OR (a.flag_status = 14 AND lower('Approved') LIKE :search) "
                        + "OR (a.flag_status = 100 AND lower('OAP Deleted') LIKE :search) "
                        + "OR ((a.flag_status = 4  OR a.flag_status = 6  OR a.flag_status = 7 "
                        + "OR a.flag_status = 11 OR a.flag_status = 12 OR a.flag_status = 13) AND lower('approved') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 0  AND lower('pending to approve') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 3  AND lower('rejected') LIKE :search) "
                        + "OR (IFNULL(b.flag_status, -1) = 10 AND lower('rework') LIKE :search) "
                        + "OR ((IFNULL(b.flag_status, -1) = 4 OR IFNULL(b.flag_status, -1) = 1) AND lower('approved') LIKE :search) "
                        + "OR ((IFNULL(b.flag_status, -1) = 2 OR IFNULL(b.flag_status, -1) = 800) AND lower('partially approved') LIKE :search) "
                        + ") ";
            }

            SQLQuery query = session.createSQLQuery(sql);

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            if (oapdocumentNumber != null && !oapdocumentNumber.equals("")) {
                query.setParameter("oapdocumentNumber", "%" + oapdocumentNumber.toLowerCase() + "%");
            }

            if (projectName != null && !projectName.equals("")) {
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
    public List getMonthWiseGraphPagination(int start, int length, String searchValue, String StartDate, String EndDate, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();

        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE('" + StartDate + "', '%d/%m/%Y') "
                        + "AND STR_TO_DATE('" + EndDate + "', '%d/%m/%Y'))";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
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
    public int getMonthWiseGraphCount(String StartDate, String EndDate) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;

        try {
            String hql = "SELECT count(a.id) "
                    + "FROM OapForm a WHERE "
                    + "(a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
    public int getFilteredMonthWiseGraphCount(String search, String StartDate, String EndDate) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;

        try {
            String hql = "SELECT count(a.id) "
                    + "FROM OapForm a WHERE "
                    + "(a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
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
    public List getProjectCoordinatorGraphUserPagination(int start, int length, String searchValue,
            String orderColumn, String orderDir, String ContactPerson, String Value,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, b.id, b.documentNo, b.pcsName, b.userid, b.designation  "
                    + "FROM CrcForm b JOIN b.oapForm a "
                    + "WHERE a.assignedName = :contactPerson "
                    + "AND b.flagStatus NOT IN (5, 6, 7) ";

            // Value filter
            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND b.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND b.flagStatus = 1 ";
                } else if (Value.equals("Three")) {
                    hql += "AND b.flagStatus = 4 ";
                }
            }

            // Filter (quick date filter)
            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            // From/To date filter
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += "AND (STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            // Search filter
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(b.documentNo)   LIKE :search "
                        + "OR lower(b.pcsName)   LIKE :search "
                        + "OR lower(b.userid)     LIKE :search "
                        + "OR lower(b.designation) LIKE :search "
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
    public int getProjectCoordinatorGraphUserCount(String ContactPerson, String Value,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(b.id) "
                    + "FROM CrcForm b JOIN b.oapForm a "
                    + "WHERE a.assignedName = :contactPerson "
                    + "AND b.flagStatus NOT IN (5, 6, 7) ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND b.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND b.flagStatus = 1 ";
                } else if (Value.equals("Three")) {
                    hql += "AND b.flagStatus = 4 ";
                }
            }

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
    public int getProjectCoordinatorGraphUserCount(String searchValue, String ContactPerson,
            String Value, String Fromdate, String Todate, String Filter,
            String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(b.id) "
                    + "FROM CrcForm b JOIN b.oapForm a "
                    + "WHERE a.assignedName = :contactPerson "
                    + "AND b.flagStatus NOT IN (5, 6, 7) ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND b.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND b.flagStatus = 1 ";
                } else if (Value.equals("Three")) {
                    hql += "AND b.flagStatus = 4 ";
                }
            }

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

            // Search filter
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(b.documentNo)   LIKE :search "
                        + "OR lower(b.pcsName)   LIKE :search "
                        + "OR lower(b.userid)     LIKE :search "
                        + "OR lower(b.designation) LIKE :search "
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
    public List getProjectCoordinatorGraphUser1Pagination(int start, int length, String searchValue,
            String orderColumn, String orderDir, String ContactPerson, String Value,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT d.id, d.documentNo, d.hubLocation, d.userId, d.designation, c.assignedName, c.createdDate "
                    + "FROM KickOffForm d JOIN d.aocForm c "
                    + "WHERE c.assignedName = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += " AND d.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += " AND d.flagStatus IN (1,4) ";
                }
            }

            if (Filter != null && !Filter.isEmpty()
                    && formattedStartDate != null && !formattedStartDate.isEmpty()
                    && formattedDate != null && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(d.documentNo)   LIKE :search "
                        + "OR lower(d.hubLocation)  LIKE :search "
                        + "OR lower(d.userId)       LIKE :search "
                        + "OR lower(d.designation)  LIKE :search "
                        + "OR lower(c.assignedName) LIKE :search "
                        + "OR lower(c.createdDate)  LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY " + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()
                    && formattedStartDate != null && !formattedStartDate.isEmpty()
                    && formattedDate != null && !formattedDate.isEmpty()) {
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
    public int getProjectCoordinatorGraphUser1Count(String ContactPerson, String Value,
            String Fromdate, String Todate, String Filter,
            String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(d.id) "
                    + "FROM KickOffForm d JOIN d.aocForm c "
                    + "WHERE c.assignedName = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += " AND d.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += " AND d.flagStatus IN (1,4) ";
                }
            }

            if (Filter != null && !Filter.isEmpty()
                    && formattedStartDate != null && !formattedStartDate.isEmpty()
                    && formattedDate != null && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()
                    && formattedStartDate != null && !formattedStartDate.isEmpty()
                    && formattedDate != null && !formattedDate.isEmpty()) {
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
    public int getProjectCoordinatorGraphUser1Count(String searchValue, String ContactPerson,
            String Value, String Fromdate, String Todate, String Filter,
            String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(d.id) "
                    + "FROM KickOffForm d JOIN d.aocForm c "
                    + "WHERE c.assignedName = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += " AND d.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += " AND d.flagStatus IN (1,4) ";
                }
            }

            if (Filter != null && !Filter.isEmpty()
                    && formattedStartDate != null && !formattedStartDate.isEmpty()
                    && formattedDate != null && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(c.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:fromdate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:todate, '%d/%m/%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(d.documentNo)   LIKE :search "
                        + "OR lower(d.hubLocation)  LIKE :search "
                        + "OR lower(d.userId)       LIKE :search "
                        + "OR lower(d.designation)  LIKE :search "
                        + "OR lower(c.assignedName) LIKE :search "
                        + "OR lower(c.createdDate)  LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);
            query.setParameter("contactPerson", ContactPerson);

            if (Filter != null && !Filter.isEmpty()
                    && formattedStartDate != null && !formattedStartDate.isEmpty()
                    && formattedDate != null && !formattedDate.isEmpty()) {
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
    public List getProjectCoorGraphUserPendingCRCPagination(int start, int length, String searchValue,
            String orderColumn, String orderDir, String ContactPerson,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, "
                    + "a.department, a.createdDate, a.userId, a.designation "
                    + "FROM OapForm a "
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
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.designation)      LIKE :search "
                        + "OR lower(a.createdDate)      LIKE :search "
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
    public int getProjectCoorGraphUserPendingCRCCount(String ContactPerson,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
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
    public int getProjectCoorGraphUserPendingCRCCount(String searchValue, String ContactPerson,
            String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
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
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.designation)      LIKE :search "
                        + "OR lower(a.createdDate)      LIKE :search "
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
    public List getProjectManagerTotalGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT b.id, b.documentNo, b.pcsName, b.userid, b.designation, b.projectEngineer, "
                    + "b.flagStatus, a.id "
                    + "FROM CrcForm b JOIN b.oapForm a "
                    + "WHERE a.projectCoordinater = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND b.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND b.flagStatus = 1 ";
                }
            }

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
                        + "  lower(b.documentNo)  LIKE :search "
                        + "OR lower(b.pcsName)    LIKE :search "
                        + "OR lower(b.userid)     LIKE :search "
                        + "OR lower(b.designation) LIKE :search "
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
    public int getProjectManagerTotalGraphUserCount(String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(b.id) "
                    + "FROM CrcForm b JOIN b.oapForm a "
                    + "WHERE a.projectCoordinater = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND b.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND b.flagStatus = 1 ";
                }
            }

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
    public int getProjectManagerTotalGraphUserCount(String searchValue, String ContactPerson, String Value, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(b.id) "
                    + "FROM CrcForm b JOIN b.oapForm a "
                    + "WHERE a.projectCoordinater = :contactPerson ";

            if (Value != null && !Value.isEmpty()) {
                if (Value.equals("One")) {
                    hql += "AND b.flagStatus = 0 ";
                } else if (Value.equals("Two")) {
                    hql += "AND b.flagStatus = 1 ";
                }
            }

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
                        + "  lower(b.documentNo)  LIKE :search "
                        + "OR lower(b.pcsName)    LIKE :search "
                        + "OR lower(b.userid)     LIKE :search "
                        + "OR lower(b.designation) LIKE :search "
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
    public List getNoOfChargerDetailsOapPagination(int start, int length, String searchValue,
            String orderColumn, String orderDir, String StartDate, String EndDate,
            String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, "
                    + "a.department, a.createdDate, a.noOfCharger "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y') ";
            }

            hql += "AND a.noOfCharger IS NOT NULL "
                    + "AND a.noOfCharger <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.noOfCharger) LIKE :search "
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
    public int getNoOfChargerDetailsOapCount(String StartDate, String EndDate,
            String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y') ";
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
    public int getFilteredNoOfChargerDetailsOapCount(String searchValue, String StartDate,
            String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:startDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:endDate, '%d/%m/%Y') ";
            }

            if (Filter != null && !Filter.isEmpty()) {
                hql += "AND STR_TO_DATE(a.createdDate, '%d/%m/%Y') BETWEEN "
                        + "STR_TO_DATE(:formattedStartDate, '%d/%m/%Y') "
                        + "AND STR_TO_DATE(:formattedDate, '%d/%m/%Y') ";
            }

            hql += "AND a.noOfCharger IS NOT NULL "
                    + "AND a.noOfCharger <> '' ";

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += "AND ("
                        + "  lower(a.documentNo)   LIKE :search "
                        + "OR lower(a.pcsName)     LIKE :search "
                        + "OR lower(a.projectName) LIKE :search "
                        + "OR lower(a.department)  LIKE :search "
                        + "OR lower(a.noOfCharger) LIKE :search "
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
    public List getTotalChargerCapacityDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, "
                    + "a.department, a.createdDate, a.totalChargerCapacity "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
                        + "  lower(a.documentNo)            LIKE :search "
                        + "OR lower(a.pcsName)              LIKE :search "
                        + "OR lower(a.projectName)          LIKE :search "
                        + "OR lower(a.department)           LIKE :search "
                        + "OR lower(a.totalChargerCapacity) LIKE :search "
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
    public int getTotalChargerCapacityDetailsOapCount(String StartDate, String EndDate,
            String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
    public int getFilteredTotalChargerCapacityDetailsOapCount(String searchValue,
            String StartDate, String EndDate, String Filter,
            String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
                        + "  lower(a.documentNo)            LIKE :search "
                        + "OR lower(a.pcsName)              LIKE :search "
                        + "OR lower(a.projectName)          LIKE :search "
                        + "OR lower(a.department)           LIKE :search "
                        + "OR lower(a.totalChargerCapacity) LIKE :search "
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
    public List getTotalKwRatingDetailsOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, "
                    + "a.department, a.createdDate, a.totalKwRating "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
                        + "  lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)      LIKE :search "
                        + "OR lower(a.projectName)  LIKE :search "
                        + "OR lower(a.department)   LIKE :search "
                        + "OR lower(a.totalKwRating) LIKE :search "
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
    public int getTotalKwRatingDetailsOapCount(String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
    public int getFilteredTotalKwRatingDetailsOapCount(String searchValue, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) "
                    + "FROM OapForm a "
                    + "WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + "OR a.partiallyApproveFlag IN (1,12)) ";

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
                        + "  lower(a.documentNo)     LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR lower(a.totalKwRating) LIKE :search "
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
    public int countAllOap() {
        String query = "SELECT COUNT(*) FROM OapForm a"
                + " WHERE a.flagStatus  NOT IN (100,0)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByAllOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from OapForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List getOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, a.flagStatus "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus NOT IN (100,0)";

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
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR (a.flagStatus = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle')            LIKE :search) "
                        + "OR (a.flagStatus = 3  AND lower('rejected')           LIKE :search) "
                        + "OR (a.flagStatus = 5  AND lower('rejected crc')       LIKE :search) "
                        + "OR (a.flagStatus = 14 AND lower('reverse approved')   LIKE :search) "
                        + "OR (a.flagStatus = 8 AND lower('cancel project manager')   LIKE :search) "
                        + "OR (a.flagStatus = 9 AND lower('reject project manager')   LIKE :search) "
                        + "OR (a.flagStatus = 10 AND lower('close project manager')   LIKE :search) "
                        + "OR ((a.flagStatus = 4  OR a.flagStatus = 6  OR a.flagStatus = 7 "
                        + "  OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "  AND lower('approved') LIKE :search) "
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
    public int getTotalOapCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT count(a.id) "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus NOT IN (100,0)";

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
    public int getFilteredOapCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT count(a.id) "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus NOT IN (100,0)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + "   lower(a.documentNo)    LIKE :search "
                        + "OR lower(a.pcsName)       LIKE :search "
                        + "OR lower(a.projectName)   LIKE :search "
                        + "OR lower(a.department)    LIKE :search "
                        + "OR str(a.createdDate)     LIKE :search "
                        + "OR (a.flagStatus = 1  AND lower('pending to approve') LIKE :search) "
                        + "OR (a.flagStatus = 2  AND lower('recycle')            LIKE :search) "
                        + "OR (a.flagStatus = 3  AND lower('rejected')           LIKE :search) "
                        + "OR (a.flagStatus = 5  AND lower('rejected crc')       LIKE :search) "
                        + "OR (a.flagStatus = 14 AND lower('reverse approved')   LIKE :search) "
                        + "OR (a.flagStatus = 8 AND lower('cancel project manager')   LIKE :search) "
                        + "OR (a.flagStatus = 9 AND lower('reject project manager')   LIKE :search) "
                        + "OR (a.flagStatus = 10 AND lower('close project manager')   LIKE :search) "
                        + "OR ((a.flagStatus = 4  OR a.flagStatus = 6  OR a.flagStatus = 7 "
                        + "  OR a.flagStatus = 11 OR a.flagStatus = 12 OR a.flagStatus = 13) "
                        + "  AND lower('approved') LIKE :search) "
                        + ")";
            }

            Query query = session.createQuery(hql);

            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
        query += " FROM OapForm a"
                + " WHERE a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14)"
                + " OR a.partiallyApproveFlag IN (1,12) ";
        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from OapForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus IN (4,6,7,11,12,13) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (4,6,7,11,12,13)";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus IN (4,6,7,11,12,13) ";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getApprovedOapDashboadPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, "
                    + " a.flagStatus, a.partiallyApproveFlag "
                    + "FROM OapForm a "
                    + " WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + " OR a.partiallyApproveFlag IN (1,12)) ";

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
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
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
    public int getTotalApprovedOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a) FROM OapForm a "
                    + " WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + " OR a.partiallyApproveFlag IN (1,12)) ";

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
    public int getFilteredApprovedOapDashboadCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a) FROM OapForm a "
                    + " WHERE (a.flagStatus IN (4,5,6,7,8,9,10,11,12,13,14) "
                    + " OR a.partiallyApproveFlag IN (1,12)) ";

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
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
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
    public int readBypendingOap() {

        String query = "SELECT COUNT(*) "
                + "FROM OapForm a "
                + "WHERE a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                + "AND a.partiallyApproveFlag NOT IN (1,12)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();

    }

    @Override
    public int readBypendingOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        String query = "";
        query += "select COUNT(a) from OapForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + "AND a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                    + "AND a.partiallyApproveFlag NOT IN (1,12)";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                        + "AND a.partiallyApproveFlag NOT IN (1,12)";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                        + "AND a.partiallyApproveFlag NOT IN (1,12)";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getPendingOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, "
                    + " a.createdDate, a.flagStatus, a.partiallyApproveFlag "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                    + "AND a.partiallyApproveFlag NOT IN (1,12)";

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
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
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
    public int getTotalPendingOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a) FROM OapForm a "
                    + " WHERE a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                    + "AND a.partiallyApproveFlag NOT IN (1,12)";

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
    public int getFilteredPendingOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a) "
                    + " FROM OapForm a "
                    + " WHERE a.flagStatus NOT IN (0,3,4,5,6,7,8,9,10,11,12,13,14,100) "
                    + "AND a.partiallyApproveFlag NOT IN (1,12)";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
    public int readByrejctedOap() {

        String query = "SELECT COUNT(*) "
                + "FROM OapForm a "
                + "WHERE a.flagStatus =3";

        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();

    }

    @Override
    public int readByrejctedOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from OapForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + "AND a.flagStatus =3";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.flagStatus =3";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + "AND a.flagStatus =3";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getRejectedOapPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, a.flagStatus "
                    + "FROM OapForm a "
                    + "WHERE a.flagStatus IN (3) ";

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
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
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
    public int getTotalRejectedOapDashboadCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) FROM OapForm a "
                    + " WHERE  a.flagStatus IN (3) ";

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
    public int getFilteredRejectedOapDashboadCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) FROM OapForm a "
                    + " WHERE  a.flagStatus IN (3) ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }
            if (search != null && !search.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
            }
            Query query = session.createQuery(hql);
            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
    public int readByunfieldCRC() {
        String query = "SELECT COUNT(*) "
                + "FROM OapForm a "
                + " WHERE a.flagStatus =4"
                + " And a.assignedName =''";
        Long count = (Long) getHibernateTemplate().find(query).get(0);

        return count.intValue();
    }

    @Override
    public int readByunfieldCRCDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        String query = "";
        query += "select COUNT(a) from OapForm a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d/%m/%Y') and STR_TO_DATE('"
                    + formattedDate + "', '%d/%m/%Y'))"
                    + " AND a.flagStatus =4"
                    + " And a.assignedName =''";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus =4"
                        + " And a.assignedName =''";
            } else {
                query += " WHERE (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') and STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y'))"
                        + " AND a.flagStatus =4"
                        + " And a.assignedName =''";
                whereAdded = true;
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List getUnfilledCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT a.id, a.documentNo, a.pcsName, a.projectName, a.department, a.createdDate, a.flagStatus "
                    + "FROM OapForm a "
                    + " WHERE  a.flagStatus =4 "
                    + " And a.assignedName ='' ";

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
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
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
    public int getTotalUnfilledCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) FROM OapForm a "
                    + " WHERE a.flagStatus = 4 "
                    + " And a.assignedName ='' ";

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
    public int getFilteredUnfilledCrcCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        Session session = getSessionFactory().openSession();
        int result = 0;

        try {
            boolean hasPreset = Filter != null && !Filter.isEmpty() && !Filter.equals("--select--") && formattedStartDate != null && !formattedStartDate.isEmpty() && formattedDate != null && !formattedDate.isEmpty();

            boolean hasExplicitRange = Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty();

            String hql = "SELECT COUNT(a.id) FROM OapForm a "
                    + " WHERE a.flagStatus = 4 "
                    + " And a.assignedName ='' ";

            if (hasPreset) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + formattedStartDate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + formattedDate + "', '%d/%m/%Y')) ";
            } else if (hasExplicitRange) {
                hql += " AND (STR_TO_DATE(a.createdDate,'%d/%m/%Y') BETWEEN STR_TO_DATE('"
                        + Fromdate + "', '%d/%m/%Y') AND STR_TO_DATE('"
                        + Todate + "', '%d/%m/%Y')) ";
            }
            if (search != null && !search.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.documentNo) LIKE :search "
                        + " OR lower(a.pcsName) LIKE :search "
                        + " OR lower(a.projectName) LIKE :search "
                        + " OR lower(a.department) LIKE :search "
                        + " OR lower(a.createdDate) LIKE :search "
                        + ") ";
            }
            Query query = session.createQuery(hql);
            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
