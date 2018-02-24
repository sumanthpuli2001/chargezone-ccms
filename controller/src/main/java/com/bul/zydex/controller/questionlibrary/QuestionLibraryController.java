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
import com.bul.zydex.model.QuestionPaper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishi
 */
public class QuestionLibraryController extends QuestionLibraryAbstract {

    public ModelAndView QuestionLibraryCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> QueLbryList = questionLibraryService.readAllQuestionLibrary();
        mv.getModelMap().put("list", QueLbryList);
        mv.setViewName("QuestionLibrary/QuestionLibraryCreate");
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
        mprEmployeeCategory.setId(Integer.parseInt(request.getParameter("mprEmployeeCategory.id")));
        questionLibrary.setQuestion(request.getParameter("question"));
        String selected = request.getParameter("correctans");
        String id = request.getParameter("id");

        int radiocount = 0;
        int asd = Integer.parseInt(request.getParameter("type"));

        if ("" == id) {

            if (0 == asd) {

                radiocount = Integer.parseInt(selected);
//                radiocount = Integer.parseInt(selected.substring(1));
            }
            int otherDetailCount = 0;
            String correctans = null;
            try {

                questionLibrary.setType(asd);
                questionLibrary.setMarks(Integer.parseInt(request.getParameter("marks")));
                questionLibrary.setSatatus(Integer.parseInt(request.getParameter("satatus")));
                questionLibrary.setMprEmployeeCategory(mprEmployeeCategory);
                otherDetailCount = 6;
//                otherDetailCount = Integer.parseInt(request.getParameter("questionCount"));
            } catch (Exception e) {
            }
            questionLibraryService.create(questionLibrary);
            if (0 == asd) {
                for (int i = 1; i <= otherDetailCount; i++) {
                    QuestionAns questionAns = new QuestionAns();
                    if (null != request.getParameter("ans" + i)) {
                        if (!request.getParameter("ans" + i).equals("")) {
                            String ans = request.getParameter("ans" + i);
                            questionAns.setAns(ans);
                            questionAns.setQuestionLibrary(questionLibrary);
                            questionAnsService.create(questionAns);
                            if (i == radiocount) {
                                questionLibrary.setAnsId(questionAns.getId());
                            }
                        }
                    }
                }
            }
            questionLibraryService.update(questionLibrary);
        } else {
            int qlId = Integer.parseInt(id);
            questionLibrary = questionLibraryService.readById(qlId);

//            if (0 == asd) {
//
//                radiocount = Integer.parseInt(selected.substring(1));
            radiocount = Integer.parseInt(selected);
//            }
            int otherDetailCount = 0;
            String correctans = null;
            try {

                questionLibrary.setType(asd);
                questionLibrary.setMarks(Integer.parseInt(request.getParameter("marks")));
                questionLibrary.setSatatus(Integer.parseInt(request.getParameter("satatus")));
                questionLibrary.setMprEmployeeCategory(mprEmployeeCategory);
                otherDetailCount = Integer.parseInt(request.getParameter("questionCount"));
            } catch (Exception e) {
            }
            questionLibraryService.update(questionLibrary);
            List<QuestionAns> anses = (List<QuestionAns>) questionAnsService.readByQLId(qlId);
            for (QuestionAns ans : anses) {

                questionAnsService.delete(ans.getId());
            }
            if (0 == asd) {
                for (int i = 1; i <= otherDetailCount; i++) {
                    QuestionAns questionAns = new QuestionAns();
                    if (null != request.getParameter("ans" + i)) {
                        if (!request.getParameter("ans" + i).equals("")) {
                            String ans = request.getParameter("ans" + i);
                            questionAns.setAns(ans);
                            questionAns.setQuestionLibrary(questionLibrary);
                            questionAnsService.create(questionAns);
                            if (i == radiocount) {
                                questionLibrary.setAnsId(questionAns.getId());
                            }
                        }
                    }
                }
                List<QuestionAns> qaList = (List<QuestionAns>) questionAnsService.readByQLId(qlId);
                Set<?> foo = new HashSet<>(qaList);
                questionLibrary.setQuestionAnses(foo);

            }
            questionLibraryService.update(questionLibrary);

        }

        mv = QuestionLibraryCreate(request, response);
        return mv;

    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        QuestionLibrary questionLibrary = new QuestionLibrary();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        String id = request.getParameter("id");
        String mprId = request.getParameter("eprId");
        employeecategoryList(request);
        mprEmployeeCategory = mprEmployeeCategoryService.readById(Integer.parseInt(mprId));
        List<?> qaList = questionAnsService.readByQLId(Integer.parseInt(id));
        Set<?> foo = new HashSet<>(qaList);
        questionLibrary = questionLibraryService.readById(Integer.parseInt(id));
        questionLibrary.setQuestionAnses(foo);
        questionLibrary.setMprEmployeeCategory(mprEmployeeCategory);
        request.setAttribute("questionAns", qaList);
        mv.getModelMap().put("questionLibrary", questionLibrary);
        mv.setViewName("QuestionLibrary/QuestionLibrarynewRecord");
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String mprId = request.getParameter("eprId");
        employeecategoryList(request);
        List<QuestionAns> qaList = (List<QuestionAns>) questionAnsService.readByQLId(Integer.parseInt(id));
        for (QuestionAns ans : qaList) {

            questionAnsService.delete(ans.getId());
        }
        questionLibraryService.delete(Integer.parseInt(id));
        List<?> QueLbryList = questionLibraryService.readAllQuestionLibrary();
        mv.getModelMap().put("list", QueLbryList);
        mv.setViewName("QuestionLibrary/QuestionLibraryCreate");
        return mv;
    }

    public ModelAndView questionPaperView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> QuePaperList = questionPaperService.readAllQuestionPaper();
        mv.getModelMap().put("list", QuePaperList);
        mv.setViewName("QuestionPaper/QuestionPaperList");
        return mv;
    }

    public ModelAndView createQuestionPaper(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        employeecategoryList(request);
        QuestionPaper questionPaper = new QuestionPaper();
         bind(request, questionPaper);
        request.setAttribute("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaper");
        return mv;
    }
}
