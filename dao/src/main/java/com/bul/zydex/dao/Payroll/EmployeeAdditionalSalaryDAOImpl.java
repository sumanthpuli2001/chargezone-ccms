/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollFinancialYear;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeAdditionalSalaryDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeAdditionalSalaryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeAdditionalSalary.class;
    }

    @Override
    public List<?> readAdditionalAmount(int employeeSalaryProcessId) {
        String query = "";

        query += "Select SUM(a.additionalAmount) "
                + "From EmployeeAdditionalSalary a"
                + " where a.employeeSalaryProcess.id=" + employeeSalaryProcessId
                + " group by a.employeeSalaryProcess.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForSalaryAdditionalinfo(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select a.payrollSalaryType,a.additionalAmount"
                + " From EmployeeAdditionalSalary a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForSalaryAddAdditionalinfo(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select a.additionalAmount"
                + " From EmployeeAdditionalSalary a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readCheckAdditionalAmount(int empId, PayrollFinancialYear payrollFinancialYear) {
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
        String query = "SELECT ";

        query += "(select SUM(c.employeeBasicSalary) from EmployeeSalaryProcess c where c.id=a.id),"
                + "(select SUM(d.additionalAmount) from EmployeeAdditionalSalary d where d.employeeSalaryProcess.id=a.id)"
                + " from EmployeeSalaryProcess a"
                + " left join a.employeeAdditionalSalaries b "
                + " where a.employeeMaster.id  = " + empId
                + " and STR_TO_DATE(CONCAT(a.month,'/',a.year), '%m/%Y') BETWEEN STR_TO_DATE('" + sDate + "', '%m/%Y') and STR_TO_DATE('" + eDate + "', '%m/%Y')"
                + " Group by a.month";
        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readByAdditionalSalaryAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";
//        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " select a "
                + "From EmployeeAdditionalSalary a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readNotOTamountAdditionalAmount(int employeeSalaryProcessId) {
        String query = "";
        query += "Select SUM(a.additionalAmount) "
                + "From EmployeeAdditionalSalary a"
                + " where a.employeeSalaryProcess.id=" + employeeSalaryProcessId
                + "and a.payrollSalaryType not like 'OT Amount'"
                + "and a.payrollSalaryType not like 'Conveyance'"
                + " group by a.employeeSalaryProcess.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForSalaryAdditionalinfoSearch(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " Select a.payrollSalaryType,a.additionalAmount"
                + " From EmployeeAdditionalSalary a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and a.payrollSalaryType not like '%OT Amount%'"
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeAllowanceGrossTotalTaxable(int EmpSalaryProcessId) {
        String query = "";
        String condition = "";

        query += " Select a.payrollSalaryType,a.additionalAmount"
                + " From EmployeeAdditionalSalary a"
                + " where a.employeeSalaryProcess.id= " + EmpSalaryProcessId;

        return getHibernateTemplate().find(query);
    }

    

}
