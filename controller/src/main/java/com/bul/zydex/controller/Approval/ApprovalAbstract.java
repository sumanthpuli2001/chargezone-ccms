/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApprovalMaster;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.service.Approval.ApprovalMasterService;
import com.bul.zydex.service.Approval.ApprovalUserService;
import com.bul.zydex.service.emp.DepartmentMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.leave.LeaveTypeMasterService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vikas
 */
public class ApprovalAbstract extends CustomAbstract {

    protected ApprovalMasterService<ApprovalMaster> approvalMasterService;
    protected ApprovalUserService<ApprovalUser> approvalUserService;
    protected LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService;

    public ApprovalMasterService<ApprovalMaster> getApprovalMasterService() {
        return approvalMasterService;
    }

    public void setApprovalMasterService(ApprovalMasterService<ApprovalMaster> approvalMasterService) {
        this.approvalMasterService = approvalMasterService;
    }

    public ApprovalUserService<ApprovalUser> getApprovalUserService() {
        return approvalUserService;
    }

    public void setApprovalUserService(ApprovalUserService<ApprovalUser> approvalUserService) {
        this.approvalUserService = approvalUserService;
    }

    public LeaveTypeMasterService<LeaveTypeMaster> getLeaveTypeMasterService() {
        return leaveTypeMasterService;
    }

    public void setLeaveTypeMasterService(LeaveTypeMasterService<LeaveTypeMaster> leaveTypeMasterService) {
        this.leaveTypeMasterService = leaveTypeMasterService;
    }

    protected void departmentList(HttpServletRequest request) {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> depttList = departmentMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            departmentMaster = (DepartmentMaster) o;
            dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }

        request.setAttribute("deptMap", dm);
    }

    protected void designationList(HttpServletRequest request) {
        DesignationMaster designationMaster = new DesignationMaster();
        List<?> desigList = designationMasterService.read();
        Map<Integer, String> dn = new HashMap<>();
        for (Object o : desigList) {
            designationMaster = (DesignationMaster) o;
            dn.put(designationMaster.getId(), designationMaster.getDesignationName());
        }

        request.setAttribute("desigList", dn);
    }

    protected void readleaveType(HttpServletRequest request) {
        List list = leaveTypeMasterService.read();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        Map<Integer, String> leaveTypemap = new HashMap();
        for (Object o : list) {
            leaveTypeMaster = (LeaveTypeMaster) o;
            leaveTypemap.put(leaveTypeMaster.getId(), leaveTypeMaster.getLeaveType());
        }
        request.setAttribute("leaveTypemap11", leaveTypemap);
    }

    public void selectEmployeeForParticularManager(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        EmployeeMaster employee = (EmployeeMaster) session.getAttribute("employeeInfo");
        int id = employee.getId();
        List<?> list = employeeMasterService.readEmployeeForParticularManager(id);
        String tempStr = "[";
        Object[] arrayOfObject;

        EmployeeMaster employeeMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3]
                    + "  /" + arrayOfObject[4]
                    + "  /" + arrayOfObject[5] + "\"}";

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }

}
