/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ClassifiedBox;

import com.bul.zydex.model.ClassifiedBox;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.UserMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hussain
 */
public class ClassifiedBoxController extends ClassifiedBoxAbstract {

    public ModelAndView showResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClassifiedBox classifiedBox = new ClassifiedBox();
//        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> ptList = classifiedBoxService.read();
        for (Object obj : ptList) {
            classifiedBox = (ClassifiedBox) obj;
//            zydexLocationMaster = zydexLocationMasterService.readById(payrollProfessionalTax.getZydexLocationMaster().getId());
//            payrollProfessionalTax.setZydexLocationMaster(zydexLocationMaster);
        }
        request.setAttribute("ptList", ptList);
        mv.setViewName("ClassifiedBox/ClassifiedBoxShow");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClassifiedBox classifiedBox = new ClassifiedBox();
        mv.getModelMap().put("classifiedBox",
                classifiedBox);
        mv.setViewName("ClassifiedBox/ClassifiedBoxCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClassifiedBox classifiedBox = new ClassifiedBox();

        BindException errors = new BindException(classifiedBox, "classifiedBox");
        bind(request, classifiedBox);
        classifiedBoxValidator.validate(classifiedBox, errors);

        if (errors.hasErrors()) {
            request.setAttribute("faliureMessage",
                    "Error : The ClassifiedBox is not valid.");

            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("classifiedBox", classifiedBox);
            mv.setViewName("ClassifiedBox/ClassifiedBoxCreate");
//            mv.addAllObjects(errors.getModel());
        } else {
            HttpSession session = request.getSession();
            UserMaster userMaster = new UserMaster();
            UserMaster user = (UserMaster) session.getAttribute("user");
            Integer user1 = user.getId();
            classifiedBox.setCreateBy(user.getId());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            classifiedBox.setCreateDate(sdf.format(cDate));
            classifiedBox.setStatus(0);
            classifiedBoxService.create(classifiedBox);

            request.setAttribute("successMessage",
                    "Information: The ClassifiedBox is Created successfully");
            mv.getModelMap().put("classifiedBox", classifiedBox);
            mv.setViewName("ClassifiedBox/ClassifiedBoxCreate");
        }

//        
//       
//        mv = showResult(request, response);
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ptId[] = request.getParameterValues("checkId");
        for (String z : ptId) {
            try {
                classifiedBoxService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
            }
        }
        mv = showResult(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClassifiedBox classifiedBox = new ClassifiedBox();
        String id = request.getParameter("id");
        zydexLocationList(request);
        classifiedBox = classifiedBoxService.readById(Integer.parseInt(id));
//        zydexLocationMaster = zydexLocationMasterService.readById(payrollProfessionalTax.getZydexLocationMaster().getId());
//        payrollProfessionalTax.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("classifiedBox", classifiedBox);
        mv.setViewName("ClassifiedBox/ClassifiedBoxView");

        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClassifiedBox classifiedBox = new ClassifiedBox();

        BindException errors = new BindException(classifiedBox, "classifiedBox");
        bind(request, classifiedBox);
        classifiedBoxValidator.validate(classifiedBox, errors);
        zydexLocationList(request);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The classifiedBox is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("classifiedBox", classifiedBox);
            mv.setViewName("ClassifiedBox/ClassifiedBoxView");
        } else {
            HttpSession session = request.getSession();
            UserMaster userMaster = new UserMaster();
            UserMaster user = (UserMaster) session.getAttribute("user");
            Integer user1 = user.getId();
            classifiedBox.setUpdateBy(user.getId());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            classifiedBox.setUpdateDate(sdf.format(cDate));
            classifiedBox.setStatus(0);
            classifiedBoxService.update(classifiedBox);

            request.setAttribute("successMessage",
                    "Information: The classifiedBox is Updated successfully");
            mv.getModelMap().put("classifiedBox", classifiedBox);
            mv.setViewName("ClassifiedBox/ClassifiedBoxView");
        }

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClassifiedBox classifiedBox = new ClassifiedBox();
//     
        List<?> list = classifiedBoxService.read();
        mv.getModelMap().put("list", list);
//        mv.getModelMap().put("classifiedBox", classifiedBox);
        mv.setViewName("ClassifiedBox/ClassifiedBoxShowHome");
        return mv;
    }

}
