/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.service.EmailAddMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailAddMasterAbstract extends CustomAbstract {

    protected EmailAddMasterService<EmailAddMaster> emailAddMasterService;

    public EmailAddMasterService<EmailAddMaster> getEmailAddMasterService() {
        return emailAddMasterService;
    }

    public void setEmailAddMasterService(EmailAddMasterService<EmailAddMaster> emailAddMasterService) {
        this.emailAddMasterService = emailAddMasterService;
    }
     protected void departmentList(HttpServletRequest request) {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> depttList = departmentMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            departmentMaster = (DepartmentMaster) o;
            dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }

        request.setAttribute("deptMap", dm);
    }
    

}
