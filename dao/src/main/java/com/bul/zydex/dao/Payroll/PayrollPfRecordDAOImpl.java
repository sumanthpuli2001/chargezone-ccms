/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollPfRecord;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollPfRecordDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollPfRecordDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollPfRecord.class;
    }

    @Override
    public List<?> readByEmployePfReport(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " select a "
                + " From PayrollPfRecord a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeePayrolllPfRecord(int employeeSalaryProcessId) {
        String query = "";

        query += "select  a.epfAmount,a.epsAmount,a.diifepsEpfAmount,a.empContrubtionEpf,a.compContrubtionEps,a.differentEpsEpf From PayrollPfRecord a"
                + " LEFT JOIN a.employeeSalaryProcess b "
                + " Where b.id=" + employeeSalaryProcessId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForPf(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

//        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
//            condition += " where a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
//        }
//        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
//            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
//        }
//        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
//            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
//        }
//        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
//            condition += " AND a.paymentType = " + employeeMaster.getPaymentType();
//        }
        if (!"".equals(employeeMaster.getBankAccountNo()) && null != employeeMaster.getBankAccountNo()) {
            condition += " WHERE b.month = '" + employeeMaster.getBankAccountNo() + "'";
        }
        if (!"".equals(employeeMaster.getPanCard()) && null != employeeMaster.getPanCard()) {
            condition += " AND b.year = '" + employeeMaster.getPanCard() + "'";
        }
        query += " Select a.employeeId,a.employeeName,j.empContrubtionEpf,j.compContrubtionEps,j.differentEpsEpf,"
                + " a.id,b.id"
                + " From PayrollPfRecord j"
                + " left join j.employeeSalaryProcess b"
                + " left join b.employeeMaster a"
                + " where b.month  ='" + employeeMaster.getBankAccountNo() + "'"
                + " and b.year  ='" + employeeMaster.getPanCard() + "'";

        return getHibernateTemplate().find(query);
    }

}
