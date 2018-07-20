/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProjectManagement;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ClientMaster;
import com.bul.zydex.model.CreateTask;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PriorityMaster;
import com.bul.zydex.model.ProjectManagementMaster;
import com.bul.zydex.model.StateMaster;
import com.bul.zydex.model.TaskEmployeeDepartment;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.ProjectManagement.ClientMasterService;
import com.bul.zydex.service.ProjectManagement.CreateTaskService;
import com.bul.zydex.service.ProjectManagement.PriorityMasterService;
import com.bul.zydex.service.ProjectManagement.ProjectManagementService;
import com.bul.zydex.service.ProjectManagement.StateMasterService;
import com.bul.zydex.service.ProjectManagement.TaskEmployeeDepartmentService;
import com.bul.zydex.service.emp.DepartmentMasterService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aman
 */
public class ProjectManagementAbstract extends CustomAbstract {

    protected ProjectManagementService<ProjectManagementMaster> projectManagementService;
    protected ClientMasterService<ClientMaster> clientMasterService;
    protected StateMasterService<StateMaster> stateMasterService;
    protected PriorityMasterService<PriorityMaster> priorityMasterService;
    protected ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;
    protected DepartmentMasterService<DepartmentMaster> departmentMasterService;
    protected CreateTaskService<CreateTask> createTaskService;
    protected TaskEmployeeDepartmentService<TaskEmployeeDepartment> taskEmployeeDepartmentService;

    public ProjectManagementService<ProjectManagementMaster> getProjectManagementService() {
        return projectManagementService;
    }

    public void setProjectManagementService(ProjectManagementService<ProjectManagementMaster> projectManagementService) {
        this.projectManagementService = projectManagementService;
    }

    public ClientMasterService<ClientMaster> getClientMasterService() {
        return clientMasterService;
    }

    public void setClientMasterService(ClientMasterService<ClientMaster> clientMasterService) {
        this.clientMasterService = clientMasterService;
    }

    public StateMasterService<StateMaster> getStateMasterService() {
        return stateMasterService;
    }

    public void setStateMasterService(StateMasterService<StateMaster> stateMasterService) {
        this.stateMasterService = stateMasterService;
    }

    public PriorityMasterService<PriorityMaster> getPriorityMasterService() {
        return priorityMasterService;
    }

    public void setPriorityMasterService(PriorityMasterService<PriorityMaster> priorityMasterService) {
        this.priorityMasterService = priorityMasterService;
    }

    public ZydexLocationMasterService<ZydexLocationMaster> getZydexLocationMasterService() {
        return zydexLocationMasterService;
    }

    public void setZydexLocationMasterService(ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService) {
        this.zydexLocationMasterService = zydexLocationMasterService;
    }

    public DepartmentMasterService<DepartmentMaster> getDepartmentMasterService() {
        return departmentMasterService;
    }

    public void setDepartmentMasterService(DepartmentMasterService<DepartmentMaster> departmentMasterService) {
        this.departmentMasterService = departmentMasterService;
    }

    public CreateTaskService<CreateTask> getCreateTaskService() {
        return createTaskService;
    }

    public void setCreateTaskService(CreateTaskService<CreateTask> createTaskService) {
        this.createTaskService = createTaskService;
    }

    public TaskEmployeeDepartmentService<TaskEmployeeDepartment> getTaskEmployeeDepartmentService() {
        return taskEmployeeDepartmentService;
    }

    public void setTaskEmployeeDepartmentService(TaskEmployeeDepartmentService<TaskEmployeeDepartment> taskEmployeeDepartmentService) {
        this.taskEmployeeDepartmentService = taskEmployeeDepartmentService;
    }
    

    protected void clientList(HttpServletRequest request) {
        ClientMaster clientMaster = new ClientMaster();
        List<?> clienList = clientMasterService.read();
        Map<Integer, String> cl = new HashMap<>();
        for (Object o : clienList) {
            clientMaster = (ClientMaster) o;
            cl.put(clientMaster.getId(), clientMaster.getName());
        }
        request.setAttribute("listClient", cl);
    }

    protected void stateList(HttpServletRequest request) {
        StateMaster stateMaster = new StateMaster();
        List<?> stateList = stateMasterService.read();
        Map<Integer, String> sl = new HashMap<>();
        for (Object o : stateList) {
            stateMaster = (StateMaster) o;
            sl.put(stateMaster.getId(), stateMaster.getName());
        }
        request.setAttribute("list1", sl);
    }

    protected void priorityList(HttpServletRequest request) {
        PriorityMaster priorityMaster = new PriorityMaster();
        List<?> priorityList = priorityMasterService.read();
        Map<Integer, String> pl = new HashMap<>();
        for (Object o : priorityList) {
            priorityMaster = (PriorityMaster) o;
            pl.put(priorityMaster.getId(), priorityMaster.getName());
        }
        request.setAttribute("list2", pl);
    }

    protected void workLocationList(HttpServletRequest request) {
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        List<?> locationList = zydexLocationMasterService.read();
        Map<Integer, String> wl = new HashMap<>();
        for (Object o : locationList) {
            zydexLocationMaster = (ZydexLocationMaster) o;
            wl.put(zydexLocationMaster.getId(), zydexLocationMaster.getZydexLocation());
        }
        request.setAttribute("list3", wl);
    }
    protected void departmmentList(HttpServletRequest request){
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> departList = departmentMasterService.read();
        Map<Integer,String> dl = new HashMap<>();
        for(Object o: departList){
            departmentMaster = (DepartmentMaster) o;
            dl.put(departmentMaster.getId(),departmentMaster.getDepartmentName());
        }
        request.setAttribute("list4", dl);
    }
    
    public void selectedEmployeeLevel1(HttpServletRequest request,
            ProjectManagementMaster projectManagementMaster) throws Exception {
        String tempStr = "";
        tempStr += "[";
        if (null != projectManagementMaster.getManager()&& !"".equals(projectManagementMaster.getManager())) {
            EmployeeMaster employeeMaster1;
            //int empId=employeeMaster.getId();
            //List<?> list1 = employeeMasterService.readByEmployeeLevelId();
            List<?> list1 = projectManagementService.readManagerEmployeeDepart(projectManagementMaster);
//            List<?> list1 = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
            projectManagementMaster = new ProjectManagementMaster();
            boolean flag = false;
            //for (Object o : list1.get(0)) {
            //employeeMaster1 = (EmployeeMaster) o;
            //employeeMaster.setReportingManagerLevel1(employeeMaster1.getId().toString());
            // List<?> list2 = employeeMasterService.readByEmployeeLevelId(employeeMaster);
            if (null != list1 && !list1.isEmpty()) {
//                employeeMaster = (EmployeeMaster) list1.get(0);
                Object[] arrayOfObject = (Object[]) list1.get(0);
                if (flag) {
                    tempStr += ", ";
                }
                flag = true;
                tempStr += "{id: \"" + arrayOfObject[0]
                        + "\", name: \"" + arrayOfObject[1]
                        + "  /" + arrayOfObject[2]
                        + "  /" + arrayOfObject[3] + "\"}";
//                       + "  /" + arrayOfObject[4] 
//                       + "  /" + arrayOfObject[5] 

            }
        }
        tempStr += "]";
//this "preList" is used in EditUserProfile.jsp for show Reporting Manager and 
//Some String Split Operation is On jsp is done for showing it to read only mode for employee Side.
        request.setAttribute("preList", tempStr);
    }

    public void selectEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = employeeMasterService.readForAliveEmployeesNew();
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
                    + "  /" + arrayOfObject[3] + "\"}";
//                    + "  /" + arrayOfObject[4]
//                    + "  /" + arrayOfObject[5] 

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }
}
