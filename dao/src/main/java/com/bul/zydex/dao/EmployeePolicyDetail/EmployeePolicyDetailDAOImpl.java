/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.EmployeePolicyDetail;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePolicyDetail;
import java.util.List;

/**
 *
 * @author OptiPlex
 */
public class EmployeePolicyDetailDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeePolicyDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeePolicyDetail.class;
    }

    @Override
    public List<?> readPolicy(int employeeid) {
        String query = "";
        query += "select a.amount,b.policyName"
                + " FROM EmployeePolicyDetail a "
                + " left join a.policyMaster b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeForPolicy(EmployeeMaster object) {
        String query = "";
        String condition = "";
        EmployeeMaster employeeMaster = (EmployeeMaster) object;

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND c.id = " + employeeMaster.getAdharCard();
        }

//     
        query += " Select c.employeeId, c.employeeName,b.policyNum,b.amount,d.policyName,b.id"
                + " From EmployeeSalaryProcess a"
                + " left join a.employeeMaster c"
                + " left join c.employeePolicyDetail b"
                + " left join b.policyMaster d"
                + " where a.month='" + employeeMaster.getBankAccountNo() + "'"
                + " and a.year='" + employeeMaster.getPanCard() + "'"
                + " and b.policyMaster.id='" + employeeMaster.getBankIfscCode() + "'"
                + " and 1=1 " + condition;
//       

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPolicyAName(int policyid) {
        String query = "";
        query += "select b.policyName"
                + " FROM EmployeePolicyDetail a "
                + " left join a.policyMaster b"
                + " where b.id=" + policyid
                + " Group by b.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> fetchPolicyData(int empId) {
        String query = "";
        query += " select b.id,b.policyName,a.policyNum,a.amount,a.status"
                + " FROM EmployeePolicyDetail a "
                + " left join a.policyMaster b"
                + " left join a.employeeMaster c"
                + " where c.id=" + empId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPolicyId(int empId) {
        String query = "";

        query += " "
                + " FROM EmployeePolicyDetail a "
                + " where a.employeeMaster.id=" + empId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readBypolicyAmount(int empId) {
        String query = "";

        query += " "
                + " FROM EmployeePolicyDetail a "
                + " where a.employeeMaster.id=" + empId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public boolean readBypolicyAmountTaxableAmount(Integer empID, Integer salaryType) {
        boolean flag = true;

        String query = "";
        query += ""
                + " From EmployeePolicyDetail a "
                + " where a.employeeMaster = " + empID
                + " and a.policyMaster = " + salaryType
                + " and a.status=" + 1;
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        List<?> list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<?> readBypolicyAmountWithTaxable(int empId) {
        String query = "";
        query += " select SUM(a.amount)"
                + " From EmployeePolicyDetail a "
                + " where a.employeeMaster = " + empId
                + " and a.status=" + 1;
        return getHibernateTemplate().find(query);
    }

}
