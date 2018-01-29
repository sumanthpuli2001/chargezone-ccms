/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OddPunch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell-1
 */
public class OddPunchController extends OddPunchAbstract {

    public ModelAndView searchOddPunch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("AttendanceRegularization/OddPunchReport");
        return mv;
    }

    public ModelAndView onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List oddPunchList = new ArrayList();
        String enteredDate = request.getParameter("enteredDate");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = formater.parse(enteredDate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormatter.format(convertedDate);

        List<?> employeeDateTimeDataList = employeeDatetimeDataService.readOddPunchedEmployeeData(date);

        for (Object list : employeeDateTimeDataList) {
            Object[] o = (Object[]) list;
            if (!(Integer.parseInt(o[3].toString()) % 2 == 0)) {
                List tempPunchList = new ArrayList();
                tempPunchList.add(o[0]);
                tempPunchList.add(o[1]);
                oddPunchList.add(tempPunchList);
            }

        }
        request.setAttribute("oddPunchList", oddPunchList);
        request.setAttribute("date", date);
        mv = searchOddPunch(request, response);

        return mv;
    }
}
