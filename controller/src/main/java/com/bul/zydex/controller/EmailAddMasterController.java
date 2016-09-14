/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailAddMasterController extends EmailAddMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailAddMaster emailAddMaster = new EmailAddMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        departmentList(request);
        emailAddMaster.setDepartmentMaster(departmentMaster);
        mv.getModelMap().put("emailAddMaster", emailAddMaster);
        mv.setViewName("EmailTemplate/EmailAddCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmailAddMaster emailAddMaster = new EmailAddMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        emailAddMaster.setDepartmentMaster(departmentMaster);
        bind(request, emailAddMaster);
        String[] email = request.getParameterValues("emailId");
        String emailId = "";
        for (String email1 : email) {
            emailId += email1 + ",";
        }
        emailAddMaster.setEmailId(emailId);
        emailAddMasterService.create(emailAddMaster);
        request.setAttribute("successMessage",
                "Information : The Information is saved Successfully.");
        mv.setViewName("redirect:emailAddMaster.htm?act=searchSubmit");

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> emailaddList = emailAddMasterService.read();
        EmailAddMaster emailAddMaster = new EmailAddMaster();
        for (Object obj : emailaddList) {
            emailAddMaster = (EmailAddMaster) obj;
            DepartmentMaster departmentMaster = new DepartmentMaster();
            departmentMaster = departmentMasterService.readById(emailAddMaster.getDepartmentMaster().getId());
            emailAddMaster.setDepartmentMaster(departmentMaster);

        }
        departmentList(request);
        mv.getModelMap().put("list", emailaddList);
        mv.getModelMap().put("emailAddMaster", emailAddMaster);
        mv.setViewName("EmailTemplate/EmailAddResult");

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailAddMaster emailAddMaster = new EmailAddMaster();
        String id = request.getParameter("id");
        departmentList(request);
        emailAddMaster = emailAddMasterService.readById(Integer.parseInt(id));

        List list = new ArrayList();
        String emailId = emailAddMaster.getEmailId();
        for (String emailId1 : emailId.split(",")) {
            list.add(emailId1);
        }
        request.setAttribute("emailList", list);
        mv.getModelMap().put("emailAddMaster", emailAddMaster);
        mv.setViewName("EmailTemplate/EmailAddEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailAddMaster emailAddMaster = new EmailAddMaster();

        String[] email = request.getParameterValues("emailId");
        String id = request.getParameter("id");
        emailAddMaster = emailAddMasterService.readById(Integer.parseInt(id));
        String emailId = "";
        for (String email1 : email) {
            emailId += email1 + ",";
        }
        emailAddMaster.setEmailId(emailId);
        emailAddMasterService.update(emailAddMaster);
        mv = searchSubmit(request, response);

        return mv;

    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String emailId[] = request.getParameterValues("checkId");
        for (String z : emailId) {
            try {
                emailAddMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);

        return mv;
    }
}
