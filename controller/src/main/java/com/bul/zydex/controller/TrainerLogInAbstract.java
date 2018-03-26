/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmployeeFeedback;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingQuestionAnswerSubmit;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.Training.EmployeeFeedbackService;
import com.bul.zydex.service.Training.TrainerService;
import com.bul.zydex.service.Training.TrainingAssessmentService;
import com.bul.zydex.service.Training.TrainingAttendanceService;
import com.bul.zydex.service.Training.TrainingIdentificationService;
import com.bul.zydex.service.Training.TrainingMasterService;
import com.bul.zydex.service.Training.TrainingQuestionAnswerSubmitService;
import com.bul.zydex.service.Training.TrainingSubTypeService;
import com.bul.zydex.service.Training.TrainingTypeService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import com.bul.zydex.service.questionlibrary.QuestionAnsService;
import com.bul.zydex.service.questionlibrary.QuestionLibraryService;
import com.bul.zydex.service.questionlibrary.QuestionPaperService;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.validation.Validator;

/**
 *
 * @author DELL3
 */
public abstract class TrainerLogInAbstract extends CustomAbstract {

    protected TrainerService<Trainer> trainerService;
    protected TrainingMasterService<TrainingMaster> trainingMasterService;
    protected TrainingSubTypeService<TrainingSubType> trainingSubTypeService;
    protected TrainingTypeService<TrainingType> trainingTypeService;
    protected TrainingAttendanceService<TrainingAttendance> trainingAttendanceService;
    protected TrainingIdentificationService<TrainingIdentification> trainingIdentificationService;
    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;
    protected QuestionPaperService<QuestionPaper> questionPaperService;
    protected TrainingAssessmentService<TrainingAssessment> trainingAssessmentService;
    protected EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService;

    public EmployeeFeedbackService<EmployeeFeedback> getEmployeeFeedbackService() {
        return employeeFeedbackService;
    }

    public void setEmployeeFeedbackService(EmployeeFeedbackService<EmployeeFeedback> employeeFeedbackService) {
        this.employeeFeedbackService = employeeFeedbackService;
    }
    protected TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> trainingQuestionAnswerSubmitService;
    protected QuestionLibraryService<QuestionLibrary> questionLibraryService;
    protected QuestionAnsService<QuestionAns> questionAnsService;

    public EmployeeMasterService<EmployeeMaster> getEmployeeMasterService() {
        return employeeMasterService;
    }

    public void setEmployeeMasterService(EmployeeMasterService<EmployeeMaster> employeeMasterService) {
        this.employeeMasterService = employeeMasterService;
    }

    public TrainingMasterService<TrainingMaster> getTrainingMasterService() {
        return trainingMasterService;
    }

    public void setTrainingMasterService(TrainingMasterService<TrainingMaster> trainingMasterService) {
        this.trainingMasterService = trainingMasterService;
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

    public QuestionPaperService<QuestionPaper> getQuestionPaperService() {
        return questionPaperService;
    }

    public void setQuestionPaperService(QuestionPaperService<QuestionPaper> questionPaperService) {
        this.questionPaperService = questionPaperService;
    }

    public TrainingAssessmentService<TrainingAssessment> getTrainingAssessmentService() {
        return trainingAssessmentService;
    }

    public void setTrainingAssessmentService(TrainingAssessmentService<TrainingAssessment> trainingAssessmentService) {
        this.trainingAssessmentService = trainingAssessmentService;
    }

    public TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> getTrainingQuestionAnswerSubmitService() {
        return trainingQuestionAnswerSubmitService;
    }

    public void setTrainingQuestionAnswerSubmitService(TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> trainingQuestionAnswerSubmitService) {
        this.trainingQuestionAnswerSubmitService = trainingQuestionAnswerSubmitService;
    }

    public QuestionLibraryService<QuestionLibrary> getQuestionLibraryService() {
        return questionLibraryService;
    }

    public void setQuestionLibraryService(QuestionLibraryService<QuestionLibrary> questionLibraryService) {
        this.questionLibraryService = questionLibraryService;
    }

    public QuestionAnsService<QuestionAns> getQuestionAnsService() {
        return questionAnsService;
    }

    public void setQuestionAnsService(QuestionAnsService<QuestionAns> questionAnsService) {
        this.questionAnsService = questionAnsService;
    }

//    public Validator getForgotPwdValidator() {
//        return forgotPwdValidator;
//    }
//
//    public void setForgotPwdValidator(Validator forgotPwdValidator) {
//        this.forgotPwdValidator = forgotPwdValidator;
//    }
//    protected static final Logger logger = Logger
//            .getLogger(LogInAbstract.class);
//    protected Validator loginValidator;
//    protected Validator userInitPwdValidator;
//    protected Validator forgotPwdValidator;
//    protected static final String PATH = "User" + File.separator;
//    protected static final String LOGIN_PAGE = PATH + "Login";
//
//    public Validator getLoginValidator() {
//        return loginValidator;
//    }
//
//    public void setLoginValidator(Validator loginValidator) {
//        this.loginValidator = loginValidator;
//    }
//
//    public Validator getUserInitPwdValidator() {
//        return userInitPwdValidator;
//    }
//
//    public void setUserInitPwdValidator(Validator userInitPwdValidator) {
//        this.userInitPwdValidator = userInitPwdValidator;
//    }
//
//    protected void addUser(HttpServletRequest request, UserMaster user) {
//        HttpSession session = request.getSession();
//        session.setAttribute("user", userMasterService.readById(user.getId()));
//    }
//
//    protected void setCookies(HttpServletRequest request, HttpServletResponse response)throws Exception {
//
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String rememberMe = request.getParameter("rememberMe");
//        System.out.println("rememberMe : " + rememberMe);
//        Cookie userNameCookie = new Cookie("userNameCookie", userName.trim());
//        Cookie passwordCookie = new Cookie("passwordCookie", password.trim());
//        Cookie rememberMeCookie = new Cookie("rememberMeCookie", rememberMe.trim());
//        userNameCookie.setMaxAge(60 * 60 * 24 * 15);//15 days
//        passwordCookie.setMaxAge(60 * 60 * 24 * 15);
//        rememberMeCookie.setMaxAge(60 * 60 * 24 * 15);
//        response.addCookie(userNameCookie);
//        response.addCookie(passwordCookie);
//        response.addCookie(rememberMeCookie);
//         //        HttpSession session = request.getSession();
//        //        session.setAttribute("user", userMasterService.readById(user.getId()));
//    }
    public void auditgetCalDate(HttpServletRequest request, String monthAndYear, Calendar now, int trainerId) throws ParseException, JSONException {
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

                        List<?> list = trainerService.ListeventDates(format.format(preDate), trainerId);
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

    protected void questionList(HttpServletRequest request) {
        QuestionPaper questionPaper = new QuestionPaper();
        List<?> depttList = questionPaperService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            questionPaper = (QuestionPaper) o;
            dm.put(questionPaper.getId(), questionPaper.getPaperName());
        }

        request.setAttribute("questions", dm);
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
