/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollFinancialYear;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeDeductionAmountDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeDeductionAmountDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeDeductionAmount.class;
    }

    @Override
    public List<?> readDeductionAmount(int employeeSalaryProcessId) {
        String query = "";

        query += "Select SUM(a.deductionAmount) "
                + "From EmployeeDeductionAmount a"
                + " where a.employeeSalaryProcess.id=" + employeeSalaryProcessId
                + " group by a.employeeSalaryProcess.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readCheckDeductionAmount(int empId, PayrollFinancialYear payrollFinancialYear) {

        String sDate = payrollFinancialYear.getStartDate();
        String eDate = payrollFinancialYear.getEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
        try {

            Date s1Date = sdf.parse(sDate);
            Date e1Date = sdf.parse(eDate);

            sDate = sdf1.format(s1Date);
            eDate = sdf1.format(e1Date);

        } catch (Exception e) {

        }
        String query = "";
        query += "select a.deductionType,SUM(a.deductionAmount) from EmployeeDeductionAmount a "
                + " left join a.employeeSalaryProcess b"
                + " where a.deductionType like '%Provident Fund%'"
                + " and b.employeeMaster.id  = " + empId
                + " and STR_TO_DATE(CONCAT(b.month,'/',b.year), '%m/%Y') BETWEEN STR_TO_DATE('" + sDate + "', '%m/%Y') and STR_TO_DATE('" + eDate + "', '%m/%Y')";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readEmployeeForSalaryDeductioninfo(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select a.deductionType,a.deductionAmount"
                + " From EmployeeDeductionAmount a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForSalaryAddDeductioninfo(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select a.deductionAmount"
                + " From EmployeeDeductionAmount a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readCheckDeductionPtAmount(int empId, PayrollFinancialYear payrollFinancialYear) {
        String sDate = payrollFinancialYear.getStartDate();
        String eDate = payrollFinancialYear.getEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
        try {

            Date s1Date = sdf.parse(sDate);
            Date e1Date = sdf.parse(eDate);

            sDate = sdf1.format(s1Date);
            eDate = sdf1.format(e1Date);

        } catch (Exception e) {

        }
        String query = "";
        query += "select a.deductionType,SUM(a.deductionAmount) from EmployeeDeductionAmount a "
                + " left join a.employeeSalaryProcess b"
                + " where a.deductionType like '%Professional Tax%'"
                + " and b.employeeMaster.id  = " + empId
                + " and STR_TO_DATE(CONCAT(b.month,'/',b.year), '%m/%Y') BETWEEN STR_TO_DATE('" + sDate + "', '%m/%Y') and STR_TO_DATE('" + eDate + "', '%m/%Y')";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readByDedutionSalaryAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";
//        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " select a "
                + "From EmployeeDeductionAmount a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForloanEditinfo(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select b.text,a.monthEmi,a.monthlyRateAmount,b.id,c.id,a.id,a.lMonth,a.lYear"
                + " From PayrollLoanRemainingAmount a"
                + " left join a.payrollLoanType b"
                + " left join a.employeeMaster c"
                + " where c.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and a.lMonth='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.lYear='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public void delete1(int empSalaryProcessid, String payrollLoanType) {
        String query = "";
        query += "  "
                + "FROM EmployeeDeductionAmount a "
                + " left join a.employeeSalaryProcess c"
                + " WHERE c.id = " + empSalaryProcessid
                + " and a.deductionType like ='" + payrollLoanType + "'";

        getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readEmployeeloandelete(int empSalaryProcessid, String payrollLoanType) {
//       String query = "";
//        query += "  select "
//                + " FROM EmployeeDeductionAmount a "
//                + " left join a.employeeSalaryProcess c"
//                + " WHERE c.id = " + empSalaryProcessid
//                + " and a.deductionType ='" + payrollLoanType + "'";
////                  + " and a.deductionType ='" + payrollLoanType + "'";
//        
//        return getHibernateTemplate().find(query);

        String query = "";
        String condition = "";

        query += " Select a.id"
                + " From EmployeeDeductionAmount a"
                + " left join a.employeeSalaryProcess b"
                + " where b.id= " + empSalaryProcessid
                + " and a.deductionType='" + payrollLoanType + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForSalaryDeductioninfoSearch(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select a.deductionType,a.deductionAmount"
                + " From EmployeeDeductionAmount a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and a.deductionType not like '%LoanIntRate%'"
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeTdsAmount(int employeeMasterID, String startDate, String endate) {
        String query = "";
        String condition = "";
        String sDate = startDate;
        String eDate = endate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
        try {

            Date s1Date = sdf.parse(startDate);
            Date e1Date = sdf.parse(endate);

            sDate = sdf1.format(s1Date);
            eDate = sdf1.format(e1Date);

        } catch (Exception e) {

        }
//      String query = "";
//        String condition = "";

        query += " Select a.deductionType,a.deductionAmount"
                + " From EmployeeDeductionAmount a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeMasterID
                + " and a.deductionType like '%TDS%'"
                 + " and STR_TO_DATE(CONCAT(b.month,'/',b.year), '%m/%Y') BETWEEN STR_TO_DATE('" + sDate + "', '%m/%Y') and STR_TO_DATE('" + eDate + "', '%m/%Y')"
                + " group by b.id";

        return getHibernateTemplate().find(query);  
    }

}
