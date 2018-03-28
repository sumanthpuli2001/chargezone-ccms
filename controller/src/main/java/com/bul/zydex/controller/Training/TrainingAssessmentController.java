/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.TrainerLogInController;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionAnswerSubmit;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingQuestionAnswerSubmit;
import com.bul.zydex.model.TrainingResultStatus;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman
 */
public class TrainingAssessmentController extends TrainingAssessmentAbstract {

    public ModelAndView clickassessment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        TrainingAssessment trainingAssessment = new TrainingAssessment();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        Integer EmpID = employeeMaster.getId();
        List listOfFinalList = new ArrayList();

        List<?> list2 = trainingAssessmentService.readOnlineAssementCandidateTraningList(EmpID);
        if (!list2.isEmpty()) {
            for (Object o2 : list2) {
                Object str1[] = (Object[]) o2;
                List finalList = new ArrayList();
                Integer onlineAssessmentID = (Integer) str1[0];
                finalList.add(onlineAssessmentID);
                Integer candidateJobApplicationID = (Integer) str1[1];
                finalList.add(candidateJobApplicationID);
                Integer questionPaperId = (Integer) str1[2];
                finalList.add(questionPaperId);
                Double passingPercentage = (Double) str1[3];
                finalList.add(passingPercentage);
                String validityFrom = (String) str1[4];
                finalList.add(validityFrom);
                String validityTo = (String) str1[5];
                finalList.add(validityTo);
                String duration = (String) str1[6];
                finalList.add(duration);
                Integer noOfAttampt = (Integer) str1[7];
                finalList.add(noOfAttampt);
                Integer noOfQue = (Integer) str1[8];
                finalList.add(noOfQue);
                Double totalMarks = (Double) str1[9];
                finalList.add(totalMarks);
                String paperName = (String) str1[10];
                finalList.add(paperName);
                finalList.add(EmpID);

                listOfFinalList.add(finalList);

            }
        }

        mv.getModelMap().put("list2", listOfFinalList);
        mv.getModelMap().put("trainingAssessment", trainingAssessment);
//        mv.getModelMap().put("candidateApplyJobid", candidateApplyJobid);
        mv.setViewName("Training/TraningAssmentList");

        return mv;
    }

    public ModelAndView clickassessmentOnlineTest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        TrainingAssessment trainingAssessment = new TrainingAssessment();
        String id = request.getParameter("id");
        String empid = request.getParameter("empid");
        String onlineAssmentID = request.getParameter("onlineAssment");
        SimpleDateFormat sdfAb = new SimpleDateFormat("hh:mm:ss");
        Date cDate1 = new Date();
        String time = sdfAb.format(cDate1);
        trainingAssessment = trainingAssessmentService.readById(Integer.parseInt(onlineAssmentID));
//        onlineAssessment.setId(Integer.parseInt(onlineAssmentID));
        String StartTime1 = trainingAssessment.getStartTimeNow();
        if (null == StartTime1 || "" == StartTime1 || StartTime1.isEmpty()) {
            trainingAssessment.setStartTimeNow(time);
            Integer attempt = trainingAssessment.getNoOfAttampt();
            Integer NoofAttemptleft = attempt - 1;
            trainingAssessment.setNoOfAttampt(NoofAttemptleft);
            trainingAssessmentService.update(trainingAssessment);
        }

        String Duration = trainingAssessment.getDuration();
        String StartTime = trainingAssessment.getStartTimeNow();
//        String Duration = onlineAssessment.getDuration();
        List listOfFinalList = new ArrayList();
        List<?> list1 = questionDetailsService.takeTestOnlineAssementCandidate(Integer.parseInt(id));
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            List finalList = new ArrayList();
            Integer questionDetailsID = (Integer) str[0];
            Integer questionPaperId = (Integer) str[1];
            Integer questionLibraryID = (Integer) str[2];
            QuestionLibrary questionLibrary = new QuestionLibrary();
            questionLibrary = questionLibraryService.readById(questionLibraryID);
            Integer questionLibraryid = questionLibrary.getId();
            String question = questionLibrary.getQuestion();
            finalList.add(question);
            Integer type = questionLibrary.getType();
            finalList.add(type);
            finalList.add(questionLibraryid);

            List<?> list2 = questionAnsService.takeTestOnlineAssementCandidateAnswer(questionLibraryid);
            for (Object o2 : list2) {
                Object str1[] = (Object[]) o2;
                Integer questionAnsID = (Integer) str1[0];
                String answer = (String) str1[2];
                finalList.add(answer);
                finalList.add(questionAnsID);
            }
            listOfFinalList.add(finalList);
        }
//        
        mv.getModelMap().put("list2", listOfFinalList);
        mv.getModelMap().put("empid", empid);
        mv.getModelMap().put("Duration", Duration);
        mv.getModelMap().put("StartTime", StartTime);
        mv.getModelMap().put("onlineAssmentID", onlineAssmentID);
        mv.setViewName("Training/TraningOnlinePaper");

        return mv;
    }

    public ModelAndView clickSubmitQuestionAnswerExpired(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        TrainingAssessment trainingAssessment = new TrainingAssessment();

        String onlineAssmentID = request.getParameter("onlineAssmentID");
        trainingAssessment = trainingAssessmentService.readById(Integer.parseInt(onlineAssmentID));

        trainingAssessment.setStartTimeNow(null);
        trainingAssessmentService.update(trainingAssessment);
        mv = clickassessment(request, response);

        return mv;
    }

    public ModelAndView clickSubmitQuestionAnswer(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        TrainingAssessment trainingAssessment = new TrainingAssessment();

        String candidateiD = request.getParameter("candidateId");
//        int candidateJobapplicationid = candidateJobApplicationService.GETByCandidateId(Integer.parseInt(candidateiD));

        String[] question = request.getParameterValues("finalData1");
        String[] email = request.getParameterValues("finalData");
//       
        String[] doneId1 = email[0].split(",");
        String[] doneId2 = question[0].split(",");
        String emailId = "";
        String emailId1 = "";
//     
        for (int i = 0; i < doneId2.length; i++) {
            TrainingQuestionAnswerSubmit trainingQuestionAnswerSubmit = new TrainingQuestionAnswerSubmit();
            QuestionAns questionAns = new QuestionAns();

            QuestionLibrary questionLibrary = new QuestionLibrary();
            String ques = doneId2[i];
            String ans = doneId1[i];
            boolean parsable = true;
            try {
                Integer.parseInt(ans);
                questionAns.setId(Integer.parseInt(ans));
            } catch (Exception e) {
                parsable = false;
                trainingQuestionAnswerSubmit.setDescription(ans);
            }
//            return parsable;

            trainingQuestionAnswerSubmit.setQuestionAns(questionAns);// Question Anaswer Id set
            trainingAssessment.setId(Integer.parseInt(candidateiD));
            trainingQuestionAnswerSubmit.setTrainingAssessment(trainingAssessment);/// candidate Apply job ID set 
            questionLibrary.setId(Integer.parseInt(ques));
            trainingQuestionAnswerSubmit.setQuestionLibrary(questionLibrary);
            trainingQuestionAnswerSubmitService.create(trainingQuestionAnswerSubmit);
//             mv.setViewName("Vacancy/AssementOnline");
        }
        trainingAssessment = trainingAssessmentService.readById(Integer.parseInt(candidateiD));
        trainingAssessment.setStatus(1);
        trainingAssessmentService.update(trainingAssessment);
        return mv;

    }

    public ModelAndView backToHomeVacancyListCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        TrainingAssessment trainingAssessment = new TrainingAssessment();

        String onlineAssmentID = request.getParameter("onlineAssmentID");
        trainingAssessment = trainingAssessmentService.readById(Integer.parseInt(onlineAssmentID));

        trainingAssessment.setStartTimeNow(null);
        trainingAssessmentService.update(trainingAssessment);
        mv = clickassessment(request, response);
        return mv;
    }

    public ModelAndView submitResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String[] id = request.getParameterValues("id");

        String eventdate = request.getParameter("eventdate");
        String assessmentId = request.getParameter("assessmentId");
        TrainingAssessment trainingAssessment = trainingAssessmentService.readById(Integer.parseInt(assessmentId));
        int trMasterId = trainingAssessment.getTrainingMaster().getId();
        TrainingMaster trainingMaster = trainingMasterService.readById(trMasterId);
        String totalResult = request.getParameter("totalResult");
        String percentageResult = request.getParameter("percentageResult");
        String passResult = request.getParameter("passResult");
        String failResult = request.getParameter("failResult");
//        String[] givenMarks1 = request.getParameterValues("givenMarks3");
        String[] givenMarks2 = request.getParameterValues("givenMarks2");
        String[] type = request.getParameterValues("type");
//        String[] mcqStatus = request.getParameterValues("mcqStatus");
        try {
            for (int i = 0; i < id.length; i++) {
                String ids = id[i];
                String tp = type[i];
                String mcqSts = null; // last add
                String inputqSts = null; // last add
                TrainingQuestionAnswerSubmit trainingQuestionAnswerSubmit = trainingQuestionAnswerSubmitService.readById(Integer.parseInt(ids));
                String inputedMarks = null;
                int typeofQue = Integer.parseInt(tp);
                if (1 == typeofQue) {
                    inputedMarks = givenMarks2[i];
                    inputqSts = request.getParameter("mcqStatus" + (i + 1));
                    trainingQuestionAnswerSubmit.setAnsStatus(Integer.parseInt(inputqSts));
                } else {
                    inputedMarks = givenMarks2[i];
                    mcqSts = request.getParameter("mcqStatus" + (i + 1));
                    trainingQuestionAnswerSubmit.setAnsStatus(Integer.parseInt(mcqSts));
                }
//            String ans = doneId1[i];

                trainingQuestionAnswerSubmit.setObtainMarks(Double.parseDouble(inputedMarks));

                trainingQuestionAnswerSubmitService.update(trainingQuestionAnswerSubmit);
//             mv.setViewName("Vacancy/AssementOnline");
            }
            TrainingResultStatus trainingResultStatus = new TrainingResultStatus();
            trainingResultStatus.setTrainingAssessment(trainingAssessment);
            trainingResultStatus.setObtainTotal(Double.parseDouble(totalResult));
            trainingResultStatus.setObtainPercentage(Double.parseDouble(percentageResult));

            if ("" != passResult) {
                trainingResultStatus.setResultStatus(passResult);
                trainingResultStatusService.create(trainingResultStatus);
                trainingMaster.setAssessmentResultStatus(0);
                trainingMasterService.update(trainingMaster);
            }
            if ("" != failResult) {
                trainingResultStatus.setResultStatus(failResult);
                trainingResultStatusService.create(trainingResultStatus);
                trainingMaster.setAssessmentResultStatus(1);
                trainingMasterService.update(trainingMaster);
            }
           
            List attenlist = new LinkedList();
            attenlist = trainingAttendanceService.gettrainerTasks(eventdate, trMasterId);
            boolean shosts = true;
            boolean feedbackStatus = trainingAttendanceService.checkFeedbackstatus(trMasterId);
            if (attenlist.isEmpty()) {
                shosts = false;
                attenlist = trainingIdentificationService.getTrainerAttendance(trMasterId);

            }
            TrainingMaster trainingMaster1 = trainingMasterService.readById(trMasterId);
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

        } catch (Exception e) {
            request.setAttribute("failureMessage",
                    "All field are Required.Please Enter Valid data");

        }
        return mv;
    }

}
