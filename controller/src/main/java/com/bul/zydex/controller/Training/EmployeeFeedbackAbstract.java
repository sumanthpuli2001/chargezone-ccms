/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.service.Training.EmployeeFeedbackService;

/**
 *
 * @author Aman
 */
public class EmployeeFeedbackAbstract extends CustomAbstract{
    protected EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService;

    public EmployeeFeedbackService<EmployeeFeedback> getEmployeeFeedbackService() {
        return employeeFeedbackService;
    }

    public void setEmployeeFeedbackService(EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService) {
        this.employeeFeedbackService = employeeFeedbackService;
    }
    
    
    
}
