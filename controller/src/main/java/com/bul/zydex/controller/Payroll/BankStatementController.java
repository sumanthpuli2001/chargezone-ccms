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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hussain
 */
public class BankStatementController extends BankStatementAbstract {

    public ModelAndView searchBankStatementDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Payroll/BankStatementDetails");
        return mv;
    }

    public ModelAndView searchFormEmployeeBankStatementDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        int sum = 0;
        List listForMonthAndYear = new ArrayList();
        List<?> list = employeeSalaryProcessService.readEmployeeForBankStatement(employeeMaster);
        if (!list.isEmpty()) {

            for (Object dedSalaryList1 : list) {
                List finalList = new ArrayList();
                DecimalFormat df = new DecimalFormat("####0.00");
                Object[] o = (Object[]) dedSalaryList1;
                double basicSalary = 0;
                int empid = 0;
                String employeeId = (String) o[0];
                String employeeName = (String) o[1];
                String bankAccountNo = (String) o[2];
                basicSalary += (Double) o[3];
                String month1 = (String) o[4];
                String year1 = (String) o[5];
                empid += (Integer) o[6];
                finalList.add(employeeId);
                finalList.add(employeeName);
                finalList.add(bankAccountNo);

                double additionalAmt = 0;
                List<?> additionalAmount = employeeAdditionalSalaryService.readAdditionalAmount(empid);
                if (!additionalAmount.isEmpty()) {
                    additionalAmt = (Double) additionalAmount.get(0);
                }
                double netSalary = (int) Math.round(basicSalary + additionalAmt);

                double deductionAmt1 = 0;
                List<?> deductionAmountList1 = employeeDeductionAmountService.readDeductionAmount(empid);
                if (!deductionAmountList1.isEmpty()) {
                    deductionAmt1 = (Double) deductionAmountList1.get(0);
                }
                double netpayable = netSalary - deductionAmt1;
                int netpayable1 = (int) Math.round(netpayable);

                sum = sum + netpayable1;
                finalList.add(df.format(netpayable1));
                finalList.add(month1);
                finalList.add(year1);
                listForMonthAndYear.add(finalList);
            }

        }

        request.setAttribute("employeelist", listForMonthAndYear);
        session.setAttribute("employeePfcheckList", listForMonthAndYear);
        session.setAttribute("sum", sum);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchBankStatementDetail(request, response);
        return mv;
    }

}
