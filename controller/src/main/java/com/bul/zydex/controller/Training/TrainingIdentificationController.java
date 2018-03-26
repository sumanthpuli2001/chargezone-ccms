/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.model.UserMaster;
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
import javax.mail.Session;
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

//    public ModelAndView createTraineList(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//
//        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession();
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        TrainingIdentification trainingIdentification = new TrainingIdentification();
//        
//        List<?> trainingList = trainingIdentificationService.readTrainingList(employeeMaster.getId());
//        mv.getModelMap().put("trainingIdentification", trainingIdentification);
//        mv.getModelMap().put("list", trainingList);
//        mv.setViewName("Training/TrainingList");
//        return mv;
//    }
    public ModelAndView sendFeedback(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeFeedback employeeFeedback = new EmployeeFeedback();
        TrainingFeedback trainingFeedback = new TrainingFeedback();
        readTrainingFeedback(request);
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        String id = request.getParameter("id");
        String eventdate = request.getParameter("eventdate");
        mv.getModelMap().put("id", id);

        employeeFeedback.setTrainingFeedback(trainingFeedback);
        mv.getModelMap().put("employeeFeedback", employeeFeedback);
        request.setAttribute("eventdate", eventdate);
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
        TrainingMaster trainingMaster2 = trainingMasterService.readById(trainingIdentification.getTrainingMaster().getId());
        if ("" == id) {
            for (String z : savingList) {
//                if(){}
                try {
                    List<TrainingMaster> innerlist = (List<TrainingMaster>) trainingIdentificationService.checkTraineeAvailableStatus(trainingIdentification.getTrainingMaster().getId(), Integer.parseInt(z));
                    int i = 0;
                    for (TrainingMaster trainingMaster : innerlist) {
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat formatterTime1 = new SimpleDateFormat("hh:mm");
                        Date startdate = formatter1.parse(trainingMaster.getStartDate());
                        Date enddate = formatter1.parse(trainingMaster.getEndDate());
                        Date currenstarttdate = formatter1.parse(trainingMaster2.getStartDate());
                        Date currentenddate = formatter1.parse(trainingMaster2.getEndDate());
                        Date currentendtime = formatterTime1.parse(trainingMaster2.getTrainingTimeForm());
                        Date currentstarttime = formatterTime1.parse(trainingMaster2.getTrainingTimeForm());
                        Date starttime = formatterTime1.parse(trainingMaster.getTrainingTimeForm());
                        Date endtime = formatterTime1.parse(trainingMaster.getTrainingTimeForm());
                        if (currenstarttdate.compareTo(startdate) >= 0 && currenstarttdate.compareTo(enddate) <= 0 || currentenddate.compareTo(startdate) >= 0 && currentenddate.compareTo(enddate) <= 0) {
                            if (currentstarttime.compareTo(starttime) >= 0 && currentstarttime.compareTo(endtime) <= 0 || currentendtime.compareTo(starttime) >= 0 && currentendtime.compareTo(endtime) <= 0) {
                                i++;
                            }

                        }

                    }
                    if (i == 0) {
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
                    }
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
        String eventdate = request.getParameter("eventdate");
        TrainingMaster trainingMaster = new TrainingMaster();
        trainingMaster.setId(Integer.parseInt(id));
        employeeFeedback.setTrainingMaster(trainingMaster);
        employeeFeedback.setEmployeeMaster(employeeMaster);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        employeeFeedback.setDateTime(sdf.format(cDate));
        employeeFeedback.setEventDate(eventdate);
        employeeFeedbackService.create(employeeFeedback);

        mv = showcalendar(request, response);
        return mv;

    }

    public ModelAndView calendarList(HttpServletRequest request, HttpServletResponse response) throws ParseException, Exception {
        ModelAndView mv = new ModelAndView();
        String monthAndYear = request.getParameter("monthAndYear");
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
        EmployeeMaster user = (EmployeeMaster) session.getAttribute("employeeInfo");
        auditgetCalDate(request, monthAndYear, cal3, user.getId());
        mv.setViewName("Training/TrainingList");
        return mv;
    }

    public ModelAndView showcalendar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Calendar cal3 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-yyyy");
        Date dateTime = new Date();
        HttpSession session = request.getSession(false);
        EmployeeMaster user = (EmployeeMaster) session.getAttribute("employeeInfo");
        String monthAndYear = simpleDateFormat.format(new Date());
        dateTime = simpleDateFormat.parse(monthAndYear);
        cal3.setTime(dateTime);
        auditgetCalDate(request, monthAndYear, cal3, user.getId());
        mv.setViewName("Training/TrainingList");
        return mv;
    }

    public ModelAndView viewProfile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        EmployeeMaster user = (EmployeeMaster) session.getAttribute("employeeInfo");
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
//        List attenlist=  new LinkedList();
//         attenlist =  trainingAttendanceService.gettrainingattendance(eventdate,Integer.parseInt(id));
        boolean shosts = true;

        boolean showFeedbackButton = employeeFeedbackService.checkFeedbackforEmp(user.getId(), trainingMaster.getId(), eventdate);

//       if(attenlist.isEmpty()){
//           shosts=false;
//           attenlist=  trainingIdentificationService.gettrainingattendance(Integer.parseInt(id));
//           
//       }
        request.setAttribute("shosts", shosts);
        request.setAttribute("showFeedbackButton", showFeedbackButton);
        request.setAttribute("eventdate", eventdate);
//        request.setAttribute("list", attenlist);
        request.setAttribute("trainingMaster", trainingMaster);
        mv.setViewName("Training/MyTrainingMasterLabelView");
        return mv;
    }

    public ModelAndView SubmitAttendanceClick(HttpServletRequest request, HttpServletResponse response, TrainingMaster trainingMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String trainingMasterId = request.getParameter("trainingMasterId");
        String eventdate = request.getParameter("eventdate");
//        Object[] allTrainingsId = (Object[])request.getParameterValues("allTrainingsId");

        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
        HttpSession session = request.getSession(false);
        Trainer trainer = (Trainer) session.getAttribute("trainerMaster");
        TrainingMaster trnMaster = new TrainingMaster();
        trnMaster.setId(Integer.parseInt(trainingMasterId));
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {

                EmployeeMaster em = new EmployeeMaster();
                em.setId(Integer.parseInt(checkedValues));
                TrainingAttendance trnatt = new TrainingAttendance();
                trnatt.setEmployeeMaster(em);
                trnatt.setTrainer(trainer);
                trnatt.setTrainingMaster(trnMaster);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                Date d = new Date();
                String currentDate = dateFormat.format(d);
                trnatt.setTrainingDate(eventdate);
                trnatt.setAttendanceDate(currentDate.toString());
                trnatt.setStatus(0);
                trainingAttendanceService.create(trnatt);
            } catch (Exception e) {
            }
        }
        List<?> Tran = trainingIdentificationService.getTrainerAttendance(Integer.parseInt(trainingMasterId));
        for (Object checkedValue : Tran) {
            try {
                Object[] obj = (Object[]) checkedValue;
                if (trainingIdentificationService.checkExistance(trnMaster.getId(), Integer.parseInt("" + obj[0]), trainer.getId(), eventdate)) {
                    EmployeeMaster em = new EmployeeMaster();
                    em.setId(Integer.parseInt("" + obj[0]));

                    TrainingAttendance trnatt = new TrainingAttendance();
                    trnatt.setEmployeeMaster(em);
                    trnatt.setTrainer(trainer);
                    trnatt.setTrainingMaster(trnMaster);
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    Date d = new Date();
                    String currentDate = dateFormat.format(d);
                    trnatt.setTrainingDate(eventdate);
                    trnatt.setAttendanceDate(currentDate.toString());
                    trnatt.setStatus(1);
                    trainingAttendanceService.create(trnatt);
                }
            } catch (Exception e) {
            }
        }
        if (flag) {
            mv.addObject("failureMessage", "Error.... " + "<b>" + checkStr + "</b>");
        } else {
            mv.addObject("successMessage", "Information Is Submitted Successfully.");
        }
        mv = showcalendar(request, response);
//        mv.setViewName("Trainer/TrainerMasterlblView");
        return mv;
    }

    public ModelAndView showTrainingFeedbackList(HttpServletRequest request, HttpServletResponse response, TrainingMaster trainingMaster) throws Exception {
        ModelAndView mv = new ModelAndView();

        String trainingId = request.getParameter("TrainingId");
        EmployeeFeedback employeeFeedback = new EmployeeFeedback();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
//        List<?> trainingsList = trainingMasterService.read();
//        Map<Integer, String> trainingsMap = new HashMap<Integer, String>();
//        for(Object o : trainingsList)
//        {
//            TrainingMaster o1 = (TrainingMaster) o;
//            int trngId = (int) o1.getId();
//            String title = (String) o1.getTrainingTitle();
////            trainingSubTypeMaster = (TrainingSubType) o[0];
//            trainingsMap.put(trngId, title);
//            
//        }

        List<?> trainingFeedbackList = new ArrayList();
        if (null != trainingId) {
            trainingFeedbackList = trainingMasterService.fetchtTrainingforFeedback(Integer.parseInt(trainingId), user.getId());
        }
        trainingsList(request);
        employeeFeedback.setTrainingMaster(trainingMaster);
        mv.addObject("trainingFeedbackList", trainingFeedbackList);
        mv.addObject("employeeFeedback", employeeFeedback);
//        mv.addObject("trainingsMaps", trainingsMap);
        mv.setViewName("Training/TrainingFeedbackDetails");
        return mv;
    }

    public ModelAndView showFeedbackView(HttpServletRequest request, HttpServletResponse response, TrainingMaster trainingMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        mv.getModelMap().put("id", id);

        EmployeeFeedback employeeFeedback = employeeFeedbackService.readById(Integer.parseInt(id));
        TrainingMaster trainingMaster1 = trainingMasterService.readById(employeeFeedback.getTrainingMaster().getId());
        TrainingFeedback trainingFeedback = trainingFeedbackService.readById(employeeFeedback.getTrainingFeedback().getId());
        EmployeeMaster employeeMaster = employeeMasterService.readById(employeeFeedback.getEmployeeMaster().getId());
        TrainingType trainingType = trainingTypeService.readById(trainingMaster1.getTrainingType().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster1.getTrainingSubType().getId());
        Trainer trainer =  trainerService.readById(trainingMaster1.getTrainer().getId());
        trainingMaster1.setTrainingType(trainingType);
        trainingMaster1.setTrainingSubType(trainingSubType);
        trainingMaster1.setTrainer(trainer);
        request.setAttribute("trainingMaster", trainingMaster1);
        request.setAttribute("description", employeeFeedback.getDescription());
        request.setAttribute("Feedaback", trainingFeedback.getFeedaback());
        request.setAttribute("EmployeeName", employeeMaster.getEmployeeName());
        mv.setViewName("Training/FeedbackView");
        return mv;
    }

}
