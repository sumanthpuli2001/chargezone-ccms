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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeePtCheckcontroller extends EmployeePtCheckAbstract {

    public ModelAndView searchSalaryPtDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        List<?> list = (List<?>) request.getAttribute("employeelist");
        zydexLocationList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        List<?> list1 = (List<?>) request.getAttribute("SalaryList");
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeelist", list);
        session.setAttribute("EmployeePtcheck1", list1);
        mv.setViewName("Payroll/EmployeePtDetail");
        return mv;
    }

    public ModelAndView searchFormEmployeePtDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String Payment_Type = request.getParameter("paymentType");
        String month = request.getParameter("month");
        String year = request.getParameter("year11");

        HttpSession session = request.getSession();
//       
        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }
//
        if (!Payment_Type.equals("")) {
            employeeMaster.setPaymentType(Payment_Type);

        }

        if (!"".equals(month)) {
            employeeMaster.setBankAccountNo(month);
        }
        if (!"".equals(year)) {
            employeeMaster.setPanCard(year);
        }

        List<?> list = employeeSalaryProcessService.readEmployeeForPt(employeeMaster);
        double totalPtAmount = 0;
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalPtAmount += (Double) next[2];
        }
        double totalGrossTotal = 0;
        Iterator itr1 = list.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            totalGrossTotal += (Double) next[5];
        }
        
        request.setAttribute("employeelist", list);
        request.setAttribute("totalPtAmount", totalPtAmount);
        request.setAttribute("totalGrossTotal", totalGrossTotal);
        session.setAttribute("employeePtcheckList", list);
        session.setAttribute("sessionTotalPtAmount", totalPtAmount);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchSalaryPtDetail(request, response);
        return mv;
    }

    public ModelAndView exportToExcelPtCheck(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> employeePtcheck1 = (List<?>) request.getSession().getAttribute("employeePtcheckList");
        String sessionTotalPtAmount = request.getSession().getAttribute("sessionTotalPtAmount").toString();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeePtCheck.xls");
        mv.addObject("employeePtcheck1", employeePtcheck1);
        request.setAttribute("sessionTotalPtAmount", sessionTotalPtAmount);
        mv.setViewName("Payroll/EmployeePtCheckExcel");
        return mv;
    }
}
