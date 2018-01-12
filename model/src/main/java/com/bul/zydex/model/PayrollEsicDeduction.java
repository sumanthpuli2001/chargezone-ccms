/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hussain
 */
public class PayrollEsicDeduction implements java.io.Serializable {

    private Integer id;
    private EmployeeSalaryProcess employeeSalaryProcess;
    private Double empContrubtion;
    private Double compContrubtion;
    private Double otEsic;
    private Double otEsicNet;

    public PayrollEsicDeduction() {
    }

    public PayrollEsicDeduction(EmployeeSalaryProcess employeeSalaryProcess, Double empContrubtion, Double compContrubtion ,Double otEsic,Double otEsicNet) {
        this.employeeSalaryProcess = employeeSalaryProcess;
        this.empContrubtion = empContrubtion;
        this.compContrubtion = compContrubtion;
        this.otEsic = otEsic;
        this.otEsicNet = otEsicNet;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeSalaryProcess getEmployeeSalaryProcess() {
        return this.employeeSalaryProcess;
    }

    public void setEmployeeSalaryProcess(EmployeeSalaryProcess employeeSalaryProcess) {
        this.employeeSalaryProcess = employeeSalaryProcess;
    }

    public Double getEmpContrubtion() {
        return empContrubtion;
    }

    public void setEmpContrubtion(Double empContrubtion) {
        this.empContrubtion = empContrubtion;
    }

    public Double getCompContrubtion() {
        return compContrubtion;
    }

    public void setCompContrubtion(Double compContrubtion) {
        this.compContrubtion = compContrubtion;
    }

    public Double getOtEsic() {
        return otEsic;
    }

    public void setOtEsic(Double otEsic) {
        this.otEsic = otEsic;
    }

    public Double getOtEsicNet() {
        return otEsicNet;
    }

    public void setOtEsicNet(Double otEsicNet) {
        this.otEsicNet = otEsicNet;
    }
    

}
