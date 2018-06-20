/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.url;

import com.bul.zydex.model.UrlMaster;
import com.bul.zydex.validator.UrlMasterValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class UrlMasterController extends UrlMasterAbstract {

    public ModelAndView viewUrlResult(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        List<?> urlList = urlMasterService.read();
        mv.getModelMap().put("list", urlList);
        mv.setViewName("Url/UrlResult");
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        UrlMaster urlMaster = new UrlMaster();
        String id = request.getParameter("id");
        urlMaster = urlMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("urlMaster", urlMaster);
        mv.setViewName("Url/editUrl");
        return mv;

    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        UrlMaster urlMaster = new UrlMaster();
        mv.getModelMap().put("urlMaster", urlMaster);
        mv.setViewName("Url/UrlCreate");
        return mv;

    }

    public ModelAndView submitClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UrlMaster urlMaster = new UrlMaster();
        BindException errors = new BindException(urlMaster, "urlMaster");
        bind(request, urlMaster);
        urlMasterValidator.validate(urlMaster, errors);
        if (errors.hasErrors()) {
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Url/UrlCreate");
        } else {
            urlMasterService.create(urlMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = viewUrlResult(request, response);
        }
        return mv;

    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] ids = request.getParameterValues("checkId");
        for (String id : ids) {
            urlMasterService.delete(Integer.parseInt(id));
        }
        request.setAttribute("successMessage",
                "Info : Rrecord Deleted successfully.");
        mv.setViewName("forward:urlMaster.htm?act=viewUrlResult");
        return mv;

    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UrlMaster urlMaster = new UrlMaster();
        BindException errors = new BindException(urlMaster, "urlMaster");
        bind(request, urlMaster);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            request.setAttribute("urlMaster", urlMaster);
            mv = viewClick(request, response);
        } else {
            urlMasterService.update(urlMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv.setViewName("forward:urlMaster.htm?act=viewUrlResult");

        }
        return mv;
    }

}
