/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingIdentification;
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

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<?> trainingList = trainingMasterService.readTrainingMasterList();
        mv.getModelMap().put("list", trainingList);
        mv.setViewName("Training/TrainingMaster");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = new TrainingMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        //The Event date is used for fetching date from calendar +(Plus button)
        String eventdate = request.getParameter("eventdate");

        trainerList(request);
        trainingtypeList(request);
        trainingSubtypeList(request);
        selectEmployee(request, response);
        departmentList(request);

        selectedEmployeeFor360Feedback(request, employeeMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        request.setAttribute("startdate", eventdate);
        mv.getModelMap().put("trainingMaster", trainingMaster);
        mv.setViewName("Training/TrainingCreate");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = trainingMasterService.readById(Integer.parseInt(id));
        Trainer trainer = trainerService.readById(trainingMaster.getTrainer().getId());
        TrainingType trainingType = trainingTypeService.readById(trainingMaster.getTrainingType().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster.getTrainingSubType().getId());
        EmployeeMaster em = employeeMasterService.readById(Integer.parseInt(trainingMaster.getTrainingOwner()));
        trainingSubType.setTrainingType(trainingType);

        selectEmployee(request, response);

        int employee = em.getId();
        employeeMaster = (EmployeeMaster) employeeMasterService.readById(employee);
        String employeeName = employeeMaster.getEmployeeName();

        selectedEmployeeFor360Feedback(request, employeeMaster);
        trainingMaster.setTrainer(trainer);
        trainingMaster.setTrainingType(trainingType);
        trainingMaster.setTrainingSubType(trainingSubType);
        trainerList(request);
        trainingtypeList(request);
        trainingSubtypeList(request);
        departmentList(request);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("trainingMaster", trainingMaster);
        mv.setViewName("Training/TrainingEditView");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        int SubtypeBytrainingTypeId = Integer.parseInt(request.getParameter("SubtypeBytrainingTypeId"));
        TrainingMaster trainingMaster = new TrainingMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
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
            int departmentId = Integer.parseInt(request.getParameter("departmentMasterid"));
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
            trainingMaster.setDepartmentMaster(departmentMasterService.readById(departmentId));
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
            trainingMaster.setFinishStatus(0);
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
            TrainingSubMaster trainingSubMaster = new TrainingSubMaster();
            trainingSubMaster.setTrainingdate(trainingMaster.getEndDate());
            trainingSubMaster.setTrainingMasterid(trainingMaster.getId());
            trainingSubMaster.setTrainerMasterid(trainingMaster.getTrainer().getId());
            trainingSubMaster.setTitle(trainingMaster.getTrainingTitle());
            trainingSubMasterService.create(trainingSubMaster);
            /////////////////////////////////////////////////////
            List<?> trainingList = trainingMasterService.read();

            mv.addObject(
                    "trainingList", trainingList);
//            mv.setViewName(
//                    "Training/TrainingMaster");
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showList(request, response);

        }
//            mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView EditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = new TrainingMaster();
        Integer trainingId = Integer.parseInt(request.getParameter("id"));
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
        HttpSession session = request.getSession();
        UserMaster userMaster = (UserMaster) session.getAttribute("user");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date d = new Date();
        String currentDate = dateFormat.format(d);
        TrainingMaster trn = trainingMasterService.readById(trainingId);
        trainingMaster.setId(trainingId);
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
        trainingMaster.setStatus(trn.getStatus());
        trainingMaster.setFinishStatus(trn.getFinishStatus());
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
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date initDate = convertToDateViaSqlDate(alldate1);
                String allDate2 = sdf.format(initDate);
                TrainingSubMaster trainingSubMaster = new TrainingSubMaster();
                trainingSubMaster.setTrainingdate(allDate2.toString());
                trainingSubMaster.setTrainingMasterid(trainingMaster.getId());
                trainingSubMaster.setTrainerMasterid(trainingMaster.getTrainer().getId());
                trainingSubMaster.setTitle(trainingMaster.getTrainingTitle());
                trainingSubMasterService.create(trainingSubMaster);

            }
            TrainingSubMaster trainingSubMaster = new TrainingSubMaster();
            trainingSubMaster.setTrainingdate(trainingMaster.getEndDate());
            trainingSubMaster.setTrainingMasterid(trainingMaster.getId());
            trainingSubMaster.setTrainerMasterid(trainingMaster.getTrainer().getId());
            trainingSubMaster.setTitle(trainingMaster.getTrainingTitle());
            trainingSubMasterService.create(trainingSubMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
//             mv.getModelMap().put("trainingMaster", trainingMaster);
            List<?> trainingList = trainingMasterService.read();
            mv.addObject("trainingList", trainingList);
//            mv.setViewName("Training/TrainingMaster");
            mv = showList(request, response);
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

        ModelAndView mv = new ModelAndView();
        String checkId[] = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {

            try {
                TrainingIdentification trainingIdentification = new TrainingIdentification();
                List<?> list = trainingIdentificationService.readTrainingById(checkedValues);
                for (Object object : list) {
                    trainingIdentification = (TrainingIdentification) object;
                    trainingIdentificationService.delete(trainingIdentification.getId());
                }
                TrainingSubMaster subMaster = new TrainingSubMaster();
                List<?> list1 = trainingSubMasterService.deletetrainingId(checkedValues);
                for (Object object1 : list1) {
                    subMaster = (TrainingSubMaster) object1;
                    trainingSubMasterService.delete(subMaster.getId());
                }

                trainingMasterService.delete(Integer.parseInt(checkedValues));
                request.setAttribute("successMessage",
                        "Info : Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showList(request, response);
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

    public ModelAndView pastTrainingMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> km = trainingMasterService.readTrainingMasterSummaryList();
//        List<?> km1 = kaizenMasterService.readKaizenMasterapprovalList(employeeMaster.getId());
        mv.getModelMap().put("list", km);
        mv.setViewName("Training/TrainingMasterSummaryList");

        return mv;
    }

    public ModelAndView VieweditClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        ModelAndView mv = new ModelAndView();
        TrainingMaster trainingMaster = trainingMasterService.readById(Integer.parseInt(id));
        Trainer trainer = trainerService.readById(trainingMaster.getTrainer().getId());
        TrainingType trainingType = trainingTypeService.readById(trainingMaster.getTrainingType().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster.getTrainingSubType().getId());
        EmployeeMaster em = employeeMasterService.readById(Integer.parseInt(trainingMaster.getTrainingOwner()));
        trainingSubType.setTrainingType(trainingType);

        selectEmployee(request, response);

        int employee = em.getId();
        employeeMaster = (EmployeeMaster) employeeMasterService.readById(employee);
        String employeeName = employeeMaster.getEmployeeName();

        selectedEmployeeFor360Feedback(request, employeeMaster);
        trainingMaster.setTrainer(trainer);
        trainingMaster.setTrainingType(trainingType);
        trainingMaster.setTrainingSubType(trainingSubType);
        trainerList(request);
        trainingtypeList(request);
        trainingSubtypeList(request);
        departmentList(request);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("trainingMaster", trainingMaster);
        mv.setViewName("Training/TrainingEditViewSummary");
        return mv;
    }

    public ModelAndView exportToExcelTrainingSummary(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> km = trainingMasterService.readTrainingMasterSummaryList();
//       
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=TrainingList.xls");
        mv.getModelMap().put("list", km);
//        mv.setViewName("Kaizen/ExportPastKaizen");
         mv.setViewName("Training/TrainingMasterSummaryListExport");
//        mv.setViewName("AttendanceRegularization/attendanceRegularizationViewResultExport");
        return mv;
    }
}
