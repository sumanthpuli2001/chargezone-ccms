/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.AdditionalAmountCheck;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.Payroll.AdditionalAmountCheckService;
import com.bul.zydex.service.Payroll.EmployeeAdditionalSalaryService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.Payroll.EmployeeExcelRecordService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.Payroll.EmployeeTypeWiseSalaryService;
import com.bul.zydex.service.Payroll.PayrollAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollDeductionService;
import com.bul.zydex.service.Payroll.PayrollLoanDetailService;
import com.bul.zydex.service.Payroll.PayrollPfCheckService;
import com.bul.zydex.service.Payroll.PayrollProfessionalTaxService;
import com.bul.zydex.service.Payroll.PayrollProvidentFundService;
import com.bul.zydex.service.Payroll.PayrollPtCheckService;
import com.bul.zydex.service.Payroll.PayrollRecurringAdditionalAmountService;
import com.bul.zydex.service.Payroll.PayrollRecurringDeductionService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
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
public class EsicDeductionStatementController extends EsicDeductionStatementAbstract {

    public ModelAndView searchEsicDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Payroll/EsicDeductionStatement");
        return mv;
    }

    public ModelAndView searchFormEmployeeEsicStatementDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        List<?> readEmployeeEsicStatementlist = employeeSalaryProcessService.readEmployeeForEsicStatement(employeeMaster);
        double totalgrossAmount = 0;
        Iterator itr = readEmployeeEsicStatementlist.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalgrossAmount += (Double) next[2];
        }
        double totalEmpContrubtionAmount = 0;
        Iterator itr1 = readEmployeeEsicStatementlist.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            totalEmpContrubtionAmount += (Double) next[3];
        }
        double totalCompContrubtionAmount = 0;
        Iterator itr2 = readEmployeeEsicStatementlist.iterator();
        while (itr2.hasNext()) {
            Object[] next = (Object[]) itr2.next();
            totalCompContrubtionAmount += (Double) next[4];
        }

        request.setAttribute("employeelist", readEmployeeEsicStatementlist);
        request.setAttribute("totalgrossAmount", totalgrossAmount);
        request.setAttribute("totalEmpContrubtionAmount", totalEmpContrubtionAmount);
        request.setAttribute("totalCompContrubtionAmount", totalCompContrubtionAmount);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchEsicDetail(request, response);
        return mv;
    }
     public ModelAndView searchEsicDetailGovt(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Payroll/EsicDeductionStatementGovt");
        return mv;
    }
      public ModelAndView searchFormEmployeeEsicStatementDetailSubmitGovt(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        List<?> readEmployeeEsicStatementlist = employeeSalaryProcessService.readEmployeeForEsicStatement(employeeMaster);
        double totalgrossAmount = 0;
        Iterator itr = readEmployeeEsicStatementlist.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalgrossAmount += (Double) next[2];
        }
        double totalEmpContrubtionAmount = 0;
        Iterator itr1 = readEmployeeEsicStatementlist.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            totalEmpContrubtionAmount += (Double) next[3];
        }
        double totalCompContrubtionAmount = 0;
        Iterator itr2 = readEmployeeEsicStatementlist.iterator();
        while (itr2.hasNext()) {
            Object[] next = (Object[]) itr2.next();
            totalCompContrubtionAmount += (Double) next[4];
        }

        request.setAttribute("employeelist", readEmployeeEsicStatementlist);
        request.setAttribute("totalgrossAmount", totalgrossAmount);
        request.setAttribute("totalEmpContrubtionAmount", totalEmpContrubtionAmount);
        request.setAttribute("totalCompContrubtionAmount", totalCompContrubtionAmount);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchEsicDetailGovt(request, response);
        return mv;
    }

}
