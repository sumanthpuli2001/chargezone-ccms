/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollLoanDetail;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author Hussain
 */
public class PayrollLoanDetailDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollLoanDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollLoanDetail.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        PayrollLoanDetail payrollLoanDetail = (PayrollLoanDetail) object;
        String query = "";
        query += ""
                + " From PayrollLoanDetail a "
                + " where a.employeeMaster = " + payrollLoanDetail.getEmployeeMaster().getId()
                + " and a.payrollLoanType = " + payrollLoanDetail.getPayrollLoanType().getId();
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        List<?> list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;

    }

//    
//    @Override
//    public List<?> readLoanDetails(int employeeid) {
//        
//        String query = "";
//        query += "select a.id,b.text"
//                + " FROM PayrollLoanDetail a "
//                + " left join a.payrollLoanType b"
//                + " where a.employeeMaster.id=" + employeeid
//                + " and DATE_FORMAT(STR_TO_DATE(a.startDate, '%m/%Y'),'%m/%Y')=DATE_FORMAT(STR_TO_DATE( '"+ employeeSalaryProcess.getMonth() + "/" + employeeSalaryProcess.getYear() + "', '%d/%m/%Y'),'%m/%Y')";
//
//        return getHibernateTemplate().find(query);
//    }
    @Override
    public List<?> readLoanDetails(int employeeid, String month, String year) {

        String date = month + "/" + year;
//
        String query = "";
        query += "select a.loanAmount,a.monltyEmi,a.instRate,b.text,b.id,a.id"
                + " FROM PayrollLoanDetail a "
                + " left join a.payrollLoanType b"
                + " where a.employeeMaster.id=" + employeeid
                //                + " and DATE_FORMAT(STR_TO_DATE('" + month + "/" + year + "', '%m/%Y'),'%m/%Y')"
                //                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.startDate, '%d/%m/%Y'),'%m/%Y') AND DATE_FORMAT(STR_TO_DATE(a.endDate, '%d/%m/%Y'),'%m/%Y')";
                + " and STR_TO_DATE(CONCAT('" + month + "/" + year + "'), '%m/%Y') BETWEEN STR_TO_DATE(a.startDate, '%m/%Y') and STR_TO_DATE(a.endDate, '%m/%Y')";
        return getHibernateTemplate().find(query);
//                + " and DATE_FORMAT(STR_TO_DATE(a.startDate, '%d/%m/%Y'),'%m/%Y')>= DATE_FORMAT(STR_TO_DATE('" + date + "', '%m/%Y'),'%m/%Y')"
//                + " and DATE_FORMAT(STR_TO_DATE(a.endDate, '%d/%m/%Y'),'%m/%Y')<= DATE_FORMAT(STR_TO_DATE('" + date + "', '%m/%Y'),'%m/%Y')";
//                 + " and STR_TO_DATE(CONCAT("+date+"), '%m/%Y') BETWEEN STR_TO_DATE('" + sDate+"', '%m/%Y') and STR_TO_DATE('" + eDate+"', '%m/%Y')";
//       
    }

    @Override
    public List<?> readByloanDeatils(int id) {
        String query = "";
        query += " "
                + " FROM PayrollLoanDetail a "
                + " WHERE a.employeeMaster.id=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByloanRemainingAmount(int id, String month, String year) {
        String query = "";
        query += "Select SUM(a.loanAmount) "
                + "From PayrollLoanDetail a"
                + " where a.employeeMaster.id=" + id
                + " and DATE_FORMAT(STR_TO_DATE('" + month + "/" + year + "', '%m/%Y'),'%m/%Y')"
                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.startDate, '%d/%m/%Y'),'%m/%Y') AND DATE_FORMAT(STR_TO_DATE(a.endDate, '%d/%m/%Y'),'%m/%Y')";
//                + " group by a.employeeSalaryProcess.id";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List<?> getLoanDetails(EmployeeMaster employeeMaster) {

        String query = "";
        String condition = "";
        EmployeeMaster employeeMasterObject = (EmployeeMaster) employeeMaster;

        if (!"".equals(employeeMasterObject.getId()) && null != employeeMasterObject.getId()) {
            condition += " AND em.id = " + employeeMasterObject.getId();
        }
        if (!"".equals(employeeMasterObject.getCityOfEmployee()) && null != employeeMasterObject.getCityOfEmployee()) {
            condition += " AND plt.id = " + employeeMasterObject.getCityOfEmployee();
        }
        if (null != employeeMasterObject.getChild1() && !"".equals(employeeMasterObject.getChild1())) {
            condition += " AND esp.month = '" + employeeMasterObject.getChild1() + "'";
        }
        if (null != employeeMasterObject.getChild2() && !"".equals(employeeMasterObject.getChild2())) {
            condition += " AND esp.year = '" + employeeMasterObject.getChild2() + "'";
        }
        if (0 != employeeMasterObject.getDepartmentMaster().getId()) {
            condition += " AND dm.id = '" + employeeMasterObject.getDepartmentMaster().getId() + "'";
        }
        query += "select em.employeeId,em.employeeName,plt.text,pld.loanAmount,pld.monltyEmi,pld.instRate,em.company"
                + " FROM PayrollLoanDetail pld "
                + " left join pld.payrollLoanType plt"
                + " left join pld.employeeMaster em"
                + " left join em.employeeSalaryProcesses esp "
                + " left join em.departmentMaster dm "
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> getLoanName(String loanId) {

        String query = "";
        query += "select plt.text"
                + " FROM PayrollLoanDetail pld "
                + " left join pld.payrollLoanType plt"
                + " WHERE plt.id=" + loanId;
//                + " left join pld.employeeMaster em"
//                + " left join em.employeeSalaryProcesses esp "
//                + " left join em.departmentMaster dm "

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByLoanEdit(int id, int payrollTypeid) {
        String query = "";
        query += "select a.loanAmount,a.monltyEmi,a.opRemainingBal,a.id,a.startDate,a.endDate,a.instRate,a.monthlyRateAmount"
                + " FROM PayrollLoanDetail a "
                + " left join a.payrollLoanType b"
                + " where a.employeeMaster.id=" + id
                + " and b.id=" + payrollTypeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByloanRemainingAmountslip(int id, String month, String year) {
        String date = month + "/" + year;
        String query = "";
        query += "Select SUM(a.loanAmount) "
                + "From PayrollLoanDetail a"
                + " left join a.payrollLoanType b"
                + " where b.text like '%Company Loan%'"
                + " and a.employeeMaster.id=" + id
                + " and STR_TO_DATE(CONCAT('" + month + "/" + year + "'), '%m/%Y') BETWEEN STR_TO_DATE(a.startDate, '%m/%Y') and STR_TO_DATE(a.endDate, '%m/%Y')";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List<?> readLoanDetailsUpdate(int employeeid, String month, String year) {
      String date = month + "/" + year;
//
        String query = "";
        query += "select a.loanAmount,a.monltyEmi,a.instRate,b.text,b.id,a.id,a.opRemainingBal"
                + " FROM PayrollLoanDetail a "
                + " left join a.payrollLoanType b"
                + " where a.employeeMaster.id=" + employeeid
                + " and STR_TO_DATE(CONCAT('" + month + "/" + year + "'), '%m/%Y') BETWEEN STR_TO_DATE(a.startDate, '%m/%Y') and STR_TO_DATE(a.endDate, '%m/%Y')";
        return getHibernateTemplate().find(query);
    }
}
