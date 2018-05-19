/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.service.Training.EmployeeFeedbackService;
import com.bul.zydex.service.Training.TrainerService;
import com.bul.zydex.service.Training.TrainingAttendanceService;
import com.bul.zydex.service.Training.TrainingFeedbackService;
import com.bul.zydex.service.Training.TrainingIdentificationService;
import com.bul.zydex.service.Training.TrainingMasterService;
import com.bul.zydex.service.Training.TrainingSubTypeService;
import com.bul.zydex.service.Training.TrainingTypeService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationAbstract extends CustomAbstract {

    protected TrainingIdentificationService<TrainingIdentification> trainingIdentificationService;
    protected TrainingMasterService<TrainingMaster> trainingMasterService;
    protected EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService;
    protected TrainerService<Trainer> trainerService;
    protected TrainingSubTypeService<TrainingSubType> trainingSubTypeService;
    protected TrainingTypeService<TrainingType> trainingTypeService;
    protected TrainingAttendanceService<TrainingAttendance> trainingAttendanceService;
    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;
    protected TrainingFeedbackService<TrainingFeedback> trainingFeedbackService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;

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

    public TrainingFeedbackService<TrainingFeedback> getTrainingFeedbackService() {
        return trainingFeedbackService;
    }

    public void setTrainingFeedbackService(TrainingFeedbackService<TrainingFeedback> trainingFeedbackService) {
        this.trainingFeedbackService = trainingFeedbackService;
    }

//    protected void readEmployeeMaster(HttpServletRequest request, int id) {
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        List employeelist = employeeMasterService.readEmployeeList(id);
////        Map<Integer, String> employeeMastername = new HashMap<>();
////        for (Object o : employeelist) {
////            employeeMaster = (EmployeeMaster) o;
////            employeeMastername.put(employeeMaster.getId(), employeeMaster.getEmployeeName());
////        }
//
//        request.setAttribute("list", employeelist);
//    }
    protected void readTrainingMaster(HttpServletRequest request) {
        TrainingMaster trainingMaster = new TrainingMaster();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        Date d = new Date();
        String currentDate = dateFormat.format(d);
        List<?> traininglist = trainingMasterService.fetchtrainingMaster(currentDate);
        Map<Integer, String> trainingMastername = new HashMap<>();
        for (Object o : traininglist) {
            trainingMaster = (TrainingMaster) o;
            String trainingDetails = trainingMaster.getTrainingTitle() + " " + trainingMaster.getStartDate() + " " + trainingMaster.getTrainingTimeForm();
            trainingMastername.put(trainingMaster.getId(), trainingDetails);
//            trainingMastername.put(trainingMaster.getId(), trainingMaster.getTrainingTitle());
        }

        request.setAttribute("tlist", trainingMastername);
    }

    protected void readTrainingFeedback(HttpServletRequest request) {
        TrainingFeedback trainingFeedback = new TrainingFeedback();
        List<?> trainingFeedbacklist = trainingIdentificationService.readTraingFeedback();
        Map<Integer, String> trainingFeedbackname = new HashMap<>();
        for (Object o : trainingFeedbacklist) {
            trainingFeedback = (TrainingFeedback) o;
            trainingFeedbackname.put(trainingFeedback.getId(), trainingFeedback.getFeedaback());
        }

        request.setAttribute("list", trainingFeedbackname);
    }

    public EmployeeMasterService<EmployeeMaster> getEmployeeMasterService() {
        return employeeMasterService;
    }

    public void setEmployeeMasterService(EmployeeMasterService<EmployeeMaster> employeeMasterService) {
        this.employeeMasterService = employeeMasterService;
    }

    public TrainingSubTypeService<TrainingSubType> getTrainingSubTypeService() {
        return trainingSubTypeService;
    }

    public void setTrainingSubTypeService(TrainingSubTypeService<TrainingSubType> trainingSubTypeService) {
        this.trainingSubTypeService = trainingSubTypeService;
    }

    public TrainingTypeService<TrainingType> getTrainingTypeService() {
        return trainingTypeService;
    }

    public void setTrainingTypeService(TrainingTypeService<TrainingType> trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }

    public TrainingAttendanceService<TrainingAttendance> getTrainingAttendanceService() {
        return trainingAttendanceService;
    }

    public void setTrainingAttendanceService(TrainingAttendanceService<TrainingAttendance> trainingAttendanceService) {
        this.trainingAttendanceService = trainingAttendanceService;
    }

    public TrainerService<Trainer> getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService<Trainer> trainerService) {
        this.trainerService = trainerService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    public void auditgetCalDate(HttpServletRequest request, String monthAndYear, Calendar now, int userId) throws ParseException, JSONException {
        List<List<JSONObject>> finalList = new ArrayList<>();

        String monthName = new SimpleDateFormat("MMM-yyyy").format(now.getTime());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c1 = Calendar.getInstance();
        c1.setTime(now.getTime());
        c1.set(Calendar.DAY_OF_MONTH,
                c1.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date firstDayOfTheMonth = c1.getTime();
        String firstdayDate = format.format(firstDayOfTheMonth);
        firstDayOfTheMonth = format.parse(firstdayDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(now.getTime());
        cal.set(Calendar.DAY_OF_MONTH,
                c1.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDateOfNextMonth = cal.getTime();
        String lastDate = format.format(lastDateOfNextMonth);
        lastDateOfNextMonth = format.parse(lastDate);

        System.out.println("firstDayOfTheMonth " + firstDayOfTheMonth);

        int week = now.getActualMaximum(Calendar.WEEK_OF_MONTH);
        now.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        int counter = 1;
        for (int z = 1; z <= week; z++) {
            List monthDays = new ArrayList();
            now.set(Calendar.WEEK_OF_MONTH, z);

//            date dd1 = 
            for (int i = 0; i < 7; i++) {
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(now.getTime());
                Date preDate = cal2.getTime();
                String preDate1 = format.format(preDate);
                preDate = format.parse(preDate1);
                List dateObject = new ArrayList();
                if (preDate.after(firstDayOfTheMonth) || preDate.equals(firstDayOfTheMonth)) {

                    if (preDate.before(lastDateOfNextMonth) || preDate.equals(lastDateOfNextMonth)) {
                        dateObject.add(counter);
                        dateObject.add(format.format(preDate).split("/")[0]);
                        dateObject.add(format.format(preDate));
                        List<?> list = trainingIdentificationService.readTrainingList(format.format(preDate), userId);
                        if (!list.isEmpty()) {
                            dateObject.add(list);
                        } else {
                            dateObject.add(null);
                        }
                        monthDays.add(dateObject);
                    } else {
                        dateObject.add(counter);
                        dateObject.add("");
                        dateObject.add("");
                        monthDays.add(dateObject);
                    }

                } else {
                    dateObject.add(counter);
                    dateObject.add("");
                    dateObject.add("");
                    monthDays.add(dateObject);
                }

                now.add(Calendar.DAY_OF_MONTH, 1);
                counter++;
            }
            finalList.add(monthDays);

        }

        List object = new LinkedList();
        object.add(monthName);
        object.add(finalList);

        request.setAttribute("list", object);
    }

    protected void trainingsList(HttpServletRequest request) {
        TrainingMaster trainMaster = new TrainingMaster();
        List<?> trainingList = trainingMasterService.read();
        Map<Integer, String> trainingsMap = new HashMap<>();
        for (Object o : trainingList) {
            trainMaster = (TrainingMaster) o;
            trainingsMap.put(trainMaster.getId(), trainMaster.getTrainingTitle());
        }

        request.setAttribute("trainingsMaps", trainingsMap);
    }

}
