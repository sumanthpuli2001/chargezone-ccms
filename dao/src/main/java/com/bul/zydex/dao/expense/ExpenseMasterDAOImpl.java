/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.expense;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ExpenseMaster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author dhruv
 */
public class ExpenseMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ExpenseMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ExpenseMaster.class;
    }

    @Override
    public List<?> readByEmpId(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String query = "";
        String condition = "";
//        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getId()) {
//            condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
//        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y')";
        }
        if ((!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) && expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard().contains("/")) && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y')";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y') ";
        }

        query += " Select a "
                + "FROM ExpenseMaster a"
                + " left join a.employeeMasterByApprover1Id b"
                + " left join a.employeeMasterByApprover2Id c"
                + " WHERE a.employeeMasterByEmployeeId.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "" + condition
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByApproverId(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String query = "";

        query += ""
                + " Select a.dateOfSubmit,a.id "
                + " FROM ExpenseMaster a"
                + " left join a.employeeMasterByApprover1Id b"
                + " left join a.employeeMasterByApprover2Id c"
                + " WHERE b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + " or c.id=" + expenseMaster.getEmployeeMasterByEmployeeId().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByApprover1List(int appId, int tabId) {
        String query = "";
        query += " "
                + " FROM ExpenseMaster a "
                + " LEFT JOIN a.employeeMasterByApprover1Id b"
                + " LEFT JOIN a.employeeMasterByEmployeeId c"
                + " WHERE b.id='" + appId + "' and  a.id='" + tabId + "' and (a.status=0) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByApprover2List(int appId, int tabId) {
        String query = "";
        query += " "
                + " FROM ExpenseMaster a "
                + " LEFT JOIN a.employeeMasterByApprover2Id b"
                + " LEFT JOIN a.employeeMasterByEmployeeId c"
                + " WHERE b.id='" + appId + "' and  a.id='" + tabId + "' and (a.status=0) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByExpensePendingRequest(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String query = "";
        query += " Select a "
                + "FROM ExpenseMaster a"
                + " left join a.employeeMasterByApprover1Id b"
                + " left join a.employeeMasterByApprover2Id c"
                + " WHERE a.employeeMasterByEmployeeId=" + expenseMaster.getEmployeeMasterByEmployeeId().getId()
                + " and a.status=0";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByExpenseApproverPendingRequest(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String query = "";
        query += " Select a.id,b.employeeName,a.dateOfSubmit"
                + " FROM ExpenseMaster a,"
                + " EmployeeMaster b"
                + " WHERE a.employeeMasterByEmployeeId=b.id"
                + " and b.reportingManagerLevel1=" + expenseMaster.getEmployeeMasterByEmployeeId().getId()
                + " and a.status=0";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByExpenseApprover2PendingRequest(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String query = "";
        query += " Select a.id,b.employeeName"
                + " FROM ExpenseMaster a,"
                + " EmployeeMaster b"
                + " WHERE a.employeeMasterByEmployeeId=b.id"
                + " and b.reportingManagerLevel2=" + expenseMaster.getEmployeeMasterByEmployeeId().getId()
                + " and a.status=0";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTravelExpenseReportList() {

        String sqlString = "SELECT"
                + " SUM(CASE WHEN status In (0,1,2) THEN 1 ELSE 0 END) AS pending,"
                + " SUM(CASE WHEN status = 4 THEN 1 ELSE 0 END) AS completed"
                + " FROM expense_master WHERE expense_master.expense_type = 'Travel'";
//        String hqlQuery = "SELECT"
//                + " SUM(CASE WHEN status In (0,1,2) THEN 1 ELSE 0 END) AS pending,"
//                + " SUM(CASE WHEN status = 4 THEN 1 ELSE 0 END) AS completed"
//                + " FROM ExpenseMaster";
//        return getHibernateTemplate().find(hqlQuery);
//        Session session = getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        List<?> list = session.createQuery(hqlQuery).list();
//        session.getTransaction().commit();
//        return list;
        Query query = getSession().createSQLQuery(sqlString);
        List<?> probationToconfirmationRequestDataList = query.list();
        return probationToconfirmationRequestDataList;
    }

    @Override
    public List<?> readExpenseReportListForAdmin() {

        String hqlQuery = ""
                + "  FROM ExpenseMaster a"
                + " where a.status IN (2,0)"
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(hqlQuery);
    }

    @Override
    public List<?> readExpenseRequestListForAdmin(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String condition = "";
        if (expenseMaster.getStatus() != 999) {
            condition += " AND a.status = " + expenseMaster.getStatus() + "";
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (null != expenseMaster.getEmployeeMasterByEmployeeId()) {

            if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getId()) {
                condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
            }
            if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getChild1()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getChild1()) {
                condition += " AND c.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getChild1() + "";
            }
            if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getChild2()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getChild2()) {
                condition += " AND d.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getChild2() + "";
            }
            if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getCompany()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getCompany()) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getCompany() + "','%d/%m/%Y')";
            }
            if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1() + "','%d/%m/%Y')";
            }
            if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getCompany()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getCompany()
                    && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getCompany() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1() + "','%d/%m/%Y') ";

            }
        }

        String hqlQuery = "Select b.employeeId, b.employeeName, c.departmentName, d.designationName,a.expenseType,a.status,a.dateOfSubmit,a.id,b.id,"
                + " case when a.status=4 then z.employeeName ELSE x.employeeName END as approver "
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " left join a.employeeMasterByApprover1Id x"
                + " left join a.employeeMasterByApprover2Id z"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " where 1=1" + condition
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(hqlQuery);
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel1(T object, String reportingManagerLevel1_id) throws ParseException {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();

        String condition = "";
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId())) {
                condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
            }
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y')";
        }
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y')";
            }
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                && null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {

            if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                    && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y') ";
            }
        }

        String hqlQuery = "Select a.id, a.dateOfSubmit, b.employeeId, b.employeeName, a.expenseType, a.status, b.id"
                + " ,case when a.status=4 then z.employeeName ELSE x.employeeName END as approver "
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " left join a.employeeMasterByApprover1Id x"
                + " left join a.employeeMasterByApprover2Id z"
                + " where 1=1"
                + " and a.status !=3"
                + " and b.reportingManagerLevel1='" + reportingManagerLevel1_id + "'" + condition;
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[1];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 4);
            Date output = c.getTime();
            if (output.equals(today) || today.before(output)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel2(T object, String reportingManagerLevel2_id) throws ParseException {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();

        String condition = "";
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId())) {
                condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
            }
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y')";
        }
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y')";
            }
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                && null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {

            if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                    && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y') ";
            }
        }

        String hqlQuery = "Select a.id, a.dateOfSubmit, b.employeeId, b.employeeName, a.expenseType, a.status, b.id"
                + " ,case when a.status=4 then z.employeeName ELSE x.employeeName END as approver "
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " left join a.employeeMasterByApprover1Id x"
                + " left join a.employeeMasterByApprover2Id z"
                + " where 1=1"
                + " and a.status !=3"
                + " and b.reportingManagerLevel2='" + reportingManagerLevel2_id + "'" + condition;
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[1];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 8);
            Date output = c.getTime();
            c.setTime(date);
            c.add(Calendar.DATE, 4);
            Date pastDate = c.getTime();
            if ((today.equals(output) || today.before(output)) && output.after(pastDate)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel3(T object, String reportingManagerLevel3_id) throws ParseException {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();
        String condition = "";
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId())) {
                condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
            }
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y')";
        }
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y')";
            }
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                && null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {

            if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                    && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y') ";
            }
        }

        String hqlQuery = "Select a.id, a.dateOfSubmit, b.employeeId, b.employeeName, a.expenseType, a.status, b.id"
                + " ,case when a.status=4 then z.employeeName ELSE x.employeeName END as approver "
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " left join a.employeeMasterByApprover1Id x"
                + " left join a.employeeMasterByApprover2Id z"
                + " where 1=1"
                + " and a.status !=3"
                + " and b.reportingManagerLevel3='" + reportingManagerLevel3_id + "'" + condition;
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[1];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 12);
            Date output = c.getTime();
            c.setTime(date);
            c.add(Calendar.DATE, 8);
            Date pastDate = c.getTime();
            if ((today.equals(output) || today.before(output)) && output.after(pastDate)) {

            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<?> readExpenseRequestByReportingLevel4(T object, String reportingManagerLevel4_id) throws ParseException {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String now = sdf.format(today);
        Calendar c = Calendar.getInstance();

        String condition = "";
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId())) {
                condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
            }
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y')";
        }
        if (null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {
            if (null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y')";
            }
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                && null != expenseMaster.getEmployeeMasterByEmployeeId() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId())) {

            if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                    && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard())) {
                condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y') ";
            }
        }

        String hqlQuery = "Select a.id, a.dateOfSubmit, b.employeeId, b.employeeName, a.expenseType, a.status, b.id"
                + " ,case when a.status=4 then z.employeeName ELSE x.employeeName END as approver "
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " left join a.employeeMasterByApprover1Id x"
                + " left join a.employeeMasterByApprover2Id z"
                + " where 1=1"
                + " and a.status !=3"
                + " and b.reportingManagerLevel4='" + reportingManagerLevel4_id + "'" + condition;
        List<?> list = getHibernateTemplate().find(hqlQuery);
        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String dd = "" + next[0];
            String dateOfSubmit = "" + next[1];
            Date date = sdf.parse(dateOfSubmit);
            c.setTime(date); // Now use today date.
            c.add(Calendar.DATE, 16);
            Date output = c.getTime();
            c.setTime(date);
            c.add(Calendar.DATE, 12);
            Date pastDate = c.getTime();
            if ((today.equals(output) || today.before(output)) && output.after(pastDate)) {

            } else {
                iterator.remove();
            }

        }
        return list;
    }

    @Override
    public List<?> searchExpenseReportByEmployee(T object) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String condition = "";
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getId()) {
            condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y')";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y')";
        }
        if (!"".equals(expenseMaster.getDateOfSubmit()) && null != expenseMaster.getDateOfSubmit()
                && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getDateOfSubmit() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getAdharCard() + "','%d/%m/%Y') ";
        }

        String hqlQuery = "Select b.employeeId, b.employeeName, c.departmentName, d.designationName,a.expenseType,a.status,a.dateOfSubmit,a.id,b.id"
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " where 1=1" + condition;
        return getHibernateTemplate().find(hqlQuery);
    }

    @Override
    public List<?> readExpenseRequestListOfSubordinates(T object, String reportingLevel_Id) {
        ExpenseMaster expenseMaster = (ExpenseMaster) object;
        String condition = "";
        if (expenseMaster.getStatus() != 999) {
            condition += " AND a.status = " + expenseMaster.getStatus() + "";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getId()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getId()) {
            condition += " AND b.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getId() + "";
        }
        if (!"".equals(expenseMaster.getExpenseType()) && null != expenseMaster.getExpenseType()) {
            condition += " AND a.expenseType = '" + expenseMaster.getExpenseType() + "'";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getChild1()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getChild1()) {
            condition += " AND c.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getChild1() + "";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getChild2()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getChild2()) {
            condition += " AND d.id = " + expenseMaster.getEmployeeMasterByEmployeeId().getChild2() + "";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getCompany()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getCompany()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') >= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getCompany() + "','%d/%m/%Y')";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') <= STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1() + "','%d/%m/%Y')";
        }
        if (!"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getCompany()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getCompany()
                && !"".equals(expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) && null != expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1()) {
            condition += " AND STR_TO_DATE(a.dateOfSubmit,'%d/%m/%Y') BETWEEN STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getCompany() + "','%d/%m/%Y') AND STR_TO_DATE('" + expenseMaster.getEmployeeMasterByEmployeeId().getContactNo1() + "','%d/%m/%Y') ";
        }

        String hqlQuery = "Select b.employeeId, b.employeeName, c.departmentName, d.designationName,a.expenseType,a.status,a.dateOfSubmit,a.id,b.id"
                + " ,case when a.status=4 then z.employeeName ELSE x.employeeName END as approver "
                + "  FROM ExpenseMaster a"
                + " Left Join a.employeeMasterByEmployeeId b"
                + " left join a.employeeMasterByApprover1Id x"
                + " left join a.employeeMasterByApprover2Id z"
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " where b.reportingManagerLevel1='" + reportingLevel_Id + "' " + condition;
        return getHibernateTemplate().find(hqlQuery);
    }

}
