/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.controller.questionlibrary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rishi
 */
public class QuestionLibraryController extends QuestionLibraryAbstract{

    public ModelAndView QuestionLibraryCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("QuestionLibrary/QuestionLibraryCreate");
        return mv;
    }
    public ModelAndView QuestionLibrarynewRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("QuestionLibrary/QuestionLibrarynewRecord");
        return mv;
    }
}
