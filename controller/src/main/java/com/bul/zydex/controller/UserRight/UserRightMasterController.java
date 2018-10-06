/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.UserRight;

import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class UserRightMasterController extends UserRightMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserRightMaster userRightMaster = new UserRightMaster();
        String userId = request.getParameter("id");
        UserMaster userMaster = new UserMaster();
        userMaster.setId(Integer.parseInt(userId));

        userRightMaster.setUserMaster(userMaster);
        List<?> list = userRightMasterService.readByUserId(userId);
        List<?> userDescription = userRightDescriptionService.read();
        if (!list.isEmpty()) {
            userRightMaster = (UserRightMaster) list.get(0);
            userRightMaster.getId();
            userRightMaster = userRightMasterService.readById(userRightMaster.getId());
        }
        mv.getModelMap().put("userRightMaster", userRightMaster);
        request.setAttribute("userDescription", userDescription);
        mv.setViewName("User/UserRight");
        return mv;
    }

    public ModelAndView createClickInduction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserRightMaster userRightMaster = new UserRightMaster();
        String userId = request.getParameter("id");
        UserMaster userMaster = new UserMaster();
        userMaster.setId(Integer.parseInt(userId));

        userRightMaster.setUserMaster(userMaster);
        List<?> list = userRightMasterService.readByUserId(userId);
        List<?> userDescription = userRightDescriptionService.read();
        if (!list.isEmpty()) {
            userRightMaster = (UserRightMaster) list.get(0);
            userRightMaster.getId();
            userRightMaster = userRightMasterService.readById(userRightMaster.getId());
        }
        mv.getModelMap().put("userRightMaster", userRightMaster);
        request.setAttribute("userDescription", userDescription);
        mv.setViewName("User/UserRightInduction");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserRightMaster userRightMaster = new UserRightMaster();
        UserRightMaster userRightMaster1 = new UserRightMaster();
        BindException errors = new BindException(userRightMaster, "userRightMaster");
        bind(request, userRightMaster);
        String userId = request.getParameter("userMaster.id");
        List<?> list = userRightMasterService.readByUserId(userId);

        userRightMasterValidator.validate(userRightMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            if (!list.isEmpty()) {
//             userRightMaster1 = new UserRightMaster();
                userRightMaster1 = (UserRightMaster) list.get(0);
                //userRightMaster1.getId();
                userRightMaster.setId(userRightMaster1.getId());
                //userRightMaster = userRightMasterService.readById(userRightMaster.getId());
                userRightMasterService.update(userRightMaster);
            } else {

                userRightMasterService.create(userRightMaster);
            }

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
        }
        mv.getModelMap().put("userRightMaster", userRightMaster);
        mv.setViewName("forward:employeeMaster.htm?act=searchSubmit");
        return mv;
    }

    public ModelAndView createSubmitInduction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserRightMaster userRightMaster = new UserRightMaster();
        UserRightMaster userRightMaster1 = new UserRightMaster();
        BindException errors = new BindException(userRightMaster, "userRightMaster");
        bind(request, userRightMaster);
        String userId = request.getParameter("userMaster.id");
        List<?> list = userRightMasterService.readByUserId(userId);

        userRightMasterValidator.validate(userRightMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            if (!list.isEmpty()) {
//             userRightMaster1 = new UserRightMaster();
                userRightMaster1 = (UserRightMaster) list.get(0);
                //userRightMaster1.getId();
                userRightMaster.setId(userRightMaster1.getId());
                //userRightMaster = userRightMasterService.readById(userRightMaster.getId());
                userRightMasterService.update(userRightMaster);
            } else {

                userRightMasterService.create(userRightMaster);
            }

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
        }
        mv.getModelMap().put("userRightMaster", userRightMaster);
        mv.setViewName("forward:candidateF2FRequest.htm?act=appoitmentLaterEditable&id=" + String.valueOf(userId));
        return mv;
    }
}
