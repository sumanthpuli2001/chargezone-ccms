/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

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
public class EmailTemplateController extends EmailTemplateAbstract{
    
    
      public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailTemplate emailTemplate = new EmailTemplate();
        mv.getModelMap().put("emailTemplate", emailTemplate);
        mv.setViewName("EmailTemplate/EmailTemplateCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailTemplate emailTemplate = new EmailTemplate();
        BindException errors = new BindException(emailTemplate, "emailTemplate");
        bind(request, emailTemplate);
        emailTemplateValidator.validate(emailTemplate, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
//            mv = createClick(request, response);
            mv.setViewName("EmailTemplate/EmailTemplateCreate");
        } else {
            emailTemplateService.create(emailTemplate);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv.setViewName("redirect:emailTemplate.htm?act=searchSubmit");
//            mv.setViewName("EmailTemplate/EmailTemplateCreate");
        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailTemplate emailTemplate = new EmailTemplate();
//        List<?> employeeMasterList = employeeMasterService.read();
        List<?> emailTemplateList = emailTemplateService.read();

        mv.getModelMap().put("list", emailTemplateList);
        mv.getModelMap().put("emailTemplate", emailTemplate);
        mv.setViewName("EmailTemplate/EmailTemplateResult");

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

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmailTemplate emailTemplate = new EmailTemplate();
        BindException errors = new BindException(emailTemplate, "emailTemplate");
        emailTemplate.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, emailTemplate);
        emailTemplateValidator.validate(emailTemplate, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = editClick(request, response);
        } else {
            emailTemplateService.update(emailTemplate);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);

        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String emailTemplateId[] = request.getParameterValues("checkId");
        for (String z : emailTemplateId) {
            try {
                emailTemplateService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);

        return mv;
    }
}
