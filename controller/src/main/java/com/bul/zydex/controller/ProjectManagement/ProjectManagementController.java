/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the ttor.
 */
package com.bul.zydex.controller.ProjectManagement;

import com.bul.zydex.model.ClientMaster;
import com.bul.zydex.model.CreateTask;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PriorityMaster;
import com.bul.zydex.model.ProjectManagementMaster;
import com.bul.zydex.model.StateMaster;
import com.bul.zydex.model.TaskEmployeeDepartment;
import com.bul.zydex.model.ZydexLocationMaster;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.json.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman
 */
public class ProjectManagementController extends ProjectManagementAbstract {

    public ModelAndView projectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = projectManagementService.readProjectMList();
        request.setAttribute("list", list);
        mv.setViewName("ProjectManagement/projectList");
        return mv;
    }

    public ModelAndView viewProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("projectId");
        ProjectManagementMaster projectManagement = projectManagementService.readById(Integer.parseInt(id));
        ClientMaster clientMaster = clientMasterService.readById(projectManagement.getClientMaster().getId());
        StateMaster stateMaster = stateMasterService.readById(projectManagement.getStateMaster().getId());
        PriorityMaster priorityMaster = priorityMasterService.readById(projectManagement.getPriorityMaster().getId());
        ZydexLocationMaster workLocation = zydexLocationMasterService.readById(projectManagement.getZydexLocationMaster().getId());
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(projectManagement.getManager()));
        try {
            String attachementFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserAttachementForProjectManagement"
                    + File.separator + id + File.separator;
            String attachementFileURL = "StorageYard" + File.separator + "UserAttachementForProjectManagement"
                    + File.separator + id + File.separator;
            List l = new ArrayList();
            File[] files = new File(attachementFileLocationURL).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    List l1 = new ArrayList();
                    l1.add(attachementFileURL + file.getName());
                    l1.add(file.getName());
                    l.add(l1);
                }
                request.setAttribute("attachementList", l);
            }
        } catch (Exception e) {
        }
        ///Code of Task List
        List<?> list = createTaskService.readTaskList(id);

        request.setAttribute("projectManagement", projectManagement);
        request.setAttribute("clientMaster", clientMaster);
        request.setAttribute("stateMaster", stateMaster);
        request.setAttribute("priorityMaster", priorityMaster);
        request.setAttribute("workLocation", workLocation);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("list", list);
        mv.setViewName("ProjectManagement/viewProject");
        return mv;
    }

    public ModelAndView editProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProjectManagementMaster projectManagementMaster = new ProjectManagementMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        projectManagementMaster = projectManagementService.readById(Integer.parseInt(id));
        clientList(request);
        stateList(request);
        priorityList(request);
        workLocationList(request);
        selectEmployee(request, response);
        selectedEmployeeLevel1(request, projectManagementMaster);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("projectManagement", projectManagementMaster);
        mv.setViewName("ProjectManagement/createProject");
        return mv;
    }

    public ModelAndView createProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProjectManagementMaster projectManagementMaster = new ProjectManagementMaster();
        ClientMaster clientMaster = new ClientMaster();
        StateMaster stateMaster = new StateMaster();
        PriorityMaster priorityMaster = new PriorityMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        clientList(request);
        stateList(request);
        priorityList(request);
        workLocationList(request);
        selectEmployee(request, response);
        selectedEmployeeLevel1(request, projectManagementMaster);
        projectManagementMaster.setClientMaster(clientMaster);
        projectManagementMaster.setStateMaster(stateMaster);
        projectManagementMaster.setPriorityMaster(priorityMaster);
        projectManagementMaster.setZydexLocationMaster(zydexLocationMaster);
        mv.getModelMap().put("projectManagement", projectManagementMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("ProjectManagement/createProject");
        return mv;
    }

    public ModelAndView deleteProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                ProjectManagementMaster projectManagementMaster = new ProjectManagementMaster();
                List<?> list = projectManagementService.deleteProjectManagement(z);
                for (Object object : list) {
                    projectManagementMaster = (ProjectManagementMaster) object;
                    projectManagementService.delete(projectManagementMaster.getId());
                }
                projectManagementService.delete(Integer.parseInt(z));
            } catch (Exception e) {
            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = projectList(request, response);
        return mv;
    }

    public ModelAndView myProjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> list = projectManagementService.readProjectEmployee(employeeMaster.getId());
        request.setAttribute("list", list);
        mv.setViewName("ProjectManagement/myProjectList");
        return mv;
    }

    public ModelAndView viewMyProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        ProjectManagementMaster projectManagementMaster = projectManagementService.readById(projectId);
        ClientMaster clientMaster = clientMasterService.readById(projectManagementMaster.getClientMaster().getId());
        StateMaster stateMaster = stateMasterService.readById(projectManagementMaster.getStateMaster().getId());
        PriorityMaster priorityMaster = priorityMasterService.readById(projectManagementMaster.getPriorityMaster().getId());
        ZydexLocationMaster workLocation = zydexLocationMasterService.readById(projectManagementMaster.getZydexLocationMaster().getId());
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(projectManagementMaster.getManager()));
        try {
            String attachementFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserAttachementForProjectManagement"
                    + File.separator + projectId + File.separator;
            String attachementFileURL = "StorageYard" + File.separator + "UserAttachementForProjectManagement"
                    + File.separator + projectId + File.separator;
            List l = new ArrayList();
            File[] files = new File(attachementFileLocationURL).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    List l1 = new ArrayList();
                    l1.add(attachementFileURL + file.getName());
                    l1.add(file.getName());
                    l.add(l1);
                }
                request.setAttribute("attachementList", l);
            }
        } catch (Exception e) {
        }
        request.setAttribute("projectManagement", projectManagementMaster);
        request.setAttribute("clientMaster", clientMaster);
        request.setAttribute("stateMaster", stateMaster);
        request.setAttribute("priorityMaster", priorityMaster);
        request.setAttribute("workLocation", workLocation);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("ProjectManagement/viewMyProject");
        return mv;
    }

    public ModelAndView viewTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("taskId");
        CreateTask viewTask = new CreateTask();
        CreateTask createTask = createTaskService.readById(Integer.parseInt(id));
        PriorityMaster priorityMaster = priorityMasterService.readById(createTask.getPriorityMaster().getId());
        List<?> list = taskEmployeeDepartmentService.readDepartmentAndEmp(id);
        try {
            String attachementFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserTaskAttachement"
                    + File.separator + id + File.separator;
            String attachementFileURL = "StorageYard" + File.separator + "UserTaskAttachement"
                    + File.separator + id + File.separator;
            List l = new ArrayList();
            File[] files = new File(attachementFileLocationURL).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    List l1 = new ArrayList();
                    l1.add(attachementFileURL + file.getName());
                    l1.add(file.getName());
                    l.add(l1);
                }
                request.setAttribute("attachementList", l);
            }
        } catch (Exception e) {
        }

        request.setAttribute("createTask", createTask);
        request.setAttribute("priorityMaster", priorityMaster);
        request.setAttribute("list", list);
//        request.setAttribute("taskEmployeeDepartment", taskEmployeeDepartment);
        mv.getModelMap().put("viewTask", viewTask);
        mv.setViewName("ProjectManagement/viewTask");
        return mv;
    }

    public ModelAndView editTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CreateTask createTask = new CreateTask();

        String id = request.getParameter("taskId");
        String projectid = request.getParameter("projectId");
        createTask = createTaskService.readById(Integer.parseInt(id));

        /////code of Resources Department and Employee
        List finalDepartEmp = new ArrayList();
        TaskEmployeeDepartment taskEmployeeDepartment = new TaskEmployeeDepartment();
        List<?> departEmp = taskEmployeeDepartmentService.readDepartmentAndEmp(id);
        for (Object departEmpData : departEmp) {
            List department = new ArrayList();
            Object[] departmentDetail = (Object[]) departEmpData;
            department.add(departmentDetail[0]);
            department.add(departmentDetail[1]);
            department.add(departmentDetail[2]);
            department.add(departmentDetail[3]);
            department.add(employeeMasterService.readDepartmentEmployee((int) departmentDetail[4]));
            finalDepartEmp.add(department);
        }
        priorityList(request);
        departmmentList(request);
        request.setAttribute("finalDepartEmp", finalDepartEmp);
        request.setAttribute("createTask", createTask);
        request.setAttribute("projectId", projectid);
        mv.setViewName("ProjectManagement/editTask");
        return mv;
    }

    public ModelAndView createTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("projectId");
        CreateTask createTask = new CreateTask();
        PriorityMaster priorityMaster = new PriorityMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        priorityList(request);
        departmmentList(request);
        createTask.setPriorityMaster(priorityMaster);
//        createTask.setDepartmentMaster(departmentMaster);
        mv.getModelMap().put("createTask", createTask);
        request.setAttribute("projectId", id);
        mv.setViewName("ProjectManagement/createTask");
        return mv;
    }

    public ModelAndView deleteTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("projectId");
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                CreateTask createTask = new CreateTask();
                List<?> list = createTaskService.deleteTask(z);
                for (Object object : list) {
                    createTask = (CreateTask) object;
                    createTaskService.delete(createTask.getId());
                }
                createTaskService.delete(Integer.parseInt(z));
            } catch (Exception e) {
            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = viewProject(request, response);
        return mv;
    }

    public void setEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        Integer departId = Integer.parseInt(request.getParameter("departmentId"));
        List<?> list = employeeMasterService.readDepartmentEmployee(departId);
        Map<Integer, String> em = new HashMap<>();
        for (Object o : list) {
            Object[] o1 = (Object[]) o;
            int emId = (int) o1[0];
            String emName = (String) o1[1];
            em.put(emId, emName);
        }
        JSONObject jObject = new JSONObject();
        jObject.put("employeeKey", em);
        PrintWriter out = response.getWriter();
        out.println(jObject.toString());
    }

    public ModelAndView clientList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = clientMasterService.readClientMaster();
        mv.getModelMap().put("list", list);
        mv.setViewName("ProjectManagement/clientList");
        return mv;
    }

    public ModelAndView createClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClientMaster clientMaster = new ClientMaster();

        mv.getModelMap().put("clientMaster", clientMaster);
        mv.setViewName("ProjectManagement/createClient");
        return mv;
    }

    public ModelAndView stateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = stateMasterService.readStateMaster();
        request.setAttribute("list", list);
        mv.setViewName("ProjectManagement/stateList");
        return mv;
    }

    public ModelAndView createState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        StateMaster stateMaster = new StateMaster();
        mv.getModelMap().put("stateMaster", stateMaster);
        mv.setViewName("ProjectManagement/createState");
        return mv;
    }

    public ModelAndView priorityList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = priorityMasterService.readPriorityMaster();
        request.setAttribute("list", list);
        mv.setViewName("ProjectManagement/priorityList");
        return mv;
    }

    public ModelAndView createPriority(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PriorityMaster priorityMaster = new PriorityMaster();
        mv.getModelMap().put("priorityMaster", priorityMaster);
        mv.setViewName("ProjectManagement/createPriority");
        return mv;
    }

    public ModelAndView submitClient(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClientMaster clientMaster = new ClientMaster();
        BindException errors = new BindException(clientMaster, "clientMaster");
        bind(request, clientMaster);

        if (clientMaster.getId() == null) {
            clientMasterService.create(clientMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        } else {
            clientMasterService.update(clientMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        }

        mv = clientList(request, response);
        return mv;
    }

    public ModelAndView editClient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ClientMaster clientMaster = new ClientMaster();
        String id = request.getParameter("id");
        clientMaster = clientMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("clientMaster", clientMaster);
        mv.setViewName("ProjectManagement/createClient");
        return mv;

    }

    public ModelAndView deleteClientMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                ClientMaster clientMaster = new ClientMaster();
                List<?> list = clientMasterService.deleteClientMaster(z);
                for (Object object : list) {
                    clientMaster = (ClientMaster) object;
                    clientMasterService.delete(clientMaster.getId());
                }
                clientMasterService.delete(Integer.parseInt(z));
            } catch (Exception e) {
            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = clientList(request, response);
        return mv;
    }

    public ModelAndView submitState(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        StateMaster stateMaster = new StateMaster();
        BindException errors = new BindException(stateMaster, "stateMaster");
        bind(request, stateMaster);

        if (stateMaster.getId() == null) {
            stateMasterService.create(stateMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is Stored Successfully.");
        } else {
            stateMasterService.update(stateMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        }

        mv = stateList(request, response);
        return mv;
    }

    public ModelAndView editState(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        StateMaster stateMaster = new StateMaster();
        String id = request.getParameter("id");
        stateMaster = stateMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("stateMaster", stateMaster);
        mv.setViewName("ProjectManagement/createState");
        return mv;

    }

    public ModelAndView submitPriority(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PriorityMaster priorityMaster = new PriorityMaster();
        BindException errors = new BindException(priorityMaster, "priorityMaster");
        bind(request, priorityMaster);

        if (priorityMaster.getId() == null) {
            priorityMasterService.create(priorityMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is Stored Successfully.");
        } else {
            priorityMasterService.update(priorityMaster);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        }
        mv = priorityList(request, response);
        return mv;
    }

    public ModelAndView editPriority(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PriorityMaster priorityMaster = new PriorityMaster();
        String id = request.getParameter("id");
        priorityMaster = priorityMasterService.readById(Integer.parseInt(id));
        request.setAttribute("priorityMaster", priorityMaster);
        mv.setViewName("ProjectManagement/createPriority");
        return mv;

    }

    public ModelAndView deletePrioretyMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empID[] = request.getParameterValues("checkId");
        for (String z : empID) {
            try {
                PriorityMaster priorityMaster = new PriorityMaster();
                List<?> list = priorityMasterService.deletePrioretyMaster(z);
                for (Object o : list) {
                    priorityMaster = (PriorityMaster) o;
                    priorityMasterService.delete(priorityMaster.getId());
                }
                priorityMasterService.delete(Integer.parseInt(z));
            } catch (Exception e) {
            }
        }
        request.setAttribute("successMessage",
                "Info :Records are deleted successfully.");
        mv = priorityList(request, response);
        return mv;
    }

    public ModelAndView SubmitProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProjectManagementMaster projectManagement = new ProjectManagementMaster();
        String firstStepCount = request.getParameter("firstStepCount");
        String projectId = request.getParameter("id");
        BindException errors = new BindException(projectManagement, "projectManagement");
        bind(request, projectManagement);

        if (projectId == null) {
            projectManagementService.create(projectManagement);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is Stored Successfully.");
        } else {
            projectManagementService.update(projectManagement);
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is updated Successfully.");
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String attachementFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserAttachementForProjectManagement"
                + File.separator + projectManagement.getId() + File.separator;
        File attachementListFile = new File(attachementFileLocationURL);
        if (!attachementListFile.exists()) {
            // create folder 
            attachementListFile.mkdirs();
        } else {
            File[] files = new File(attachementFileLocationURL).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    // delete file if any there
                    Files.deleteIfExists(Paths.get(attachementFileLocationURL + file.getName()));
                }
            }
        }

        List list = new ArrayList();
        for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {
            MultipartFile multipartFile1 = multipartRequest.getFile("certificateId" + i);
            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                try {
                    File file3 = new File(attachementFileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                    // transfer uploaded file to created folder
                    multipartFile1.transferTo(file3);
                    List l1 = new ArrayList();
                    l1.add("StorageYard" + File.separator + "UserAttachementForProjectManagement" + File.separator + projectManagement.getId() + File.separator + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                    l1.add(multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                    list.add(l1);
                } catch (Exception e) {
                }
            }
        }

        ClientMaster clientMaster = clientMasterService.readById(projectManagement.getClientMaster().getId());
        StateMaster stateMaster = stateMasterService.readById(projectManagement.getStateMaster().getId());
        PriorityMaster priorityMaster = priorityMasterService.readById(projectManagement.getPriorityMaster().getId());
        ZydexLocationMaster workLocation = zydexLocationMasterService.readById(projectManagement.getZydexLocationMaster().getId());
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(projectManagement.getManager()));

        request.setAttribute("attachementList", list);
        request.setAttribute("projectManagement", projectManagement);
        request.setAttribute("clientMaster", clientMaster);
        request.setAttribute("stateMaster", stateMaster);
        request.setAttribute("priorityMaster", priorityMaster);
        request.setAttribute("workLocation", workLocation);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("ProjectManagement/viewProject");
        return mv;
    }

    public ModelAndView taskSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CreateTask createTask = new CreateTask();
        String projectId = request.getParameter("projectId");
        String taskId = request.getParameter("taskId");
        String firstStepCount = request.getParameter("firstStepCount");
        TaskEmployeeDepartment taskEmployeeDepartment = new TaskEmployeeDepartment();
        BindException error = new BindException(createTask, "createTask");
        bind(request, createTask);

        if (taskId == null) {
            ProjectManagementMaster pmm = new ProjectManagementMaster();
            pmm.setId(Integer.parseInt(projectId));
            createTask.setProjectManagementMaster(pmm);
            createTaskService.create(createTask);
            ///////Code for Multiple Department and Employee
            int departEmp = Integer.parseInt(request.getParameter("firstStepCount12"));
            for (int i = 1; i <= departEmp; i++) {
                if (null != request.getParameter("departmentId" + i) && null != request.getParameter("employeeId" + i)) {
                    if (!request.getParameter("departmentId" + i).equals("") && !request.getParameter("employeeId" + i).equals("")) {
                        DepartmentMaster department = new DepartmentMaster();

                        EmployeeMaster empNameId = new EmployeeMaster();
                        int departId = Integer.parseInt(request.getParameter("departmentId" + i));
                        department.setId(departId);
                        int empId = Integer.parseInt(request.getParameter("employeeId" + i));
                        empNameId.setId(empId);
                        taskEmployeeDepartment.setDepartmentMaster(department);
                        taskEmployeeDepartment.setEmployeeMaster(empNameId);
                        taskEmployeeDepartment.setCreateTask(createTask);
                        if (null != request.getParameter("authorize" + i)) {
                            taskEmployeeDepartment.setAuthorize(true);
                        } else {
                            taskEmployeeDepartment.setAuthorize(false);
                        }
                    }
                }
                taskEmployeeDepartmentService.create(taskEmployeeDepartment);

            }

            request.setAttribute(
                    "successMessage",
                    "Information : The Information is Stored Successfully.");
        } else {
            ProjectManagementMaster pmm = new ProjectManagementMaster();
            pmm.setId(Integer.parseInt(projectId));
            createTask.setProjectManagementMaster(pmm);
            createTask.setId(Integer.parseInt(taskId));
            createTaskService.update(createTask);

            ///deleted previous multiple department and employee
            List<?> taskDeartEmpDetail = taskEmployeeDepartmentService.readDepartmentAndEmp(taskId);
            for (Object departEmpobject : taskDeartEmpDetail) {
                Object[] depart = (Object[]) departEmpobject;
                Integer taskDepartId = (Integer) depart[0];
                taskEmployeeDepartmentService.delete(taskDepartId);
            }

            /////code for multiple Department and Employee
            int departEmp = Integer.parseInt(request.getParameter("firstStepCount12"));
            for (int i = 1; i <= departEmp; i++) {
                if (null != request.getParameter("departmentId" + i) && null != request.getParameter("employeeId" + i)) {
                    if (!request.getParameter("departmentId" + i).equals("") && !request.getParameter("employeeId" + i).equals("")) {
                        DepartmentMaster department = new DepartmentMaster();
                        EmployeeMaster empNameId = new EmployeeMaster();
                        int departId = Integer.parseInt(request.getParameter("departmentId" + i));
                        department.setId(departId);
                        int empId = Integer.parseInt(request.getParameter("employeeId" + i));
                        empNameId.setId(empId);
                        taskEmployeeDepartment.setDepartmentMaster(department);
                        taskEmployeeDepartment.setEmployeeMaster(empNameId);
                        taskEmployeeDepartment.setCreateTask(createTask);
                        if (null != request.getParameter("authorize" + i)) {
                            taskEmployeeDepartment.setAuthorize(true);
                        } else {
                            taskEmployeeDepartment.setAuthorize(false);
                        }
                    }
                }
                taskEmployeeDepartmentService.create(taskEmployeeDepartment);

            }
            request.setAttribute(
                    "successMessage",
                    "Information : The Information is Updated Successfully.");
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String attachementFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserTaskAttachement"
                + File.separator + createTask.getId() + File.separator;
        File attachementListFile = new File(attachementFileLocationURL);
        if (!attachementListFile.exists()) {
            // create folder 
            attachementListFile.mkdirs();
        } else {
            File[] files = new File(attachementFileLocationURL).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    // delete file if any there
                    Files.deleteIfExists(Paths.get(attachementFileLocationURL + file.getName()));
                }
            }
        }

        List list = new ArrayList();
        for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {
            MultipartFile multipartFile1 = multipartRequest.getFile("certificateId" + i);
            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                try {
                    File file3 = new File(attachementFileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                    // transfer uploaded file to created folder
                    multipartFile1.transferTo(file3);
                    List l1 = new ArrayList();
                    l1.add("StorageYard" + File.separator + "UserTaskAttachement" + File.separator + createTask.getId() + File.separator + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                    l1.add(multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                    list.add(l1);
                } catch (Exception e) {
                }
            }
        }
        mv = viewProject(request, response);

        return mv;
    }
}
