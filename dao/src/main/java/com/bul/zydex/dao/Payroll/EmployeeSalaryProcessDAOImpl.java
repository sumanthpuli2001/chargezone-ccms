/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollAdditionalAmount;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeSalaryProcessDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeSalaryProcessDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeSalaryProcess.class;
    }

    @Override
    public List<?> readEmployeeForSalary(EmployeeMaster employeeMaster) {

        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }

        query += " From EmployeeMaster a "
                + " Where 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readsal(EmployeeMaster employeeMaster) {

        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND b.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (null != employeeMaster.getEmployeeType() && !"".equals(employeeMaster.getEmployeeType())) {
            condition += " AND b.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (null != employeeMaster.getCompany() && !"".equals(employeeMaster.getCompany())) {
            condition += " AND b.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (null != employeeMaster.getPaymentType() && !"".equals(employeeMaster.getPaymentType())) {
            condition += " AND b.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }
        if (null != employeeMaster.getBankName() && !"".equals(employeeMaster.getBankName())) {
            condition += " AND a.month = '" + employeeMaster.getBankName() + "'";
        }
        if (null != employeeMaster.getChild1() && !"".equals(employeeMaster.getChild1())) {
            condition += " AND a.year = '" + employeeMaster.getChild1() + "'";
        }
        if (null != employeeMaster.getBasicSalary() && !"".equals(employeeMaster.getBasicSalary())) {
            condition += " AND c.payrollSalaryType like '%" + employeeMaster.getBasicSalary() + "%'";
        }
        query += "Select b.employeeId, b.employeeName,a.employeeLwp,a.employeeBasicSalary,c.additionalAmount,c.payrollSalaryType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where 1=1" + condition
                + " GROUP BY a.id,c.payrollSalaryType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readdaywise(int empId, String Date) {
        PayrollAdditionalAmount payrollAdditionalAmount = (PayrollAdditionalAmount) readById(empId);
        String query = "";
        String condition = "";

        query += "Select b.employeeId, b.employeeName,a.amount,a.date"
                + " From PayrollAdditionalAmount a"
                + " LEFT JOIN a.employeeMaster b";
//                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForFormSixteen(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND b.id = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getEmployeeName()) && null != employeeMaster.getEmployeeName()) {
            condition += " AND a.employeeName = '" + employeeMaster.getEmployeeName() + "'";
        }

        query += " Select a.employeeId, a.employeeName, a.id, b.id"
                + " From EmployeeMaster a,"
                + " PayrollFinancialYear b"
                + " Where a.zydexLocationMaster.id = b.zydexLocationMaster.id "
                + " and 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForPf(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }
        query += " Select a.employeeId, a.employeeName,c.deductionAmount,"
                + " (a.pfAmountEmployer*8.33)/100 as epfAmount,"
                + " (a.pfAmountEmployer*3.67)/100 as apfAmount,"
                + " a.id,b.id"
                + " From EmployeeMaster a"
                + " left join a.employeeSalaryProcesses b"
                + " left join b.employeeDeductionAmounts c"
                + " where c.deductionType ='Provident Fund' " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForPt(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

        query += " Select a.employeeId, a.employeeName,c.deductionAmount,a.id,b.id,b.grossTotal"
                + " From EmployeeMaster a"
                + " left join a.employeeSalaryProcesses b"
                + " left join b.employeeDeductionAmounts c"
                + " where c.deductionType ='Professional Tax' " + condition;

        return getHibernateTemplate().find(query);
    }

    public List<?> readEmployeeForSlip(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

        query += " Select a.employeeId, a.employeeName,b.month,b.year,a.id,b.id,b.employeeBasicSalary"
                + " From EmployeeMaster a"
                + " left join a.employeeSalaryProcesses b"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForSalaryinfo(T object) {
        String query = "";
        String condition = "";
        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " Select a.employeeBasicSalary"
                + " From EmployeeSalaryProcess a"
                + " where a.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and a.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readsalDeduction(EmployeeMaster object) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        query += "Select b.employeeId,d.deductionAmount,d.deductionType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where 1=1" + condition
                + " GROUP BY a.id,d.deductionType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpSalary(EmployeeMaster employeeMaster) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }
        if (!"".equals(employeeSalaryProcess.getMonth()) && null != employeeSalaryProcess.getMonth()) {
            condition += " AND a.month = '" + employeeSalaryProcess.getMonth() + "'";
        }
        if (!"".equals(employeeSalaryProcess.getYear()) && null != employeeSalaryProcess.getYear()) {
            condition += " AND a.year = '" + employeeSalaryProcess.getYear() + "'";
        }

        query += "From EmployeeSalaryProcess a"
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpsal(EmployeeMaster object) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }
        if (!"".equals(employeeSalaryProcess.getMonth()) && null != employeeSalaryProcess.getMonth()) {
            condition += " AND a.month = '" + employeeSalaryProcess.getMonth() + "'";
        }
        if (!"".equals(employeeSalaryProcess.getYear()) && null != employeeSalaryProcess.getYear()) {
            condition += " AND a.year = '" + employeeSalaryProcess.getYear() + "'";
        }
        if (!"".equals(employeeMaster.getBasicSalary()) && null != employeeMaster.getBasicSalary()) {
            condition += " AND c.payrollSalaryType like '%" + employeeMaster.getBasicSalary() + "%'";
        }
        query += "Select b.employeeId, b.employeeName,a.employeeLwp,b.basicSalary,c.additionalAmount,c.payrollSalaryType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where 1=1" + condition
                + " GROUP BY a.id,c.payrollSalaryType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeeSalaryProcess(T object) {
        String query = "";
        String condition = "";
        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " From EmployeeSalaryProcess a"
                + " where a.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and a.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpSalaryReport(EmployeeMaster employeeMaster) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }
        if (null != employeeMaster.getBankName() && !"".equals(employeeMaster.getBankName())) {
            condition += " AND b.month = '" + employeeMaster.getBankName() + "'";
        }
        if (null != employeeMaster.getChild1() && !"".equals(employeeMaster.getChild1())) {
            condition += " AND b.year = '" + employeeMaster.getChild1() + "'";
        }

        query += "select b From EmployeeMaster a"
                + " LEFT JOIN a.employeeSalaryProcesses b "
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readMasterEmpsal(EmployeeMaster object) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }

        if (!"".equals(employeeMaster.getBasicSalary()) && null != employeeMaster.getBasicSalary()) {
            condition += " AND c.payrollSalaryType like '%" + employeeMaster.getBasicSalary() + "%'";
        }
        query += "Select b.employeeId, b.employeeName,b.basicSalary,c.additionalAmount,c.payrollSalaryType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " where c.payrollSalaryType not like 'leave Encashment' " + condition
                + " GROUP BY a.id,c.payrollSalaryType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readMasterEmpsalarySearch(EmployeeMaster object) {

        EmployeeMaster employeeMaster = (EmployeeMaster) object;
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND b.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND b.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND b.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND b.paymentType = '" + employeeMaster.getPaymentType();
        }

        query += "Select b.employeeId, b.employeeName,b.basicSalary "
                + " From EmployeeMaster b";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpMasterSalary(EmployeeMaster employeeMaster) {

        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }

        query += "From EmployeeMaster a"
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readOTAmountAndSalary(T object) {
        String query = "";
        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += "Select a.employeeBasicSalary,a.otAmount"
                + " From EmployeeSalaryProcess a"
                + " where a.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.year='" + employeeSalaryProcess.getYear() + "'"
                + " GROUP BY a.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readAdditionalSalary(T object) {
        String query = "";
        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += "Select b.payrollSalaryType,b.additionalAmount"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeAdditionalSalaries b"
                + " where a.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.year='" + employeeSalaryProcess.getYear() + "'"
                + " GROUP BY a.id,b.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readDeductionAmounts(T object) {
        String query = "";
        String condition = "";
        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += "Select b.deductionType,b.deductionAmount "
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeDeductionAmounts b"
                + " where a.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.year='" + employeeSalaryProcess.getYear() + "'"
                + " GROUP BY b.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeePolicyAmounts(T object) {
        String query = "";
        EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) object;

        query += " Select f.policyName,e.amount,d.company"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster d"
                + " LEFT JOIN d.employeePolicyDetail e"
                + " LEFT JOIN e.policyMaster f"
                + " where a.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and a.year='" + employeeSalaryProcess.getYear() + "'"
                + " GROUP BY e.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readProfessionalTaxes(EmployeeMaster employeeMaster) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND em.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND em.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (null != employeeMaster.getBankName() && !"".equals(employeeMaster.getBankName())) {
            condition += " AND esp.month = '" + employeeMaster.getBankName() + "'";
        }
        if (null != employeeMaster.getChild1() && !"".equals(employeeMaster.getChild1())) {
            condition += " AND esp.year = '" + employeeMaster.getChild1() + "'";
        }

        query += "select em.id,em.basicSalary,em.company,esp.id,esp.grossTotal From PayrollPtCheck ppt"
                + " LEFT JOIN ppt.employeeTypeMaster etm "
                + " LEFT JOIN ppt.employeeSubType est "
                + " LEFT JOIN etm.employeeMasters em "
                + " LEFT JOIN em.employeeSalaryProcesses esp "
                + " Where 1=1" + condition
                + " and ppt.ptCheck = 1";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readEmployeeForBankStatement(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

        query += " Select a.employeeId, a.employeeName,a.bankAccountNo,b.employeeBasicSalary,b.month,b.year,b.id"
                + " From EmployeeMaster a"
                + " left join a.employeeSalaryProcesses b"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForEsicStatement(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

//        query += " Select a.employeeId, a.employeeName,b.grossTotal,c.empContrubtion,c.compContrubtion,b.month,b.year"
//                + " From EmployeeMaster a"
//                + " left join a.employeeSalaryProcesses b"
//                + " left join b.payrollEsicDeduction c"
//                + " where 1=1 " + condition;
        query += " Select c.employeeId, c.employeeName,b.grossTotal,a.empContrubtion,a.compContrubtion,c.esicNo,b.month,b.year"
                + " From PayrollEsicDeduction a"
                + " left join a.employeeSalaryProcess b"
                + " left join b.employeeMaster c"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readEmployeeForOTStatement(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }

//       
//        query += " Select c.employeeId, c.employeeName,a.otHours,b.otAmount,b.grossTotal,c.basicSalary,d.otEsic,d.otEsicNet,b.month,b.year"
//                + " From EmployeeExcelRecord a"
//                + " left join a.employeeSalaryProcess b"
//                + " left join b.employeeMaster c"
//                + " left join b.payrollEsicDeductions d"
//                + " where  1=1" + condition;
//                + " where  1=1" + condition;
        query += "Select c.employeeId, c.employeeName,a.otHours,a.otAmount,b.grossTotal,c.basicSalary,d.otEsic,d.otEsicNet,b.month,b.year"
                + " from EmployeeExcelRecord a,"
                + " EmployeeSalaryProcess b"
                + " left join b.employeeMaster c"
                + " left join b.payrollEsicDeductions d"
                + " where a.employeeSalaryProcess.id=b.id "
                + " and a.otAmount >0 "
                + " and 1=1" + condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readOTAmounts(int employeeSalaryProcessId) {
        String query = "";

        query += "Select a.otAmount "
                + "From EmployeeSalaryProcess a"
                + " where a.id=" + employeeSalaryProcessId
                + " group by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeYearlySalary(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }

        if (!"".equals(employeeMaster.getEmployeeName()) && null != employeeMaster.getEmployeeName()) {
            condition += " AND a.id = '" + employeeMaster.getEmployeeName() + "'";
        }

        query += " Select a.employeeId, a.employeeName, a.id"
                + " From EmployeeMaster a"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readsalyearly(int empID) {
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        String query = "";
        String condition = "";
        query += "Select b.employeeId, b.employeeName,a.employeeLwp,a.employeeBasicSalary,c.additionalAmount,c.payrollSalaryType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where b.id=" + empID
                + " GROUP BY a.id,c.payrollSalaryType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readsalDeductionYearly(int empID) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        query += "Select b.employeeId,d.deductionAmount,d.deductionType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where b.id=" + empID
                + " GROUP BY a.id,d.deductionType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpSalaryReportyearly(int empID) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        query += "select b From EmployeeMaster a"
                + " LEFT JOIN a.employeeSalaryProcesses b "
                + " Where a.id=" + empID;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readEmployeebyEmpolyeeSalary(int EmpId, String month, String year) {
        String query = "";
        String condition = "";

        query += " Select a.id"
                + " From EmployeeSalaryProcess a"
                + " where a.employeeMaster.id= " + EmpId
                + " and a.month='" + month + "'"
                + " and a.year='" + year + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeMasterID(int employeeSalaryProcessId) {
        String query = "";

//        query += "select a.id"
//                + "From EmployeeSalaryProcess a"
//                + " LEFT JOIN a.employeeMaster b"
//                + " Where a.id=" + employeeSalaryProcessId;
//
//        return getHibernateTemplate().find(query);
        query += "select  a.id,b.id,a.employeeLwp,a.employeeBasicSalary,a.month,a.year,a.otAmount,a.netPayable,a.grossTotal From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b "
                + " Where a.id=" + employeeSalaryProcessId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readsalSearch(EmployeeMaster employeeMaster) {

        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND b.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (null != employeeMaster.getEmployeeType() && !"".equals(employeeMaster.getEmployeeType())) {
            condition += " AND b.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (null != employeeMaster.getCompany() && !"".equals(employeeMaster.getCompany())) {
            condition += " AND b.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (null != employeeMaster.getPaymentType() && !"".equals(employeeMaster.getPaymentType())) {
            condition += " AND b.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }
        if (null != employeeMaster.getBankName() && !"".equals(employeeMaster.getBankName())) {
            condition += " AND a.month = '" + employeeMaster.getBankName() + "'";
        }
        if (null != employeeMaster.getChild1() && !"".equals(employeeMaster.getChild1())) {
            condition += " AND a.year = '" + employeeMaster.getChild1() + "'";
        }
        if (null != employeeMaster.getBasicSalary() && !"".equals(employeeMaster.getBasicSalary())) {
            condition += " AND c.payrollSalaryType like '%" + employeeMaster.getBasicSalary() + "%'";
        }
        query += "Select b.employeeId, b.employeeName,a.employeeLwp,a.employeeBasicSalary,c.additionalAmount,c.payrollSalaryType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where c.payrollSalaryType not like '%OT Amount%'"
                + " and 1=1" + condition
                + " GROUP BY a.id,c.payrollSalaryType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readsalDeductionSearch(EmployeeMaster object) {
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "";
        String condition = "";

        query += "Select b.employeeId,d.deductionAmount,d.deductionType"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " LEFT JOIN a.employeeDeductionAmounts d"
                + " Where d.deductionType not like '%LoanIntRate%'"
                + " and 1=1" + condition
                + " GROUP BY a.id,d.deductionType";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForPfGov(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }
        query += " Select a.employeeId, a.employeeName,"
                + " a.id,b.id,"
                + " a.uanNo,b.grossTotal,a.pfAmount,a.dateOfBirth"
                + " From EmployeeMaster a"
                + " left join a.employeeSalaryProcesses b"
                + " where b.month  ='" + employeeMaster.getBankAccountNo() + "'"
                + " and b.year  ='" + employeeMaster.getPanCard() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpId(int EmpId) {

//        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String query = "SELECT a"
                + " FROM EmployeeSalaryProcess a "
                + " WHERE a.employeeMaster=" + EmpId;

        List<?> list = getHibernateTemplate().find(query);
//        if (!list.isEmpty()) {
//            employeeSalaryProcess = (EmployeeSalaryProcess) list.get(0);
//        } else {
//            employeeSalaryProcess = null;
//        }
        return list;
    }

    @Override
    public List<?> readEmployeeGrossTotalTaxable(int EmpId, String startDate, String endate) {
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
//        String date = "01/" + month + "/" + year;
        query += " select a.id,a.employeeBasicSalary"
                + " From EmployeeSalaryProcess a"
                + " LEFT JOIN a.employeeAdditionalSalaries c"
                + " where a.employeeMaster.id=" + EmpId
                + " and STR_TO_DATE(CONCAT(a.month,'/',a.year), '%m/%Y') BETWEEN STR_TO_DATE('" + sDate + "', '%m/%Y') and STR_TO_DATE('" + eDate + "', '%m/%Y')"
                + " group by a.id";
        return getHibernateTemplate().find(query);
//         + " WHERE b.id=" + empId + " and (STR_TO_DATE(a.completeDateStr,'%d/%m/%Y') BETWEEN  STR_TO_DATE('" + startD + "','%d/%m/%Y') AND STR_TO_DATE('" + endD + "','%d/%m/%Y')) "
    }
    
     public List<?> readEmployeeForSlip1(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " AND b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }
        if (!"".equals(employeeMaster.getId()) && null != employeeMaster.getId()) {
            condition += " AND a.id = " + employeeMaster.getId();
        }

        query += " Select a.employeeId, a.employeeName,b.month,b.year,a.id,b.id,b.employeeBasicSalary"
                + " From EmployeeMaster a"
                + " left join a.employeeSalaryProcesses b"
                + " where 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }

}
