/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSubType;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OptiPlex
 */
public class AttendanceReportController extends AttendanceReportAbstract {

    public ModelAndView searchAttendanceData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        mv.setViewName("Payroll/AttendanceReport");
        return mv;
    }

    public ModelAndView onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        String typeOfEmployee = request.getParameter("employeeTypeMasterId");
        String employeeSubId = request.getParameter("employeeSubTypeId");
        String month = request.getParameter("month");
        String year = request.getParameter("year11");
        List finalAttendanceList = new ArrayList();
        List excelRecordDataList = new ArrayList();
        String company = "";
        Float totalPresentDays = 0.0F;
        Float totalWorkingDays = 0.0F;
        Double totalOTHours = 0.0D;

        if (!typeOfEmployee.equals("")) {
            employeeMaster.setEmployeeType(typeOfEmployee);
        }
        if (null != employeeSubId && !employeeSubId.equals("")) {
            employeeMaster.setBankName(employeeSubId);
        }

        if (!month.equals("")) {
            employeeMaster.setChild1(month);
        }
        if (!year.equals("")) {
            employeeMaster.setChild2(year);
        }
        List<?> employeeExcelList = employeeExcelRecordService.readAttendanceRecord(employeeMaster);

        for (Object empExcelObject : employeeExcelList) {
            List attendanceList = new ArrayList();
            Object[] empExcelData = (Object[]) empExcelObject;
            attendanceList.add(empExcelData[0]);
            attendanceList.add(empExcelData[1]);
            attendanceList.add(empExcelData[2]);
            attendanceList.add(empExcelData[3]);
            attendanceList.add(empExcelData[4]);
            attendanceList.add(empExcelData[5]);
            attendanceList.add(empExcelData[6]);
            attendanceList.add(empExcelData[7]);
            attendanceList.add(empExcelData[8]);
            attendanceList.add(empExcelData[9]);
            company = (String) empExcelData[10];
            finalAttendanceList.add(attendanceList);
        }
        List attendanceList = new ArrayList();
        for (int i = 0; i < finalAttendanceList.size(); i++) {
            List tempList = (List) finalAttendanceList.get(i);
            
            totalPresentDays = totalPresentDays + (Float) tempList.get(3);
            totalOTHours = totalOTHours + (Double) tempList.get(9);
            totalWorkingDays = totalWorkingDays + (Float) tempList.get(2);
        }
        attendanceList.add("");
        attendanceList.add("--TOTAL--");
        attendanceList.add(totalWorkingDays);
        attendanceList.add(totalPresentDays);
        attendanceList.add("");
        attendanceList.add("");
        attendanceList.add("");
        attendanceList.add("");
        attendanceList.add("");
        attendanceList.add(totalOTHours);
        finalAttendanceList.add(attendanceList);
        excelRecordDataList.add(finalAttendanceList);
        excelRecordDataList.add(company);
        request.setAttribute("attendanceList", excelRecordDataList);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchAttendanceData(request, response);
        return mv;
    }
}
