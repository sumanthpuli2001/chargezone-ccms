/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.UserMaster;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(questionsPaperId));
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

        return mv;

    }

}
