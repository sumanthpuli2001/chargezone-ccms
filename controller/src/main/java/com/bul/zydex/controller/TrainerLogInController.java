/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.Training.TrainingAssessmentService;
import com.sun.jmx.snmp.SnmpDataTypeEnums;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
//import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class TrainerLogInController extends TrainerLogInAbstract {

    public ModelAndView Login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        Trainer trainerMaster = new Trainer();
        mv.getModelMap().put("trainerMaster", trainerMaster);

        mv.setViewName("Trainer/TrainerLogin");
        return mv;
    }

    public ModelAndView loginSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        ModelAndView mv = new ModelAndView();
        Trainer trainerMaster = new Trainer();
//        VacancyMaster vacancyMaster = new VacancyMaster();
//        BindException errors = new BindException(trainerMaster, "trainerMaster");
//        bind(request, trainerMaster);
//        String userName = trainerMaster.getUserName();
//        String PassString = trainerMaster.getPassword();
//        String userName = trainerMaster.getUserName();
//        String PassString = trainerMaster.getPassword();

        if (!"".equals(username) && !"".equals(password)) {
            List<?> TrainerList = trainerService.readByUser(username);
            for (Object o : TrainerList) {
                trainerMaster = (Trainer) o;
            }
//            Trainer train = new Trainer();
//            train.setUserName(username);
//            train.setPassword(password);
//            Trainer master = (Trainer) trainerService.read();

            if (trainerMaster.getId() != null) {
                HttpSession session1 = request.getSession(false);
                session1.setAttribute("trainerMaster", trainerMaster);

                request.setAttribute("successMessage",
                        "Information : Login Successfully.");

//                List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(master.getId());
//                List<?> CandidateJobApplyList = new ArrayList<>();
//                if (!candidateProfile.isEmpty()) {
//                    CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
//                    CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());
//                }
//                request.setAttribute("successMessage",
//                        "Information : Login Successfully.");
//                request.setAttribute("list", CandidateJobApplyList);
//                mv.getModelMap().put("TrainerList", TrainerList);
//                mv.setViewName("Trainer/TrainerList");
                mv = showcalendar(request, response);
                return mv;
            } else {
                request.setAttribute("successMessage",
                        "Error : Invalid UserName Or Password.");
                mv = Login(request, response);
            }
        } else {
            request.setAttribute("successMessage",
                    "Error : Invalid UserName Or Password.");
            mv = Login(request, response);
        }
//        mv.getModelMap().put("trainerMaster", trainerMaster);

        return mv;

    }

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        Trainer trnMaster = (Trainer) session.getAttribute("trainerMaster");
        session.invalidate();
        Trainer vacancyMaster = new Trainer();
        mv.setViewName("Trainer/TrainerLogin");
        return mv;

    }
//   public ModelAndView backToHome(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//
//        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        Trainer trnMaster = (Trainer) session.getAttribute("trainerMaster");
//        session.invalidate();
//        mv.setViewName("User/Login");
//        return mv;
//
//    }

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
        Trainer trainer = (Trainer) session.getAttribute("trainerMaster");
        auditgetCalDate(request, monthAndYear, cal3, trainer.getId());
        mv.setViewName("Trainer/TrainerList");
        return mv;
    }

    public ModelAndView showcalendar(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Calendar cal3 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-yyyy");
        Date dateTime = new Date();
        HttpSession session = request.getSession(false);
        Trainer trainer = (Trainer) session.getAttribute("trainerMaster");
        String monthAndYear = simpleDateFormat.format(new Date());
        dateTime = simpleDateFormat.parse(monthAndYear);
        cal3.setTime(dateTime);
        auditgetCalDate(request, monthAndYear, cal3, trainer.getId());
        mv.setViewName("Trainer/TrainerList");
        return mv;
    }

    public ModelAndView viewProfile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        Trainer user = (Trainer) session.getAttribute("trainerMaster");
        String eventdate = request.getParameter("eventdate");
        List attenlist = new LinkedList();
        attenlist = trainingAttendanceService.gettrainerTasks(eventdate, Integer.parseInt(id));
        boolean shosts = true;
        boolean feedbackStatus = trainingAttendanceService.checkFeedbackstatus(Integer.parseInt(id));
        if (attenlist.isEmpty()) {
            shosts = false;
            attenlist = trainingIdentificationService.getTrainerAttendance(Integer.parseInt(id));

        }
        TrainingMaster trainingMaster1 = trainingMasterService.readById(Integer.parseInt(id));
        TrainingType trainingType = trainingTypeService.readById(trainingMaster1.getTrainingType().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster1.getTrainingSubType().getId());
        Trainer trainer = trainerService.readById(trainingMaster1.getTrainer().getId());
        trainingMaster1.setTrainingType(trainingType);
        trainingMaster1.setTrainingSubType(trainingSubType);
        trainingMaster1.setTrainer(trainer);
        List<?>  trainingFeedbackList = trainingMasterService.fetchtTrainingforFeedback1(trainingMaster1.getId(), user.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        String currentDate = sdf.format(cDate);
        Date currenstarttdate = sdf.parse(currentDate);
        Date currentenddate = sdf.parse(eventdate);
        boolean shosts2 = true;
        boolean feedbackdshow = false;
        if(!trainingFeedbackList.isEmpty()){
        feedbackdshow = true;
        }
        if (currenstarttdate.compareTo(currentenddate) <= 0) {
            shosts2 = false;
        }
        boolean assflage = false;
         SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        Date startdate = formatter1.parse(trainingMaster1.getStartDate());
                        Date enddate = formatter1.parse(trainingMaster1.getEndDate());
                        if (currenstarttdate.compareTo(startdate) >= 0 && currenstarttdate.compareTo(enddate) <= 0 || currentenddate.compareTo(startdate) >= 0 && currentenddate.compareTo(enddate) <= 0) {
                        assflage = true;
                        }
                        
        request.setAttribute("finishStatus", trainingMaster1.getFinishStatus());
        request.setAttribute("feedbackdshow", feedbackdshow);
        request.setAttribute("assflage", assflage);
        request.setAttribute("shosts2", shosts2);
        request.setAttribute("trainingMaster", trainingMaster1);
        request.setAttribute("shosts", shosts);
        request.setAttribute("eventdate", eventdate);
        request.setAttribute("list", attenlist);
        request.setAttribute("trainingMasterId", id);
        request.setAttribute("feedbackStatus", feedbackStatus);
        mv.setViewName("Trainer/TrainerMasterlblView");
        return mv;
    }

    public ModelAndView viewProfile1(HttpServletRequest request,
            HttpServletResponse response, String id, String eventdate) throws Exception {
        ModelAndView mv = new ModelAndView();
//        String id = request.getParameter("id");
//        String eventdate = request.getParameter("eventdate");
        boolean feedbackStatus = trainingAttendanceService.checkFeedbackstatus(Integer.parseInt(id));
        List attenlist = new LinkedList();
        attenlist = trainingAttendanceService.gettrainerTasks(eventdate, Integer.parseInt(id));
        boolean shosts = true;

        if (attenlist.isEmpty()) {
            shosts = false;
            attenlist = trainingIdentificationService.getTrainerAttendance(Integer.parseInt(id));

        }
        TrainingMaster trainingMaster1 = trainingMasterService.readById(Integer.parseInt(id));
        TrainingType trainingType = trainingTypeService.readById(trainingMaster1.getTrainingType().getId());
        TrainingSubType trainingSubType = trainingSubTypeService.readById(trainingMaster1.getTrainingSubType().getId());
        Trainer trainer = trainerService.readById(trainingMaster1.getTrainer().getId());
        trainingMaster1.setTrainingType(trainingType);
        trainingMaster1.setTrainingSubType(trainingSubType);
        trainingMaster1.setTrainer(trainer);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        String currentDate = sdf.format(cDate);
        Date currenstarttdate = sdf.parse(currentDate);
        Date currentenddate = sdf.parse(eventdate);
        boolean shosts2 = true;
        if (currenstarttdate.compareTo(currentenddate) <= 0) {
            shosts2 = false;
        }
        request.setAttribute("shosts2", shosts2);
        request.setAttribute("trainingMaster", trainingMaster1);
        request.setAttribute("shosts", shosts);
        request.setAttribute("eventdate", eventdate);
        request.setAttribute("list", attenlist);
        request.setAttribute("trainingMasterId", id);
        request.setAttribute("feedbackStatus", feedbackStatus);
        mv.setViewName("Trainer/TrainerMasterlblView");
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

    public ModelAndView sendFeedback(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String eventdate = request.getParameter("eventdate");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        TrainingMaster trainingMaster = (TrainingMaster) trainingMasterService.readById(id);
        trainingMaster.setStatus(1);
        trainingMasterService.update(trainingMaster);
        mv = viewProfile1(request, response, "" + id, eventdate);
//        request.setAttribute("id", id);
//        request.setAttribute("eventdate", eventdate);
//        mv.setViewName("Training/applyTrainingFeedback");
        return mv;
    }
    public ModelAndView finishTraining(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String eventdate = request.getParameter("eventdate");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        TrainingMaster trainingMaster = (TrainingMaster) trainingMasterService.readById(id);
        trainingMaster.setFinishStatus(1);
        trainingMasterService.update(trainingMaster);
        mv = viewProfile1(request, response, "" + id, eventdate);
//        request.setAttribute("id", id);
//        request.setAttribute("eventdate", eventdate);
//        mv.setViewName("Training/applyTrainingFeedback");
        return mv;
    }

    public ModelAndView showTrainingFeedbackList(HttpServletRequest request, HttpServletResponse response, TrainingMaster trainingMaster) throws Exception {
        ModelAndView mv = new ModelAndView();

        String trainingId = request.getParameter("trainingMasterId");
        TrainingMaster trainingMaster1 = new TrainingMaster();

        EmployeeFeedback employeeFeedback = new EmployeeFeedback();
        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
        Trainer user = (Trainer) session.getAttribute("trainerMaster");
//        Trainer trainer= new Trainer();
        List<?> trainingFeedbackList = new ArrayList();
//        if (null != trainingId) {
        trainingFeedbackList = trainingMasterService.fetchtTrainingforFeedback1(Integer.parseInt(trainingId), user.getId());
//        }
        trainingsList(request);
        employeeFeedback.setTrainingMaster(trainingMaster);
//         mv.getModelMap().put("trainerMaster", trainerMaster);
        mv.addObject("trainingFeedbackList", trainingFeedbackList);
        mv.addObject("trainingMaster1", trainingMaster1);
//        mv.addObject("employeeFeedback", employeeFeedback);
//        mv.addObject("trainerMaster", trainer);
//        mv.addObject("trainingsMaps", trainingsMap);
        mv.setViewName("Trainer/TrainerFeedbackDetails");
        return mv;
    }

    public ModelAndView trainerAssessMent(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        TrainingAssessment trainingAssessment = new TrainingAssessment();
        String eventdate = request.getParameter("eventdate");
        int id = Integer.parseInt(request.getParameter("id"));
        TrainingMaster trainingMaster = new TrainingMaster();
        trainingMaster.setId(id);
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        questionList(request);
        List attenlist = new LinkedList();
        attenlist = trainingAttendanceService.gettrainerTasks(eventdate, id);
        mv.getModelMap().put("trainingAssessment", trainingAssessment);
        request.setAttribute("eventdate", eventdate);
        request.setAttribute("trainingMaster", trainingMaster);
        request.setAttribute("list", attenlist);
        mv.setViewName("Trainer/TrainingAssessment");

        return mv;
    }

    public ModelAndView submitTrainingAssessment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        TrainingAssessment trainingAssessment = new TrainingAssessment();
//        TrainingAssessment trainingAssessment1 = new TrainingAssessment();
        Trainer trnMaster = (Trainer) session.getAttribute("trainerMaster");
//        String eventdate = request.getParameter("eventdate");
        int trainingMasterId = Integer.parseInt(request.getParameter("trainingMasterId"));
        BindException errors = new BindException(trainingAssessment, "trainingAssessment");
        bind(request, trainingAssessment);
        TrainingMaster trainingMaster = trainingMasterService.readById(trainingMasterId);
        trainingAssessment.setTrainingMaster(trainingMaster);
        trainingAssessment.setCreatedBy(trnMaster.getId());
        trainingAssessment.setCreatedDate(dtf.format(localDate));
        String[] checkId = request.getParameterValues("checkId");
        trainingAssessment.setStatus(0);
        Integer hour = Integer.parseInt(trainingAssessment.getDuration()) / 60;
        Integer minits = Integer.parseInt(trainingAssessment.getDuration()) % 60;
        String strhout = hour.toString();
        String strminits = minits.toString();
        if (strhout.length() == 1) {
            strhout = "0" + strhout;
        }
        if (strhout.length() == 0) {
            strhout = "00";
        }
        if (strminits.length() == 1) {
            strminits = "0" + strminits;
        }
        if (strminits.length() == 0) {
            strminits = "00";
        }
        trainingAssessment.setDuration(strhout + ":" + strminits + ":00");
        for (String string : checkId) {
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setId(Integer.parseInt(string));
            trainingAssessment.setEmployeeMaster(employeeMaster);
//            Integer hour = Integer.parseInt(trainingAssessment.getDuration()) / 60;
//            Integer minits = Integer.parseInt(trainingAssessment.getDuration()) % 60;
//            String strhout = hour.toString();
//            String strminits = minits.toString();
//            if (strhout.length() == 1) {
//                strhout = "0" + strhout;
//            }
//            if (strhout.length() == 0) {
//                strhout = "00";
//            }
//            if (strminits.length() == 1) {
//                strminits = "0" + strminits;
//            }
//            if (strminits.length() == 0) {
//                strminits = "00";
//            }
//            String finalduration = strhout + ":" + strminits + ":00";
//            trainingAssessment.setDuration(finalduration);

            trainingAssessmentService.create(trainingAssessment);
        }

//        String[] checkId = request.getParameterValues("checkId");
        ModelAndView mv = new ModelAndView();
        mv = showcalendar(request, response);
        return mv;
    }

    public ModelAndView goToAns(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        int empId = Integer.parseInt(request.getParameter("id"));
        int trainingMasterId = Integer.parseInt(request.getParameter("trainingMasterId"));
        String eventdate = request.getParameter("eventdate");

//        TrainingAssessment trainingAssessment = new TrainingAssessment();
//        Trainer trnMaster = (Trainer) session.getAttribute("trainerMaster");
//        int trainingMasterId = Integer.parseInt(request.getParameter("trainingMasterId"));
        List<?> OnList = trainingAssessmentService.readTrainingAssementList(trainingMasterId, empId);
        Double passingPercentage = 0.0;
        Double totalMarks = 0.0;
        int assessmentId = 0;

        if (!OnList.isEmpty()) {
            for (Object o2 : OnList) {
                Object str1[] = (Object[]) o2;
                passingPercentage = (Double) str1[4];
                totalMarks = (Double) str1[10];
                assessmentId = (int) str1[0];

            }
        }

        List<?> QuestionAnswerListIds = trainingQuestionAnswerSubmitService.readByTrainigAssessmentId(assessmentId);
        List listOfFinalList = new ArrayList();
        for (Object o1 : QuestionAnswerListIds) {
            Object str[] = (Object[]) o1;
            List finalList = new ArrayList();
            Integer qasid = (Integer) str[0];
            Integer questionLibraryID = (Integer) str[2];
            Integer selectedAns = (Integer) str[3];
            Integer correctAns = (Integer) str[4];
            String Description = (String) str[5];
            Integer marks = (Integer) str[6];
            QuestionLibrary questionLibrary = new QuestionLibrary();
            questionLibrary = questionLibraryService.readById(questionLibraryID);
            Integer questionLibraryid = questionLibrary.getId();
            String question = questionLibrary.getQuestion();
            finalList.add(question);                // 0
            Integer type = questionLibrary.getType();
            finalList.add(type);                    // 1
            finalList.add(questionLibraryid);       // 2
            finalList.add(selectedAns);     //3
            finalList.add(correctAns);      //4
            finalList.add(marks);      //5
            finalList.add(passingPercentage);  //6
            finalList.add(totalMarks);  //7
            finalList.add(qasid);  //8
            finalList.add(assessmentId);  //9

            List<?> list2 = questionAnsService.takeTestOnlineAssementCandidateAnswer(questionLibraryid);
            if (!list2.isEmpty()) {
                for (Object o2 : list2) {
                    Object str1[] = (Object[]) o2;
                    Integer questionAnsID = (Integer) str1[0];
                    String answer = (String) str1[2];
                    finalList.add(answer);
                    finalList.add(questionAnsID);
                }

            } else {

                finalList.add(Description);
            }
            listOfFinalList.add(finalList);
        }

        mv.getModelMap().put("list2", listOfFinalList);
        mv.getModelMap().put("eventdate", eventdate);

        mv.setViewName("Trainer/TrainingQuestionAnsCheck");
        return mv;
    }
}
