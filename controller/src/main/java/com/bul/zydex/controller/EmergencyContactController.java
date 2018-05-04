/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmergencyContact;
import com.bul.zydex.model.EmployeeMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class EmergencyContactController extends EmergencyContactAbstract {

    public ModelAndView createContact(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();

        EmergencyContact emergencyContact = emergencyContactService.readEmergencyContact();

        mv.getModelMap().put("emergencyContact", emergencyContact);
        mv.setViewName("Emergency/EmergencyContact");
        return mv;
    }

    public ModelAndView contactCreateUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        EmergencyContact emergencyContact = new EmergencyContact();
        bind(request, emergencyContact);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cudate = new Date();

        if (emergencyContact.getContactDescription().equals("")) {
            request.setAttribute("faliureMessage",
                    "Error : The Emergency Contact Creation/Updation is not valid.");

        } else {
            if (emergencyContact.getId() == null) {
                emergencyContact.setCreatedBy(employeeMaster.getId());
                emergencyContact.setCreatedDate(sdf.format(cudate));
                emergencyContactService.create(emergencyContact);
                request.setAttribute("successMessage",
                        "Success : The Emergency Contact Creation is successful.");
            } else {
                emergencyContact.setUpdatedBy(employeeMaster.getId());
                emergencyContact.setUpdatedDate(sdf.format(cudate));
                emergencyContactService.update(emergencyContact);
                request.setAttribute("successMessage",
                        "Success : The Emergency Contact Updation is successful.");
            }
        }

        mv.getModelMap().put("emergencyContact", emergencyContact);
        mv = createContact(request, response);
        return mv;
    }
    
    public ModelAndView viewContact(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        EmergencyContact emergencyContact = new EmergencyContact();
        
        List<EmergencyContact> list = (List<EmergencyContact>) emergencyContactService.read();

        request.setAttribute("list", list.get(0).getContactDescription());
        mv.getModelMap().put("emergencyContact", emergencyContact);
        mv.setViewName("Emergency/EmergencyContactView");
        return mv;
    }
}
