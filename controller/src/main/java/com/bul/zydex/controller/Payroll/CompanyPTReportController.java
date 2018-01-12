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
import com.bul.zydex.model.PayrollProfessionalTax;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OptiPlex
 */
public class CompanyPTReportController extends CompanyPTReportAbstract {

    public ModelAndView searchCompanyPTReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        mv.setViewName("Payroll/CompanyPTReport");
        return mv;
    }

    public ModelAndView onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        Double basicSalary = 0.0D;
        Double grossTotal = 0.0D;
        int numberOfEmployees = 0;
        Double totalProfessionalTaxAmount = 0.0D;
        List totalProfessionalTaxList = new ArrayList();
        int totalEmployee = 0;
        Double totalProfessionalTaxRupees = 0.0D;
        List listWithSearchParameters = new ArrayList();
        String companyName = "";
        List finalList = new ArrayList();
        int flag = 0;
        double additionalAmt = 0;
        double netSalary = 0;
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("employeeSubTypeId");
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year11");

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!month1.equals("")) {
            employeeMaster.setBankName(month1);

        }
        if (!year11.equals("")) {
            employeeMaster.setChild1(year11);

        }

        List<?> empList = (List<?>) employeeSalaryProcessService.readProfessionalTaxes(employeeMaster);

        List<?> professionalTaxList = (List<?>) payrollProfessionalTaxService.read();
        for (Object professionalTaxListObj : professionalTaxList) {
            List numberOfEmployessWithAmount = new ArrayList();

            PayrollProfessionalTax professionalTaxData = (PayrollProfessionalTax) professionalTaxListObj;
            numberOfEmployessWithAmount.add(professionalTaxData.getAmount());
            for (Object empWithSalaryObj : empList) {
                Object[] empWithSalary = (Object[]) empWithSalaryObj;
                companyName = (String) empWithSalary[2];
                basicSalary = (Double.parseDouble((String) empWithSalary[1]));
                grossTotal = (Double) ( empWithSalary[4]);
                int employeeSalaryProcessid = (Integer) empWithSalary[3];

                
                if (Double.parseDouble(professionalTaxData.getSalaryFrom()) <= grossTotal
                        && Double.parseDouble(professionalTaxData.getSalaryTo()) >= grossTotal) {
                    numberOfEmployees++;
                }

            }
            numberOfEmployessWithAmount.add(numberOfEmployees);
            totalProfessionalTaxAmount = numberOfEmployees * Double.parseDouble(professionalTaxData.getAmount());
            numberOfEmployessWithAmount.add(totalProfessionalTaxAmount);
            finalList.add(numberOfEmployessWithAmount);
            numberOfEmployees = 0;

        }

        for (int i = 0; i < finalList.size(); i++) {
            List tempTotalList = (List) finalList.get(i);
            totalEmployee = totalEmployee + (int) tempTotalList.get(1);
            totalProfessionalTaxRupees = totalProfessionalTaxRupees + (Double) tempTotalList.get(2);
        }
        totalProfessionalTaxList.add("Total");
        totalProfessionalTaxList.add(totalEmployee);
        totalProfessionalTaxList.add(totalProfessionalTaxRupees);
        finalList.add(totalProfessionalTaxList);
        for (int i = 0; i < finalList.size(); i++) {
            List tempFinalList = (List) finalList.get(i);
            if ((tempFinalList.get(1).equals(0) && tempFinalList.get(2).equals(0.0))) {
                flag++;
            }
        }

        listWithSearchParameters.add(finalList);
        listWithSearchParameters.add(month1);
        listWithSearchParameters.add(year11);
        listWithSearchParameters.add(type_of_employee);
        listWithSearchParameters.add(employee_sub_id);
        listWithSearchParameters.add(companyName);
        if (flag == finalList.size()) {
            listWithSearchParameters.add("empty");
        } else {
            listWithSearchParameters.add("not empty");
        }
        request.setAttribute("professionalTaxList", listWithSearchParameters);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);
        mv = searchCompanyPTReport(request, response);
        return mv;
    }

}
