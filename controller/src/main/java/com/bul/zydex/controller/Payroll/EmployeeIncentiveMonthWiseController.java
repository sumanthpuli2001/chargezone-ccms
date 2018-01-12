/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePayrollIncentive;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hussain
 */
public class EmployeeIncentiveMonthWiseController extends EmployeeIncentiveMonthWiseAbstract {

    public ModelAndView searchEmpSalIncentiveDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        request.setAttribute("search", request.getParameter("search"));
        mv.setViewName("Payroll/EmployeeSearchIncentive");
        return mv;
    }

    public ModelAndView searchEmpIncentiveDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String pincentive = request.getParameter("pincentive");
        String aincentive = request.getParameter("aincentive");
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year11");
        EmployeePayrollIncentive employeePayrollIncentive = new EmployeePayrollIncentive();
        List<?> listemplpay = employeePayrollIncentiveService.readByEmployeePayrollIncentive(month1, year11);
        for (Object v : listemplpay) {
            employeePayrollIncentive.setId((Integer) v);
            employeePayrollIncentiveService.delete(employeePayrollIncentive.getId());
        }
// before create deleted past data
        employeeIncentiveMonthwiseService.readByEmployeeIncentiveMonthwise(month1, year11);

        // create Employeee Incentive month 
        EmployeeIncentiveMonthwise employeeIncentiveMonthwise = new EmployeeIncentiveMonthwise();
        employeeIncentiveMonthwise.setIncentiveAmount(Double.parseDouble(pincentive));
        employeeIncentiveMonthwise.setAttenDay(Float.parseFloat(aincentive));
        employeeIncentiveMonthwise.setMonth(month1);
        employeeIncentiveMonthwise.setYear(year11);
        employeeIncentiveMonthwiseService.create(employeeIncentiveMonthwise);

        ////end Employeee Incentive month 
        List finalList2 = new ArrayList();
        List<?> list = employeeExcelRecordService.readEmployeeForIncentive(pincentive, aincentive, month1, year11);
        if (!list.isEmpty()) {

            for (Object incentiveList1 : list) {
                Object[] o = (Object[]) incentiveList1;
                List finalList = new ArrayList();
                String Empid = (String) o[0];
                String EmpName = (String) o[1];
                Float presentDays = (Float) o[2];
                Double employeeBasicSalary = (Double) o[3];
                Double employeeLwp = (Double) o[4];
                String basicsalary = (String) o[5];
                int empIdEmpmaster = (Integer) o[6];

                employeeMaster.setId(empIdEmpmaster);
                float totalpresentday = 0;
                Iterator itr = list.iterator();
                while (itr.hasNext()) {
                    Object[] next = (Object[]) itr.next();
                    totalpresentday += (Float) next[2];

                }
                double netProductionIncentiveperday = 0;

//                netProductionIncentiveperday = (totalpresentday / Double.parseDouble(pincentive));
                netProductionIncentiveperday = (Double.parseDouble(pincentive) / totalpresentday);// net production per day
                double productIncentiveAmount = 0;
                productIncentiveAmount = (presentDays * netProductionIncentiveperday);//production amount calculation
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.MONTH, (Integer.parseInt(month1) - 1));
                int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                double basicSalary = Double.parseDouble(basicsalary);
                double perdayrate = basicSalary / days;//basic per day
                double aincentive1 = Double.parseDouble(aincentive);
                double attndInctAmount = aincentive1 * perdayrate;//attend incentive amount

//                EmployeePayrollIncentive employeePayrollIncentive = new EmployeePayrollIncentive();
                //// delete before create employeePayrollIncentive
                /// create EmployeePayrollIncentive
                employeePayrollIncentive.setEmployeeMaster(employeeMaster);
                employeePayrollIncentive.setEmployeeIncentiveMonthwise(employeeIncentiveMonthwise);
                if (!employeeLwp.equals(0.0)) {
                    double netProductionIncentiveperday1 = 0;
                    double attndInctAmount1 = 0;
                    double productIncentiveAmount1 = 0;
                    double aincentive2 = 0;
                    employeePayrollIncentive.setProdIncentivePerDay(netProductionIncentiveperday1);
                    employeePayrollIncentive.setIncentiveAmount(attndInctAmount1);
                    employeePayrollIncentive.setProdIncentiveAmount(productIncentiveAmount1);
                    employeePayrollIncentive.setAttenIncentiveDay(aincentive2);

                } else {

                    employeePayrollIncentive.setProdIncentivePerDay(netProductionIncentiveperday);
                    employeePayrollIncentive.setIncentiveAmount(attndInctAmount);
                    employeePayrollIncentive.setProdIncentiveAmount(productIncentiveAmount);
                    employeePayrollIncentive.setAttenIncentiveDay(aincentive1);

                }

//                employeePayrollIncentive.setProdIncentivePerDay(netProductionIncentiveperday);
//                employeePayrollIncentive.setAttenIncentiveDay(aincentive1);
                employeePayrollIncentive.setBasicRatePerDay(perdayrate);
//                employeePayrollIncentive.setIncentiveAmount(attndInctAmount);
//                employeePayrollIncentive.setProdIncentiveAmount(productIncentiveAmount);
                employeePayrollIncentive.setMonth(month1);
                employeePayrollIncentive.setYear(year11);
                employeePayrollIncentive.setpDay(presentDays);
                employeePayrollIncentiveService.create(employeePayrollIncentive);

                finalList.add(Empid);
                finalList.add(EmpName);
                finalList.add(presentDays);
                if (!employeeLwp.equals(0.0)) {
                    finalList.add(0.0);
                    finalList.add(0.0);
                } else {

                    finalList.add(netProductionIncentiveperday);
                    finalList.add(productIncentiveAmount);
                }
                finalList.add(perdayrate);

                if (!employeeLwp.equals(0.0)) {
                    finalList.add(0.0);
                    finalList.add(0.0);
                } else {

                    finalList.add(aincentive);
                    finalList.add(attndInctAmount);
                }
                finalList.add(employeePayrollIncentive.getId());
                finalList2.add(finalList);

            }
        }
        float totalpresentday1 = 0;
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalpresentday1 += (Float) next[2];

        }

        List<?> list1 = employeePayrollIncentiveService.readByEmployeePayrollIncentivelistAmount(employeeIncentiveMonthwise);
        double productionIncentive1 = 0;
        double atttentIncentive1 = 0;
        Iterator itr1 = list1.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            productionIncentive1 += (double) next[0];
            atttentIncentive1 += (double) next[1];

        }

        request.setAttribute("employeelist", finalList2);
        request.setAttribute("totalpresentday1", totalpresentday1);
        request.setAttribute("productionIncentive1", productionIncentive1);
        request.setAttribute("atttentIncentive1", atttentIncentive1);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);
        mv = searchEmpSalIncentiveDetail(request, response);
//        mv.setViewName("Leave/LeaveEmployeeDetailResult");
        return mv;
    }

    public ModelAndView editemployeeIncentiveMonthWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        List<?> list1 = employeePayrollIncentiveService.readByEmployeePayrollIncentivelistAmountEdit(Integer.parseInt(id));
        request.setAttribute("employeelist", list1);
        mv.setViewName("Payroll/editIncentiveForm");
        return mv;
    }

    public ModelAndView submitincentiveedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeIncentiveMonthwise employeeIncentiveMonthwise = new EmployeeIncentiveMonthwise();

        String id = request.getParameter("id");
        String attendDay = request.getParameter("incentiveMapId");
        List<?> list1 = employeePayrollIncentiveService.readByEmployeePayrollIncentivelistAmountEdit(Integer.parseInt(id));
        if (!list1.isEmpty()) {

            for (Object employeePayrollIncentive : list1) {
                Object[] o = (Object[]) employeePayrollIncentive;
                int Empid = (Integer) o[8];
                int employeePayrollincennt = (Integer) o[7];
                int employeeIncentiveMonthwiseid = (Integer) o[6];
                Double basicperday = (Double) o[2];
                String month = (String) o[9];
                String year = (String) o[10];
                Float pday = (Float) o[0];
                Double prodIncentiveAmount = (Double) o[5];
                Double prodIncentivePerDay = (Double) o[2];
                double aincentive1 = Double.parseDouble(attendDay);
//                double attndInctAmount =  * basicperday;//attend incentive amount
                double attndInctAmount = basicperday * aincentive1;//attend incentive amount

                EmployeePayrollIncentive employeePayrollIncentive1 = new EmployeePayrollIncentive();
                employeeMaster.setId(Empid);
                employeeIncentiveMonthwise.setId(employeeIncentiveMonthwiseid);
                employeePayrollIncentive1.setId(employeePayrollincennt);
                employeePayrollIncentive1.setEmployeeMaster(employeeMaster);
                employeePayrollIncentive1.setEmployeeIncentiveMonthwise(employeeIncentiveMonthwise);
                employeePayrollIncentive1.setIncentiveAmount(attndInctAmount);
                employeePayrollIncentive1.setBasicRatePerDay(basicperday);
                employeePayrollIncentive1.setAttenIncentiveDay(aincentive1);
                employeePayrollIncentive1.setMonth(month);
                employeePayrollIncentive1.setYear(year);
                employeePayrollIncentive1.setpDay(pday);
                employeePayrollIncentive1.setProdIncentiveAmount(prodIncentiveAmount);
                employeePayrollIncentive1.setProdIncentivePerDay(prodIncentivePerDay);
                employeePayrollIncentiveService.update(employeePayrollIncentive1);

            }
        }
        request.setAttribute("successMessage", "Information : Update Successfully.");
        mv.setViewName("Payroll/editIncentiveForm");
        return mv;
    }

    public ModelAndView searchEmpSalIncentiveMonthDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        request.setAttribute("search", request.getParameter("search"));
        mv.setViewName("Payroll/EmployeeSearchIncentiveMonthwise");
        return mv;
    }

    public ModelAndView searchEmpIncentiveDetailmonthSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String month = request.getParameter("month");
        String year = request.getParameter("year11");
        EmployeePayrollIncentive employeePayrollIncentive = new EmployeePayrollIncentive();

        List<?> list1 = employeePayrollIncentiveService.readByEmployeePayrollIncentiveReport(month, year);

        double productionIncentive1 = 0;
        double atttentIncentive1 = 0;
        float pday = 0;
        Iterator itr1 = list1.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            productionIncentive1 += (double) next[4];
            atttentIncentive1 += (double) next[7];
            pday += (float) next[2];

        }

        request.setAttribute("employeelist", list1);
        request.setAttribute("productionIncentive1", productionIncentive1);
        request.setAttribute("atttentIncentive1", atttentIncentive1);
        request.setAttribute("pday", pday);
         request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchEmpSalIncentiveMonthDetail(request, response);
//        mv.setViewName("Leave/LeaveEmployeeDetailResult");
        return mv;
    }
    
     public ModelAndView searchEmpSalIncentiveMonthEmployeeDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        request.setAttribute("search", request.getParameter("search"));
        mv.setViewName("Payroll/EmployeeSearchBankStatementIncentive");
        return mv;
    }
     
       public ModelAndView searchEmpIncentiveDetailmonthEmployeeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String month = request.getParameter("month");
        String year = request.getParameter("year11");
        EmployeePayrollIncentive employeePayrollIncentive = new EmployeePayrollIncentive();

        List<?> list1 = employeePayrollIncentiveService.readByEmployeePayrollIncentiveReportnew(month, year);

        double productionIncentive1 = 0;
       
        Iterator itr1 = list1.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            productionIncentive1 += (double) next[4];
           

        }

        request.setAttribute("employeelist", list1);
        request.setAttribute("productionIncentive1", productionIncentive1);
         request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchEmpSalIncentiveMonthEmployeeDetail(request, response);
//        mv.setViewName("Leave/LeaveEmployeeDetailResult");
        return mv;
    }

}
