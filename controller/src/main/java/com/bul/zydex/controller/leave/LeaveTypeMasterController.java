/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class LeaveTypeMasterController extends LeaveTypeMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        DepartmentMaster departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
        leaveTypeMaster.setDepartmentMaster(departmentMaster);
        mv.getModelMap().put("leaveTypeMaster", leaveTypeMaster);
        mv.setViewName("Leave/LeaveTypeCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        BindException errors = new BindException(leaveTypeMaster, "leaveTypeMaster");
        bind(request, leaveTypeMaster);
        leaveTypeMasterValidator.validate(leaveTypeMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Leave/LeaveTypeCreate");
        } else {
            DepartmentMaster departmentMaster = departmentMasterService.readById(Integer.parseInt(request.getParameter("DeptID")));
            leaveTypeMaster.setDepartmentMaster(departmentMaster);
            leaveTypeMasterService.create(leaveTypeMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.setViewName("redirect:leaveTypeMaster.htm?act=searchSubmit");
        }

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        List<?> leaveTypeList = leaveTypeMasterService.read();

        mv.getModelMap().put("list", leaveTypeList);
        mv.getModelMap().put("leaveTypeMaster", leaveTypeMaster);
        mv.setViewName("Leave/LeaveTypeMasterResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        String id = request.getParameter("id");
        leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("leaveTypeMaster", leaveTypeMaster);
        mv.setViewName("Leave/LeaveTypeMasterView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        BindException errors = new BindException(leaveTypeMaster, "leaveTypeMaster");
        leaveTypeMaster.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, leaveTypeMaster);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        DepartmentMaster departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
        leaveTypeMaster.setDepartmentMaster(departmentMaster);
        leaveTypeMasterValidator.validate(leaveTypeMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            leaveTypeMasterService.update(leaveTypeMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);
        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String leaveTypeId[] = request.getParameterValues("checkId");
        for (String z : leaveTypeId) {
            try {
                leaveTypeMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView leaveExcelUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Leave/LeaveExcelUpload");
        return mv;
    }

    public void readLeaveUploadFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "LeaveExcelUpload" + File.separator + fileName;

        String appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView leaveExcelUploadSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file1");
        String employeeNo = "";
        String casualLeave = "";
        String sickLeave = "";
        String privilegeLeave = "";
        String paternityLeave = "";
        int count = 0;
        String cl = "Casual Leave";
        String sl = "Sick Leave";
        String pl = "Privilege Leave";
        String ptl = "Paternity Leave";
        float cLeave = 0;
        float sLeave = 0;
        float pLeave = 0;
        float ptLeave = 0;
        String countEmpId = "";

        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
        LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
        LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
        List<?> clList = leaveTypeMasterService.readLeaveType(cl);
        List<?> slList = leaveTypeMasterService.readLeaveType(sl);
        List<?> plList = leaveTypeMasterService.readLeaveType(pl);
        List<?> ptlList = leaveTypeMasterService.readLeaveType(ptl);
        if (!clList.isEmpty()) {
            Integer id = (Integer) clList.get(0);
            leaveTypeMaster = leaveTypeMasterService.readById(id);
//            leaveTypeMaster = (LeaveTypeMaster) clList.get(0);
        }
        if (!slList.isEmpty()) {
            Integer id1 = (Integer) slList.get(0);
            leaveTypeMaster1 = leaveTypeMasterService.readById(id1);
//            leaveTypeMaster1 = (LeaveTypeMaster) slList.get(0);
        }
        if (!plList.isEmpty()) {
            Integer id2 = (Integer) plList.get(0);
            leaveTypeMaster2 = leaveTypeMasterService.readById(id2);
//            leaveTypeMaster2 = (LeaveTypeMaster) plList.get(0);
        }
        if (!ptlList.isEmpty()) {
            Integer id3 = (Integer) ptlList.get(0);
            leaveTypeMaster3 = leaveTypeMasterService.readById(id3);
//            leaveTypeMaster3 = (LeaveTypeMaster) ptlList.get(0);
        }

        try {
            if (multipartFile.getSize() > 0) {
                InputStream file = multipartFile.getInputStream();
                Workbook workbook = WorkbookFactory.create(file);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    if (row.getRowNum() != 0) {
                        try {
                            employeeNo = new BigDecimal("" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0))).toPlainString();
                            employeeNo = employeeNo.split("\\.", 2)[0];
                        } catch (Exception e) {
                            employeeNo = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                        }
                        casualLeave = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
                        sickLeave = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
                        privilegeLeave = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
                        paternityLeave = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));

                        if (!casualLeave.equals("")) {
                            cLeave = Float.parseFloat(casualLeave);
                        }
                        if (!sickLeave.equals("")) {
                            sLeave = Float.parseFloat(sickLeave);
                        }
                        if (!privilegeLeave.equals("")) {
                            pLeave = Float.parseFloat(privilegeLeave);
                        }
                        if (!paternityLeave.equals("")) {
                            ptLeave = Float.parseFloat(paternityLeave);
                        }

                        EmployeeMaster employeeMaster = new EmployeeMaster();
                        int empNo = Integer.parseInt(employeeNo);
                        List<?> list = employeeMasterService.readByEmployeeNo(empNo);
                        if (!list.isEmpty()) {
                            employeeMaster = (EmployeeMaster) list.get(0);
                            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                            EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                            EmployeeLeaveBalance employeeLeaveBalance4 = new EmployeeLeaveBalance();
                            if (!casualLeave.equals("")) {
                                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                employeeLeaveBalance.setNoOfLeaveRemain(Float.parseFloat(casualLeave));
                            }
                            if (!sickLeave.equals("")) {
                                employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster1);
                                employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(sickLeave));
                            }
                            if (!privilegeLeave.equals("")) {
                                employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                employeeLeaveBalance2.setLeaveTypeMaster(leaveTypeMaster2);
                                employeeLeaveBalance2.setNoOfLeaveRemain(Float.parseFloat(privilegeLeave));
                            }

                            if (!paternityLeave.equals("")) {
                                employeeLeaveBalance4.setEmployeeMaster(employeeMaster);
                                employeeLeaveBalance4.setLeaveTypeMaster(leaveTypeMaster3);
                                employeeLeaveBalance4.setNoOfLeaveRemain(Float.parseFloat(paternityLeave));
                            }
                            if (!casualLeave.equals("")) {
                                if (cLeave <= 7) {
                                    List<?> list1 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                    if (!list1.isEmpty()) {
                                        EmployeeLeaveBalance employeeLeaveBalance3 = (EmployeeLeaveBalance) list1.get(0);
                                        employeeLeaveBalance.setId(employeeLeaveBalance3.getId());
                                        employeeLeaveBalanceService.update(employeeLeaveBalance);
                                        employeeLeaveBalance3 = null;
                                    } else {
                                        employeeLeaveBalanceService.create(employeeLeaveBalance);
                                    }
                                }
                            }
                            if (!sickLeave.equals("")) {
                                if (sLeave <= 7) {

                                    List<?> list2 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                    if (!list2.isEmpty()) {
                                        EmployeeLeaveBalance employeeLeaveBalance3 = (EmployeeLeaveBalance) list2.get(0);
                                        employeeLeaveBalance1.setId(employeeLeaveBalance3.getId());
                                        employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                        employeeLeaveBalance3 = null;
                                    } else {
                                        employeeLeaveBalanceService.create(employeeLeaveBalance1);
                                    }
                                }
                            }
                            if (!privilegeLeave.equals("")) {
                                if (pLeave <= 60) {

                                    List<?> list3 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                    if (!list3.isEmpty()) {
                                        EmployeeLeaveBalance employeeLeaveBalance3 = (EmployeeLeaveBalance) list3.get(0);
                                        employeeLeaveBalance2.setId(employeeLeaveBalance3.getId());
                                        employeeLeaveBalanceService.update(employeeLeaveBalance2);
                                        employeeLeaveBalance3 = null;
                                    } else {
                                        employeeLeaveBalanceService.create(employeeLeaveBalance2);
                                    }
                                }
                            }

                            if (!paternityLeave.equals("")) {
                                if (ptLeave <= 6) {

                                    List<?> list4 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance4);
                                    if (!list4.isEmpty()) {
                                        EmployeeLeaveBalance employeeLeaveBalance3 = (EmployeeLeaveBalance) list4.get(0);
                                        employeeLeaveBalance4.setId(employeeLeaveBalance3.getId());
                                        employeeLeaveBalanceService.update(employeeLeaveBalance4);
                                        employeeLeaveBalance3 = null;
                                    } else {
                                        employeeLeaveBalanceService.create(employeeLeaveBalance4);
                                    }
                                }
                            }

                        } else {
                            count++;
                            countEmpId += employeeNo + ",";
                        }

                    }
                }
            }
            request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
            if (count > 0) {
                request.setAttribute("failureMessage", "Information : " + countEmpId + " Rcecords Not Inserted Due To Employe No Is Not Correct");
            }
            mv = leaveExcelUpload(request, response);
        } catch (Exception e) {
            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
            mv = leaveExcelUpload(request, response);
        }
        return mv;
    }
}
