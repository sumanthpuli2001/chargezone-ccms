/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingSubMaster;
import com.bul.zydex.service.Training.TrainingSubTypeService;
import com.bul.zydex.service.Training.TrainingTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.service.Training.TrainerService;
import com.bul.zydex.service.Training.TrainingAttendanceService;
import com.bul.zydex.service.Training.TrainingIdentificationService;
import com.bul.zydex.service.Training.TrainingMasterService;
import com.bul.zydex.service.Training.TrainingSubMasterService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Rishi
 */
public abstract class TrainingTypeAbstract extends CustomAbstract {
    protected TrainingTypeService<TrainingType> trainingTypeService;
    protected TrainingSubTypeService<TrainingSubType> trainingSubTypeService;
    protected TrainerService<Trainer> trainerService;
    protected TrainingMasterService<TrainingMaster> trainingMasterService;
    protected TrainingSubMasterService<TrainingSubMaster> trainingSubMasterService;
    protected TrainingAttendanceService<TrainingAttendance> trainingAttendanceService;
    protected TrainingIdentificationService<TrainingIdentification> trainingIdentificationService;

    public TrainingAttendanceService<TrainingAttendance> getTrainingAttendanceService() {
        return trainingAttendanceService;
    }

    public void setTrainingAttendanceService(TrainingAttendanceService<TrainingAttendance> trainingAttendanceService) {
        this.trainingAttendanceService = trainingAttendanceService;
    }

    public TrainingIdentificationService<TrainingIdentification> getTrainingIdentificationService() {
        return trainingIdentificationService;
    }

    public void setTrainingIdentificationService(TrainingIdentificationService<TrainingIdentification> trainingIdentificationService) {
        this.trainingIdentificationService = trainingIdentificationService;
    }

    public TrainerService<Trainer> getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService<Trainer> trainerService) {
        this.trainerService = trainerService;
    }

    public TrainingMasterService<TrainingMaster> getTrainingMasterService() {
        return trainingMasterService;
    }

    public void setTrainingMasterService(TrainingMasterService<TrainingMaster> trainingMasterService) {
        this.trainingMasterService = trainingMasterService;
    }

    public TrainingSubMasterService<TrainingSubMaster> getTrainingSubMasterService() {
        return trainingSubMasterService;
    }

    public void setTrainingSubMasterService(TrainingSubMasterService<TrainingSubMaster> trainingSubMasterService) {
        this.trainingSubMasterService = trainingSubMasterService;
    }

    public TrainingTypeService<TrainingType> getTrainingTypeService() {
        return trainingTypeService;
    }

    public void setTrainingTypeService(TrainingTypeService<TrainingType> trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }

    public TrainingSubTypeService<TrainingSubType> getTrainingSubTypeService() {
        return trainingSubTypeService;
    }

    public void setTrainingSubTypeService(TrainingSubTypeService<TrainingSubType> trainingSubTypeService) {
        this.trainingSubTypeService = trainingSubTypeService;
    }
    protected void trainingList(HttpServletRequest request) {
        TrainingType trainingType = new TrainingType();
        List<?> desigList = trainingTypeService.read();
        Map<Integer, String> dn = new HashMap<>();
        for (Object o : desigList) {
            trainingType = (TrainingType) o;
            dn.put(trainingType.getId(), trainingType.getTraining());
        }

        request.setAttribute("list", dn);
    }
    public void auditgetCalDate(HttpServletRequest request,String monthAndYear, Calendar now) throws ParseException, JSONException {
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

                        List<?> list = trainingSubMasterService.ListeventDates(format.format(preDate));
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
}
