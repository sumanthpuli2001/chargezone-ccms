/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.CurrencyMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class CurrencyMasterController extends CurrencyMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CurrencyMaster currencyMaster = new CurrencyMaster();

        mv.getModelMap().put("currencyMaster", currencyMaster);
        mv.setViewName("Travel/CurrencyCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CurrencyMaster currencyMaster = new CurrencyMaster();
        BindException errors = new BindException(currencyMaster, "currencyMaster");
        bind(request, currencyMaster);
        currencyMasterValidator.validate(currencyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("currencyMaster", currencyMaster);
            mv.setViewName("Travel/CurrencyCreate");

        } else {
            currencyMasterService.create(currencyMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = searchSubmit(request, response);

        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CurrencyMaster currencyMaster = new CurrencyMaster();

        List<?> list = currencyMasterService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("currencyMaster", currencyMaster);
        mv.setViewName("Travel/CurrencyResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CurrencyMaster currencyMaster = new CurrencyMaster();
        String id = request.getParameter("id");
        currencyMaster = currencyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("currencyMaster", currencyMaster);
        mv.setViewName("Travel/CurrerncyEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CurrencyMaster currencyMaster = new CurrencyMaster();
        BindException errors = new BindException(currencyMaster, "currencyMaster");
        bind(request, currencyMaster);
        currencyMasterValidator.validate(currencyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("currencyMaster", currencyMaster);
            mv.setViewName("Travel/CurrerncyEdit");

        } else {
            currencyMasterService.update(currencyMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);

        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String currencyId[] = request.getParameterValues("checkId");
        for (String z : currencyId) {
            try {
                currencyMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

}
