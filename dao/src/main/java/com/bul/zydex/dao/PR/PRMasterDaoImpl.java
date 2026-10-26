/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.LiveTender;
import com.bul.zydex.model.PRMaster;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import static net.sf.dynamicreports.report.builder.DynamicReports.query;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class PRMasterDaoImpl<T> extends GenericsDAOImpl<T> implements PRMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return PRMaster.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.prNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List pendingPRList() {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=1"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public PRMaster readByPrNo(String pr_no) {
        PRMaster prMaster = new PRMaster();
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.prNo = '" + pr_no + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            prMaster = (PRMaster) list.get(0);
        }
        return prMaster;
    }

    @Override
    public List readByemployee(String employee_name) {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.contactPerson = '" + employee_name + "'"
                + " order by a.prNo desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readLog(String prNumber, String open_from_date, String open_to_date, String department, String projectName) {
        StringBuilder query = new StringBuilder(
                "SELECT a,b FROM PRMaster a, TenderMaster b WHERE 1=1"
        );

        Map<String, Object> params = new HashMap<>();

        if (prNumber != null && !prNumber.isEmpty()) {
            query.append(" AND LOWER(a.prNo) LIKE LOWER(:prNumber)");
            params.put("prNumber", "%" + prNumber + "%");
        }

        if (projectName != null && !projectName.isEmpty()) {
            query.append(" AND LOWER(a.title) LIKE LOWER(:projectName)");
            params.put("projectName", "%" + projectName + "%");
        }

        if (department != null && !department.isEmpty()) {
            query.append(" AND LOWER(a.department) LIKE LOWER(:department)");
            params.put("department", "%" + department + "%");
        }

        if (open_from_date != null && !open_from_date.isEmpty() && open_to_date != null && !open_to_date.isEmpty()) {

            query.append(
                    " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                    + "BETWEEN STR_TO_DATE(:openFromDate,'%d-%m-%Y') "
                    + "AND STR_TO_DATE(:openToDate,'%d-%m-%Y')"
            );

            params.put("openFromDate", open_from_date);
            params.put("openToDate", open_to_date);

        } else if (open_from_date != null && !open_from_date.isEmpty()) {

            query.append(
                    " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:openFromDate,'%d-%m-%Y')"
            );

            params.put("openFromDate", open_from_date);

        } else if (open_to_date != null && !open_to_date.isEmpty()) {

            query.append(
                    " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:openToDate,'%d-%m-%Y')"
            );

            params.put("openToDate", open_to_date);
        }

        query.append(" and a.prNo = b.prNo");
        query.append(" ORDER BY a.prNo DESC");

        return (List<PRMaster>) getHibernateTemplate()
                .execute(session -> {
                    Query q = session.createQuery(query.toString());

                    for (Map.Entry<String, Object> entry : params.entrySet()) {
                        q.setParameter(entry.getKey(), entry.getValue());
                    }

                    return q.list();
                });
    }

    @Override
    public List readLogOnlyPrMaster(String prNumber, String open_from_date, String open_to_date, String department, String projectName) {
        StringBuilder query = new StringBuilder(
                "SELECT a FROM PRMaster a WHERE 1=1"
        );

        Map<String, Object> params = new HashMap<>();

        if (prNumber != null && !prNumber.isEmpty()) {
            query.append(" AND LOWER(a.prNo) LIKE LOWER(:prNumber)");
            params.put("prNumber", "%" + prNumber + "%");
        }

        if (projectName != null && !projectName.isEmpty()) {
            query.append(" AND LOWER(a.title) LIKE LOWER(:projectName)");
            params.put("projectName", "%" + projectName + "%");
        }

        if (department != null && !department.isEmpty()) {
            query.append(" AND LOWER(a.department) LIKE LOWER(:department)");
            params.put("department", "%" + department + "%");
        }

        if (open_from_date != null && !open_from_date.isEmpty() && open_to_date != null && !open_to_date.isEmpty()) {

            query.append(
                    " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                    + "BETWEEN STR_TO_DATE(:openFromDate,'%d-%m-%Y') "
                    + "AND STR_TO_DATE(:openToDate,'%d-%m-%Y')"
            );

            params.put("openFromDate", open_from_date);
            params.put("openToDate", open_to_date);

        } else if (open_from_date != null && !open_from_date.isEmpty()) {

            query.append(
                    " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= "
                    + "STR_TO_DATE(:openFromDate,'%d-%m-%Y')"
            );

            params.put("openFromDate", open_from_date);

        } else if (open_to_date != null && !open_to_date.isEmpty()) {

            query.append(
                    " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') <= "
                    + "STR_TO_DATE(:openToDate,'%d-%m-%Y')"
            );

            params.put("openToDate", open_to_date);
        }

        query.append(" ORDER BY a.prNo DESC");

        return (List<PRMaster>) getHibernateTemplate()
                .execute(session -> {
                    Query q = session.createQuery(query.toString());

                    for (Map.Entry<String, Object> entry : params.entrySet()) {
                        q.setParameter(entry.getKey(), entry.getValue());
                    }

                    return q.list();
                });
    }

    @Override
    public List pendingPRList1(String username) {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.tenderCreaterId = '" + username + "' and (a.authorizeFlag=0 or a.authorizeFlag=1)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List pendingPRList2() {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=1 and a.tenderFlag=0";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List pendingPRListDashboard() {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE  a.authorizeFlag=1";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List prRecycleList(String username) {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=10 and  a.prAuthorizeUser = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List pendingPRListDashboad() {

        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=0 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List approvedPRListDashboad() {
        String query = "";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=1 or a.authorizeFlag=6 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List groupByProjectName() {

        String query = "SELECT COUNT(*) as count, a.title "
                + "FROM PRMaster a "
                + "GROUP BY a.title "
                + "ORDER BY COUNT(a.id) DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByMonthpr(String from_date1) {

        LocalDate today = LocalDate.now();                           // e.g. 2025-09-23
        LocalDate fromDate = today.minusMonths(11).withDayOfMonth(1); // 2024-10-01

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String from_date = fromDate.format(formatter);

        String query = "";
        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'),'%b-%y') "
                + " FROM PRMaster a "
                + " WHERE (a.authorizeFlag=1 OR a.authorizeFlag=6) "
                + " AND STR_TO_DATE(a.announceDate,'%d-%m-%Y') >= STR_TO_DATE('" + from_date + "', '%d-%m-%Y') "
                + " GROUP BY DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'), '%Y-%m') "
                + " ORDER BY STR_TO_DATE(a.announceDate,'%d-%m-%Y %T') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public int readByDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'";
            } else {
                query += " WHERE a.department ='" + Department + "'";
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByDateformate1(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " AND  a.authorizeFlag IN (0, 2,7, 10)";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " AND a.authorizeFlag IN (0, 2,7, 10)";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " AND a.authorizeFlag IN (0, 2,7, 10)";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'"
                        + " AND a.authorizeFlag IN (0, 2,7, 10)";
            } else {
                query += " WHERE a.department ='" + Department + "'"
                        + " AND a.authorizeFlag IN (0, 2,7, 10)";
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByDateformate2(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " And a.authorizeFlag IN (1, 6) ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.authorizeFlag IN (1, 6) ";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.authorizeFlag IN (1, 6) ";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'"
                        + " And a.authorizeFlag IN (1, 6) ";
            } else {
                query += " WHERE a.department ='" + Department + "'"
                        + " And a.authorizeFlag IN (1, 6) ";
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List readByDateformate3(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " And a.value is not null ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.value is not null ";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.value is not null ";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'"
                        + " And a.value is not null ";
            } else {
                query += " WHERE a.department ='" + Department + "'"
                        + " And a.value is not null ";
            }
        }

        return getHibernateTemplate().find(query);

    }

    @Override
    public int readByDateformate4(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " And a.tenderFlag=1 and a.authorizeFlag=1 ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.tenderFlag=1 and a.authorizeFlag=1 ";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.tenderFlag=1 and a.authorizeFlag=1 ";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'"
                        + " And a.tenderFlag=1 and a.authorizeFlag=1 ";
            } else {
                query += " WHERE a.department ='" + Department + "'"
                        + " And a.tenderFlag=1 and a.authorizeFlag=1 ";
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByDateformate5(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " And a.tenderFlag=0 and a.authorizeFlag=1 ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.tenderFlag=0 and a.authorizeFlag=1 ";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.tenderFlag=0 and a.authorizeFlag=1 ";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'"
                        + " And a.tenderFlag=0 and a.authorizeFlag=1 ";
            } else {
                query += " WHERE a.department ='" + Department + "'"
                        + " And a.tenderFlag=0 and a.authorizeFlag=1 ";
            }
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public int readByDateformate6(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from PRMaster a ";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))"
                    + " And a.authorizeFlag=1 ";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.authorizeFlag=1 ";
            } else {
                query += " WHERE (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))"
                        + " And a.authorizeFlag=1 ";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'"
                        + " And a.authorizeFlag=1 ";
            } else {
                query += " WHERE a.department ='" + Department + "'"
                        + " And a.authorizeFlag=1 ";
            }
        }
        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readyByflagzero() {
        String query = "SELECT COUNT(*)";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag IN (0, 2, 7, 10)";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByflagonesix() {
        String query = "SELECT COUNT(*)";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag IN (1, 6) ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByprtenderFlagone() {
        String query = "SELECT COUNT(*)";
        query += " FROM PRMaster a"
                + " WHERE a.tenderFlag=1 and a.authorizeFlag=1 ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readByprtenderFlagzero() {
        String query = "SELECT COUNT(*)";
        query += " FROM PRMaster a"
                + " WHERE a.tenderFlag=0 and a.authorizeFlag=1 ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int readbyflagone() {
        String query = "SELECT COUNT(*)";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=1 ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int countAllPr() {
        String query = "SELECT COUNT(*) FROM PRMaster a ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int countRejectedPr() {
        String query = "SELECT COUNT(*)";
        query += " FROM PRMaster a"
                + " WHERE a.authorizeFlag=3 ";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    // INDIVIDUAL USER FILTERATIO STARTS FROM HERE
    //1
    @Override
    public int readByflagonesixFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += " SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "') AND a.authorizeFlag IN (1, 6)";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            } else {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
                whereAdded = true;
            }
        }

        if (!Department.equals("")) {
            query += " AND a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate()
                .find(query)
                .get(0);

        return count.intValue();

    }

    //2
    @Override
    public int countRejectedPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += " SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "') AND a.authorizeFlag IN (3)";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            } else {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
                whereAdded = true;
            }
        }

        if (!Department.equals("")) {
            query += " AND a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate()
                .find(query)
                .get(0);

        return count.intValue();

    }

    //3
    @Override
    public int readByprtenderFlagoneFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += " SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "') AND  a.tenderFlag = 1 AND a.authorizeFlag = 1";

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (!Fromdate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate()
                .find(query)
                .get(0);

        return count.intValue();
    }

// 4
    @Override
    public int readByprtenderFlagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += " SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "') AND  a.tenderFlag = 0 AND a.authorizeFlag = 1";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "(STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            whereAdded = true;
        }

        if (!Department.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate()
                .find(query)
                .get(0);

        return count.intValue();
    }

    //5
    @Override
    public int readbyflagoneFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += " SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')  AND a.authorizeFlag = 1";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "(STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            whereAdded = true;
        }

        if (!Department.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate()
                .find(query)
                .get(0);

        return count.intValue();
    }

    //6
    @Override
    public int countAllPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "(STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            whereAdded = true;
        }

        if (!Department.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate()
                .find(query)
                .get(0);

        return count.intValue();

    }

    @Override
    public int readyByflagzeroFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";
        query += " SELECT COUNT(*) FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "') AND a.authorizeFlag = 0 ";

        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "(STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            whereAdded = true;
        }

        if (!Department.equals("")) {
            query += (whereAdded ? " AND " : " AND ") + "a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public List monthWiseListPrFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";
        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.announceDate,'%d-%m-%Y %T'),'%b-%y') ";
        query += " FROM PRMaster a WHERE (a.authorizeFlag = 1 OR a.authorizeFlag = 6)";

        if (!Filter.equals("--select--")) {
            query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s') ";
        }

        if (!Fromdate.equals("") && !Todate.equals("")) {
            if (query.contains("WHERE")) {
                query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                        + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y') ";
            } else {
                query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                        + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y') ";
            }
        }

        if (!Department.equals("--select--")) {
            if (query.contains("WHERE")) {
                query += " AND a.department = '" + Department + "' ";
            } else {
                query += " AND a.department = '" + Department + "' ";
            }
        }

        query += " GROUP BY DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'), '%M-%Y')";
        query += " ORDER BY DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'), '%M-%Y') DESC";

        query += " ORDER BY a.announceDate DESC";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public int countRejectedPrFilter(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";
        query += "select COUNT(a) from PRMaster a WHERE a.authorizeFlag=3";
        boolean whereAdded = false;

        if (!Filter.equals("--select--")) {
            query += " And (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') and STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
            whereAdded = true;
        }

        if (!Fromdate.equals("")) {
            if (whereAdded) {
                query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
            } else {
                query += " And (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') and STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
                whereAdded = true;
            }
        }

        if (!Department.equals("--select--")) {
            if (whereAdded) {
                query += " AND a.department ='" + Department + "'";
            } else {
                query += " And a.department ='" + Department + "'";
            }
        }
        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List monthWiseListPrFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";
        query += " SELECT count(*), DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'),'%b-%y') ";

        query += " FROM PRMaster a WHERE (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "') "
                + " AND (a.authorizeFlag = 1 OR a.authorizeFlag = 6) ";

        if (!Filter.equals("--select--")) {
            query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + " AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s') ";
        }

        if (!Fromdate.equals("") && !Todate.equals("")) {
            query += " AND STR_TO_DATE(a.announceDate, '%d-%m-%Y') BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + " AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y') ";
        }

        if (!Department.equals("")) {
            query += " AND a.department = '" + Department + "' ";
        }

        query += " GROUP BY DATE_FORMAT(STR_TO_DATE(a.announceDate, '%d-%m-%Y %T'), '%Y-%m') ";
        query += " ORDER BY STR_TO_DATE(a.announceDate, '%d-%m-%Y %T') ASC";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List monthWiseListPrGraphUser(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "";

        query += "  FROM PRMaster a WHERE (a.authorizeFlag = 1 OR a.authorizeFlag = 6)";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + StartDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + EndDate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }
        query += " ORDER BY a.prNo DESC";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readBycontactperFilterUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = "";

        query += "SELECT a.tenderCreaterId, "
                + "COUNT(a), "
                + "SUM(CASE WHEN a.tenderFlag = 0 THEN 1 ELSE 0 END), "
                + "SUM(CASE WHEN a.tenderFlag = 1 THEN 1 ELSE 0 END) "
                + "FROM PRMaster a WHERE a.prAdmin ='" + username + "'";

        boolean whereAdded = true;

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE('"
                    + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE('"
                    + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN STR_TO_DATE('"
                    + Fromdate + "', '%d-%m-%Y') AND STR_TO_DATE('"
                    + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("")) {
            query += " AND a.department ='" + Department + "'";
        }

        query += " GROUP BY a.tenderCreaterId ";
        query += " ORDER BY COUNT(a) DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalPrUser(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = " FROM PRMaster a WHERE 1=1";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalUnderApproval(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = " FROM PRMaster a WHERE  a.authorizeFlag IN (0, 2,7, 10)";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalLivePr(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = " FROM PRMaster a WHERE a.authorizeFlag IN (1, 6)";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalRejectedPr(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = " FROM PRMaster a WHERE a.authorizeFlag IN (3)";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalAssignToBuyer(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = " FROM PRMaster a WHERE a.tenderFlag = 1 AND a.authorizeFlag = 1";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalPendingToAssign(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = " FROM PRMaster a WHERE a.tenderFlag = 0 AND a.authorizeFlag = 1";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List totalPendingToFloat(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        String query = " FROM PRMaster a WHERE a.authorizeFlag = 1";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    //PR Register dashboard 
    @Override
    public List readPrRegister(String userName, String Fromdate, String Todate) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, -3);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo,b.prAdmin, b.announceDate, b.prAuthorizeUser , b.prAuthorizeDate,b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate,  b.prReworkDate,b.tenderCreaterDate, b.title, b.prComment, b.finalCloseDate, b.businessType,"
                + "DATEDIFF(STR_TO_DATE(c.poDate, '%d-%m-%Y'), STR_TO_DATE(b.authorizeDate, '%d-%m-%Y')) AS daysLeft, "
                + "DATEDIFF(STR_TO_DATE(c.poDate, '%d-%m-%Y'), STR_TO_DATE(b.announceDate, '%d-%m-%Y')) AS announceApprovalDiff, "
                + "DATEDIFF(STR_TO_DATE(c.poDate, '%d-%m-%Y'), STR_TO_DATE(b.announceDate, '%d-%m-%Y')) AS prReworkDiff, "
                + " a.submitLastdate,"
                + "c.poNo, c.poDate, c.poValue, c.vendorCode "
                + "FROM TenderMaster a, PRMaster b, PoDetails c "
                + "WHERE a.prNo = b.prNo "
                + "AND b.prNo = c.prNo ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
        } else {
            query += " AND STR_TO_DATE(b.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d-%m-%Y')";
        }

        if (userName != null && !userName.trim().isEmpty()) {
            query += " AND b.prAdmin = '" + userName + "'";
        }

        query += " ORDER BY b.prNo DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readPrRegisterUnCommon(String userName, String Fromdate, String Todate) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, -3);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo , b.prAdmin,  b.announceDate,b.prAuthorizeUser , b.prAuthorizeDate,b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate, b.prReworkDate, b.tenderCreaterDate, "
                + "b.title, b.prComment, b.finalCloseDate, b.businessType,"
                + "DATEDIFF(STR_TO_DATE(b.authorizeDate, '%d-%m-%Y'), STR_TO_DATE('" + toDate + "', '%d-%m-%Y')) AS daysLeft, "
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.authorizeDate, '%d-%m-%Y')) AS announceApprovalDiff,"
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.prReworkDate, '%d-%m-%Y')) AS prReworkDiff, "
                + " a.submitLastdate "
                + "FROM TenderMaster a, PRMaster b "
                + "WHERE a.prNo = b.prNo "
                + "AND b.prNo NOT IN (SELECT prNo FROM PoDetails) ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
        } else {
            query += " AND STR_TO_DATE(b.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d-%m-%Y')";
        }

        if (userName != null && !userName.trim().isEmpty()) {
            query += " AND b.prAdmin = '" + userName + "'";
        }

        query += " ORDER BY b.prNo DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readOnlyPr(String userName, String Fromdate, String Todate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, -3);
        String fromDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo, b.prAdmin, b.announceDate,b.prAuthorizeUser , b.prAuthorizeDate, b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate, b.prReworkDate, b.tenderCreaterDate, "
                + "b.title, b.prComment, b.finalCloseDate, b.businessType, "
                + "DATEDIFF(STR_TO_DATE(b.authorizeDate, '%d-%m-%Y'), STR_TO_DATE('" + toDate + "', '%d-%m-%Y')) AS daysLeft, "
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.authorizeDate, '%d-%m-%Y')) AS announceApprovalDiff, "
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.prReworkDate, '%d-%m-%Y')) AS prReworkDiff "
                + "FROM PRMaster b "
                + "WHERE b.prNo NOT IN (SELECT prNo FROM PoDetails) ";

        if (Fromdate != null && !Fromdate.trim().isEmpty() && Todate != null && !Todate.trim().isEmpty()) {
            query += " AND STR_TO_DATE(b.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y')";
        } else {
            query += " AND STR_TO_DATE(b.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + fromDate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + toDate + "', '%d-%m-%Y')";
        }

        if (userName != null && !userName.trim().isEmpty()) {
            query += " AND b.prAdmin = '" + userName + "'";
        }

        query += " AND (b.tenderCreaterDate IS NULL) ";
        query += " ORDER BY b.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByTenderCreater() {
        String query = "";
        query += "SELECT DISTINCT a.tenderCreaterId "
                + "FROM PRMaster a "
                + "WHERE a.tenderCreaterId IS NOT NULL "
                + "ORDER BY a.tenderCreaterId";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readPrAdmin() {
        String query = "";
        query += "SELECT DISTINCT a.prAdmin "
                + "FROM PRMaster a "
                + "WHERE a.prAdmin IS NOT NULL "
                + "ORDER BY a.prAdmin";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readPrRegisterForAll() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo,b.prAdmin, b.announceDate, b.prAuthorizeUser , b.prAuthorizeDate,b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate,  b.prReworkDate,b.tenderCreaterDate, b.title, b.prComment, b.finalCloseDate, b.businessType,"
                + "DATEDIFF(STR_TO_DATE(c.poDate, '%d-%m-%Y'), STR_TO_DATE(b.authorizeDate, '%d-%m-%Y')) AS daysLeft, "
                + "DATEDIFF(STR_TO_DATE(c.poDate, '%d-%m-%Y'), STR_TO_DATE(b.announceDate, '%d-%m-%Y')) AS announceApprovalDiff, "
                + "DATEDIFF(STR_TO_DATE(c.poDate, '%d-%m-%Y'), STR_TO_DATE(b.announceDate, '%d-%m-%Y')) AS prReworkDiff, "
                + " a.submitLastdate,"
                + "c.poNo, c.poDate, c.poValue, c.vendorCode "
                + "FROM TenderMaster a, PRMaster b, PoDetails c "
                + "WHERE a.prNo = b.prNo "
                + "AND b.prNo = c.prNo ";

        query += " ORDER BY b.prNo DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readPrRegisterUnCommonForAll() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo , b.prAdmin,  b.announceDate,b.prAuthorizeUser , b.prAuthorizeDate,b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate, b.prReworkDate, b.tenderCreaterDate, "
                + "b.title, b.prComment, b.finalCloseDate, b.businessType,"
                + "DATEDIFF(STR_TO_DATE(b.authorizeDate, '%d-%m-%Y'), STR_TO_DATE('" + toDate + "', '%d-%m-%Y')) AS daysLeft, "
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.authorizeDate, '%d-%m-%Y')) AS announceApprovalDiff,"
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.prReworkDate, '%d-%m-%Y')) AS prReworkDiff, "
                + " a.submitLastdate "
                + "FROM TenderMaster a, PRMaster b "
                + "WHERE a.prNo = b.prNo "
                + "AND b.prNo NOT IN (SELECT prNo FROM PoDetails) ";

        query += " ORDER BY b.prNo DESC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readOnlyPrForAll() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        String toDate = sdf.format(cal.getTime());

        String query = "SELECT "
                + "b.prNo, b.prAdmin, b.announceDate,b.prAuthorizeUser , b.prAuthorizeDate, b.value, b.tenderAssignDate, b.authorizeFlag, "
                + "b.tenderCreaterId, b.tenderCreaterDate, b.prReworkDate, b.tenderCreaterDate, "
                + "b.title, b.prComment, b.finalCloseDate, b.businessType, "
                + "DATEDIFF(STR_TO_DATE(b.authorizeDate, '%d-%m-%Y'), STR_TO_DATE('" + toDate + "', '%d-%m-%Y')) AS daysLeft, "
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.authorizeDate, '%d-%m-%Y')) AS announceApprovalDiff, "
                + "DATEDIFF(STR_TO_DATE(b.announceDate, '%d-%m-%Y'), STR_TO_DATE(b.prReworkDate, '%d-%m-%Y')) AS prReworkDiff "
                + "FROM PRMaster b "
                + "WHERE b.prNo NOT IN (SELECT prNo FROM PoDetails) ";

        query += " AND (b.tenderCreaterDate IS NULL) ";

        query += " ORDER BY b.prNo DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public int readOnlyPrForAll(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = "SELECT COUNT(*) FROM PRMaster a WHERE a.authorizeFlag = 151";

        if (!Filter.equals("--select--")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                    + "BETWEEN STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (!Fromdate.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                    + "BETWEEN STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (!Department.equals("--select--")) {
            query += " AND a.department = '" + Department + "'";
        }

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();

    }

    @Override
    public int totalClosePrCount() {
        String query = "SELECT COUNT(*) FROM PRMaster a where a.authorizeFlag = 151";

        Long count = (Long) getHibernateTemplate().find(query).get(0);
        return count.intValue();
    }

    @Override
    public List closePrWithFilter(String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        String query = " FROM PRMaster a WHERE a.authorizeFlag = 151";

        if (username != null && !username.isEmpty()) {
            query += " AND (a.prAdmin = '" + username + "' OR a.prAuthorizeUser = '" + username + "')";
        }

        if (Filter != null && !Filter.equals("")) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') BETWEEN "
                    + "STR_TO_DATE('" + formattedStartDate + "', '%d-%m-%Y %H:%i:%s') "
                    + "AND STR_TO_DATE('" + formattedDate + "', '%d-%m-%Y %H:%i:%s'))";
        }

        if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
            query += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') BETWEEN "
                    + "STR_TO_DATE('" + Fromdate + "', '%d-%m-%Y') "
                    + "AND STR_TO_DATE('" + Todate + "', '%d-%m-%Y'))";
        }

        if (Department != null && !Department.isEmpty()) {
            query += " AND a.department = '" + Department + "'";
        }

        query += " ORDER BY a.prNo DESC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByClosePr(String prNumber, String open_from_date, String open_to_date, String department) {
        String query = "";
        query += "SELECT a.id, a.prNo, b.tenderNo, b.closedBy, b.dateTime "
                + "FROM PRMaster a, ClosePr b "
                + "WHERE a.authorizeFlag = 151 "
                + "and b.prMasterId = a.id";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List getPRPagination(int start, int length, String searchValue, String prNumber, String projectName, String department, String fromDate, String toDate, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();

        String hql = "FROM PRMaster p WHERE 1=1 ";

        if (prNumber != null && !prNumber.equals("")) {
            hql += " AND lower(p.prNo) LIKE :prNo ";
        }

        if (projectName != null && !projectName.equals("")) {
            hql += " AND lower(p.title) LIKE :title ";
        }

        if (department != null && !department.equals("")) {
            hql += " AND lower(p.department) LIKE :department ";
        }

        if (fromDate != null && !fromDate.trim().equals("")
                && toDate != null && !toDate.trim().equals("")) {

            hql += " AND STR_TO_DATE(p.announceDate,'%d-%m-%Y') "
                    + " BETWEEN STR_TO_DATE(:fromDate,'%d-%m-%Y') "
                    + " AND STR_TO_DATE(:toDate,'%d-%m-%Y') ";
        } else if (fromDate != null && !fromDate.trim().equals("")) {

            hql += " AND STR_TO_DATE(p.announceDate,'%d-%m-%Y') "
                    + " >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
        } else if (toDate != null && !toDate.trim().equals("")) {

            hql += " AND STR_TO_DATE(p.announceDate,'%d-%m-%Y') "
                    + " <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
        }

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
            orderDir = "asc";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(p.prNo) LIKE :searchValue "
                    + " OR lower(p.title) LIKE :searchValue "
                    + " OR lower(p.projectId) LIKE :searchValue "
                    + " OR lower(p.department) LIKE :searchValue "
                    + " OR lower(p.workDesc) LIKE :searchValue "
                    + " OR lower(p.contactPerson) LIKE :searchValue "
                    + " OR lower(p.billingLocation) LIKE :searchValue "
                    + " OR lower(p.prAuthorizeUser) LIKE :searchValue "
                    + " OR lower(p.announceDate) LIKE :searchValue "
                    + " OR lower(p.prAuthorizeDate) LIKE :searchValue "
                    + " OR lower(p.tenderCreaterId) LIKE :searchValue "
                    + " OR lower(p.tenderAssignUser) LIKE :searchValue "
                    + " OR lower(p.tenderAssignDate) LIKE :searchValue "
                    + " OR lower(p.tenderCreaterUser) LIKE :searchValue "
                    + " OR lower(p.tenderCreaterDate) LIKE :searchValue "
                    + " OR lower(p.techBidOpenUser) LIKE :searchValue "
                    + " OR lower(p.techBidOpenDate) LIKE :searchValue "
                    + " OR lower(p.techBidApproveUser) LIKE :searchValue "
                    + " OR lower(p.techBidApproveDate) LIKE :searchValue "
                    + " OR lower(p.priceBidStartUser) LIKE :searchValue "
                    + " OR lower(p.priceBidStartDate) LIKE :searchValue "
                    + " OR lower(p.priceBidOpenUser) LIKE :searchValue "
                    + " OR lower(p.priceBidOpenDate) LIKE :searchValue "
                    + " OR lower(p.tenderAwardUser) LIKE :searchValue "
                    + " OR lower(p.tenderAwardDate) LIKE :searchValue "
                    + " OR lower(p.tenderAcceptUser) LIKE :searchValue "
                    + " OR lower(p.tenderAcceptDate) LIKE :searchValue "
                    + " OR lower(p.finalCloseUser) LIKE :searchValue "
                    + " OR lower(p.finalCloseDate) LIKE :searchValue "
                    + ")";
        }

        hql += " ORDER BY p." + orderColumn + " " + orderDir;

        Query query = session.createQuery(hql);

        if (prNumber != null && !prNumber.equals("")) {
            query.setParameter("prNo", "%" + prNumber.toLowerCase() + "%");
        }

        if (projectName != null && !projectName.equals("")) {
            query.setParameter("title", "%" + projectName.toLowerCase() + "%");
        }

        if (department != null && !department.equals("")) {
            query.setParameter("department", "%" + department.toLowerCase() + "%");
        }

        if (fromDate != null && !fromDate.trim().equals("")) {
            query.setParameter("fromDate", fromDate);
        }

        if (toDate != null && !toDate.trim().equals("")) {
            query.setParameter("toDate", toDate);
        }

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query.setFirstResult(start);
        query.setMaxResults(length);

        return query.list();

    }

    @Override
    public int getTotalPRCount() {

        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(*) "
                + "from PRMaster a "
        ).uniqueResult();

        session.close();

        return count.intValue();
    }

    @Override
    public int getFilteredPRCount(String searchValue, String prNumber, String projectName, String department, String fromDate, String toDate) {

        Session session = getSessionFactory().openSession();

        String hql = "select count(*) FROM PRMaster p WHERE 1=1 ";

        if (prNumber != null && !prNumber.equals("")) {
            hql += " AND lower(p.prNo) LIKE :prNo ";
        }

        if (projectName != null && !projectName.equals("")) {
            hql += " AND lower(p.title) LIKE :title ";
        }

        if (department != null && !department.equals("")) {
            hql += " AND lower(p.department) LIKE :department ";
        }

        if (fromDate != null && !fromDate.trim().equals("")
                && toDate != null && !toDate.trim().equals("")) {

            hql += " AND STR_TO_DATE(p.announceDate,'%d-%m-%Y') "
                    + " BETWEEN STR_TO_DATE(:fromDate,'%d-%m-%Y') "
                    + " AND STR_TO_DATE(:toDate,'%d-%m-%Y') ";
        } else if (fromDate != null && !fromDate.trim().equals("")) {

            hql += " AND STR_TO_DATE(p.announceDate,'%d-%m-%Y') "
                    + " >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
        } else if (toDate != null && !toDate.trim().equals("")) {

            hql += " AND STR_TO_DATE(p.announceDate,'%d-%m-%Y') "
                    + " <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
        }

        if (searchValue != null && !searchValue.equals("")) {

            hql += " AND ("
                    + " lower(p.prNo) LIKE :searchValue "
                    + " OR lower(p.title) LIKE :searchValue "
                    + " OR lower(p.projectId) LIKE :searchValue "
                    + " OR lower(p.department) LIKE :searchValue "
                    + " OR lower(p.workDesc) LIKE :searchValue "
                    + " OR lower(p.contactPerson) LIKE :searchValue "
                    + " OR lower(p.billingLocation) LIKE :searchValue "
                    + " OR lower(p.prAuthorizeUser) LIKE :searchValue "
                    + " OR lower(p.announceDate) LIKE :searchValue "
                    + " OR lower(p.prAuthorizeDate) LIKE :searchValue "
                    + " OR lower(p.tenderCreaterId) LIKE :searchValue "
                    + " OR lower(p.tenderAssignUser) LIKE :searchValue "
                    + " OR lower(p.tenderAssignDate) LIKE :searchValue "
                    + " OR lower(p.tenderCreaterUser) LIKE :searchValue "
                    + " OR lower(p.tenderCreaterDate) LIKE :searchValue "
                    + " OR lower(p.techBidOpenUser) LIKE :searchValue "
                    + " OR lower(p.techBidOpenDate) LIKE :searchValue "
                    + " OR lower(p.techBidApproveUser) LIKE :searchValue "
                    + " OR lower(p.techBidApproveDate) LIKE :searchValue "
                    + " OR lower(p.priceBidStartUser) LIKE :searchValue "
                    + " OR lower(p.priceBidStartDate) LIKE :searchValue "
                    + " OR lower(p.priceBidOpenUser) LIKE :searchValue "
                    + " OR lower(p.priceBidOpenDate) LIKE :searchValue "
                    + " OR lower(p.tenderAwardUser) LIKE :searchValue "
                    + " OR lower(p.tenderAwardDate) LIKE :searchValue "
                    + " OR lower(p.tenderAcceptUser) LIKE :searchValue "
                    + " OR lower(p.tenderAcceptDate) LIKE :searchValue "
                    + " OR lower(p.finalCloseUser) LIKE :searchValue "
                    + " OR lower(p.finalCloseDate) LIKE :searchValue "
                    + ")";
        }

        Query query = session.createQuery(hql);

        if (prNumber != null && !prNumber.equals("")) {
            query.setParameter("prNo",
                    "%" + prNumber.toLowerCase() + "%");
        }

        if (projectName != null && !projectName.equals("")) {
            query.setParameter("title",
                    "%" + projectName.toLowerCase() + "%");
        }

        if (department != null && !department.equals("")) {
            query.setParameter("department",
                    "%" + department.toLowerCase() + "%");
        }

        if (fromDate != null && !fromDate.trim().equals("")) {
            query.setParameter("fromDate", fromDate);
        }

        if (toDate != null && !toDate.trim().equals("")) {
            query.setParameter("toDate", toDate);
        }

        if (searchValue != null && !searchValue.equals("")) {
            query.setParameter("searchValue",
                    "%" + searchValue.toLowerCase() + "%");
        }

        Long count = (Long) query.uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public List getListPRPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir, String statusFilter) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {

            String hql = "FROM PRMaster p WHERE p.contactPerson = :username ";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(p.prNo) LIKE :search "
                        + " OR lower(p.title) LIKE :search "
                        + " OR lower(p.projectId) LIKE :search "
                        + " OR lower(p.contactPerson) LIKE :search "
                        + ")";
            }

            if (statusFilter != null && !statusFilter.trim().equals("")) {

                hql += " AND (";

                if (statusFilter.contains("Pending")) {

                    hql += " p.authorizeFlag = 0 OR ";
                }

                if (statusFilter.contains("Approve")) {

                    hql += " p.authorizeFlag = 1 OR ";
                }

                if (statusFilter.contains("Rework")) {

                    hql += " p.authorizeFlag = 2 OR ";
                }

                if (statusFilter.contains("Tender Created")) {

                    hql += " p.authorizeFlag = 6 OR ";
                }

                if (statusFilter.contains("Draft")) {

                    hql += " p.authorizeFlag = 7 OR ";
                }

                hql = hql.substring(0, hql.length() - 3);

                hql += " ) ";
            }

            hql += " ORDER BY p." + orderColumn + " " + orderDir;

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
    public int getTotalListPRCount(String username) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(p.id) "
                    + "FROM PRMaster p "
                    + "WHERE p.contactPerson = :username";

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
    public int getFilteredListPRCount(String username, String searchValue) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(p.id) "
                    + "FROM PRMaster p "
                    + "WHERE p.contactPerson = :username ";

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(p.prNo) LIKE :search "
                        + " OR lower(p.title) LIKE :search "
                        + " OR lower(p.projectId) LIKE :search "
                        + " OR lower(p.contactPerson) LIKE :search "
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
    public List getClosePrListPagination(int start, int length, String searchValue, String prNumber, String open_from_date, String open_to_date, String department, String orderByField, String orderDir) {

        Session session = getSessionFactory().openSession();

        List list = new ArrayList();

        try {

            String hql = "SELECT a.id, a.prNo, b.tenderNo, b.closedBy, b.dateTime "
                    + "FROM PRMaster a, ClosePr b "
                    + "WHERE a.authorizeFlag = 151 "
                    + "AND b.prMasterId = a.id ";

            if (prNumber != null && !prNumber.trim().equals("")) {

                hql += " AND lower(a.prNo) LIKE :prNumber ";
            }

            if (department != null && !department.trim().equals("")) {

                hql += " AND lower(a.department) LIKE :department ";
            }

            if (open_from_date != null && !open_from_date.trim().equals("")) {

                hql += " AND STR_TO_DATE(b.dateTime,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            }

            if (open_to_date != null && !open_to_date.trim().equals("")) {

                hql += " AND STR_TO_DATE(b.dateTime,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.prNo) LIKE :search "
                        + " OR lower(b.tenderNo) LIKE :search "
                        + " OR lower(b.closedBy) LIKE :search "
                        + ") ";
            }

            hql += " ORDER BY " + orderByField + " " + orderDir;

            Query query = session.createQuery(hql);

            if (prNumber != null && !prNumber.trim().equals("")) {

                query.setParameter("prNumber", "%" + prNumber.toLowerCase() + "%");
            }

            if (department != null && !department.trim().equals("")) {

                query.setParameter("department", "%" + department.toLowerCase() + "%");
            }

            if (open_from_date != null && !open_from_date.trim().equals("")) {

                query.setParameter("fromDate", open_from_date);
            }

            if (open_to_date != null && !open_to_date.trim().equals("")) {

                query.setParameter("toDate", open_to_date);
            }

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
    public int getTotalClosePRCount() {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM PRMaster a, ClosePr b "
                    + "WHERE a.authorizeFlag = 151 "
                    + "AND b.prMasterId = a.id";

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
    public int getFilteredClosePRCount(String searchValue, String prNumber, String open_from_date, String open_to_date, String department) {

        Session session = getSessionFactory().openSession();

        Long count = 0L;

        try {

            String hql = "SELECT COUNT(a.id) "
                    + "FROM PRMaster a, ClosePr b "
                    + "WHERE a.authorizeFlag = 151 "
                    + "AND b.prMasterId = a.id ";

            if (prNumber != null && !prNumber.trim().equals("")) {

                hql += " AND lower(a.prNo) LIKE :prNumber ";
            }

            if (department != null && !department.trim().equals("")) {

                hql += " AND lower(a.department) LIKE :department ";
            }

            if (open_from_date != null && !open_from_date.trim().equals("")) {

                hql += " AND STR_TO_DATE(b.dateTime,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ";
            }

            if (open_to_date != null && !open_to_date.trim().equals("")) {

                hql += " AND STR_TO_DATE(b.dateTime,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.prNo) LIKE :search "
                        + " OR lower(b.tenderNo) LIKE :search "
                        + " OR lower(b.closedBy) LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (prNumber != null && !prNumber.trim().equals("")) {

                query.setParameter("prNumber", "%" + prNumber.toLowerCase() + "%");
            }

            if (department != null && !department.trim().equals("")) {

                query.setParameter("department", "%" + department.toLowerCase() + "%");
            }

            if (open_from_date != null && !open_from_date.trim().equals("")) {

                query.setParameter("fromDate", open_from_date);
            }

            if (open_to_date != null && !open_to_date.trim().equals("")) {

                query.setParameter("toDate", open_to_date);
            }

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
    public List getPRRegisterPagination(int start, int length, String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ")
                    .append("b.pr_no, b.pr_admin, b.announce_date, ")
                    .append("b.pr_authorize_user, b.pr_authorize_date, ")
                    .append("b.value, b.tender_assign_date, b.authorize_flag, ")
                    .append("b.tender_creater_id, b.tender_creater_date, ")
                    .append("b.pr_rework_date, ")
                    .append("CAST(b.title AS CHAR(5000)) AS title, ")
                    .append("CAST(b.pr_comment AS CHAR(5000)) AS pr_comment, ")
                    .append("b.final_close_date, b.business_type, ")
                    .append("IFNULL(ABS(DATEDIFF(STR_TO_DATE(c.po_date,'%d-%m-%Y'), ")
                    .append("STR_TO_DATE(b.authorize_date,'%d-%m-%Y %H:%i:%s'))),0) AS daysLeft, ")
                    .append("IFNULL(ABS(DATEDIFF(STR_TO_DATE(c.po_date,'%d-%m-%Y'), ")
                    .append("STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s'))),0) AS announceApprovalDiff, ")
                    .append("a.submit_lastdate, ")
                    .append("c.po_no, c.po_date, c.po_value, c.vendor_code ")
                    .append("FROM tender_master a ")
                    .append("LEFT JOIN pr_master b ON a.pr_no = b.pr_no ")
                    .append("LEFT JOIN po_details c ON b.pr_no = c.pr_no ")
                    .append("WHERE 1=1 ");

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ");
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ");
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_no) LIKE :prNo ");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_admin) LIKE :prAdmin ");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.announce_date) LIKE :announceDate ");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_user) LIKE :prAuthorizeUser ");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_date) LIKE :prAuthorizeDate ");
            }

            if (value != null && !value.trim().isEmpty()) {
                sql.append(" AND CAST(b.value AS CHAR) LIKE :value ");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_assign_date) LIKE :tenderAssignDate ");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {
                    sql.append(" AND IFNULL(c.po_no, '') <> '' ");
                } else {
                    sql.append(" AND LOWER(b.authorize_flag) LIKE :statusFilter ");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_id) LIKE :tenderCreaterId ");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_date) LIKE :tenderCreaterDate ");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_rework_date) LIKE :prReworkDate ");
            }

            if (title != null && !title.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.title AS CHAR(5000))) LIKE :title ");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :prComment ");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.final_close_date) LIKE :finalCloseDate ");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                sql.append(" AND LOWER(b.business_type) LIKE :businessType ");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                sql.append(" AND LOWER(a.submit_lastdate) LIKE :submitLastdate ");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_no) LIKE :poNo ");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_date) LIKE :poDate ");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                sql.append(" AND CAST(c.po_value AS CHAR) LIKE :poValue ");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                sql.append(" AND LOWER(c.vendor_code) LIKE :vendorCode ");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" AND (")
                        .append("LOWER(b.pr_no) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_admin) LIKE :searchValue ")
                        .append("OR LOWER(b.announce_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_user) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_date) LIKE :searchValue ")
                        .append("OR CAST(b.value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_assign_date) LIKE :searchValue ")
                        .append("OR LOWER(b.authorize_flag) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_id) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_rework_date) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.title AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(b.final_close_date) LIKE :searchValue ")
                        .append("OR LOWER(b.business_type) LIKE :searchValue ")
                        .append("OR LOWER(a.submit_lastdate) LIKE :searchValue ")
                        .append("OR LOWER(c.po_no) LIKE :searchValue ")
                        .append("OR LOWER(c.po_date) LIKE :searchValue ")
                        .append("OR CAST(c.po_value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(c.vendor_code) LIKE :searchValue ")
                        .append(")");
            }

            sql.append(" ORDER BY :orderColumn :orderDir");

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                query.setParameter("toDate", toDate);
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                query.setParameter("prNo", "%" + prNo.toLowerCase() + "%");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                query.setParameter("prAdmin", "%" + prAdmin.toLowerCase() + "%");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                query.setParameter("announceDate", "%" + announceDate.toLowerCase() + "%");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                query.setParameter("prAuthorizeUser", "%" + prAuthorizeUser.toLowerCase() + "%");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                query.setParameter("prAuthorizeDate", "%" + prAuthorizeDate.toLowerCase() + "%");
            }

            if (value != null && !value.trim().isEmpty()) {
                query.setParameter("value", "%" + value + "%");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                query.setParameter("tenderAssignDate", "%" + tenderAssignDate.toLowerCase() + "%");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {

                } else {
                    query.setParameter("statusFilter", "%" + statusFilter.toLowerCase() + "%");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                query.setParameter("tenderCreaterId", "%" + tenderCreaterId.toLowerCase() + "%");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                query.setParameter("tenderCreaterDate", "%" + tenderCreaterDate.toLowerCase() + "%");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                query.setParameter("prReworkDate", "%" + prReworkDate.toLowerCase() + "%");
            }

            if (title != null && !title.trim().isEmpty()) {
                query.setParameter("title", "%" + title.toLowerCase() + "%");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                query.setParameter("prComment", "%" + prComment.toLowerCase() + "%");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                query.setParameter("finalCloseDate", "%" + finalCloseDate.toLowerCase() + "%");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                query.setParameter("businessType", "%" + businessType.toLowerCase() + "%");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                query.setParameter("submitLastdate", "%" + submitLastdate.toLowerCase() + "%");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                query.setParameter("poNo", "%" + poNo.toLowerCase() + "%");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                query.setParameter("poDate", "%" + poDate.toLowerCase() + "%");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                query.setParameter("poValue", "%" + poValue.toLowerCase() + "%");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                query.setParameter("vendorCode", "%" + vendorCode.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setParameter("orderColumn", orderColumn);
            query.setParameter("orderDir", orderDir);

            query.setFirstResult(start);
            query.setMaxResults(length);

            List list = query.list();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public int getPRRegisterCount(String fromDate, String toDate) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT COUNT(*) ")
                    .append("FROM tender_master a ")
                    .append("LEFT JOIN pr_master b ON a.pr_no = b.pr_no ")
                    .append("LEFT JOIN po_details c ON b.pr_no = c.pr_no ")
                    .append("WHERE 1=1 ");

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ");
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ");
            }

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                query.setParameter("toDate", toDate);
            }

            Number count = (Number) query.uniqueResult();
            return count.intValue();

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            session.close();
        }
    }

    @Override
    public int getFilteredPRRegisterCount(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode) {
        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT COUNT(*) ")
                    .append("FROM tender_master a ")
                    .append("LEFT JOIN pr_master b ON a.pr_no = b.pr_no ")
                    .append("LEFT JOIN po_details c ON b.pr_no = c.pr_no ")
                    .append("WHERE 1=1 ");

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ");
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ");
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_no) LIKE :prNo ");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_admin) LIKE :prAdmin ");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.announce_date) LIKE :announceDate ");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_user) LIKE :prAuthorizeUser ");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_date) LIKE :prAuthorizeDate ");
            }

            if (value != null && !value.trim().isEmpty()) {
                sql.append(" AND CAST(b.value AS CHAR) LIKE :value ");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_assign_date) LIKE :tenderAssignDate ");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {
                    sql.append(" AND IFNULL(c.po_no, '') <> '' ");
                } else {
                    sql.append(" AND LOWER(b.authorize_flag) LIKE :statusFilter ");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_id) LIKE :tenderCreaterId ");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_date) LIKE :tenderCreaterDate ");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_rework_date) LIKE :prReworkDate ");
            }

            if (title != null && !title.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.title AS CHAR(5000))) LIKE :title ");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :prComment ");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.final_close_date) LIKE :finalCloseDate ");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                sql.append(" AND LOWER(b.business_type) LIKE :businessType ");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                sql.append(" AND LOWER(a.submit_lastdate) LIKE :submitLastdate ");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_no) LIKE :poNo ");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_date) LIKE :poDate ");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                sql.append(" AND CAST(c.po_value AS CHAR) LIKE :poValue ");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                sql.append(" AND LOWER(c.vendor_code) LIKE :vendorCode ");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" AND (")
                        .append("LOWER(b.pr_no) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_admin) LIKE :searchValue ")
                        .append("OR LOWER(b.announce_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_user) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_date) LIKE :searchValue ")
                        .append("OR CAST(b.value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_assign_date) LIKE :searchValue ")
                        .append("OR LOWER(b.authorize_flag) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_id) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_rework_date) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.title AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(b.final_close_date) LIKE :searchValue ")
                        .append("OR LOWER(b.business_type) LIKE :searchValue ")
                        .append("OR LOWER(a.submit_lastdate) LIKE :searchValue ")
                        .append("OR LOWER(c.po_no) LIKE :searchValue ")
                        .append("OR LOWER(c.po_date) LIKE :searchValue ")
                        .append("OR CAST(c.po_value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(c.vendor_code) LIKE :searchValue ")
                        .append(")");
            }

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                query.setParameter("toDate", toDate);
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                query.setParameter("prNo", "%" + prNo.toLowerCase() + "%");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                query.setParameter("prAdmin", "%" + prAdmin.toLowerCase() + "%");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                query.setParameter("announceDate", "%" + announceDate.toLowerCase() + "%");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                query.setParameter("prAuthorizeUser", "%" + prAuthorizeUser.toLowerCase() + "%");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                query.setParameter("prAuthorizeDate", "%" + prAuthorizeDate.toLowerCase() + "%");
            }

            if (value != null && !value.trim().isEmpty()) {
                query.setParameter("value", "%" + value + "%");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                query.setParameter("tenderAssignDate", "%" + tenderAssignDate.toLowerCase() + "%");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {

                } else {
                    query.setParameter("statusFilter", "%" + statusFilter.toLowerCase() + "%");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                query.setParameter("tenderCreaterId", "%" + tenderCreaterId.toLowerCase() + "%");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                query.setParameter("tenderCreaterDate", "%" + tenderCreaterDate.toLowerCase() + "%");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                query.setParameter("prReworkDate", "%" + prReworkDate.toLowerCase() + "%");
            }

            if (title != null && !title.trim().isEmpty()) {
                query.setParameter("title", "%" + title.toLowerCase() + "%");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                query.setParameter("prComment", "%" + prComment.toLowerCase() + "%");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                query.setParameter("finalCloseDate", "%" + finalCloseDate.toLowerCase() + "%");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                query.setParameter("businessType", "%" + businessType.toLowerCase() + "%");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                query.setParameter("submitLastdate", "%" + submitLastdate.toLowerCase() + "%");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                query.setParameter("poNo", "%" + poNo.toLowerCase() + "%");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                query.setParameter("poDate", "%" + poDate.toLowerCase() + "%");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                query.setParameter("poValue", "%" + poValue.toLowerCase() + "%");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                query.setParameter("vendorCode", "%" + vendorCode.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Number count = (Number) query.uniqueResult();
            return count.intValue();

        } catch (Exception e) {

            e.printStackTrace();
            return 0;

        } finally {

            session.close();
        }
    }

    @Override
    public Object[] getTotalPRAndPOValue(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ")
                    .append("COALESCE(SUM(b.value),0) AS totalPRValue, ")
                    .append("COALESCE(SUM(c.po_value),0) AS totalPOValue ")
                    .append("FROM tender_master a ")
                    .append("LEFT JOIN pr_master b ON a.pr_no = b.pr_no ")
                    .append("LEFT JOIN po_details c ON b.pr_no = c.pr_no ")
                    .append("WHERE 1=1 ");

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ");
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ");
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_no) LIKE :prNo ");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_admin) LIKE :prAdmin ");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.announce_date) LIKE :announceDate ");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_user) LIKE :prAuthorizeUser ");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_date) LIKE :prAuthorizeDate ");
            }

            if (value != null && !value.trim().isEmpty()) {
                sql.append(" AND CAST(b.value AS CHAR) LIKE :value ");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_assign_date) LIKE :tenderAssignDate ");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {
                    sql.append(" AND IFNULL(c.po_no, '') <> '' ");
                } else {
                    sql.append(" AND LOWER(b.authorize_flag) LIKE :statusFilter ");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_id) LIKE :tenderCreaterId ");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_date) LIKE :tenderCreaterDate ");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_rework_date) LIKE :prReworkDate ");
            }

            if (title != null && !title.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.title AS CHAR(5000))) LIKE :title ");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :prComment ");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.final_close_date) LIKE :finalCloseDate ");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                sql.append(" AND LOWER(b.business_type) LIKE :businessType ");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                sql.append(" AND LOWER(a.submit_lastdate) LIKE :submitLastdate ");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_no) LIKE :poNo ");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_date) LIKE :poDate ");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                sql.append(" AND CAST(c.po_value AS CHAR) LIKE :poValue ");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                sql.append(" AND LOWER(c.vendor_code) LIKE :vendorCode ");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" AND (")
                        .append("LOWER(b.pr_no) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_admin) LIKE :searchValue ")
                        .append("OR LOWER(b.announce_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_user) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_date) LIKE :searchValue ")
                        .append("OR CAST(b.value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_assign_date) LIKE :searchValue ")
                        .append("OR LOWER(b.authorize_flag) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_id) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_rework_date) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.title AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(b.final_close_date) LIKE :searchValue ")
                        .append("OR LOWER(b.business_type) LIKE :searchValue ")
                        .append("OR LOWER(a.submit_lastdate) LIKE :searchValue ")
                        .append("OR LOWER(c.po_no) LIKE :searchValue ")
                        .append("OR LOWER(c.po_date) LIKE :searchValue ")
                        .append("OR CAST(c.po_value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(c.vendor_code) LIKE :searchValue ")
                        .append(")");
            }

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                query.setParameter("toDate", toDate);
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                query.setParameter("prNo", "%" + prNo.toLowerCase() + "%");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                query.setParameter("prAdmin", "%" + prAdmin.toLowerCase() + "%");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                query.setParameter("announceDate", "%" + announceDate.toLowerCase() + "%");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                query.setParameter("prAuthorizeUser", "%" + prAuthorizeUser.toLowerCase() + "%");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                query.setParameter("prAuthorizeDate", "%" + prAuthorizeDate.toLowerCase() + "%");
            }

            if (value != null && !value.trim().isEmpty()) {
                query.setParameter("value", "%" + value + "%");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                query.setParameter("tenderAssignDate", "%" + tenderAssignDate.toLowerCase() + "%");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {

                } else {
                    query.setParameter("statusFilter", "%" + statusFilter.toLowerCase() + "%");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                query.setParameter("tenderCreaterId", "%" + tenderCreaterId.toLowerCase() + "%");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                query.setParameter("tenderCreaterDate", "%" + tenderCreaterDate.toLowerCase() + "%");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                query.setParameter("prReworkDate", "%" + prReworkDate.toLowerCase() + "%");
            }

            if (title != null && !title.trim().isEmpty()) {
                query.setParameter("title", "%" + title.toLowerCase() + "%");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                query.setParameter("prComment", "%" + prComment.toLowerCase() + "%");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                query.setParameter("finalCloseDate", "%" + finalCloseDate.toLowerCase() + "%");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                query.setParameter("businessType", "%" + businessType.toLowerCase() + "%");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                query.setParameter("submitLastdate", "%" + submitLastdate.toLowerCase() + "%");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                query.setParameter("poNo", "%" + poNo.toLowerCase() + "%");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                query.setParameter("poDate", "%" + poDate.toLowerCase() + "%");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                query.setParameter("poValue", "%" + poValue.toLowerCase() + "%");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                query.setParameter("vendorCode", "%" + vendorCode.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Object[] result = (Object[]) query.uniqueResult();

            double totalPRValue = 0.0;
            double totalPOValue = 0.0;

            if (result != null) {

                totalPRValue = result[0] != null
                        ? ((Number) result[0]).doubleValue()
                        : 0.0;

                totalPOValue = result[1] != null
                        ? ((Number) result[1]).doubleValue()
                        : 0.0;
            }

            return new Object[]{totalPRValue, totalPOValue};

        } catch (Exception e) {
            e.printStackTrace();
            return new Object[]{0.0, 0.0};
        } finally {
            session.close();
        }
    }

    @Override
    public int getPRRegisterExcelCount(String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT COUNT(*) ")
                    .append("FROM tender_master a ")
                    .append("LEFT JOIN pr_master b ON a.pr_no = b.pr_no ")
                    .append("LEFT JOIN po_details c ON b.pr_no = c.pr_no ")
                    .append("WHERE 1=1 ");

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ");
            }
            if (toDate != null && !toDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ");
            }
            if (id != null && !id.trim().isEmpty()) {
                sql.append(" AND LOWER(b.id) LIKE :id ");
            }
            if (prNo != null && !prNo.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_no) LIKE :prNo ");
            }
            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_admin) LIKE :prAdmin ");
            }
            if (announceDate != null && !announceDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.announce_date) LIKE :announceDate ");
            }
            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_user) LIKE :prAuthorizeUser ");
            }
            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_date) LIKE :prAuthorizeDate ");
            }
            if (value != null && !value.trim().isEmpty()) {
                sql.append(" AND CAST(b.value AS CHAR) LIKE :value ");
            }
            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_assign_date) LIKE :tenderAssignDate ");
            }
            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {
                    sql.append(" AND IFNULL(c.po_no, '') <> '' ");
                } else {
                    sql.append(" AND LOWER(b.authorize_flag) LIKE :statusFilter ");
                }
            }
            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_id) LIKE :tenderCreaterId ");
            }
            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_date) LIKE :tenderCreaterDate ");
            }
            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_rework_date) LIKE :prReworkDate ");
            }
            if (title != null && !title.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.title AS CHAR(5000))) LIKE :title ");
            }
            if (prComment != null && !prComment.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :prComment ");
            }
            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.final_close_date) LIKE :finalCloseDate ");
            }
            if (businessType != null && !businessType.trim().isEmpty()) {
                sql.append(" AND LOWER(b.business_type) LIKE :businessType ");
            }
            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                sql.append(" AND LOWER(a.submit_lastdate) LIKE :submitLastdate ");
            }
            if (poNo != null && !poNo.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_no) LIKE :poNo ");
            }
            if (poDate != null && !poDate.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_date) LIKE :poDate ");
            }
            if (poValue != null && !poValue.trim().isEmpty()) {
                sql.append(" AND CAST(c.po_value AS CHAR) LIKE :poValue ");
            }
            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                sql.append(" AND LOWER(c.vendor_code) LIKE :vendorCode ");
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                sql.append(" AND (")
                        .append("LOWER(b.pr_no) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_admin) LIKE :searchValue ")
                        .append("OR LOWER(b.announce_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_user) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_date) LIKE :searchValue ")
                        .append("OR CAST(b.value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_assign_date) LIKE :searchValue ")
                        .append("OR LOWER(b.authorize_flag) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_id) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_rework_date) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.title AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(b.final_close_date) LIKE :searchValue ")
                        .append("OR LOWER(b.business_type) LIKE :searchValue ")
                        .append("OR LOWER(a.submit_lastdate) LIKE :searchValue ")
                        .append("OR LOWER(c.po_no) LIKE :searchValue ")
                        .append("OR LOWER(c.po_date) LIKE :searchValue ")
                        .append("OR CAST(c.po_value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(c.vendor_code) LIKE :searchValue ")
                        .append(")");
            }

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                query.setParameter("fromDate", fromDate);
            }
            if (toDate != null && !toDate.trim().isEmpty()) {
                query.setParameter("toDate", toDate);
            }
            if (id != null && !id.trim().isEmpty()) {
                query.setParameter("id", "%" + id.toLowerCase() + "%");
            }
            if (prNo != null && !prNo.trim().isEmpty()) {
                query.setParameter("prNo", "%" + prNo.toLowerCase() + "%");
            }
            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                query.setParameter("prAdmin", "%" + prAdmin.toLowerCase() + "%");
            }
            if (announceDate != null && !announceDate.trim().isEmpty()) {
                query.setParameter("announceDate", "%" + announceDate.toLowerCase() + "%");
            }
            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                query.setParameter("prAuthorizeUser", "%" + prAuthorizeUser.toLowerCase() + "%");
            }
            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                query.setParameter("prAuthorizeDate", "%" + prAuthorizeDate.toLowerCase() + "%");
            }
            if (value != null && !value.trim().isEmpty()) {
                query.setParameter("value", "%" + value + "%");
            }
            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                query.setParameter("tenderAssignDate", "%" + tenderAssignDate.toLowerCase() + "%");
            }
            if (statusFilter != null && !statusFilter.trim().isEmpty() && !"PO Issued".equals(statusFilter)) {
                query.setParameter("statusFilter", "%" + statusFilter.toLowerCase() + "%");
            }
            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                query.setParameter("tenderCreaterId", "%" + tenderCreaterId.toLowerCase() + "%");
            }
            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                query.setParameter("tenderCreaterDate", "%" + tenderCreaterDate.toLowerCase() + "%");
            }
            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                query.setParameter("prReworkDate", "%" + prReworkDate.toLowerCase() + "%");
            }
            if (title != null && !title.trim().isEmpty()) {
                query.setParameter("title", "%" + title.toLowerCase() + "%");
            }
            if (prComment != null && !prComment.trim().isEmpty()) {
                query.setParameter("prComment", "%" + prComment.toLowerCase() + "%");
            }
            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                query.setParameter("finalCloseDate", "%" + finalCloseDate.toLowerCase() + "%");
            }
            if (businessType != null && !businessType.trim().isEmpty()) {
                query.setParameter("businessType", "%" + businessType.toLowerCase() + "%");
            }
            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                query.setParameter("submitLastdate", "%" + submitLastdate.toLowerCase() + "%");
            }
            if (poNo != null && !poNo.trim().isEmpty()) {
                query.setParameter("poNo", "%" + poNo.toLowerCase() + "%");
            }
            if (poDate != null && !poDate.trim().isEmpty()) {
                query.setParameter("poDate", "%" + poDate.toLowerCase() + "%");
            }
            if (poValue != null && !poValue.trim().isEmpty()) {
                query.setParameter("poValue", "%" + poValue.toLowerCase() + "%");
            }
            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                query.setParameter("vendorCode", "%" + vendorCode.toLowerCase() + "%");
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            Object result = query.uniqueResult();
            return result != null ? ((Number) result).intValue() : 0;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public List getPRRegisterExcelData(int start, int length, String searchValue, String fromDate, String toDate, String id, String prNo, String prAdmin, String announceDate, String prAuthorizeUser, String prAuthorizeDate, String tenderAssignDate, String statusFilter, String tenderCreaterId, String tenderCreaterDate, String prReworkDate, String title, String prComment, String finalCloseDate, String businessType, String announceApprovalDiff, String prReworkDiff, String submitLastdate, String value, String poNo, String poDate, String poValue, String vendorCode, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ")
                    .append("b.pr_no, b.pr_admin, b.announce_date, ")
                    .append("b.pr_authorize_user, b.pr_authorize_date, ")
                    .append("b.value, b.tender_assign_date, b.authorize_flag, ")
                    .append("b.tender_creater_id, b.tender_creater_date, ")
                    .append("b.pr_rework_date, ")
                    .append("CAST(b.title AS CHAR(5000)) AS title, ")
                    .append("CAST(b.pr_comment AS CHAR(5000)) AS pr_comment, ")
                    .append("b.final_close_date, b.business_type, ")
                    .append("IFNULL(ABS(DATEDIFF(STR_TO_DATE(c.po_date,'%d-%m-%Y'), ")
                    .append("STR_TO_DATE(b.authorize_date,'%d-%m-%Y %H:%i:%s'))),0) AS daysLeft, ")
                    .append("IFNULL(ABS(DATEDIFF(STR_TO_DATE(c.po_date,'%d-%m-%Y'), ")
                    .append("STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s'))),0) AS announceApprovalDiff, ")
                    .append("a.submit_lastdate, ")
                    .append("c.po_no, c.po_date, c.po_value, c.vendor_code ")
                    .append("FROM tender_master a ")
                    .append("LEFT JOIN pr_master b ON a.pr_no = b.pr_no ")
                    .append("LEFT JOIN po_details c ON b.pr_no = c.pr_no ")
                    .append("WHERE 1=1 ");

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE(:fromDate,'%d-%m-%Y') ");
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                sql.append(" AND STR_TO_DATE(b.announce_date,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE(:toDate,'%d-%m-%Y') ");
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_no) LIKE :prNo ");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_admin) LIKE :prAdmin ");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.announce_date) LIKE :announceDate ");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_user) LIKE :prAuthorizeUser ");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_authorize_date) LIKE :prAuthorizeDate ");
            }

            if (value != null && !value.trim().isEmpty()) {
                sql.append(" AND CAST(b.value AS CHAR) LIKE :value ");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_assign_date) LIKE :tenderAssignDate ");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {
                    sql.append(" AND IFNULL(c.po_no, '') <> '' ");
                } else {
                    sql.append(" AND LOWER(b.authorize_flag) LIKE :statusFilter ");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_id) LIKE :tenderCreaterId ");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.tender_creater_date) LIKE :tenderCreaterDate ");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.pr_rework_date) LIKE :prReworkDate ");
            }

            if (title != null && !title.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.title AS CHAR(5000))) LIKE :title ");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                sql.append(" AND LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :prComment ");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                sql.append(" AND LOWER(b.final_close_date) LIKE :finalCloseDate ");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                sql.append(" AND LOWER(b.business_type) LIKE :businessType ");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                sql.append(" AND LOWER(a.submit_lastdate) LIKE :submitLastdate ");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_no) LIKE :poNo ");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                sql.append(" AND LOWER(c.po_date) LIKE :poDate ");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                sql.append(" AND CAST(c.po_value AS CHAR) LIKE :poValue ");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                sql.append(" AND LOWER(c.vendor_code) LIKE :vendorCode ");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                sql.append(" AND (")
                        .append("LOWER(b.pr_no) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_admin) LIKE :searchValue ")
                        .append("OR LOWER(b.announce_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_user) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_authorize_date) LIKE :searchValue ")
                        .append("OR CAST(b.value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_assign_date) LIKE :searchValue ")
                        .append("OR LOWER(b.authorize_flag) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_id) LIKE :searchValue ")
                        .append("OR LOWER(b.tender_creater_date) LIKE :searchValue ")
                        .append("OR LOWER(b.pr_rework_date) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.title AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(CAST(b.pr_comment AS CHAR(5000))) LIKE :searchValue ")
                        .append("OR LOWER(b.final_close_date) LIKE :searchValue ")
                        .append("OR LOWER(b.business_type) LIKE :searchValue ")
                        .append("OR LOWER(a.submit_lastdate) LIKE :searchValue ")
                        .append("OR LOWER(c.po_no) LIKE :searchValue ")
                        .append("OR LOWER(c.po_date) LIKE :searchValue ")
                        .append("OR CAST(c.po_value AS CHAR) LIKE :searchValue ")
                        .append("OR LOWER(c.vendor_code) LIKE :searchValue ")
                        .append(")");
            }

            sql.append(" ORDER BY :orderColumn :orderDir");

            SQLQuery query = session.createSQLQuery(sql.toString());

            if (fromDate != null && !fromDate.trim().isEmpty()) {
                query.setParameter("fromDate", fromDate);
            }

            if (toDate != null && !toDate.trim().isEmpty()) {
                query.setParameter("toDate", toDate);
            }

            if (prNo != null && !prNo.trim().isEmpty()) {
                query.setParameter("prNo", "%" + prNo.toLowerCase() + "%");
            }

            if (prAdmin != null && !prAdmin.trim().isEmpty()) {
                query.setParameter("prAdmin", "%" + prAdmin.toLowerCase() + "%");
            }

            if (announceDate != null && !announceDate.trim().isEmpty()) {
                query.setParameter("announceDate", "%" + announceDate.toLowerCase() + "%");
            }

            if (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty()) {
                query.setParameter("prAuthorizeUser", "%" + prAuthorizeUser.toLowerCase() + "%");
            }

            if (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty()) {
                query.setParameter("prAuthorizeDate", "%" + prAuthorizeDate.toLowerCase() + "%");
            }

            if (value != null && !value.trim().isEmpty()) {
                query.setParameter("value", "%" + value + "%");
            }

            if (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty()) {
                query.setParameter("tenderAssignDate", "%" + tenderAssignDate.toLowerCase() + "%");
            }

            if (statusFilter != null && !statusFilter.trim().isEmpty()) {
                if ("PO Issued".equals(statusFilter)) {

                } else {
                    query.setParameter("statusFilter", "%" + statusFilter.toLowerCase() + "%");
                }
            }

            if (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty()) {
                query.setParameter("tenderCreaterId", "%" + tenderCreaterId.toLowerCase() + "%");
            }

            if (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty()) {
                query.setParameter("tenderCreaterDate", "%" + tenderCreaterDate.toLowerCase() + "%");
            }

            if (prReworkDate != null && !prReworkDate.trim().isEmpty()) {
                query.setParameter("prReworkDate", "%" + prReworkDate.toLowerCase() + "%");
            }

            if (title != null && !title.trim().isEmpty()) {
                query.setParameter("title", "%" + title.toLowerCase() + "%");
            }

            if (prComment != null && !prComment.trim().isEmpty()) {
                query.setParameter("prComment", "%" + prComment.toLowerCase() + "%");
            }

            if (finalCloseDate != null && !finalCloseDate.trim().isEmpty()) {
                query.setParameter("finalCloseDate", "%" + finalCloseDate.toLowerCase() + "%");
            }

            if (businessType != null && !businessType.trim().isEmpty()) {
                query.setParameter("businessType", "%" + businessType.toLowerCase() + "%");
            }

            if (submitLastdate != null && !submitLastdate.trim().isEmpty()) {
                query.setParameter("submitLastdate", "%" + submitLastdate.toLowerCase() + "%");
            }

            if (poNo != null && !poNo.trim().isEmpty()) {
                query.setParameter("poNo", "%" + poNo.toLowerCase() + "%");
            }

            if (poDate != null && !poDate.trim().isEmpty()) {
                query.setParameter("poDate", "%" + poDate.toLowerCase() + "%");
            }

            if (poValue != null && !poValue.trim().isEmpty()) {
                query.setParameter("poValue", "%" + poValue.toLowerCase() + "%");
            }

            if (vendorCode != null && !vendorCode.trim().isEmpty()) {
                query.setParameter("vendorCode", "%" + vendorCode.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                query.setParameter("searchValue", "%" + searchValue.toLowerCase() + "%");
            }

            query.setParameter("orderColumn", orderColumn);
            query.setParameter("orderDir", orderDir);

            query.setFirstResult(start);
            query.setMaxResults(length);

            List list = query.list();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public List gettotalPrUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {

            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson, "
                    + "a.announceDate, a.authorizeFlag "
                    + "FROM PRMaster a "
                    + "WHERE 1 = 1 ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            // Custom from-to date range
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {

                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0 AND lower('Pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1 AND lower('Approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2 AND lower('Rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3 AND lower('Reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6 AND lower('Tender Created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7 AND lower('Draft')          LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }

            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getMonthWiseGraphCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE 1 = 1 ";
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
    public int getFilteredMonthWiseGraphCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE 1 = 1 ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0 AND lower('Pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1 AND lower('Approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2 AND lower('Rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3 AND lower('Reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6 AND lower('Tender Created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7 AND lower('Draft')          LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }

            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getunderApprovalPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson, "
                    + "a.announceDate, a.authorizeFlag "
                    + "FROM PRMaster a "
                    + "WHERE a.authorizeFlag IN (0, 2, 7, 10) ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getunderApprovalCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.authorizeFlag IN (0, 2, 7, 10) ";
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
    public int getFilteredunderApprovalCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.authorizeFlag IN (0, 2, 7, 10) ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getrejectedPrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson,a.announceDate, a.authorizeFlag "
                    + " FROM PRMaster a WHERE a.authorizeFlag IN (3)";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getrejectedPrCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id)  FROM PRMaster a WHERE a.authorizeFlag IN (3)";
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
    public int getFilteredrejectedPrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id)  FROM PRMaster a WHERE a.authorizeFlag IN (3)";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getlivePrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson,a.announceDate ,a.prAuthorizeUser ,a.prAuthorizeDate, a.authorizeFlag "
                    + " FROM PRMaster a WHERE a.authorizeFlag IN (1, 6)";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR lower(a.prAuthorizeUser)   LIKE :search "
                        + "OR lower(a.prAuthorizeDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getlivePrCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id)    FROM PRMaster a WHERE a.authorizeFlag IN (1, 6)";

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
    public int getFilteredlivePrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id)   FROM PRMaster a WHERE a.authorizeFlag IN (1, 6)";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR lower(a.prAuthorizeUser)   LIKE :search "
                        + "OR lower(a.prAuthorizeDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List gettenderPendingToFloatPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson,a.tenderAssignUser ,a.tenderAssignDate ,a.announceDate, a.authorizeFlag "
                    + " FROM PRMaster a WHERE a.authorizeFlag = 1";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.tenderAssignUser)   LIKE :search "
                        + "OR lower(a.tenderAssignDate)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int gettenderPendingToFloatCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id)     FROM PRMaster a WHERE a.authorizeFlag = 1";

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
    public int getFilteredtenderPendingToFloatCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id)    FROM PRMaster a WHERE a.authorizeFlag = 1";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.tenderAssignUser)   LIKE :search "
                        + "OR lower(a.tenderAssignDate)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getPendingToAssignPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.prAuthorizeUser,a.prAuthorizeDate ,a.contactPerson ,a.announceDate ,a.authorizeFlag "
                    + " FROM PRMaster a WHERE a.tenderFlag = 0 AND a.authorizeFlag = 1";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.prAuthorizeUser)  LIKE :search "
                        + "OR lower(a.prAuthorizeDate)   LIKE :search "
                        + "OR lower(a.tenderAssignUser)   LIKE :search "
                        + "OR lower(a.tenderAssignDate)   LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getPendingToAssignFloatCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.tenderFlag = 0 AND a.authorizeFlag = 1";

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
    public int getFilteredPendingToAssignCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.tenderFlag = 0 AND a.authorizeFlag = 1";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.prAuthorizeUser)  LIKE :search "
                        + "OR lower(a.prAuthorizeDate)   LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getAssginedToBuyerPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.prAuthorizeUser,a.prAuthorizeDate ,a.tenderAssignUser,a.tenderAssignDate,a.contactPerson ,a.announceDate ,a.authorizeFlag "
                    + " FROM PRMaster a WHERE a.tenderFlag = 1 AND a.authorizeFlag = 1";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.prAuthorizeUser)  LIKE :search "
                        + "OR lower(a.prAuthorizeDate)   LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getAssginedToBuyerCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {

            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.tenderFlag = 1 AND a.authorizeFlag = 1";

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
    public int getFilteredAssginedToBuyerCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.tenderFlag = 1 AND a.authorizeFlag = 1";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }

            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }

            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }

            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.prAuthorizeUser)  LIKE :search "
                        + "OR lower(a.prAuthorizeDate)   LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10 AND lower('unknown')        LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getClosedPrPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson, "
                    + "a.announceDate, a.authorizeFlag "
                    + "FROM PRMaster a WHERE a.authorizeFlag = 151 ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :username OR a.prAuthorizeUser = :username) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)            LIKE :search "
                        + "OR lower(a.title)           LIKE :search "
                        + "OR lower(a.projectId)       LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)    LIKE :search "
                        + "OR (a.authorizeFlag = 0   AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1   AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2   AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3   AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6   AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7   AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10  AND lower('unknown')        LIKE :search) "
                        + "OR (a.authorizeFlag = 151 AND lower('closed')         LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public int getClosedPrCount() {
        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.authorizeFlag = 151";
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
    public int getFilteredClosedPrCount(String searchValue, String username, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a WHERE a.authorizeFlag = 151 ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :username OR a.prAuthorizeUser = :username) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)            LIKE :search "
                        + "OR lower(a.title)           LIKE :search "
                        + "OR lower(a.projectId)       LIKE :search "
                        + "OR lower(a.contactPerson)   LIKE :search "
                        + "OR lower(a.announceDate)    LIKE :search "
                        + "OR (a.authorizeFlag = 0   AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1   AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2   AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3   AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6   AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7   AND lower('draft')          LIKE :search) "
                        + "OR (a.authorizeFlag = 10  AND lower('unknown')        LIKE :search) "
                        + "OR (a.authorizeFlag = 151 AND lower('closed')         LIKE :search) "
                        + ") ";
            }

            // FIXED: Query is now OUTSIDE the searchValue block so it always runs
            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (Fromdate != null && !Fromdate.isEmpty() && Todate != null && !Todate.isEmpty()) {
                query.setParameter("startDate", Fromdate);
                query.setParameter("endDate", Todate);
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
    public List getmonthWiseListPrGraphUserPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        List list = new ArrayList();
        try {
            String hql = "SELECT a.id, a.prNo, a.title, a.projectId, a.contactPerson, "
                    + "a.announceDate, a.authorizeFlag "
                    + "FROM PRMaster a WHERE (a.authorizeFlag = 1 OR a.authorizeFlag = 6) ";

            if (username != null && !username.trim().isEmpty()) {

                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + ") ";
            }

            hql += " ORDER BY a." + orderColumn + " " + (orderDir != null ? orderDir : "desc");

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                // FIXED: param names now match HQL
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
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
    public int getmonthWiseListPrGraphUserCount(String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            // FIXED: was ignoring all filter params and returning total unfiltered count.
            //        Now applies the same username/date/filter conditions as the list query.
            String hql = "SELECT COUNT(a.id) FROM PRMaster a "
                    + "WHERE (a.authorizeFlag = 1 OR a.authorizeFlag = 6) ";

            if (username != null && !username.trim().isEmpty()) {
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
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
    public int getFilteredmonthWiseListPrGraphUserCount(String searchValue, String username, String StartDate, String EndDate, String Filter, String formattedDate, String formattedStartDate, String Department) {

        Session session = getSessionFactory().openSession();
        Long count = 0L;
        try {
            String hql = "SELECT COUNT(a.id) FROM PRMaster a "
                    + "WHERE (a.authorizeFlag = 1 OR a.authorizeFlag = 6) ";

            if (username != null && !username.trim().isEmpty()) {
                // FIXED: param names now match HQL
                hql += " AND (a.prAdmin = :prAdmin OR a.prAuthorizeUser = :prAuthorizeUser) ";
            }
            if (Department != null && !Department.trim().isEmpty()) {
                hql += " AND lower(a.department) LIKE :Department ";
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y %H:%i:%s') "
                        + "BETWEEN STR_TO_DATE(:formattedStartDate,'%d-%m-%Y %H:%i:%s') "
                        + "AND STR_TO_DATE(:formattedDate,'%d-%m-%Y %H:%i:%s')) ";
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                hql += " AND (STR_TO_DATE(a.announceDate,'%d-%m-%Y') "
                        + "BETWEEN STR_TO_DATE(:startDate,'%d-%m-%Y') "
                        + "AND STR_TO_DATE(:endDate,'%d-%m-%Y')) ";
            }
            if (searchValue != null && !searchValue.trim().isEmpty()) {
                hql += " AND ("
                        + "  lower(a.prNo)           LIKE :search "
                        + "OR lower(a.title)          LIKE :search "
                        + "OR lower(a.projectId)      LIKE :search "
                        + "OR lower(a.contactPerson)  LIKE :search "
                        + "OR lower(a.announceDate)   LIKE :search "
                        + "OR (a.authorizeFlag = 0  AND lower('pending')        LIKE :search) "
                        + "OR (a.authorizeFlag = 1  AND lower('approve')        LIKE :search) "
                        + "OR (a.authorizeFlag = 2  AND lower('rework')         LIKE :search) "
                        + "OR (a.authorizeFlag = 3  AND lower('reject')         LIKE :search) "
                        + "OR (a.authorizeFlag = 6  AND lower('tender created') LIKE :search) "
                        + "OR (a.authorizeFlag = 7  AND lower('draft')          LIKE :search) "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (username != null && !username.trim().isEmpty()) {
                // FIXED: param names now match HQL
                query.setParameter("prAdmin", username);
                query.setParameter("prAuthorizeUser", username);
            }
            if (Department != null && !Department.trim().isEmpty()) {
                query.setParameter("Department", "%" + Department.toLowerCase() + "%");
            }
            if (Filter != null && !Filter.trim().isEmpty()
                    && !formattedStartDate.isEmpty() && !formattedDate.isEmpty()) {
                query.setParameter("formattedStartDate", formattedStartDate);
                query.setParameter("formattedDate", formattedDate);
            }
            if (StartDate != null && !StartDate.isEmpty() && EndDate != null && !EndDate.isEmpty()) {
                query.setParameter("startDate", StartDate);
                query.setParameter("endDate", EndDate);
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

}
