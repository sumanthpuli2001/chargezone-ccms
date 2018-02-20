/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.model.ApprovalMaster;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vikas
 */
public class ApprovalController extends ApprovalAbstract {

    public ModelAndView createApprovalSetting(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApprovalMaster approvalMaster =  new ApprovalMaster();
        mv.getModelMap().put("approvalMaster", approvalMaster);
        mv.setViewName("Approval/CreateApproval");
        return mv;
    }

}
