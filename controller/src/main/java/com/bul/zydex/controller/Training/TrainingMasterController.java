/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingSubMaster;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.model.UserMaster;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class TrainingMasterController extends TrainingMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, TrainingMaster trainingMaster) throws Exception {
        
        ModelAndView mv = new ModelAndView();
        List<?> trainingList = trainingMasterService.readTrainingMasterList();
        mv.getModelMap().put("list", trainingList);
        mv.setViewName("Training/TrainingMaster");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = new TrainingMaster();

        trainerList(request);
        trainingtypeList(request);
        trainingSubtypeList(request);

        mv.getModelMap().put("trainingMaster", trainingMaster);
        mv.setViewName("Training/TrainingCreate");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = trainingMasterService.readById(Integer.parseInt(id));
        Trainer trainer = trainerService.readById(trainingMaster.getTrainer().getId());
        TrainingType trainingType = trainingTypeService.readById(trainingMaster.getTrainingType().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster.getTrainingSubType().getId());
        trainingSubType.setTrainingType(trainingType);

        trainingMaster.setTrainer(trainer);
        trainingMaster.setTrainingType(trainingType);
        trainingMaster.setTrainingSubType(trainingSubType);
        trainerList(request);
        trainingtypeList(request);
        trainingSubtypeList(request);

        mv.getModelMap().put("trainingMaster", trainingMaster);
        mv.setViewName("Training/TrainingEditView");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        int SubtypeBytrainingTypeId = Integer.parseInt(request.getParameter("SubtypeBytrainingTypeId"));
        TrainingMaster trainingMaster = new TrainingMaster();
//        trainingMaster.setTrainingSubType(trainingSubTypeService.readById(SubtypeBytrainingTypeId));
        BindException errors = new BindException(trainingMaster, "trainingMaster");
        bind(request, trainingMaster);
//        trainingMasterValidator.validate(trainingMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            trainerList(request);
            trainingtypeList(request);
            trainingSubtypeList(request);

            mv.addAllObjects(errors.getModel());
//            mv.getModelMap().put("trainingMaster", trainingMaster);

            mv.setViewName("Training/TrainingCreate");
        } else {
            String trainingTitle = request.getParameter("trainingTitle");
            String trainingDescription = request.getParameter("trainingDescription");
            String trainingOwner = request.getParameter("trainingOwner");
            int trainerId = Integer.parseInt(request.getParameter("trainer"));
            int trainingType = Integer.parseInt(request.getParameter("trainingType"));
            int SubtypeBytrainingTypeId = Integer.parseInt(request.getParameter("SubtypeBytrainingTypeId"));
            String venue = request.getParameter("venue");
            String cost = request.getParameter("cost");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String trainingTimeForm = request.getParameter("trainingTimeForm");
            String trainingTimeTo = request.getParameter("trainingTimeTo");
            String trainingSource = request.getParameter("trainingSource");
            String companySource = request.getParameter("companySponsor");
            int reimbursable = Integer.parseInt(request.getParameter("reimbursable"));
//            int status = Integer.parseInt(request.getParameter("status"));
            
            HttpSession session = request.getSession();
            UserMaster userMaster = (UserMaster) session.getAttribute("user");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            Date d = new Date();
            String currentDate = dateFormat.format(d);

            trainingMaster.setTrainingTitle(trainingTitle);
            trainingMaster.setTrainingDescription(trainingDescription);
            trainingMaster.setTrainingOwner(trainingOwner);
            trainingMaster.setTrainer(trainerService.readById(trainerId));
            trainingMaster.setTrainingType(trainingTypeService.readById(trainingType));
            trainingMaster.setTrainingSubType(trainingSubTypeService.readById(SubtypeBytrainingTypeId));
            trainingMaster.setVenue(venue);
            trainingMaster.setCost(cost);
            trainingMaster.setStartDate(startDate);
            trainingMaster.setEndDate(endDate);
            trainingMaster.setTrainingTimeForm(trainingTimeForm);
            trainingMaster.setTrainingTimeTo(trainingTimeTo);
            trainingMaster.setTrainingSource(trainingSource);
            trainingMaster.setCompanySponsor(null);
            trainingMaster.setReimbursable(reimbursable);
            trainingMaster.setStatus(0);
            trainingMaster.setCreatedBy(userMaster.getId());
            trainingMaster.setCreatedDate(currentDate);
            trainingMaster.setUpdatedBy(0);
            trainingMaster.setUpdatedDate(null);

            mv.getModelMap().put("trainingMaster", trainingMaster);
            trainingMasterService.create(trainingMaster);
            /////////////////////////////////////////////////////
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate Startdate = LocalDate.parse(trainingMaster.getStartDate(), formatter);
            LocalDate Enddate = LocalDate.parse(trainingMaster.getEndDate(), formatter);
            List<LocalDate> alldate = getDatesBetween(Startdate, Enddate);
            for (LocalDate alldate1 : alldate) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date initDate = convertToDateViaSqlDate(alldate1);
                String finalDateSet = sdf.format(initDate);
                TrainingSubMaster trainingSubMaster = new TrainingSubMaster();
                trainingSubMaster.setTrainingdate(finalDateSet);
                trainingSubMaster.setTrainingMasterid(trainingMaster.getId());
                trainingSubMaster.setTrainerMasterid(trainingMaster.getTrainer().getId());
                trainingSubMaster.setTitle(trainingMaster.getTrainingTitle());
                trainingSubMasterService.create(trainingSubMaster);
            }
            /////////////////////////////////////////////////////
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is saved Successfully.");
            List<?> trainingList = trainingMasterService.read();

            mv.addObject(
                    "trainingList", trainingList);
//            mv.setViewName(
//                    "Training/TrainingMaster");
              mv = showList(request,response,trainingMaster);

        }
//            mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView EditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = new TrainingMaster();
        String trainingTitle = request.getParameter("trainingTitle");
        String trainingDescription = request.getParameter("trainingDescription");
        String trainingOwner = request.getParameter("trainingOwner");
        int trainerId = Integer.parseInt(request.getParameter("trainer.id"));
        int trainingType = Integer.parseInt(request.getParameter("trainingType.id"));
        int SubtypeBytrainingTypeId = Integer.parseInt(request.getParameter("trainingSubType.id"));
        String venue = request.getParameter("venue");
        String cost = request.getParameter("cost");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String trainingTimeForm = request.getParameter("trainingTimeForm");
        String trainingTimeTo = request.getParameter("trainingTimeTo");
        String trainingSource = request.getParameter("trainingSource");
        String companySource = request.getParameter("companySponsor");
        int reimbursable = Integer.parseInt(request.getParameter("reimbursable"));
        int status = Integer.parseInt(request.getParameter("status"));
        HttpSession session = request.getSession();
        UserMaster userMaster = (UserMaster) session.getAttribute("user");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date d = new Date();
        String currentDate = dateFormat.format(d);

        trainingMaster.setTrainingTitle(trainingTitle);
        trainingMaster.setTrainingDescription(trainingDescription);
        trainingMaster.setTrainingOwner(trainingOwner);
        trainingMaster.setTrainer(trainerService.readById(trainerId));
        trainingMaster.setTrainingType(trainingTypeService.readById(trainingType));
        trainingMaster.setTrainingSubType(trainingSubTypeService.readById(SubtypeBytrainingTypeId));
        trainingMaster.setVenue(venue);
        trainingMaster.setCost(cost);
        trainingMaster.setStartDate(startDate);
        trainingMaster.setEndDate(endDate);
        trainingMaster.setTrainingTimeForm(trainingTimeForm);
        trainingMaster.setTrainingTimeTo(trainingTimeTo);
        trainingMaster.setTrainingSource(trainingSource);
        trainingMaster.setTrainingSource(null);
        trainingMaster.setReimbursable(reimbursable);
        trainingMaster.setStatus(0);
        trainingMaster.setCreatedBy(userMaster.getId());
        trainingMaster.setCreatedDate(currentDate);
        trainingMaster.setUpdatedBy(0);
        trainingMaster.setUpdatedDate(null);
        BindException errors = new BindException(trainingMaster, "trainingMaster");
        bind(request, trainingMaster);
//        currencyMasterValidator.validate(trainingMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());

            mv.setViewName("Training/TrainingCreate");

        } else {

            mv.getModelMap().put("trainingMaster", trainingMaster);
            trainingMasterService.update(trainingMaster);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate Startdate = LocalDate.parse(trainingMaster.getStartDate(), formatter);
            LocalDate Enddate = LocalDate.parse(trainingMaster.getEndDate(), formatter);
            List<LocalDate> alldate = getDatesBetween(Startdate, Enddate);
            trainingMasterService.deletetrainingSubMaster(trainingMaster.getId());
            for (LocalDate alldate1 : alldate) {
                TrainingSubMaster trainingSubMaster = new TrainingSubMaster();
                trainingSubMaster.setTrainingdate(alldate1.toString());
                trainingSubMaster.setTrainingMasterid(trainingMaster.getId());
                trainingSubMaster.setTrainerMasterid(trainingMaster.getTrainer().getId());
                trainingSubMaster.setTitle(trainingMaster.getTrainingTitle());
                trainingSubMasterService.create(trainingSubMaster);

            }
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
//             mv.getModelMap().put("trainingMaster", trainingMaster);
            List<?> trainingList = trainingMasterService.read();
            mv.addObject("trainingList", trainingList);
//            mv.setViewName("Training/TrainingMaster");
            mv = showList(request,response,trainingMaster);
        }

//            mv = searchSubmit(request, response);
        return mv;
    }

    public void getSubTypeByTrainingType(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int trainingTypeId = Integer.valueOf(request.getParameter("trainingTypeId"));
        Map<Integer, String> subtypeByTypeMap = new HashMap<Integer, String>();
        List subtypeAtTypeList = trainingSubTypeService.readtrainingSubTypeByTrainingTypeId(trainingTypeId);
        TrainingSubType trainingSubTypeMaster = new TrainingSubType();
        for (Object subTypeList1 : subtypeAtTypeList) {
            Object[] o = (Object[]) subTypeList1;
            int subTypeid = (int) o[0];
            String trainingSubTypeName = (String) o[1];
//            trainingSubTypeMaster = (TrainingSubType) o[0];
            subtypeByTypeMap.put(subTypeid, trainingSubTypeName);
        }
        String jsonOfsubtypeByTypeMap = new Gson().toJson(subtypeByTypeMap);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonOfsubtypeByTypeMap);

        } finally {
            out.close();
        }
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, TrainingMaster trainingMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                trainingMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    trainingMaster = trainingMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += trainingMaster.getTrainingTitle();
                    } else {
                        checkStr += "," + trainingMaster.getTrainingTitle();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            mv.addObject("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            mv.addObject("successMessage", "Information Is Deleted Successfully.");
        }
//        List<?> trainingList = trainingMasterService.read();
//          mv.addObject("trainingList", trainingList);
        mv = showList(request,response,trainingMaster);
//        showList(request,response,trainingMaster);
        return mv;
    }

    public static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}
