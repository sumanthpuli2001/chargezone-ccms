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
    public List<?> readEmployeesAppraisalPerformance(EmployeeMaster employeeMaster, boolean hr) {
        return appraisalPerformanceDAO.readEmployeesAppraisalPerformance(employeeMaster, hr);
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
    public Object[] readperformanceByHr(final int currentYear) {
        return appraisalPerformanceDAO.readperformanceByHr(currentYear);
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
    public List<?> readPMPSearchByEmployee(T object) {
        return appraisalPerformanceDAO.readPMPSearchByEmployee(object);
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
    public List<?> readstageWiseSearchByEmployee(T object, AppraisalFillingData appraisalFillingData) {
        return appraisalPerformanceDAO.readstageWiseSearchByEmployee(object, appraisalFillingData);
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
   public List<?> readPendingEmployeePmpByManager(String employeeId, int year)  {
        return appraisalPerformanceDAO.readPendingEmployeePmpByManager(employeeId, year);
    }

}
