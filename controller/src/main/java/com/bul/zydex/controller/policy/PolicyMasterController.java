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
import com.bul.zydex.model.PolicyCreate;
import com.bul.zydex.model.PolicyDropDown;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.PolicyReadHistory;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

    public ModelAndView showPolicyList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();
        List<?> policyList = policyCreateService.readpolicyCreate();
        mv.getModel().put("list", policyList);
        mv.getModel().put("policyCreate", policyCreate);
        mv.setViewName("Policy/ShowPolicy");
        return mv;
    }

    public ModelAndView dashboardshowPolicy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();
        List<?> policyList = policyCreateService.readpolicyCreate();
        mv.getModel().put("list", policyList);
        mv.getModel().put("policyCreate", policyCreate);
        mv.setViewName("Policy/dashboardshowPolicy");
        return mv;
    }

    public ModelAndView policyCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();
        selectEmployee(request, response);
        policyDropDownList(request);
        mv.getModel().put("policyCreate", policyCreate);
        mv.setViewName("Policy/CreatePolicy");
        return mv;
    }

    public ModelAndView newCreateSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(policyCreate, "policyCreate");
        bind(request, policyCreate);
        String typePolicy = request.getParameter("policyId1");
        String attachment = request.getParameter("attachment");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        PolicyDropDown pdd = policyDropDownService.readById(Integer.parseInt(typePolicy));

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("attachment");
        String fileLocationURL2 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "policyAttachment" + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "policyAttachment" + File.separator;
        File Folder1 = new File(fileLocationURL2);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL2 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                policyCreate.setAttachment(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }

        policyCreate.setPolicyDropDown(pdd);
        policyCreate.setStatus(0);
        policyCreate.setCreatedDate(sdf.format(cDate));
        policyCreate.setCreatedBy(employeeMaster.getEmployeeName());
        policyCreateService.create(policyCreate);
        request.setAttribute("successMessage",
                "Info : Records are create successfully.");
        mv.getModel().put("policyCreate", policyCreate);
        mv.setViewName("Policy/CreatePolicy");
        mv = showPolicyList(request, response);
        return mv;
    }

    public ModelAndView editClickSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(policyCreate, "policyCreate");
        bind(request, policyCreate);
        String typePolicy = request.getParameter("policyId1");
        String attachment = request.getParameter("attachment");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        PolicyCreate ttd = policyCreateService.readById(policyCreate.getId());

        PolicyDropDown pdd = policyDropDownService.readById(Integer.parseInt(typePolicy));

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("attachment");
        String fileLocationURL2 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "policyAttachment" + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "policyAttachment" + File.separator;
        File Folder1 = new File(fileLocationURL2);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL2 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                policyCreate.setAttachment(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }

        policyCreate.setPolicyDropDown(pdd);
        policyCreate.setStatus(1);
        policyCreate.setAttachment(attachment);
        policyCreate.setCreatedDate(ttd.getCreatedDate());
        policyCreate.setCreatedBy(ttd.getCreatedBy());
        policyCreate.setUpdatedDate(sdf.format(cDate));
        policyCreate.setUpdatedBy(employeeMaster.getEmployeeName());
        policyCreateService.update(policyCreate);
        request.setAttribute("successMessage",
                "Info : Records are updated successfully.");
        mv.getModel().put("policyCreate", policyCreate);
        mv.setViewName("Policy/CreatePolicy");
        mv = showPolicyList(request, response);
        return mv;
    }

    public ModelAndView editClickView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();
        selectEmployee(request, response);
        policyDropDownList(request);
        String id = request.getParameter("id");
        policyCreate = policyCreateService.readById(Integer.parseInt(id));
        mv.getModel().put("policyCreate", policyCreate);
        mv.setViewName("Policy/EditViewPolicy");
        return mv;
    }

    public ModelAndView readViewDasPolicy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cDate = new Date();
        PolicyReadHistory policyReadHistory = new PolicyReadHistory();
        PolicyReadHistory policyReadHistory1 = new PolicyReadHistory();
        PolicyReadHistory policyReadHistory2 = new PolicyReadHistory();
//        PolicyCreate policyCreate = new PolicyCreate();
        selectEmployee(request, response);
        policyDropDownList(request);
        String id = request.getParameter("id");
        PolicyCreate policyCreate = policyCreateService.readById(Integer.parseInt(id));
        policyCreate.setStatus(2);
        policyCreate.setReadBy(employeeMaster.getEmployeeName());
        policyCreate.setReadDate(sdf.format(cDate));
        policyCreateService.update(policyCreate);

        try {
//            policyReadHistory1 = policyReadHistoryService.policyReadCheck(employeeMaster.getEmployeeName());
//            if (policyReadHistory1.getPolicyReadStatus() != 1) {
//                policyReadHistory.setPolicyId(Integer.parseInt(id));
//                policyReadHistory.setReaderBy(employeeMaster.getEmployeeName());
//                policyReadHistory.setReaderDate(sdf.format(cDate));
//                policyReadHistory.setPolicyAcept(0);
//                policyReadHistory.setPolicyReadStatus(1);
//                policyReadHistoryService.create(policyReadHistory);
//            } else {
            policyReadHistory2 = policyReadHistoryService.policyReadCheck(employeeMaster.getEmployeeName());
            if (policyReadHistory2 == null) {
                policyReadHistory.setPolicyId(Integer.parseInt(id));
                policyReadHistory.setReaderBy(employeeMaster.getEmployeeName());
                policyReadHistory.setReaderDate(sdf.format(cDate));
                policyReadHistory.setPolicyAcept(0);
                policyReadHistory.setPolicyReadStatus(1);
                policyReadHistoryService.create(policyReadHistory);
            } else {
                policyReadHistory1 = policyReadHistoryService.policyReadCheck(employeeMaster.getEmployeeName());
                if (policyReadHistory1.getPolicyReadStatus() != 1) {
                    policyReadHistory.setPolicyId(Integer.parseInt(id));
                    policyReadHistory.setReaderBy(employeeMaster.getEmployeeName());
                    policyReadHistory.setReaderDate(sdf.format(cDate));
                    policyReadHistory.setPolicyAcept(0);
                    policyReadHistory.setPolicyReadStatus(1);
                    policyReadHistoryService.create(policyReadHistory);
                }
            }

        } catch (Exception e) {

        }

        mv.getModel().put("policyCreate", policyCreate);
        mv.getModel().put("employeeMaster", employeeMaster);
        mv.setViewName("Policy/ReadViewPolicy");
        return mv;
    }

    public ModelAndView policyAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cDate = new Date();
        selectEmployee(request, response);
        policyDropDownList(request);

        PolicyReadHistory policyReadHistory = new PolicyReadHistory();
        policyReadHistory = policyReadHistoryService.policyReadCheck(employeeMaster.getEmployeeName());

        policyReadHistory.setPolicyAcept(1);
        policyReadHistory.setPolicyAceptTime(sdf.format(cDate));
        policyReadHistoryService.update(policyReadHistory);

        mv = dashboardshowPolicy(request, response);
        return mv;
    }

    public ModelAndView policydeleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {

                PolicyReadHistory prh = new PolicyReadHistory();
                List<?> list = policyCreateService.deletepolicy(z);
                for (Object object : list) {
                    prh = (PolicyReadHistory) object;
                    policyReadHistoryService.delete(prh.getId());
                }

                policyCreateService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showPolicyList(request, response);
        return mv;
    }

    public void downloadAttachment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        PolicyCreate pc = policyCreateService.readById(Integer.parseInt(id));
        String attachment = pc.getAttachment();

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "policyAttachment" + File.separator + attachment;

        request.setAttribute("filePath", fileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView policyReport(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        PolicyCreate policyCreate = new PolicyCreate();

        List<?> policyListName = policyCreateService.read();
        Map<Integer, String> poilnm = new HashMap<>();
        for (Object o : policyListName) {
            policyCreate = (PolicyCreate) o;
            poilnm.put(policyCreate.getId(), policyCreate.getName());
        }
        mv.getModelMap().put("policyName", poilnm);
        mv.getModelMap().put("policyCreate", policyCreate);
        mv.setViewName("Policy/PolicyReport");
        return mv;
    }

    public ModelAndView policyReportGet(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String policyId1 = request.getParameter("policyId1");
        if (policyId1 != "") {
            PolicyCreate policyCreate = new PolicyCreate();
            PolicyCreate pc = policyCreateService.readById(Integer.parseInt(policyId1));
            List<?> policylist = policyReadHistoryService.readPolicyId(Integer.parseInt(policyId1));
            request.setAttribute("pc", pc);
            request.setAttribute("list", policylist);
            mv.getModelMap().put("policyCreate", policyCreate);
        } else {
            request.setAttribute("failureMessage",
                    "Info : Please Select Policy Type.");
        }
        mv = policyReport(request, response);
        return mv;
    }

}
