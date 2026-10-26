/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Apprentices;

import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class ApprenticesController extends ApprenticesAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
        List list = apprenticesService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("apprenticesMaster", apprenticesMaster);
        mv.setViewName("Apprentices/ApprenticesList");
        return mv;
    }

    public ModelAndView createApprenticesMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
        mv.getModelMap().put("apprenticesMaster", apprenticesMaster);
        mv.setViewName("Apprentices/ApprenticesCreate");
        return mv;
    }

    public ModelAndView submitApprenticesMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
        bind(request, apprenticesMaster);
        Boolean rfId = apprenticesService.readByApprenticesCode(apprenticesMaster.getApprenticeCode());
        if (!rfId) {
            apprenticesMaster.setRfId("" + (apprenticesMaster.getApprenticeCode().length() == 4 ? "0020" + apprenticesMaster.getApprenticeCode().substring(3) : apprenticesMaster.getApprenticeCode().length() == 3 ? "00200" + apprenticesMaster.getApprenticeCode().substring(3) : apprenticesMaster.getApprenticeCode().length() == 2 ? "002000" + apprenticesMaster.getApprenticeCode().substring(3) : "0020000" + apprenticesMaster.getApprenticeCode().substring(3))).setdRow("N").setDuration("0").setRightName("Apprentice");
            apprenticesService.create(apprenticesMaster);
            UserMaster um = new UserMaster();
         //   um.setLoginName(apprenticesMaster.getApprenticeCode()).setPassword(encription(apprenticesMaster.getApprenticeCode())).setUserFullName(apprenticesMaster.getName()).setRights(apprenticesMaster.getRightName()).setDepartment(apprenticesMaster.getDepartment()).setDesignation(" ").setEmailId(" ").setdRow("N");
         //   userMasterService.create(um);
            request.setAttribute("successMessage",
                    "Information: Apprentices Created successfully");
        } else {
            request.setAttribute("failureMessage",
                    "Information: Apprentices code duplicated found.");
            request.setAttribute("apprenticesMaster", apprenticesMaster);
            mv.setViewName("Apprentices/ApprenticesCreate");
        }
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView editApprenticesMasterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
        bind(request, apprenticesMaster);
        apprenticesService.update(apprenticesMaster);
        UserMaster um = userMasterService.read(apprenticesMaster.getApprenticeCode());
    //    um.setUserFullName(apprenticesMaster.getName()).setRights(apprenticesMaster.getRightName()).setDepartment(apprenticesMaster.getDepartment());
    //    userMasterService.update(um);
        request.setAttribute("successMessage",
                "Information: Apprentices Updated successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String apprenticeCode = request.getParameter("id");
        ApprenticesMaster apprenticesMaster = apprenticesService.read(apprenticeCode);
        mv.getModelMap().put("apprenticesMaster", apprenticesMaster);
        mv.setViewName("Apprentices/ApprenticesEdit");
        return mv;
    }

    public ModelAndView deleteApprenticesMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            apprenticesService.deleteByApprenticeCode(checkedValues);
            userMasterService.deleteByLoginName(checkedValues);
        }
        request.setAttribute("successMessage",
                "Information: One or more Apprentices deleted successfully");
        mv = showList(request, response);
        return mv;
    }

}
