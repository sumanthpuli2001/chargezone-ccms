/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
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
        BindException errors = new BindException(emailAddMaster, "emailAddMaster");
        bind(request, emailAddMaster);
        int countId = Integer.parseInt(request.getParameter("countId"));
        String [] email=request.getParameterValues("emailId");
        String emailId= "";
        for(String email1:email)
        {
            emailId+=email1+",";
        }
//        for (int i = 1; i <= countId; i++) {
//            emailId = (request.getParameter("emailId")+",");
//           
//        }
        emailAddMaster.setEmailId(emailId);
        emailAddMasterService.create(emailAddMaster);
        request.setAttribute("successMessage",
                "Information : The Information is saved Successfully.");
        mv.setViewName("redirect:emailAddMaster.htm?act=searchSubmit");

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailAddMaster emailAddMaster = new EmailAddMaster();
        List<?> emailaddList = emailAddMasterService.read();

        mv.getModelMap().put("list", emailaddList);
        mv.getModelMap().put("emailAddMaster", emailAddMaster);
        mv.setViewName("EmailTemplate/EmailAddResult");

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailTemplate emailTemplate = new EmailTemplate();
        String id = request.getParameter("id");
        emailTemplate = emailTemplateService.readById(Integer.parseInt(id));
        emailTemplate.setId(Integer.parseInt(id));
        mv.getModelMap().put("emailTemplate", emailTemplate);
        mv.setViewName("EmailTemplate/EmailTemplateEdit");
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
