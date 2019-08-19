/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeExcelRecordDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeExcelRecordDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeExcelRecord.class;
    }

//    @Override
//    public List<?> readByEmployeExcelReport(String month, String year) {
//        String query = "";
//        String condition = "";
//
//        query += " From EmployeeExcelRecord a"
//                + " left join a.employeeSalaryProcess b"
//                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
//                + " and b.month='"+employeeSalaryProcess.getMonth()+"'"
//                + " and b.year='"+employeeSalaryProcess.getYear()+"'";
//
//        return getHibernateTemplate().find(query);
//    }
    @Override
    public List<?> readByEmployeExcelReport(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " select a "
                + " From EmployeeExcelRecord a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readAttendanceRecord(EmployeeMaster employeeMaster) {
        String query = "";
        String condition = "";

        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND em.locationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (null != employeeMaster.getCompany() && !"".equals(employeeMaster.getCompany())) {
//            condition += " AND b.company = " + employeeMaster.getEmployeeType();
            condition += " AND em.company = '" + employeeMaster.getCompany() + "'";
        }
        if (null != employeeMaster.getChild1() && !"".equals(employeeMaster.getChild1())) {
            condition += " AND esp.month = '" + employeeMaster.getChild1() + "'";
        }
        if (null != employeeMaster.getChild2() && !"".equals(employeeMaster.getChild2())) {
            condition += " AND esp.year = '" + employeeMaster.getChild2() + "'";
        }

        query += " select em.employeeId,em.employeeName,eer.workingDays,eer.presentDays,eer.casuaLeave,eer.sickLeave, "
                + "  eer.pleave,eer.otherLeave,eer.lwp,eer.otHours,em.company "
                + " From EmployeeExcelRecord eer"
                + " LEFT JOIN eer.employeeSalaryProcess esp "
                + " LEFT JOIN esp.employeeMaster em "
                + " LEFT JOIN em.employeeTypeMaster etm "
                + " LEFT JOIN em.employeeSubType est "
                + " Where 1=1" + condition;

        return getHibernateTemplate().find(query);

    }

    @Override
    public void delete1(T object) {
        EmployeeExcelRecord employeeExcelRecord = (EmployeeExcelRecord) object;
        String query = "";

        query += "  "
                + "delete FROM EmployeeExcelRecord a "
                + " WHERE a.id = " + employeeExcelRecord.getId();

    }

    @Override
    public List<?> readEmployeeForIncentive(String pincentive, String aincentive, String month1, String year11) {
        String query = "";
        String condition = "";
        query += "Select c.employeeId, c.employeeName,a.presentDays,b.employeeBasicSalary,b.employeeLwp,c.basicSalary,c.id"
                + " From EmployeeExcelRecord a "
                + " left join a.employeeSalaryProcess b"
                + " left join b.employeeMaster c"
                + " where b.month='" + month1 + "'"
                + " and b.year='" + year11 + "'";

//        query += " Select a.employeeId, a.employeeName,c.deductionAmount,"
//                + " (c.deductionAmount*8.33)/12 as epfAmount,"
//                + " (c.deductionAmount*3.67)/12 as apfAmount,"
//                + " a.id,b.id"
//                + " From EmployeeMaster a"
//                + " left join a.employeeSalaryProcesses b"
//                + " left join b.employeeDeductionAmounts c"
//                + " where c.deductionType ='Pf' " + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeExcelReportSearch(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " select a.presentDays "
                + " From EmployeeExcelRecord a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeExcelFetch(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " select a"
                + " From EmployeeExcelRecord a"
                + " left join a.employeeSalaryProcess b"
                + " where b.id= " + employeeSalaryProcess.getId();

        return getHibernateTemplate().find(query);
    }

}
