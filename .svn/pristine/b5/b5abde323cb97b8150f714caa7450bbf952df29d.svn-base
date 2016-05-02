/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.PolicyDeviationForAir;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class PolicyDeviationForAirController extends PolicyDeviationForAirAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyDeviationForAir policyDeviationForAir = new PolicyDeviationForAir();
        levelList(request);

        mv.getModelMap().put("policyDeviationForAir", policyDeviationForAir);
        mv.setViewName("Travel/PolicyDeviationForAirCreate");
        return mv;

    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyDeviationForAir policyDeviationForAir = new PolicyDeviationForAir();
        LevelMaster levelMaster = new LevelMaster();
        BindException errors = new BindException(policyDeviationForAir, "policyDeviationForAir");
        bind(request, policyDeviationForAir);
        String levelMasterId = request.getParameter("levelMaster");
        levelMaster.setId(Integer.parseInt(levelMasterId));
        policyDeviationForAir.setLevelMaster(levelMaster);
        levelList(request);
        policyDeviationForAirValidator.validate(policyDeviationForAir, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("policyDeviationForAir", policyDeviationForAir);
            mv.setViewName("Travel/PolicyDeviationForAirCreate");

        } else {
            policyDeviationForAirService.create(policyDeviationForAir);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv = searchSubmit(request, response);
        }

        return mv;

    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyDeviationForAir policyDeviationForAir = new PolicyDeviationForAir();
        List<?> list = policyDeviationForAirService.readDetail(policyDeviationForAir);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("policyDeviationForAir", policyDeviationForAir);
        mv.setViewName("Travel/PolicyDeviationForAirResult");
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyDeviationForAir policyDeviationForAir = new PolicyDeviationForAir();
        String id = request.getParameter("id");
        levelList(request);
        policyDeviationForAir = policyDeviationForAirService.readById(Integer.parseInt(id));

        mv.getModelMap().put("policyDeviationForAir", policyDeviationForAir);
        mv.setViewName("Travel/PolicyDeviationForAirView");
        return mv;

    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyDeviationForAir policyDeviationForAir = new PolicyDeviationForAir();
        LevelMaster levelMaster = new LevelMaster();
        BindException errors = new BindException(policyDeviationForAir, "policyDeviationForAir");
        bind(request, policyDeviationForAir);
        String levelMasterId = request.getParameter("levelMaster.id");
        levelMaster.setId(Integer.parseInt(levelMasterId));
        policyDeviationForAir.setLevelMaster(levelMaster);
        levelList(request);
        policyDeviationForAirValidator.validate(policyDeviationForAir, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("policyDeviationForAir", policyDeviationForAir);
            mv.setViewName("Travel/PolicyDeviationForAirView");

        } else {
            policyDeviationForAirService.update(policyDeviationForAir);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");

            mv = searchSubmit(request, response);
        }

        return mv;

    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String hoursId[] = request.getParameterValues("checkId");
        for (String z : hoursId) {
            try {
                policyDeviationForAirService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);

        return mv;

    }

    public void ajaxCall(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String selectedValue = request.getParameter("selectedvalue");
        String levelId = request.getParameter("levelId");
        List<?> list = policyDeviationForAirService.readlevelWise(levelId);
        String dataByPrNo = "";
        String deviation = "";
        if (!list.isEmpty()) {
            list.get(0);
            deviation = "" + list.get(0);
        }
        if (deviation.equals("No")) {
            dataByPrNo = "Yes";
        } else {
            dataByPrNo = "No";
        }
//        request.setAttribute("selectedValue", selectedValue);
        PrintWriter out = response.getWriter();
        out.print(dataByPrNo);
//        return mv;
    }

}
