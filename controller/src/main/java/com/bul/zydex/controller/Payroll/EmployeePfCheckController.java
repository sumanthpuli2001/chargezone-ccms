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
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.RetirementAge;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeePfCheckController extends EmployeePfCheckAbstract {

    public ModelAndView searchSalaryPfDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Payroll/EmployeePfDetail");
        return mv;
    }

    public ModelAndView searchFormEmployeePfDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

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

        List<?> list = employeeSalaryProcessService.readEmployeeForPf(employeeMaster);

        double totalPfAmount = 0;
        double totalePfAmount = 0;
        double totalaPfAmount = 0;
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalPfAmount += (Double) next[2];
            totalePfAmount += (Double) next[3];
            totalaPfAmount += (Double) next[4];
        }

        request.setAttribute("employeelist", list);
        request.setAttribute("totalPfAmount", totalPfAmount);
        request.setAttribute("totalePfAmount", totalePfAmount);
        request.setAttribute("totalaPfAmount", totalaPfAmount);
        session.setAttribute("sessionTotalPfAmount", totalPfAmount);
        session.setAttribute("sessionTotalePfAmount", totalePfAmount);
        session.setAttribute("sessionTotalaPfAmount", totalaPfAmount);
        session.setAttribute("employeePfcheckList", list);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchSalaryPfDetail(request, response);
        return mv;
    }

    public ModelAndView exportToExcelPfCheck(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> employeePfcheck1 = (List<?>) request.getSession().getAttribute("employeePfcheckList");
        String sessionTotalPfAmount = request.getSession().getAttribute("sessionTotalPfAmount").toString();
        String sessionTotalePfAmount = request.getSession().getAttribute("sessionTotalePfAmount").toString();
        String sessionTotalaPfAmount = request.getSession().getAttribute("sessionTotalaPfAmount").toString();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeePfCheck.xls");
        mv.addObject("employeePfcheck1", employeePfcheck1);
        request.setAttribute("sessionTotalPfAmount", sessionTotalPfAmount);
        request.setAttribute("sessionTotalePfAmount", sessionTotalePfAmount);
        request.setAttribute("sessionTotalaPfAmount", sessionTotalaPfAmount);
        mv.setViewName("Payroll/EmployeePfCheckExcel");
        return mv;
    }
    public ModelAndView searchSalaryPfGovDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Payroll/EmployeePfDetailGov");
        return mv;
    }

    public ModelAndView searchFormEmployeePfDetailSubmitGov(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

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

        List<?> list = employeeSalaryProcessService.readEmployeeForPfGov(employeeMaster);
        List tempemployeeSalaryDetail = new ArrayList();
        for (Object employeePfdetail : list) {
            Object[] o = (Object[]) employeePfdetail;
            List tempemployeePfdetailList = new ArrayList();
            String employeeId = (String) o[0];
            tempemployeePfdetailList.add(employeeId);
            String employeeName = (String) o[1];
            tempemployeePfdetailList.add(employeeName);
            int employeeMasterID = (int) o[2];
            tempemployeePfdetailList.add(employeeMasterID);
            int employeeProcessId = (int) o[3];
            tempemployeePfdetailList.add(employeeProcessId);
            String uano = (String) o[4];
            tempemployeePfdetailList.add(uano);
            Double totalGoss = (Double) o[5];
            tempemployeePfdetailList.add(totalGoss);

            String pfAmount = (String) o[6];
            tempemployeePfdetailList.add(pfAmount);
            String dayofbirth = (String) o[7];
            String birthyear = dayofbirth.substring(6, 10);
            Calendar cal = Calendar.getInstance();
            int year2 = cal.get(cal.YEAR);
            int diffYear = year2 - Integer.parseInt(birthyear);
            RetirementAge retirementAge = new RetirementAge();
            List<?> retirementAgeList = retirementAgeService.read();
            retirementAge = (RetirementAge) retirementAgeList.get(0);
            String ages = retirementAge.getRetireAge();
//            for (Object o8 : retirementAgeList) {
//                retirementAge = (RetirementAge) o8;
//                String ages = retirementAge.getRetireAge();
//            }
//            retirementAge = (RetirementAge) retirementAgeService.read();
//              EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster = employeeMasterService.readById(employeeMasterID);

            boolean pfFlag = payrollPfCheckService.readForPfCheck(employeeMaster.getEmployeeTypeMaster().getId(),
                    employeeMaster.getEmployeeSubType().getId());

            if (pfFlag) {
                List<?> pfAmountList = payrollProvidentFundService.readPf(employeeMaster.getZydexLocationMaster().getId());
                if (!pfAmountList.isEmpty()) {
                    PayrollProvidentFund payrollProvidentFund = (PayrollProvidentFund) pfAmountList.get(0);
                    double maxiAmount1 = Double.parseDouble(payrollProvidentFund.getMaximumBasicAmount());
                    String pfPercentage = payrollProvidentFund.getPfPercentage();
                    String epfPercentage = payrollProvidentFund.getEpfPercentage();

                    if (maxiAmount1 <= Double.parseDouble(pfAmount)) {
                        tempemployeePfdetailList.add(maxiAmount1);
                        tempemployeePfdetailList.add(maxiAmount1);
                        double Epf1 = 0;

                        Epf1 = (Double.parseDouble(pfAmount) * Double.parseDouble(pfPercentage) / 100);
                        tempemployeePfdetailList.add(Epf1);// epf wages calculate by 12 percentage of pf 
                        double Eps1 = 0;

                        if (Integer.parseInt(ages) <= diffYear) {
                            Eps1 = (maxiAmount1 * Double.parseDouble(epfPercentage) / 100);
                            tempemployeePfdetailList.add(Eps1);// epf wages calculate by 8.33 percentage of pf    
                        } else {
                            tempemployeePfdetailList.add(Eps1);
                        }
//                        Eps1 = (maxiAmount1 * Double.parseDouble(epfPercentage) / 100);
//                        tempemployeePfdetailList.add(Eps1);// epf wages calculate by 8.33 percentage of pf 
                        double diffEpsEpf = 0;
                        diffEpsEpf = Epf1 - Eps1;// 
                        tempemployeePfdetailList.add(diffEpsEpf);// different epf-eps

                    } else {
                        tempemployeePfdetailList.add(pfAmount);
                        tempemployeePfdetailList.add(pfAmount);
                        double Epf2 = 0;
                        Epf2 = (Double.parseDouble(pfAmount) * Double.parseDouble(pfPercentage) / 100);
                        tempemployeePfdetailList.add(Epf2);// epf wages calculate by 12 percentage of pf
                        double Eps2 = 0;
                        if (Integer.parseInt(ages) <= diffYear) {

                            Eps2 = (Double.parseDouble(pfAmount) * Double.parseDouble(epfPercentage) / 100);
                            tempemployeePfdetailList.add(Eps2);// epf wages calculate by 8.33 percentage of pf 
                        } else {
                            tempemployeePfdetailList.add(Eps2);
                        }

                        double diffEpsEpf1 = 0;
                        diffEpsEpf1 = Epf2 - Eps2;// 
                        tempemployeePfdetailList.add(diffEpsEpf1);// different epf-eps
                    }
                    String dateOfBirth = "12/04/1975";

//                    
                    tempemployeeSalaryDetail.add(tempemployeePfdetailList);

                }

            }

        }

//        double totalPfAmount = 0;
//        double totalePfAmount = 0;
//        double totalaPfAmount = 0;
//        Iterator itr = list.iterator();
//        while (itr.hasNext()) {
//            Object[] next = (Object[]) itr.next();
//            totalPfAmount += (Double) next[2];
//            totalePfAmount += (Double) next[3];
//            totalaPfAmount += (Double) next[4];
//        }
//
        request.setAttribute("employeelist", tempemployeeSalaryDetail);
//        request.setAttribute("totalPfAmount", totalPfAmount);
//        request.setAttribute("totalePfAmount", totalePfAmount);
//        request.setAttribute("totalaPfAmount", totalaPfAmount);
//        session.setAttribute("sessionTotalPfAmount", totalPfAmount);
//        session.setAttribute("sessionTotalePfAmount", totalePfAmount);
//        session.setAttribute("sessionTotalaPfAmount", totalaPfAmount);
//        session.setAttribute("employeePfcheckList", list);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchSalaryPfGovDetail(request, response);
        return mv;
    }
}
