/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class TypeOfPayment {
   
     private Integer id;
     private String typeOfEmployee;
//     private Set employeeMasters = new HashSet(0);
//     private Set payrollPfChecks = new HashSet(0);
//     private Set payrollPtChecks = new HashSet(0);
//     private Set employeeSubTypes = new HashSet(0);
//     private Set employeeTypeWiseSalaries = new HashSet(0);

    public TypeOfPayment() {
    }

    public TypeOfPayment(String typeOfEmployee) {
       this.typeOfEmployee = typeOfEmployee;
//       this.employeeMasters = employeeMasters;
//       this.payrollPfChecks = payrollPfChecks;
//       this.payrollPtChecks = payrollPtChecks;
//       this.employeeSubTypes = employeeSubTypes;
//       this.employeeTypeWiseSalaries = employeeTypeWiseSalaries;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTypeOfEmployee() {
        return this.typeOfEmployee;
    }
    
    public void setTypeOfEmployee(String typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }
//    public Set getEmployeeMasters() {
//        return this.employeeMasters;
//    }
//    
//    public void setEmployeeMasters(Set employeeMasters) {
//        this.employeeMasters = employeeMasters;
//    }
//    public Set getPayrollPfChecks() {
//        return this.payrollPfChecks;
//    }
//    
//    public void setPayrollPfChecks(Set payrollPfChecks) {
//        this.payrollPfChecks = payrollPfChecks;
//    }
//    public Set getPayrollPtChecks() {
//        return this.payrollPtChecks;
//    }
//    
//    public void setPayrollPtChecks(Set payrollPtChecks) {
//        this.payrollPtChecks = payrollPtChecks;
//    }
//    public Set getEmployeeSubTypes() {
//        return this.employeeSubTypes;
//    }
//    
//    public void setEmployeeSubTypes(Set employeeSubTypes) {
//        this.employeeSubTypes = employeeSubTypes;
//    }
//    public Set getEmployeeTypeWiseSalaries() {
//        return this.employeeTypeWiseSalaries;
//    }
//    
//    public void setEmployeeTypeWiseSalaries(Set employeeTypeWiseSalaries) {
//        this.employeeTypeWiseSalaries = employeeTypeWiseSalaries;
//    }


}
