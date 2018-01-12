/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanType;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nishant
 */
public class PayrollLoanTypeController extends PayrollLoanTypeAbstract {

    public ModelAndView showResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list = payrollLoanTypeService.read();
        request.setAttribute("list", list);
        mv.setViewName("Payroll/PayrollLoanTypeShow");

        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        mv.getModelMap().put("payrollLoanType", payrollLoanType);
        mv.setViewName("Payroll/PayrollLoanTypeCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        BindException errors = new BindException(payrollLoanType, "payrollLoanType");
        bind(request, payrollLoanType);
        payrollLoanTypeValidator.validate(payrollLoanType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("payrollLoanType", payrollLoanType);
            mv.setViewName("Payroll/PayrollLoanTypeCreate");

        } else {
            if (!payrollLoanTypeService.isExist(payrollLoanType)) {
                payrollLoanTypeService.create(payrollLoanType);
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
                mv = showResult(request, response);

            } else {
                request.setAttribute("failureMessage",
                        "Error : The Loan Type is already there.");
                mv.setViewName("Payroll/PayrollLoanTypeCreate");
                mv.getModelMap().put("payrollLoanType", payrollLoanType);
            }

//        return mv;
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                payrollLoanTypeService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResult(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        String id = request.getParameter("id");
        payrollLoanType = payrollLoanTypeService.readById(Integer.parseInt(id));
        mv.getModelMap().put("payrollLoanType", payrollLoanType);
        mv.setViewName("Payroll/PayrollLoanTypeEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        BindException errors = new BindException(payrollLoanType, "payrollLoanType");
//        payrollSavingType.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, payrollLoanType);
        payrollLoanTypeValidator.validate(payrollLoanType, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            if (!payrollLoanTypeService.isExist(payrollLoanType)) {
                payrollLoanTypeService.update(payrollLoanType);
                request.setAttribute("successMessage",
                        "Information : The Information is Updated Successfully.");
                mv = showResult(request, response);
            } else {
                request.setAttribute("failureMessage",
                        "Error : The Loan Type is already there.");
                mv.setViewName("Payroll/PayrollLoanTypeEdit");
                mv.getModelMap().put("payrollLoanType", payrollLoanType);
            }

//        return mv;
        }
        return mv;
    }

    public ModelAndView showResultLoanDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanDetail payrollLoanDetail = new PayrollLoanDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        List<?> payrollLoanDetaillist = payrollLoanDetailService.read();
        for (Object obj : payrollLoanDetaillist) {
            payrollLoanDetail = (PayrollLoanDetail) obj;
            employeeMaster = employeeMasterService.readById(payrollLoanDetail.getEmployeeMaster().getId());
            payrollLoanDetail.setEmployeeMaster(employeeMaster);
            PayrollLoanType payrollLoanType1 = payrollLoanDetail.getPayrollLoanType();
            payrollLoanType = payrollLoanTypeService.readById(payrollLoanType1.getId());
            payrollLoanDetail.setPayrollLoanType(payrollLoanType);
        }
        request.setAttribute("payrollLoanDetaillist", payrollLoanDetaillist);
        mv.setViewName("Payroll/PayrollLoanDetail");

        return mv;

    }

    public ModelAndView createClickLoanDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanDetail payrollLoanDetail = new PayrollLoanDetail();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        PayrollLoanTypeList(request);
        payrollLoanDetail.setEmployeeMaster(new EmployeeMaster());
        payrollLoanDetail.setPayrollLoanType(new PayrollLoanType());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("payrollLoanDetail", payrollLoanDetail);
        mv.setViewName("Payroll/PayrollLoanDetailCreate");
        return mv;
    }
//}

    public ModelAndView createSubmitLoanDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanDetail payrollLoanDetail = new PayrollLoanDetail();

        BindException errors = new BindException(payrollLoanDetail, "payrollLoanDetail");
        bind(request, payrollLoanDetail);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeMasterId");
        if (null != empId && !"".equals(empId)) {
            employeeMaster.setId(Integer.parseInt(empId));
            payrollLoanDetail.setEmployeeMaster(employeeMaster);
        } else {
            payrollLoanDetail.setEmployeeMaster(new EmployeeMaster());
        }
        selectEmployee(request, response);
        PayrollLoanTypeList(request);
        payrollLoanTypeDetailsValidator.validate(payrollLoanDetail, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The payrollLoanDetail is not valid. NO white Space");
//            mv.addAllObjects(errors.getModel());
            mv = createClickLoanDetail(request, response);
        } else {
            boolean isExist = payrollLoanDetailService.isExist(payrollLoanDetail);
            if (isExist) {
                payrollLoanDetailService.create(payrollLoanDetail);
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
            } else {
                request.setAttribute("failureMessage",
                        "Error : Information Is Already Exist.");
            }
            mv = showResultLoanDetail(request, response);
        }

//        payrollLoanDetailService.create(payrollLoanDetail);
//        request.setAttribute("successMessage",
//                "Information : The Information is saved Successfully.");
//        }
//
        return mv;
    }

    public ModelAndView viewClickLoanDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanDetail payrollLoanDetail = new PayrollLoanDetail();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");

        payrollLoanDetail = payrollLoanDetailService.readById(Integer.parseInt(id));
        employeeMaster = employeeMasterService.readById(payrollLoanDetail.getEmployeeMaster().getId());
        payrollLoanDetail.setEmployeeMaster(employeeMaster);
        PayrollLoanType payrollLoanType1 = payrollLoanDetail.getPayrollLoanType();
        payrollLoanType = payrollLoanTypeService.readById(payrollLoanType1.getId());
        payrollLoanDetail.setPayrollLoanType(payrollLoanType);
        PayrollLoanTypeList(request);
        mv.getModelMap().put("payrollLoanDetail", payrollLoanDetail);
        mv.setViewName("Payroll/PayrollLoanDetailEdit");
        return mv;
    }

    public ModelAndView editSubmitLoanDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PayrollLoanDetail payrollLoanDetail = new PayrollLoanDetail();
        BindException errors = new BindException(payrollLoanDetail, "payrollLoanDetail");
        bind(request, payrollLoanDetail);
        payrollLoanTypeDetailsValidator.validate(payrollLoanDetail, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The payrollLoanDetail is not valid. NO white Space");
//            mv.addAllObjects(errors.getModel());
            mv = viewClickLoanDetail(request, response);
        } else {
            payrollLoanDetailService.update(payrollLoanDetail);
            request.setAttribute("successMessage",
                    "Information: The Loan Details  is Updated successfully");
            mv = showResultLoanDetail(request, response);
//        }
        }
            return mv;

    }

    

    public ModelAndView deleteSubmitLoanDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                payrollLoanDetailService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showResultLoanDetail(request, response);
        return mv;
    }

}
