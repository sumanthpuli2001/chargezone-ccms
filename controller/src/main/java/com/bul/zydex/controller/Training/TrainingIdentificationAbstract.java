/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.service.Training.EmployeeFeedbackService;
import com.bul.zydex.service.Training.TrainingIdentificationService;
import com.bul.zydex.service.Training.TrainingMasterService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationAbstract extends CustomAbstract {

    protected TrainingIdentificationService<TrainingIdentification> trainingIdentificationService;
    protected TrainingMasterService<TrainingMaster> trainingMasterService;
    protected EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService;

    public TrainingIdentificationService<TrainingIdentification> getTrainingIdentificationService() {
        return trainingIdentificationService;
    }

    public void setTrainingIdentificationService(TrainingIdentificationService<TrainingIdentification> trainingIdentificationService) {
        this.trainingIdentificationService = trainingIdentificationService;
    }

    public TrainingMasterService<TrainingMaster> getTrainingMasterService() {
        return trainingMasterService;
    }

    public void setTrainingMasterService(TrainingMasterService<TrainingMaster> trainingMasterService) {
        this.trainingMasterService = trainingMasterService;
    }

    public EmployeeFeedbackService<EmployeeFeedback> getEmployeeFeedbackService() {
        return employeeFeedbackService;
    }

    public void setEmployeeFeedbackService(EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService) {
        this.employeeFeedbackService = employeeFeedbackService;
    }
    

    protected void readEmployeeMaster(HttpServletRequest request, int id) {
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List employeelist = employeeMasterService.readEmployeeList(id);
//        Map<Integer, String> employeeMastername = new HashMap<>();
//        for (Object o : employeelist) {
//            employeeMaster = (EmployeeMaster) o;
//            employeeMastername.put(employeeMaster.getId(), employeeMaster.getEmployeeName());
//        }

        request.setAttribute("list", employeelist);
    }

    protected void readTrainingMaster(HttpServletRequest request) {
        TrainingMaster trainingMaster = new TrainingMaster();
        List<?> traininglist = trainingMasterService.read();
        Map<Integer, String> trainingMastername = new HashMap<>();
        for (Object o : traininglist) {
            trainingMaster = (TrainingMaster) o;
            trainingMastername.put(trainingMaster.getId(), trainingMaster.getTrainingTitle());
        }

        request.setAttribute("tlist", trainingMastername);
    }
    protected void readTrainingFeedback(HttpServletRequest request) {
        TrainingFeedback trainingFeedback = new TrainingFeedback();
        List<?> trainingFeedbacklist = trainingIdentificationService.readTraingFeedback();
        Map<Integer, String> trainingFeedbackname = new HashMap<>();
        for (Object o : trainingFeedbacklist) {
            trainingFeedback = (TrainingFeedback) o;
            trainingFeedbackname.put(trainingFeedback.getId(),trainingFeedback.getFeedaback());
        }

        request.setAttribute("list", trainingFeedbackname);
    }

}
