/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.PolicyMaster;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class PolicyMasterController extends PolicyMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {
        ModelAndView mv = new ModelAndView("Policy/PolicyList", "policyMaster", policyMaster);
        List<?> policyList = policyMasterService.read();
        mv.addObject("policyList", policyList);
        return mv;

    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {

        return new ModelAndView("Policy/PolicyCreate", "policyMaster", policyMaster);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {
        BindException errors = new BindException(policyMaster, "policyMaster");
        bind(request, policyMaster);
        policyMasterValidator.validate(policyMaster, errors);
        ModelAndView mv = new ModelAndView();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Policy/PolicyCreate");
        } else {
            if (policyMasterService.isExist(policyMaster)) {
                policyMasterService.createOrUpdate(policyMaster);
                List<?> policyList = policyMasterService.read();
                mv.addObject("policyList", policyList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Policy/PolicyList");
            } else {
                mv.setViewName("Policy/PolicyCreate");
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
            }
        }
        mv.getModelMap().put("policyMaster", policyMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, PolicyMaster policyMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                policyMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    policyMaster = policyMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += policyMaster.getPolicyName();
                    } else {
                        checkStr += "," + policyMaster.getPolicyName();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            request.setAttribute("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            request.setAttribute("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:policyMaster.htm?act=showList");
        return mv;
    }
     public ModelAndView searchPolicyDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
        PolicyMaster policyMaster = new PolicyMaster();
        selectEmployee(request, response);
        policyList(request);
        mv.getModelMap().put("employeePolicyDetail", employeePolicyDetail);
        mv.setViewName("Payroll/PolicyReportSearch");
        return mv;
    }

    public ModelAndView searchFormPolicyDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String empId = request.getParameter("employeeMasterId");
        String type_of_policy = request.getParameter("policyId1");
        String month = request.getParameter("month");
        String year = request.getParameter("year11");

        HttpSession session = request.getSession();
//         
        if (!empId.equals("")) {
            employeeMaster.setAdharCard(empId);
        }

        if (!type_of_policy.equals("")) {
            employeeMaster.setBankIfscCode(type_of_policy);
        }

        if (!"".equals(month)) {
            employeeMaster.setBankAccountNo(month);
        }
        if (!"".equals(year)) {
            employeeMaster.setPanCard(year);
        }

        List<?> list = employeePolicyDetailService.readEmployeeForPolicy(employeeMaster);

        double totalpolicydeductionAmount = 0;

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalpolicydeductionAmount += (Double) next[3];
        }

        List<?> policyName = employeePolicyDetailService.readPolicyAName(Integer.parseInt(type_of_policy));

        request.setAttribute("employeelist", list);
        request.setAttribute("month", month);
        request.setAttribute("totalpolicydeductionAmount", totalpolicydeductionAmount);
        request.setAttribute("year", year);
        request.setAttribute("policyName", policyName);
        mv = searchPolicyDetail(request, response);
        return mv;
    }
}
