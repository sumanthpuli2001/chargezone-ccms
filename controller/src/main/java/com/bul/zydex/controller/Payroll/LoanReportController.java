/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeTypeMaster;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OptiPlex
 */
public class LoanReportController extends LoanReportAbstract {

    public ModelAndView searchLoanData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
        selectEmployee(request, response);
        loanTypeList(request);
        departmentList(request);
        mv.getModelMap().put("employeePolicyDetail", employeePolicyDetail);
        mv.setViewName("Payroll/LoanReport");
        return mv;
    }

//    public ModelAndView onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        List loanListOfAllEmployees = new ArrayList();
//        String employeeId = request.getParameter("employeeMasterId");
//        String loanTypeId = request.getParameter("loanType");
//        String month = request.getParameter("month");
//        String year = request.getParameter("year11");
//        String departmentId = request.getParameter("departmentId");
//        Double totalOfInstAndInterest = 0.0D;
//        Double openBalance = 0.0D;
//        String company = "";
//        Double totalInstallmentAmount = 0.0D;
//        Double totalInterestAmount = 0.0D;
//        Double total = 0.0D;
//        Double totalClearBalance = 0.0D;
//        List listOfEmployeeeLoanDetails = new ArrayList();
//        Double doubleLoanAmt = 0.0D;
//        Double doubleinstallmentAmt = 0.0D;
//        Double interestRate = 0.0D;
//
//        List totalList = new ArrayList();
//        DepartmentMaster deptMaster = new DepartmentMaster();
//
//        if (!employeeId.equals("")) {
//            employeeMaster.setId(Integer.parseInt(employeeId));
//        }
//        if (null != loanTypeId && !loanTypeId.equals("")) {
//            employeeMaster.setCityOfEmployee(loanTypeId);
//        }
//
//        if (!month.equals("")) {
//            employeeMaster.setChild1(month);
//        }
//        if (!year.equals("")) {
//            employeeMaster.setChild2(year);
//        }
//
//        if (departmentId.equals("") || null == departmentId) {
//            deptMaster.setId(0);
//        } else {
//            deptMaster.setId(Integer.parseInt(departmentId));
//        }
//        employeeMaster.setDepartmentMaster(deptMaster);
////        String loanDatatype = "";
////        if (!loanTypeId.equals("")) {
//
//            List<?> loanDatatype = payrollLoanDetailService.getLoanName(loanTypeId);
////        }
//         
//
//        List<?> loanData = payrollLoanRemainingAmountService.getPayrollLoanDetails(employeeMaster);
//
//        Iterator itr = loanData.iterator();
//        while (itr.hasNext()) {
//            Object[] next = (Object[]) itr.next();
//            openBalance += (Double) next[3];
//            totalInstallmentAmount += (Double) next[4];
//            totalInterestAmount += (Double) next[5];
//            totalOfInstAndInterest += (Double) next[6];
//            totalClearBalance += (Double) next[7];
//        }
//
//        request.setAttribute("loanList", loanData);
//        request.setAttribute("openBalance", openBalance);
//        request.setAttribute("totalInstallmentAmount", totalInstallmentAmount);
//        request.setAttribute("totalInterestAmount", totalInterestAmount);
//        request.setAttribute("totalOfInstAndInterest", totalOfInstAndInterest);
//        request.setAttribute("totalClearBalance", totalClearBalance);
//        request.setAttribute("loanDatatype", loanDatatype);
//        request.setAttribute("month", month);
//        request.setAttribute("year", year);
//        mv = searchLoanData(request, response);
//        return mv;
//    }
//    
    public ModelAndView onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List loanListOfAllEmployees = new ArrayList();
        String employeeId = request.getParameter("employeeMasterId");
        String loanTypeId = request.getParameter("loanType");
        String month = request.getParameter("month");
        String year = request.getParameter("year11");
        String departmentId = request.getParameter("departmentId");
        Double totalOfInstAndInterest = 0.0D;
        Double openBalance = 0.0D;
        String company = "";
        Double totalInstallmentAmount = 0.0D;
        Double totalInterestAmount = 0.0D;
        Double total = 0.0D;
        Double totalClearBalance = 0.0D;
        List listOfEmployeeeLoanDetails = new ArrayList();
        Double doubleLoanAmt = 0.0D;
        Double doubleinstallmentAmt = 0.0D;
        Double interestRate = 0.0D;
  Double doctor = 0.0;
        List totalList = new ArrayList();
        DepartmentMaster deptMaster = new DepartmentMaster();

        if (!employeeId.equals("")) {
            employeeMaster.setId(Integer.parseInt(employeeId));
        }
        if (null != loanTypeId && !loanTypeId.equals("")) {
            employeeMaster.setCityOfEmployee(loanTypeId);
        }

        if (!month.equals("")) {
            employeeMaster.setChild1(month);
        }
        if (!year.equals("")) {
            employeeMaster.setChild2(year);
        }

        if (departmentId.equals("") || null == departmentId) {
            deptMaster.setId(0);
        } else {
            deptMaster.setId(Integer.parseInt(departmentId));
        }
        employeeMaster.setDepartmentMaster(deptMaster);

        List<?> loanDatatype = payrollLoanDetailService.getLoanName(loanTypeId);
        List<?> loanDepartmentWise = payrollLoanRemainingAmountService.readByloanDepartment(month, year);
        List<?> loanData = payrollLoanRemainingAmountService.getPayrollLoanDetails(employeeMaster);
        List deptList = new ArrayList();

        List finallist2 = new ArrayList();
        List tempDepartmentList = new ArrayList();
        List finallist8 = new ArrayList();
        List finallist9 = new ArrayList();

        for (Object loanDepartmentWiseObject : loanDepartmentWise) {
            Object[] loanDepartmentWise1 = (Object[]) loanDepartmentWiseObject;
            if (!deptList.contains(loanDepartmentWise1[1])) {
                deptList.add(loanDepartmentWise1[1]);
            }
        }

        String deptmt = "";
        int count = 0;
        for (int i = 0; i < loanDepartmentWise.size(); i++) {
            String prev = "";
            Object[] individualList = (Object[]) loanDepartmentWise.get(i);
            if (i != 0) {
                Object[] prevList = (Object[]) loanDepartmentWise.get(i - 1);
                deptmt = prevList[1].toString();
            }
            if (i == 0) {
                Object[] prevList = (Object[]) loanDepartmentWise.get(i);
                prev = prevList[1].toString();
            }
            String currentdptm = individualList[1].toString();//state
            List finalList3 = new ArrayList();
            if (!tempDepartmentList.contains(currentdptm)) {
                List finallist = new ArrayList();

                finallist.add(currentdptm);
              
                for (int j = 0; j < loanData.size(); j++) {
                    Object[] compareList = (Object[]) loanData.get(j);
                    if (currentdptm.equalsIgnoreCase(compareList[11].toString())) {
                        List deptwiseEmployee = new ArrayList();
                        deptwiseEmployee.add(compareList[0]);
                        deptwiseEmployee.add(compareList[1]);
                        deptwiseEmployee.add(compareList[2]);
                        deptwiseEmployee.add(compareList[3]);
                        deptwiseEmployee.add(compareList[4]);
                        deptwiseEmployee.add(compareList[5]);
                        deptwiseEmployee.add(compareList[6]);
                        deptwiseEmployee.add(compareList[7]);
                        deptwiseEmployee.add(compareList[8]);
                        deptwiseEmployee.add(compareList[9]);
                        deptwiseEmployee.add(compareList[10]);
                        deptwiseEmployee.add(compareList[11]);
                        doctor = doctor + (Double) compareList[6];
                      
                        tempDepartmentList.add(currentdptm);
                        finalList3.add(deptwiseEmployee);
                    }
                }
                finallist.add(finalList3);
                finallist8.add(finallist);
            }

        }

        finallist9.add(finallist8);
        Iterator itr = loanData.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            openBalance += (Double) next[3];
            totalInstallmentAmount += (Double) next[4];
            totalInterestAmount += (Double) next[5];
            totalOfInstAndInterest += (Double) next[6];
            totalClearBalance += (Double) next[7];
        }

        request.setAttribute("loanList", finallist9);
        request.setAttribute("openBalance", openBalance);
        request.setAttribute("totalInstallmentAmount", totalInstallmentAmount);
        request.setAttribute("totalInterestAmount", totalInterestAmount);
        request.setAttribute("totalOfInstAndInterest", totalOfInstAndInterest);
        request.setAttribute("totalClearBalance", totalClearBalance);
        request.setAttribute("loanDatatype", loanDatatype);
        request.setAttribute("doctor", doctor);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchLoanData(request, response);
        return mv;
    }
}
