/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.questionlibrary;

import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionLibrary;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishi
 */
public class QuestionLibraryController extends QuestionLibraryAbstract {

    public ModelAndView QuestionLibraryCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("QuestionLibrary/QuestionLibraryCreate");
        return mv;
    }

    public ModelAndView QuestionLibrarynewRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        QuestionLibrary questionLibrary = new QuestionLibrary();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        if (questionLibrary.getId() != null) {
            questionLibrary.setMprEmployeeCategory(questionLibrary.getMprEmployeeCategory());
        } else {
            questionLibrary.setMprEmployeeCategory(new MprEmployeeCategory());
        }
        employeecategoryList(request);
        mv.getModelMap().put("mprEmployeeCategory", mprEmployeeCategory);
        mv.getModelMap().put("questionLibrary", questionLibrary);
        mv.setViewName("QuestionLibrary/QuestionLibrarynewRecord");
        return mv;
    }

    public ModelAndView submitQuestionLibrarynewRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        QuestionLibrary questionLibrary = new QuestionLibrary();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        mprEmployeeCategory.setId(Integer.parseInt(request.getParameter("mprEmployeeCategory")));
        questionLibrary.setQuestion(request.getParameter("question"));
       String selected=request.getParameter("correctans");
       int radiocount =Integer.parseInt(selected.substring(1));
        int otherDetailCount = 0;
        String correctans=null;
        try {
            int asd = Integer.parseInt(request.getParameter("type"));
            questionLibrary.setType(asd);
            questionLibrary.setMarks(Integer.parseInt(request.getParameter("marks")));
            questionLibrary.setSatatus(Integer.parseInt(request.getParameter("status")));
            questionLibrary.setMprEmployeeCategory(mprEmployeeCategory);
            otherDetailCount = Integer.parseInt(request.getParameter("questionCount"));
        } catch (Exception e) {
        }
        questionLibraryService.create(questionLibrary);
        for (int i = 1; i <= otherDetailCount; i++) {
            QuestionAns questionAns = new QuestionAns();
            if (null != request.getParameter("ans" + i)) {
                if (!request.getParameter("ans" + i).equals("")) {
                    String ans = request.getParameter("ans" + i);
                    questionAns.setAns(ans);
                    questionAns.setQuestionLibrary(questionLibrary);
                    questionAnsService.create(questionAns);
                    if(i==radiocount){
                    questionLibrary.setAnsId(questionAns.getId());
                    }
                }
            }
        }
        questionLibraryService.update(questionLibrary);
        mv=QuestionLibraryCreate(request, response);
        return mv;

    }
}
