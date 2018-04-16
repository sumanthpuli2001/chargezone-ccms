/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.UserMaster;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishi
 */
public class TrainingTypeController extends TrainingTypeAbstract {

    public ModelAndView newtraining(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> trainingTypeList = trainingTypeService.readtrainingTypeDetail();
        mv.getModelMap().put("list", trainingTypeList);
        mv.setViewName("Training/newtraining");
        return mv;
    }

    public ModelAndView createtraining(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingType trainingType = new TrainingType();
        mv.getModelMap().put("trainingType", trainingType);
        mv.setViewName("Training/createtrainingmaster");
        return mv;
    }

    public ModelAndView edittraining(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingType trainingType = new TrainingType();
        String id = request.getParameter("id");
        trainingType = trainingTypeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("trainingType", trainingType);
        mv.setViewName("Training/createtrainingmaster");
        return mv;
    }

    public ModelAndView newsubtraining(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> trainingTypeList = trainingSubTypeService.readtrainingSubTypeDetail();
        mv.getModelMap().put("list", trainingTypeList);
        mv.setViewName("Training/newsubtraining");

        return mv;
    }

    public ModelAndView createtrainingsub(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingSubType trainingSubType = new TrainingSubType();
        TrainingType trainingType = new TrainingType();
        trainingSubType.setTrainingType(trainingType);
        trainingList(request);
        mv.getModelMap().put("trainingSubType", trainingSubType);
        mv.setViewName("Training/createtrainingsubmaster");
        return mv;
    }

    public ModelAndView edittrainingsub(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingSubType trainingSubType = new TrainingSubType();
        trainingList(request);
        String id = request.getParameter("id");
        trainingSubType = trainingSubTypeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("trainingSubType", trainingSubType);
        mv.setViewName("Training/createtrainingsubmaster");
        return mv;
    }

    public ModelAndView Submittraningtype(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        TrainingType trainingType = new TrainingType();
//        BindException errors = new BindException(trainingType, "trainingType");
        bind(request, trainingType);
        String abc = trainingType.getTraining().trim();
        abc = abc.replaceAll("\t", "");
        trainingType.setTraining(abc);
        if (trainingType.getId() == null) {
            if (!trainingTypeService.isExist(trainingType)) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.now();

                trainingType.setCreateddate(dtf.format(localDate));
                trainingType.setCreatedby(user.getId());
                trainingTypeService.create(trainingType);
                request.setAttribute(
                        "successMessage",
                        "Information : The Information is saved Successfully.");
            } else {
                request.setAttribute("faliureMessage",
                        "Error : The Saving Type is already there.");
            }
        } else {
            if (!trainingTypeService.isExist(trainingType)) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.now();
                trainingType.setUpdateddate(dtf.format(localDate));
                trainingType.setUpdatedby(user.getId());
                trainingTypeService.update(trainingType);
                request.setAttribute(
                        "successMessage",
                        "Information : The Information is updated Successfully.");
            } else {
                request.setAttribute("faliureMessage",
                        "Error : The Saving Type is already there.");
            }
        }

        mv = newtraining(request, response);
        return mv;
    }

    public ModelAndView SubmittraningSubtype(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        TrainingSubType trainingType = new TrainingSubType();
//        BindException errors = new BindException(trainingType, "trainingType");
        bind(request, trainingType);
        String abc = trainingType.getTrainingsubtype().trim();
        abc = abc.replaceAll("\t", "");
        trainingType.setTrainingsubtype(abc);
        if (trainingType.getId() == null) {
            if (!trainingSubTypeService.isExist(trainingType)) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.now();
                trainingType.setCreateddate(dtf.format(localDate));
                trainingType.setCreatedby(user.getId());
                trainingSubTypeService.create(trainingType);
                request.setAttribute(
                        "successMessage",
                        "Information : The Information is saved Successfully.");
            } else {
                request.setAttribute("faliureMessage",
                        "Error : The Saving Type is already there.");
            }
        } else {
            if (!trainingSubTypeService.isExist(trainingType)) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.now();
                trainingType.setUpdateddate(dtf.format(localDate));
                trainingType.setUpdatedby(user.getId());
                trainingSubTypeService.update(trainingType);
                request.setAttribute(
                        "successMessage",
                        "Information : The Information is Updated Successfully.");
            } else {
                request.setAttribute("faliureMessage",
                        "Error : The Saving Type is already there.");
            }
        }
        mv = newsubtraining(request, response);
        return mv;
    }

    public ModelAndView deleteSubmittrainingtype(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {

                trainingTypeService.delete(Integer.parseInt(z));
            } catch (Exception e) {

            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = newtraining(request, response);

        return mv;
    }

    public ModelAndView deleteSubmittrainingsubtype(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {

                trainingSubTypeService.delete(Integer.parseInt(z));
            } catch (Exception e) {

            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = newsubtraining(request, response);

        return mv;
    }

    public ModelAndView calendarList(HttpServletRequest request, HttpServletResponse response) throws ParseException, Exception {
        ModelAndView mv = new ModelAndView();
        String monthAndYear = request.getParameter("monthAndYear");;
        String btnType = request.getParameter("btnType");;
        Calendar cal3 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-yyyy");
        Date dateTime = new Date();
        if (monthAndYear.equals("NA")) {
            monthAndYear = simpleDateFormat.format(new Date());
            dateTime = simpleDateFormat.parse(monthAndYear);
            cal3.setTime(dateTime);
        } else {
            dateTime = simpleDateFormat.parse(monthAndYear);
            cal3.setTime(dateTime);
            if ("Next".equals(btnType)) {
                cal3.add(Calendar.MONTH, 1);
            } else if ("Last".equals(btnType)) {
                cal3.add(Calendar.MONTH, -1);
            }
            dateTime = cal3.getTime();
            monthAndYear = simpleDateFormat.format(dateTime);
        }
        HttpSession session = request.getSession(false);
        auditgetCalDate(request, monthAndYear, cal3);
        mv.setViewName("Training/calendar");
        return mv;
    }

    public ModelAndView showcalendar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Calendar cal3 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-yyyy");
        Date dateTime = new Date();

        String monthAndYear = simpleDateFormat.format(new Date());
        dateTime = simpleDateFormat.parse(monthAndYear);
        cal3.setTime(dateTime);
        auditgetCalDate(request, monthAndYear, cal3);
        mv.setViewName("Training/calendar");
        return mv;
    }

    public ModelAndView viewProfile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String eventdate = request.getParameter("eventdate");
        TrainingMaster trainingMaster = trainingMasterService.readById(Integer.parseInt(id));
        Trainer trainer = trainerService.readById(trainingMaster.getTrainer().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster.getTrainingSubType().getId());
        TrainingType trainingType = trainingTypeService.readById(trainingMaster.getTrainingType().getId());
        trainingMaster.setTrainer(trainer);
        trainingMaster.setTrainingSubType(trainingSubType);
        trainingMaster.setTrainingType(trainingType);
        List attenlist = new LinkedList();
        attenlist = trainingAttendanceService.gettrainingattendance(eventdate, Integer.parseInt(id));
        boolean shosts = true;

        if (attenlist.isEmpty()) {
            shosts = false;
            attenlist = trainingIdentificationService.gettrainingattendance(Integer.parseInt(id));

        }
        boolean showFeedbackButton = employeeFeedbackService.checkFeedbackforHR(trainingMaster.getId());

        request.setAttribute("shosts", shosts);
        request.setAttribute("list", attenlist);
        request.setAttribute("showFeedbackButton", showFeedbackButton);
        request.setAttribute("trainingMaster", trainingMaster);
        mv.setViewName("Training/TrainingMasterlblview");
        return mv;
    }
}
