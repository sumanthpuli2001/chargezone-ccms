/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman
 */
public class TaskEmployeeDepartment  implements java.io.Serializable {


     private Integer id;
     private CreateTask createTask;
     private DepartmentMaster departmentMaster;
     private EmployeeMaster employeeMaster;
     private Boolean authorize;

    public TaskEmployeeDepartment() {
    }

    public TaskEmployeeDepartment(CreateTask createTask, DepartmentMaster departmentMaster, EmployeeMaster employeeMaster, Boolean authorize) {
       this.createTask = createTask;
       this.departmentMaster = departmentMaster;
       this.employeeMaster = employeeMaster;
       this.authorize = authorize;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public CreateTask getCreateTask() {
        return this.createTask;
    }
    
    public void setCreateTask(CreateTask createTask) {
        this.createTask = createTask;
    }
    public DepartmentMaster getDepartmentMaster() {
        return this.departmentMaster;
    }
    
    public void setDepartmentMaster(DepartmentMaster departmentMaster) {
        this.departmentMaster = departmentMaster;
    }
    public EmployeeMaster getEmployeeMaster() {
        return this.employeeMaster;
    }
    
    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }
    public Boolean getAuthorize() {
        return this.authorize;
    }
    
    public void setAuthorize(Boolean authorize) {
        this.authorize = authorize;
    }




}
