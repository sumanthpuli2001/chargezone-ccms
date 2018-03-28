/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.EmployeeFeedbackDAO;
import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman
 */
public class EmployeeFeedbackServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeFeedbackService<T>{
    
    private EmployeeFeedbackDAO<T> employeeFeedbackDAO;

    public EmployeeFeedbackDAO<T> getEmployeeFeedbackDAO() {
        return employeeFeedbackDAO;
    }

    public void setEmployeeFeedbackDAO(EmployeeFeedbackDAO<T> employeeFeedbackDAO) {
        this.employeeFeedbackDAO = employeeFeedbackDAO;
        setGenericsDAO(employeeFeedbackDAO);
    }
    
    @Override
    public Boolean checkFeedbackforEmp(int empId, int trainingId, String eventdate) {
         return employeeFeedbackDAO.checkFeedbackforEmp(empId, trainingId, eventdate);
    }

    @Override
    public Boolean checkFeedbackforHR(int trainingId) {
        return employeeFeedbackDAO.checkFeedbackforHR(trainingId);
    }
    
    
}
