/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.UserMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class TrainerLogInController extends TrainerLogInAbstract {
    public ModelAndView Login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        Trainer trainerMaster = new Trainer();
        mv.getModelMap().put("trainerMaster", trainerMaster);

        mv.setViewName("Trainer/TrainerLogin");
        return mv;
    }
   public ModelAndView loginSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
     String username= request.getParameter("userName");
     String password= request.getParameter("password");
     
        ModelAndView mv = new ModelAndView();
        Trainer trainerMaster = new Trainer();
//        VacancyMaster vacancyMaster = new VacancyMaster();
//        BindException errors = new BindException(trainerMaster, "trainerMaster");
//        bind(request, trainerMaster);
//        String userName = trainerMaster.getUserName();
//        String PassString = trainerMaster.getPassword();
//        String userName = trainerMaster.getUserName();
//        String PassString = trainerMaster.getPassword();


        if (!"".equals(username) && !"".equals(password)) {
 List<?> TrainerList = trainerService.readByUser(username);
 for(Object o :TrainerList)
 {
     trainerMaster =(Trainer)o;
 }
//            Trainer train = new Trainer();
//            train.setUserName(username);
//            train.setPassword(password);
//            Trainer master = (Trainer) trainerService.read();

            if (null != trainerMaster) {
                HttpSession session1 = request.getSession(false);
                session1.setAttribute("trainerMaster", trainerMaster);

                request.setAttribute("successMessage",
                        "Information : Login Successfully.");

//                List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(master.getId());
//                List<?> CandidateJobApplyList = new ArrayList<>();
//                if (!candidateProfile.isEmpty()) {
//                    CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
//                    CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());
//                }
//                request.setAttribute("successMessage",
//                        "Information : Login Successfully.");
//                request.setAttribute("list", CandidateJobApplyList);
                mv.getModelMap().put("TrainerList", TrainerList);
                mv.setViewName("Trainer/TrainerList");
                return mv;
            } else {
                request.setAttribute("failureMessage",
                        "Error : Invalid UserName Or Password.");
                mv = Login(request, response);
            }
        } else {
            request.setAttribute("failureMessage",
                    "Error : Invalid UserName Or Password.");
            mv = Login(request, response);
        }
//        mv.getModelMap().put("trainerMaster", trainerMaster);
        return mv;
    }
}
