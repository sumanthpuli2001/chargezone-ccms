/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CandidateResultStatus;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionAnswerSubmit;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.UserMaster;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class OnlineAssessmentController extends OnlineAssessmentAbstract {

    public ModelAndView submitAssessment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
 EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String id = request.getParameter("id");
        String questionsPaperId = request.getParameter("questions");
        String passingPercentage = request.getParameter("passingPercentage");
        String duration = request.getParameter("duration");
        String validityFrom = request.getParameter("validityFrom");
        String validityTo = request.getParameter("validityTo");
        String noOfAttampt = request.getParameter("noOfAttampt");
        String totalMarks = request.getParameter("totalMarks");
        String NoOfQue = request.getParameter("NoOfQue");
        String candidateJobApplicationId = request.getParameter("candidateJobApplicationId");
//        String[] checkId = request.getParameterValues("checkId");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        Integer hour = Integer.parseInt(duration) / 60;
        Integer minits = Integer.parseInt(duration) % 60;
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
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(questionsPaperId));
        try {
            if ("" == id) {

                OnlineAssessment onlineAssessment = new OnlineAssessment();
                onlineAssessment.setCreatedBy(user.getId());
                onlineAssessment.setCreatedDate(dtf.format(localDate));
                onlineAssessment.setDuration(strhout + ":" + strminits + ":00");
                onlineAssessment.setNoOfAttampt(Integer.parseInt(noOfAttampt));
                onlineAssessment.setQuestionPaper(questionPaper);
                onlineAssessment.setValidityFrom(validityFrom);
                onlineAssessment.setValidityTo(validityTo);
                double pp = Integer.parseInt(passingPercentage);
                onlineAssessment.setPassingPercentage(pp);
                onlineAssessment.setNoOfQue(Integer.parseInt(NoOfQue));
                double total = Integer.parseInt(totalMarks);
                onlineAssessment.setTotalMarks(total);
                CandidateJobApplication jobApplication = candidateJobApplicationService.readById(Integer.parseInt(candidateJobApplicationId));
                onlineAssessment.setCandidateJobApplication(jobApplication);
                jobApplication.setStatus(5);
                candidateJobApplicationService.update(jobApplication);
                onlineAssessmentService.create(onlineAssessment);
            } else {

                OnlineAssessment onlineAssessment = onlineAssessmentService.readById(Integer.parseInt(id));
                onlineAssessment.setUpdatedBy(user.getId());
                onlineAssessment.setUdatedDate(dtf.format(localDate));
                onlineAssessment.setDuration(duration);
                onlineAssessment.setNoOfAttampt(Integer.parseInt(noOfAttampt));
                onlineAssessment.setQuestionPaper(questionPaper);
                onlineAssessment.setValidityFrom(validityFrom);
                onlineAssessment.setValidityTo(validityTo);
                double pp = Integer.parseInt(passingPercentage);
                onlineAssessment.setPassingPercentage(pp);
                onlineAssessment.setNoOfQue(Integer.parseInt(NoOfQue));
                double total = Integer.parseInt(totalMarks);
                onlineAssessment.setTotalMarks(total);
                CandidateJobApplication jobApplication = candidateJobApplicationService.readById(Integer.parseInt(candidateJobApplicationId));
                jobApplication.setStatus(5);
                candidateJobApplicationService.update(jobApplication);
                onlineAssessment.setCandidateJobApplication(jobApplication);
                onlineAssessmentService.update(onlineAssessment);

            }

            CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(candidateJobApplicationId));
            CandidateApplyJob candidateApplyJob = candidateJobApplyService.readById(cja.getCandidateApplyJob().getId());
            OnlineAssessment onlineAssessment = new OnlineAssessment();
            questionList(request);
            
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setCreateDate(sdf.format(cDate));
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
            mprApprovalHistory.setStatus(5);
            mprApprovalHistory.setStatusMessage("Online Assessment");
            mprApprovalHistory.setMprMaster(cja.getVacancyMaster().getMprMaster());
            mprApprovalHistoryService.create(mprApprovalHistory);
            
            mv.getModelMap().put("onlineAssessment", onlineAssessment);
            request.setAttribute("candidateJobApplication", cja);
            mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
            mv.setViewName("Recruitment/CandidateApproval");
        } catch (Exception e) {
            request.setAttribute("failureMessage",
                    "All field are Required.Please Enter Valid data");

        }
        return mv;

    }

    public void getTotalMarksAndNoOfQue(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(id));
        List<?> list = questionDetailsService.getTotalMarksAndNoOfQueByQuePaperId(Integer.parseInt(id));
        Double val1 = 0.0;
        Long val2 = 0l;

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            val1 = (Double) row[1];
            val2 = (Long) row[0];
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("check", val1);
        jSONObject.put("val2", val2);
        PrintWriter out = response.getWriter();
        String json = jSONObject.toString();
        out.write(json);
        System.out.println("JSON " + json);
        out.close();

    }

    public ModelAndView goToAns(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String appliCationId = request.getParameter("id");
        String candidateId = request.getParameter("candidateId");
        CandidateApplyJob candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));
        List<?> OnList = onlineAssessmentService.getOnlineAssementCandidateList(Integer.parseInt(appliCationId));
        Double passingPercentage = 0.0;
        Double totalMarks = 0.0;

        if (!OnList.isEmpty()) {
            for (Object o2 : OnList) {
                Object str1[] = (Object[]) o2;
                passingPercentage = (Double) str1[3];
                totalMarks = (Double) str1[9];

            }
        }
        List<?> QuestionAnswerListIds = questionAnswerSubmitService.readByCandidateApplicationId(Integer.parseInt(appliCationId));
        List listOfFinalList = new ArrayList();
//        List<?> list1 = questionDetailsService.takeTestOnlineAssementCandidate(Integer.parseInt(id));
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
//        
        mv.getModelMap().put("list2", listOfFinalList);
        mv.getModelMap().put("candidateID", appliCationId);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/QuestionAnsCheck");
        return mv;
    }

    public ModelAndView submitResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String[] id = request.getParameterValues("id");

        String candidateiD = request.getParameter("candidateId");
        CandidateJobApplication candidateJobapplicationid = candidateJobApplicationService.readById(Integer.parseInt(candidateiD));
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
                QuestionAnswerSubmit questionAnswerSubmit = questionAnswerSubmitService.readById(Integer.parseInt(ids));
                String inputedMarks = null;
                int typeofQue = Integer.parseInt(tp);
                if (1 == typeofQue) {
                    inputedMarks = givenMarks2[i];
                    inputqSts = request.getParameter("mcqStatus" + (i + 1));
                    questionAnswerSubmit.setAnsStatus(Integer.parseInt(inputqSts));
                } else {
                    inputedMarks = givenMarks2[i];
                    mcqSts = request.getParameter("mcqStatus" + (i + 1));
                    questionAnswerSubmit.setAnsStatus(Integer.parseInt(mcqSts));
                }
//            String ans = doneId1[i];

                questionAnswerSubmit.setObtainMarks(Double.parseDouble(inputedMarks));

                questionAnswerSubmitService.update(questionAnswerSubmit);
//             mv.setViewName("Vacancy/AssementOnline");
            }
            CandidateResultStatus candidateResultStatus = new CandidateResultStatus();
            candidateResultStatus.setCandidateJobApplication(candidateJobapplicationid);
            candidateResultStatus.setObtainTotal(Double.parseDouble(totalResult));
            candidateResultStatus.setObtainsPercentage(Double.parseDouble(percentageResult));
            
            if ("" != passResult) {
                candidateResultStatus.setResultStatus(passResult);
            candidateResultStatusService.create(candidateResultStatus);
                candidateJobapplicationid.setStatus(6);   // 6 status Pass
                candidateJobApplicationService.update(candidateJobapplicationid);
            }
            if ("" != failResult) {
                candidateResultStatus.setResultStatus(failResult);
            candidateResultStatusService.create(candidateResultStatus);
                candidateJobapplicationid.setStatus(7);   // 7 status Fail
                candidateJobApplicationService.update(candidateJobapplicationid);
            }

            CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
            OnlineAssessment onlineAssessment = new OnlineAssessment();
//        List<?> candidateApplyJobList = candidateJobApplyService.fetchcandidatelist();
            List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

            mv.getModelMap().put("list", candidateJobList);
            questionList(request);
            mv.getModelMap().put("onlineAssessment", onlineAssessment);
            mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
            mv.setViewName("Recruitment/CandidateRequestList");

        } catch (Exception e) {
            request.setAttribute("failureMessage",
                    "All field are Required.Please Enter Valid data");

        }
        return mv;

    }

}
