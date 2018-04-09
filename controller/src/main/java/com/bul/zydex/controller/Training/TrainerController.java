/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.model.Trainer;
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
 * @author Aman
 */
public class TrainerController extends TrainerAbstract {

    public ModelAndView createTrainerShow(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        Trainer trainer = new Trainer();
        List<?> trainerList = trainerService.readTrainerList();
        mv.getModelMap().put("list", trainerList);
        mv.getModelMap().put("trainer", trainer);
        mv.setViewName("Training/createTrainer");
        return mv;
    }

    public ModelAndView newCreateTrainer(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        Trainer trainer = new Trainer();
        mv.getModelMap().put("trainer", trainer);
        mv.setViewName("Training/RegistrationTrainer");
        return mv;
    }

    public ModelAndView newEditTrainer(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        Trainer trainer = trainerService.readById(Integer.parseInt(id));
        mv.getModelMap().put("trainer", trainer);
        mv.setViewName("Training/RegistrationTrainer");
        return mv;
    }

    public ModelAndView trainerCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        Trainer trainer = new Trainer();
        HttpSession session = request.getSession();
        UserMaster user = (UserMaster) session.getAttribute("user");
        BindException errors = new BindException(trainer, "trainer");
        bind(request, trainer);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        trainerValidator.validate(trainer, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Training/RegistrationTrainer");
        } else {
            if (null == trainer.getId()) {
                if (!trainerService.isExist(trainer)) {
                    trainer.setCreatedDate(sdf.format(cDate));
                    trainer.setCreatedBy(user.getId());
                    trainerService.create(trainer);

                    request.setAttribute("successMessage",
                            "Information : The Information is saved Successfully.");
                } else {
                    request.setAttribute("faliureMessage",
                            "Error : The Saving Type is already there.");
                }
            } else {
                if (!trainerService.isExist(trainer)) {
                    trainer.setUpdatedDate(sdf.format(cDate));
                    trainer.setUpdatedBy(user.getId());
                    trainerService.update(trainer);

                    request.setAttribute("successMessage",
                            "Information : The Information is Updated Successfully.");

                } else {
                    request.setAttribute("faliureMessage",
                            "Error : The Saving Type is already there.");
                }

            }

            mv = createTrainerShow(request, response);
        }
        return mv;
    }

    public ModelAndView budgetdeleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                trainerService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info :The Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = createTrainerShow(request, response);
        return mv;
    }

}
