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
import java.util.ArrayList;
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
        session.setAttribute("EmployeePfcheck1", list1);
        mv.setViewName("Payroll/overtimeStatement");
        return mv;
    }

    public ModelAndView searchFormEmployeeOTStatementDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        Double grossTotal = 0.0D;
        Double EmpCont = 0.0D;
        Double comCont = 0.0D;
        String employeeId = "";
        String employeeName = "";

        List finalList = new ArrayList();
        List listForMonthAndYear = new ArrayList();
        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String Payment_Type = request.getParameter("paymentType");
        String month = request.getParameter("month");
        String year = request.getParameter("year11");

        HttpSession session = request.getSession();
//       

        if (!zydex_location_id.equals(
                "")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals(
                "")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id
                && !employee_sub_id.equals(
                        "")) {
            employeeMaster.setCompany(employee_sub_id);
        }
//

        if (!Payment_Type.equals(
                "")) {
            employeeMaster.setPaymentType(Payment_Type);

        }

        if (!"".equals(month)) {
            employeeMaster.setBankAccountNo(month);
        }

        if (!"".equals(year)) {
            employeeMaster.setPanCard(year);
        }

        List<?> readEmployeeOTStatementlist = employeeSalaryProcessService.readEmployeeForOTStatement(employeeMaster);
        
//         for (Object empExcelObject : readEmployeeOTStatementlist) {
//            List attendanceList = new ArrayList();
//            Object[] empExcelData = (Object[]) empExcelObject;
////            attendanceList.add(empExcelData[0]);
////            attendanceList.add(empExcelData[1]);
////            attendanceList.add(empExcelData[2]);
////            attendanceList.add(empExcelData[3]);
////            attendanceList.add(empExcelData[4]);
////            attendanceList.add(empExcelData[5]);
////            attendanceList.add(empExcelData[6]);
////            attendanceList.add(empExcelData[7]);
////            attendanceList.add(empExcelData[8]);
////            attendanceList.add(empExcelData[9]);
////            company = (String) empExcelData[10];
////            finalAttendanceList.add(attendanceList);
//        }
        
        
        
        
        double totalOtAmount = 0;
        Iterator itr = readEmployeeOTStatementlist.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalOtAmount += (Double) next[3];
        }
        double totalOtHours = 0;
        Iterator itr1 = readEmployeeOTStatementlist.iterator();
        while (itr1.hasNext()) {
          
            Object[] next = (Object[]) itr1.next();
            totalOtHours += (Double) next[2];
        }
        double totalGrossTotal = 0;
        Iterator itr2 = readEmployeeOTStatementlist.iterator();
        while (itr2.hasNext()) {
            Object[] next = (Object[]) itr2.next();
            totalGrossTotal += (Double) next[4];
        }
//        double totalOtEsic = 0;
//        Iterator itr3 = readEmployeeOTStatementlist.iterator();
//        while (itr3.hasNext()) {
//            Object[] next = (Object[]) itr3.next();
//            totalOtEsic += (Double) next[6];
//        }
//        double totalOtEsicNet = 0;
//        Iterator itr4 = readEmployeeOTStatementlist.iterator();
//        while (itr4.hasNext()) {
//            Object[] next = (Object[]) itr4.next();
//            totalOtEsicNet += (Double) next[7];
//        }
        
        

        request.setAttribute("employeelist", readEmployeeOTStatementlist);
        request.setAttribute("totalOtAmount", totalOtAmount);
        request.setAttribute("totalOtHours", totalOtHours);
        request.setAttribute("totalGrossTotal", totalGrossTotal);
//        request.setAttribute("totalOtEsic", totalOtEsic);
//        request.setAttribute("totalOtEsicNet", totalOtEsicNet);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchOTDetail(request, response);
        return mv;
    }

}
