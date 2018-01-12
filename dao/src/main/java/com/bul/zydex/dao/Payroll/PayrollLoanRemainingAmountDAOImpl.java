/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollLoanRemainingAmount;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollLoanRemainingAmountDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollLoanRemainingAmountDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollLoanRemainingAmount.class;
    }

    @Override
    public List<?> readByLoanReaminingAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";
//        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " select a "
                + "From PayrollLoanRemainingAmount a"
                + " left join a.employeeMaster b"
                + " where b.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and a.lMonth='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.lYear='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByloanRemainingAmountslip(int id, String month, String year) {
        String query = "";
        query += "Select SUM(a.clBal) "
                + "From PayrollLoanRemainingAmount a"
                + " where a.employeeMaster.id=" + id
                + " and DATE_FORMAT(STR_TO_DATE('" + month + "','%m'),'%m') = DATE_FORMAT(STR_TO_DATE(a.lMonth,'%m'),'%m')"
                + " and DATE_FORMAT(STR_TO_DATE('" + year + "','%y'),'%y') = DATE_FORMAT(STR_TO_DATE(a.lYear,'%y'),'%y')";
//                + " and DATE_FORMAT(STR_TO_DATE('" + month + "/" + year + "', '%m/%Y'),'%m/%Y')"
//                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.startDate, '%d/%m/%Y'),'%m/%Y') AND DATE_FORMAT(STR_TO_DATE(a.endDate, '%d/%m/%Y'),'%m/%Y')";
//                + " group by a.employeeSalaryProcess.id";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List<?> getPayrollLoanDetails(EmployeeMaster employeeMaster) {

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
            condition += " AND pld.lMonth = '" + employeeMasterObject.getChild1() + "'";
        }
        if (null != employeeMasterObject.getChild2() && !"".equals(employeeMasterObject.getChild2())) {
            condition += " AND pld.lYear = '" + employeeMasterObject.getChild2() + "'";
        }
        if (0 != employeeMasterObject.getDepartmentMaster().getId()) {
            condition += " AND dm.id = '" + employeeMasterObject.getDepartmentMaster().getId() + "'";
        }
        query += "select em.employeeId,em.employeeName,plt.text,pld.opRemainingBal,pld.monthEmi,pld.monthlyRateAmount,pld.monthyInstallment,pld.clBal,em.company,"
                + " pld.lMonth,pld.lYear,dm.departmentName"
                + " FROM PayrollLoanRemainingAmount pld "
                + " left join pld.payrollLoanType plt"
                + " left join pld.employeeMaster em"
                + " left join em.departmentMaster dm "
                + " Where 1=1" + condition;
//                + " GROUP BY pld.lMonth,pld.lYear ";

        return getHibernateTemplate().find(query);

    }

    @Override
    public void delete1(T object) {
        PayrollLoanRemainingAmount payrollLoanRemainingAmount = (PayrollLoanRemainingAmount) object;
        String query = "";

        query += "  "
                + "delete FROM PayrollLoanRemainingAmount a "
                + " WHERE a.id = " + payrollLoanRemainingAmount.getId();
        getHibernateTemplate().bulkUpdate(query);

    }

    @Override
    public List<?> readByloanDepartment(String month, String year) {
        String query = "";
        query += "Select a.id, dm.departmentName "
                + "From PayrollLoanRemainingAmount a"
                + " left join a.employeeMaster em"
                + " left join em.departmentMaster dm"
                + " where DATE_FORMAT(STR_TO_DATE('" + month + "','%m'),'%m') = DATE_FORMAT(STR_TO_DATE(a.lMonth,'%m'),'%m')"
                + " and DATE_FORMAT(STR_TO_DATE('" + year + "','%y'),'%y') = DATE_FORMAT(STR_TO_DATE(a.lYear,'%y'),'%y')";
//               
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
