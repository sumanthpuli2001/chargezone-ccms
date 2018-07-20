/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.KraCategory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BlackBull
 */
public class KraCategoryController extends KraCategoryAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KraCategory kraCategory = new KraCategory();
        List catList = kraCategoryService.read();
        mv.getModelMap().put("catList", catList);
        mv.getModelMap().put("kraCategory", kraCategory);
        mv.setViewName("Appraisal/KraCategory");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KraCategory kraCategory = new KraCategory();
        bind(request, kraCategory);
        if (null != kraCategory.getId()) {
            KraCategory kraCategory1 = kraCategoryService.readById(kraCategory.getId());
            kraCategoryService.update(kraCategory);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = createClick(request, response);
        } else {
            kraCategoryService.create(kraCategory);
            request.setAttribute("successMessage",
                    "Information : The Information is Created Successfully.");
            mv = createClick(request, response);
        }

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KraCategory kraCategory = new KraCategory();
        String id = request.getParameter("id");
        kraCategory = kraCategoryService.readById(Integer.parseInt(id));
        mv.getModelMap().put("kraCategory", kraCategory);
        mv.setViewName("Appraisal/KraCategoryEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        KraCategory kraCategory = new KraCategory();
        bind(request, kraCategory);
        kraCategoryService.update(kraCategory);

        mv.setViewName("Appraisal/KraCategory");
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("Appraisal/KraCategory");
        return mv;
    }

    public ModelAndView deletekraCategory(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        KraCategory kraCategory = new KraCategory();
//        String[] empId = request.getParameterValues("checkId");
//        for (String z : empId) {
//            try {
//
//                kraCategoryService.delete(Integer.parseInt(z));
//                request.setAttribute("successMessage",
//                        "Info :  Records Deleted Successfully.");
//            } catch (Exception e) {
//
//            }
//        }
        String id = request.getParameter("id");
        kraCategory = kraCategoryService.readById(Integer.parseInt(id));
        kraCategoryService.delete(kraCategory.getId());
        mv = createClick(request, response);
        return mv;
    }
}
