/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.UserMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationController extends TrainingIdentificationAbstract {

    public ModelAndView createTraineAssigne(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        readTrainingMaster(request);
        TrainingIdentification trainingIdentification = new TrainingIdentification();
        List<?> trainingIdentificationList = trainingIdentificationService.readTrainingIdentificationList();
        mv.getModelMap().put("list", trainingIdentificationList);
        mv.getModelMap().put("trainingIdentification", trainingIdentification);
        mv.setViewName("Training/CreateAssignTraine");
        return mv;
    }

    public ModelAndView createTraineList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        TrainingIdentification trainingIdentification = new TrainingIdentification();
        List<?> trainingList = trainingIdentificationService.readTrainingList(employeeMaster.getId());
        mv.getModelMap().put("trainingIdentification", trainingIdentification);
        mv.getModelMap().put("list", trainingList);
        mv.setViewName("Training/TrainingList");
        return mv;
    }

    public ModelAndView sendFeedback(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeFeedback employeeFeedback = new EmployeeFeedback();
        TrainingFeedback trainingFeedback = new TrainingFeedback();
        readTrainingFeedback(request);
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        String id = request.getParameter("id");
        mv.getModelMap().put("id", id);

        employeeFeedback.setTrainingFeedback(trainingFeedback);
        mv.getModelMap().put("employeeFeedback", employeeFeedback);
        mv.setViewName("Training/applyTrainingFeedback");
        return mv;
    }

    public ModelAndView newAssignTraine(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        TrainingIdentification trainingIdentification = new TrainingIdentification();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        TrainingMaster trainingMaster = new TrainingMaster();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");

        readTrainingMaster(request);

        trainingIdentification.setTrainingMaster(trainingMaster);

        List<?> employeelist = employeeMasterService.readEmployeeList(user.getId());
        mv.getModelMap().put("trainingIdentification", trainingIdentification);
        mv.getModelMap().put("list", employeelist);
        mv.getModelMap().put("trainingMaster", trainingMaster);
        mv.setViewName("Training/registrationAssigntraine");
        return mv;

    }

    public ModelAndView trainingAssignSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        TrainingIdentification trainingIdentification = new TrainingIdentification();

        BindException errors = new BindException(trainingIdentification, "trainingIdentification");
        bind(request, trainingIdentification);
        String id = request.getParameter("id");
        String savingList[] = request.getParameterValues("checkId");
        if ("" == id) {
            for (String z : savingList) {
//                if(){}
                try {
                    TrainingIdentification trainingIdentification1 = new TrainingIdentification();

                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster.setId(Integer.parseInt(z));
                    trainingIdentification1.setEmployeeMaster(employeeMaster);
                    trainingIdentification1.setStatus(1);
                    trainingIdentification1.setTrainingMaster(trainingIdentification.getTrainingMaster());
                    trainingIdentification1.setDescription(trainingIdentification.getDescription());
                    trainingIdentificationService.create(trainingIdentification1);
                    request.setAttribute("successMessage",
                            "Info :The Records are deleted successfully.");
                } catch (Exception e) {

                }
            }
        } else {
            String trainingMaster = request.getParameter("trainingMaster");
            TrainingIdentification trainingIdentification1 = trainingIdentificationService.readById(Integer.parseInt(id));
            TrainingMaster trainingMaster1 = trainingMasterService.readById(Integer.parseInt(trainingMaster));
            trainingIdentification1.setTrainingMaster(trainingMaster1);
            trainingIdentificationService.update(trainingIdentification1);
        }
        mv = createTraineAssigne(request, response);
        return mv;

    }

    public ModelAndView trainingIdentificationdeleteDeleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                trainingIdentificationService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info :The Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = createTraineAssigne(request, response);
        return mv;
    }

    public ModelAndView submitEmployeeFeedbackCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeFeedback employeeFeedback = new EmployeeFeedback();
        BindException errors = new BindException(employeeFeedback, "employeeFeedback");
        bind(request, employeeFeedback);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String id = request.getParameter("id2");
        TrainingMaster trainingMaster = new TrainingMaster();
        trainingMaster.setId(Integer.parseInt(id));
        employeeFeedback.setTrainingMaster(trainingMaster);
        employeeFeedback.setEmployeeMaster(employeeMaster);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        employeeFeedback.setDateTime(sdf.format(cDate));
        employeeFeedbackService.create(employeeFeedback);

        mv = createTraineList(request, response);
        return mv;

    }

}
