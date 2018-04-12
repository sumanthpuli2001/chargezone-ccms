/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalPerformanceDAO;
import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalPerformanceService<T> {

    private AppraisalPerformanceDAO<T> appraisalPerformanceDAO;

    public AppraisalPerformanceDAO<T> getAppraisalPerformanceDAO() {
        return appraisalPerformanceDAO;
    }

    public void setAppraisalPerformanceDAO(AppraisalPerformanceDAO<T> appraisalPerformanceDAO) {
        this.appraisalPerformanceDAO = appraisalPerformanceDAO;
        setGenericsDAO(appraisalPerformanceDAO);
    }

    @Override
    public List<?> readEmployeesAppraisalPerformance(EmployeeMaster employeeMaster, boolean hr, int year) {
        return appraisalPerformanceDAO.readEmployeesAppraisalPerformance(employeeMaster, hr, year);
    }

    @Override
    public List<?> readByAppraisalPerformanceId(String employeeId, int year) {
        return appraisalPerformanceDAO.readByAppraisalPerformanceId(employeeId, year);
    }

    @Override
    public List<?> readByAppraisalPerformanceIdAndYearWise(String employeeId, int year) {
        return appraisalPerformanceDAO.readByAppraisalPerformanceIdAndYearWise(employeeId, year);
    }

    @Override
    public int readperformanceByHr(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr(currentYear);
    }

    @Override
    public int readperformanceByHr1(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr1(currentYear);
    }

    @Override
    public int readperformanceByHr2(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr2(currentYear);
    }

    @Override
    public int readperformanceByHr3(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr3(currentYear);
    }

    @Override
    public int readperformanceByHr4(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr4(currentYear);
    }

    @Override
    public int readperformanceByHr5(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr5(currentYear);
    }

    @Override
    public int readperformanceByHr6(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr6(currentYear);
    }

    @Override
    public List<?> readperformanceByHr() {
        return appraisalPerformanceDAO.readperformanceByHr();
    }

    @Override
    public List<?> readOwnAppraisalPerformance(EmployeeMaster employeeMaster, int cyear) {
        return appraisalPerformanceDAO.readOwnAppraisalPerformance(employeeMaster, cyear);
    }

    @Override
    public List<?> readPMPSearchByEmployee(T object,int pyear) {
        return appraisalPerformanceDAO.readPMPSearchByEmployee(object,pyear);
    }

    @Override
    public List<?> readIDPSearchByEmployee(T object) {
        return appraisalPerformanceDAO.readIDPSearchByEmployee(object);
    }

    @Override
    public List<?> readcompetencySearchByEmployee(T object) {
        return appraisalPerformanceDAO.readcompetencySearchByEmployee(object);
    }

    @Override
    public List<?> readstageWiseSearchByEmployee(T object, AppraisalFillingData appraisalFillingData,int pyear) {
        return appraisalPerformanceDAO.readstageWiseSearchByEmployee(object, appraisalFillingData,pyear);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return appraisalPerformanceDAO.readEmpIdFromTabId(id);
    }

    @Override
    public List<?> readIDPSearchByEmployeeWise(T object) {
        return appraisalPerformanceDAO.readIDPSearchByEmployeeWise(object);
    }

    @Override
    public List<?> readPendingEmployeePmp(int employeeId, int year) {
        return appraisalPerformanceDAO.readPendingEmployeePmp(employeeId, year);
    }

    @Override
    public List<?> readPendingEmployeePmpByManager(String employeeId, int year) {
        return appraisalPerformanceDAO.readPendingEmployeePmpByManager(employeeId, year);
    }

    @Override
    public List<?> readEmpIdByAppraisalPerformanceId() {
        return appraisalPerformanceDAO.readEmpIdByAppraisalPerformanceId();
    }

    @Override
    public List<?> readByEmpID(int id) {
        return appraisalPerformanceDAO.readByEmpID(id);
    }

    @Override
    public List<?> readOwnAppraisalPerformanceTimeLine(EmployeeMaster employeeMaster, int cyear) {
        return appraisalPerformanceDAO.readOwnAppraisalPerformanceTimeLine(employeeMaster, cyear);
    }

    @Override
    public List<?> readByAppraisalPerformanceIdNew(String employeeId, String yearId) {
            return appraisalPerformanceDAO.readByAppraisalPerformanceIdNew(employeeId, yearId);
    }

    
}
