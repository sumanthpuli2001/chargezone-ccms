/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.questionlibrary;

import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.questionlibrary.QuestionDetailsService;
import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
//                List<QuestionAns> qaList = (List<QuestionAns>) questionAnsService.readByQLId(qlId);
//                Set<?> foo = new HashSet<>(qaList);
//                questionLibrary.setQuestionAnses(foo);

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
//        Set<?> foo = new HashSet<>(qaList);
        questionLibrary = questionLibraryService.readById(Integer.parseInt(id));
//        questionLibrary.setQuestionAnses(foo);
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
        String id = request.getParameter("id");
        QuestionPaper questionPaper = new QuestionPaper();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        if (null == id) {
            questionPaper.setCategoryName(mprEmployeeCategory);
            bind(request, questionPaper);
        } else {
            questionPaper = questionPaperService.readById(Integer.parseInt(id));
            mprEmployeeCategory = mprEmployeeCategoryService.readById(questionPaper.getCategoryName().getId());
            questionPaper.setCategoryName(mprEmployeeCategory);
        }

        request.setAttribute("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaper");
        return mv;
    }

    public ModelAndView submitQuestionPaperStep1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        QuestionPaper questionPaper = new QuestionPaper();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        String id = request.getParameter("id");
        String categoryName = request.getParameter("categoryName.id");
        String paperName = request.getParameter("paperName");
        employeecategoryList(request);
        int total =0;
        MprEmployeeCategory mprEmployeeCategory = mprEmployeeCategoryService.readById(Integer.parseInt(categoryName));
        if ("" == id) {

            questionPaper.setCategoryName(mprEmployeeCategory);
            questionPaper.setPaperName(paperName);
            questionPaper.setCreatedBy(user.getId());
            questionPaper.setCreatedDate(dtf.format(localDate));

            questionPaperService.create(questionPaper);

        } else {
            int newId = Integer.parseInt(id);
            questionPaper = questionPaperService.readById(newId);
            questionPaper.setCategoryName(mprEmployeeCategory);
            questionPaper.setPaperName(paperName);
            questionPaper.setUpdatedBy(user.getId());
            questionPaper.setUpdatedDate(dtf.format(localDate));
            questionPaperService.update(questionPaper);
        }

//        request.setAttribute("questionAns", qaList);
        List<?> questionDetailses = questionDetailsService.readByQuePaperId(Integer.parseInt(id));
        for (int i = 0; i < questionDetailses.size(); i++) {
            Object[] row = (Object[]) questionDetailses.get(i);
            int sum = (int) row[2];
            total = total + sum;
        }
        request.setAttribute("total", total);

        request.setAttribute("questionDetailses", questionDetailses);
        mv.getModelMap().put("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaperStep2");
        return mv;
    }

    public ModelAndView searchQuestionLibraryRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String question = request.getParameter("question");
        String id = request.getParameter("id");
        String marks = request.getParameter("marks");
        String categoryName = request.getParameter("categoryName.employeeCategory");
        int mark = 0;
        int ctg = 0;
        int total = 0;
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(id));
        MprEmployeeCategory mprEmployeeCategory = mprEmployeeCategoryService.readById(questionPaper.getCategoryName().getId());
        questionPaper.setCategoryName(mprEmployeeCategory);
        if (marks.equals("")) {
            mark = 0;
        } else {
            mark = Integer.parseInt(marks);
        }
        if (categoryName.equals("")) {
            ctg = 0;
        } else {
            List<?> mprlist = mprEmployeeCategoryService.getByName(categoryName);
            for (Object list : mprlist) {
                ctg = (int) list;
            }
        }
        List<QuestionLibrary> list = (List<QuestionLibrary>) questionLibraryService.readByQusNameCatyMark(ctg, question, mark);
        List<?> questionDetailses = questionDetailsService.readByQuePaperId(Integer.parseInt(id));
        for (int i = 0; i < questionDetailses.size(); i++) {
            Object[] row = (Object[]) questionDetailses.get(i);
            int sum = (int) row[2];
            total = total + sum;
        }
        request.setAttribute("total", total);
        request.setAttribute("list", list);

        request.setAttribute("questionDetailses", questionDetailses);
        mv.getModelMap().put("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaperStep2");
        return mv;
    }

    public ModelAndView addQuePaperData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        QuestionDetails questionDetails = new QuestionDetails();

        String QPid = request.getParameter("id");
        String[] checkId = request.getParameterValues("checkId");
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(QPid));
        int total = 0;
        for (String z : checkId) {
            try {

                QuestionLibrary questionLibrary = questionLibraryService.readById(Integer.parseInt(z));

                Boolean flag = questionDetailsService.isExistQuestion(Integer.parseInt(z), Integer.parseInt(QPid));
                if (!flag) {

                    questionDetails.setQuestionLibrary(questionLibrary);
                    questionDetails.setQuestionPaper(questionPaper);
                    questionDetailsService.create(questionDetails);
                }
                request.setAttribute("successMessage",
                        "Info : One or more records are add successfully.");
            } catch (Exception e) {
            }
        }
        List<?> questionDetailses = questionDetailsService.readByQuePaperId(Integer.parseInt(QPid));
        for (int i = 0; i < questionDetailses.size(); i++) {
            Object[] row = (Object[]) questionDetailses.get(i);
            int mark = (int) row[2];
            total = total + mark;
        }
        double totalMarks = total;
        MprEmployeeCategory mprEmployeeCategory = mprEmployeeCategoryService.readById(questionPaper.getCategoryName().getId());
        questionPaper.setCategoryName(mprEmployeeCategory);
        questionPaper.setTotalMarks(totalMarks);
        questionPaperService.update(questionPaper);
        request.setAttribute("total", total);
        request.setAttribute("questionDetailses", questionDetailses);
        mv.getModelMap().put("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaperStep2");
        return mv;
    }

    public ModelAndView deleteQuesClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        String queId = request.getParameter("queId");
        String[] queId = request.getParameterValues("queId");
//        String QpId = request.getParameter("QpId");
        int total = 0;
        QuestionDetails questionDetails = questionDetailsService.readById(Integer.parseInt(queId[0]));
        int QpId = questionDetails.getQuestionPaper().getId();
        for (String z : queId) {
            try {
                questionDetailsService.delete(Integer.parseInt(z));

                request.setAttribute("successMessage",
                        "Info : Records are deleted successfully.");
            } catch (Exception e) {
            }
        }

        QuestionPaper questionPaper = questionPaperService.readById(QpId);
        List<?> questionDetailses = questionDetailsService.readByQuePaperId(QpId);
        MprEmployeeCategory mprEmployeeCategory = mprEmployeeCategoryService.readById(questionPaper.getCategoryName().getId());
        questionPaper.setCategoryName(mprEmployeeCategory);
        for (int i = 0; i < questionDetailses.size(); i++) {
            Object[] row = (Object[]) questionDetailses.get(i);
            int mark = (int) row[2];
            total = total + mark;
        }
        double totalMarks = total;
        questionPaper.setTotalMarks(totalMarks);
        questionPaperService.update(questionPaper);
        request.setAttribute("total", total);
        request.setAttribute("questionDetailses", questionDetailses);
        mv.getModelMap().put("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaperStep2");
        return mv;
    }

    public ModelAndView SubmitStep2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        int total = 0;
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(id));
        MprEmployeeCategory mprEmployeeCategory = mprEmployeeCategoryService.readById(questionPaper.getCategoryName().getId());
        questionPaper.setCategoryName(mprEmployeeCategory);
        List<?> questionDetailses = questionDetailsService.readByQuePaperId(Integer.parseInt(id));
        for (int i = 0; i < questionDetailses.size(); i++) {
            Object[] row = (Object[]) questionDetailses.get(i);
            int mark = (int) row[2];
            total = total + mark;
        }
        request.setAttribute("total", total);
        request.setAttribute("questionDetailses", questionDetailses);
        mv.getModelMap().put("questionPaper", questionPaper);
        mv.setViewName("QuestionPaper/CreateQuestionPaperStep3");
        return mv;
    }

    public ModelAndView finishQuestionPaper(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String status = request.getParameter("status");
        QuestionPaper questionPaper = questionPaperService.readById(Integer.parseInt(id));
        questionPaper.setStatus(Integer.parseInt(status));
        questionPaperService.update(questionPaper);
        List<?> QuePaperList = questionPaperService.readAllQuestionPaper();
        mv.getModelMap().put("list", QuePaperList);
        mv.setViewName("QuestionPaper/QuestionPaperList");
        return mv;
    }

    public ModelAndView deleteQuesPaperClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String z : checkId) {
            try {
                List<?> qaList = questionDetailsService.readByQuePaperId(Integer.parseInt(z));
                if (!qaList.isEmpty()) {

                    for (int i = 0; i < qaList.size(); i++) {
                        Object[] row = (Object[]) qaList.get(i);
                        int qd = (int) row[0];
                        questionDetailsService.delete(qd);
                    }
                }
                questionPaperService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are add successfully.");
            } catch (Exception e) {
            }
        }
        List<?> QuePaperList = questionPaperService.readAllQuestionPaper();
        mv.getModelMap().put("list", QuePaperList);
        mv.setViewName("QuestionPaper/QuestionPaperList");
        return mv;

    }
}
