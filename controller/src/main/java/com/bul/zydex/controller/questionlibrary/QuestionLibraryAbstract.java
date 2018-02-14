/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.controller.questionlibrary;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.service.questionlibrary.QuestionAnsService;
import com.bul.zydex.service.questionlibrary.QuestionLibraryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rishi
 */
public abstract class QuestionLibraryAbstract extends CustomAbstract{
    
    protected QuestionLibraryService<QuestionLibrary> questionLibraryService;
    protected QuestionAnsService<QuestionAns> questionAnsService;

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
//    protected void employeecategoryList(HttpServletRequest request) {
//        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
//        List<?> categoryList = mprEmployeeCategoryService.read();
//        Map<Integer, String> en = new HashMap<>();
//        for (Object o : categoryList) {
//            mprEmployeeCategory = (MprEmployeeCategory) o;
//            en.put(mprEmployeeCategory.getId(), mprEmployeeCategory.getEmployeeCategory());
//        }
//
//        request.setAttribute("categoryList", en);
//    }
}
