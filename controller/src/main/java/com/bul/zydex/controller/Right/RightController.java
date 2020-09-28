/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Right;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.UserMaster;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class RightController extends CustomAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        List list = rightService.readByDrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("rightMaster", rightMaster);
        mv.setViewName("Right/RightList");
        return mv;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        List list = rightService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("rightMaster", rightMaster);
        mv.setViewName("Right/RightDisableList");
        return mv;
    }

    public ModelAndView createRightMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        mv.getModelMap().put("rightMaster", rightMaster);
        mv.setViewName("Right/RightCreate");
        return mv;
    }

    public ModelAndView submitRightMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        bind(request, rightMaster);
        StringJoiner sj = new StringJoiner("");
        rightMaster.setdRow("N");

        String[] SelectedEntry = {"u", "e", "cn", "a", "co", "ca", "w", "rp", "l", "rc"};
        String a;
        String str1 = "";
        for (int i = 0; i < SelectedEntry.length; i++) {
            a = SelectedEntry[i];
            String s = request.getParameter(a);
            if (s != null) {
                String WrightsEntry[] = request.getParameterValues(a);
                for (int j = 0; j < WrightsEntry.length; j++) {
                    str1 = str1 + WrightsEntry[j];
                }
                str1 = str1 + " ";
            } else {
                str1 = str1 + "N ";
            }

        }
        rightMaster.setRight(str1);
        rightService.create(rightMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right created").setDrow("Y");
        logService.create(lm);
        request.setAttribute("successMessage",
                "Information: Right Created successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        RightMaster rightMaster = new RightMaster();
        bind(request, rightMaster);
        rightMaster.setdRow("N");

        String[] SelectedEntry = {"u", "e", "cn", "a", "co", "ca", "w", "rp", "l", "rc"};
        String a;
        String str1 = "";
        for (int i = 0; i < SelectedEntry.length; i++) {
            a = SelectedEntry[i];
            String s = request.getParameter(a);
            if (s != null) {
                String WrightsEntry[] = request.getParameterValues(a);
                for (int j = 0; j < WrightsEntry.length; j++) {
                    str1 = str1 + WrightsEntry[j];
                }
                str1 = str1 + " ";
            } else {
                str1 = str1 + "N ";
            }

        }
        rightMaster.setRight(str1);
        rightService.update(rightMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right edited").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: Right Updated successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String rightName = request.getParameter("id");
        RightMaster rightMaster = rightService.read(rightName);
        int count = 0;
        ArrayList arr = new ArrayList();
        StringTokenizer st = new StringTokenizer(rightMaster.getRight(), "  ");
        while (st.hasMoreTokens()) {
            arr.add(count, st.nextToken());
            count++;
        }

        request.setAttribute("wright", arr);
        mv.getModelMap().put("rightMaster", rightMaster);
        mv.setViewName("Right/RightEdit");
        return mv;
    }

    public ModelAndView disableRight(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            RightMaster rightMaster = rightService.read(checkedValues);
            rightMaster.setdRow("Y");
            rightService.update(rightMaster);
        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Delete").setDrow("Y");
        logService.create(lm);
        request.setAttribute("successMessage",
                "Information: One or more Right deleted successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView deleteRightMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                rightService.deleteByRightName(checkedValues);
            }
            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Delete permanantely").setDrow("Y");
            logService.create(lm);
            request.setAttribute("successMessage",
                    "Information: One or more Right deleted successfully");
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                RightMaster rightMaster = rightService.read(checkedValues);
                rightMaster.setdRow("N");
                rightService.update(rightMaster);
            }
            //------for Log entry---------

            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Right Restore").setDrow("Y");
            logService.create(lm);
            request.setAttribute("successMessage",
                    "Information: One or more Right Restore successfully");
        }
        mv = showList(request, response);
        return mv;
    }

}
