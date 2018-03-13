/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.UserMaster;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(questionsPaperId));
        if ("" == id) {

            OnlineAssessment onlineAssessment = new OnlineAssessment();
            onlineAssessment.setCreatedBy(user.getId());
            onlineAssessment.setCreatedDate(dtf.format(localDate));
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
            onlineAssessment.setCandidateJobApplication(jobApplication);
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
            onlineAssessment.setCandidateJobApplication(jobApplication);
            onlineAssessmentService.update(onlineAssessment);

        }

        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(candidateJobApplicationId));
        CandidateApplyJob candidateApplyJob = candidateJobApplyService.readById(cja.getCandidateApplyJob().getId());
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        request.setAttribute("candidateJobApplication", cja);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateApproval");
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

}
