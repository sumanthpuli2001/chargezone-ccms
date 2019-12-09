/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.OTRegularization;
import com.bul.zydex.model.UserMaster;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hussain
 */
public class OverTimeController extends OverTimeAbstract {

    public ModelAndView searchOTDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OTRegularization oTRegularization = new OTRegularization();
        selectEmployee(request, response);
        mv.getModelMap().put("oTRegularization", oTRegularization);
        mv.setViewName("Payroll/overtimeStatement");
        return mv;
    }

    public ModelAndView searchFormEmployeeOTStatementDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OTRegularization oTRegularization = new OTRegularization();

        String employeeName = request.getParameter("employeeMasterId");
        String startDate = request.getParameter("startDateTime");
        String enddate = request.getParameter("endDateTime");

        HttpSession session = request.getSession();
//       

        if (!"".equals(startDate)) {
            oTRegularization.setStartDateTime(startDate);
        }

        if (!"".equals(enddate)) {
            oTRegularization.setEndDateTime(enddate);
        }
        if (!"".equals(employeeName)) {
            oTRegularization.setReason(employeeName);
        }

        List<?> readEmployeeOTStatementlist = employeeSalaryProcessService.readEmployeeForOTStatement(oTRegularization);
        List finalOtlist = new ArrayList();
        for (Object empExcelObject : readEmployeeOTStatementlist) {
            List otList = new ArrayList();
            Object[] empExcelData = (Object[]) empExcelObject;
            Integer userId = (Integer) empExcelData[0];

            UserMaster Us = userMasterService.readById(userId);
            String employeeid = Us.getUserName();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            List<?> list = employeeMasterService.getByEmployeeNo(employeeid);
            employeeMaster = (EmployeeMaster) list.get(0);
            String employeeName1 = employeeMaster.getEmployeeName();
            otList.add(employeeid);
            otList.add(employeeName1);
            otList.add(empExcelData[1]);
            otList.add(empExcelData[2]);
            otList.add(empExcelData[4]);
            otList.add(empExcelData[3]);
            

            finalOtlist.add(otList);
        }

//     
        request.setAttribute("employeelist", finalOtlist);

//        request.setAttribute("month", month);
//        request.setAttribute("year", year);
        mv = searchOTDetail(request, response);
        return mv;
    }

}
