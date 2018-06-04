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
public class PayrollPfRecord implements java.io.Serializable {

    private Integer id;
    private EmployeeSalaryProcess employeeSalaryProcess;
    private Double empContrubtionEpf;
    private Double compContrubtionEps;
    private Double differentEpsEpf;
    private Double epfAmount;
    private Double epsAmount;
    private Double diifepsEpfAmount;

    public PayrollPfRecord() {
    }

    public PayrollPfRecord(Integer id, EmployeeSalaryProcess employeeSalaryProcess, Double empContrubtionEpf, Double compContrubtionEps, Double differentEpsEpf, Double epfAmount, Double epsAmount, Double diifepsEpfAmount) {
        this.id = id;
        this.employeeSalaryProcess = employeeSalaryProcess;
        this.empContrubtionEpf = empContrubtionEpf;
        this.compContrubtionEps = compContrubtionEps;
        this.differentEpsEpf = differentEpsEpf;
        this.epfAmount = epfAmount;
        this.epsAmount = epsAmount;
        this.diifepsEpfAmount = diifepsEpfAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeSalaryProcess getEmployeeSalaryProcess() {
        return employeeSalaryProcess;
    }

    public void setEmployeeSalaryProcess(EmployeeSalaryProcess employeeSalaryProcess) {
        this.employeeSalaryProcess = employeeSalaryProcess;
    }

    public Double getEmpContrubtionEpf() {
        return empContrubtionEpf;
    }

    public void setEmpContrubtionEpf(Double empContrubtionEpf) {
        this.empContrubtionEpf = empContrubtionEpf;
    }

    public Double getCompContrubtionEps() {
        return compContrubtionEps;
    }

    public void setCompContrubtionEps(Double compContrubtionEps) {
        this.compContrubtionEps = compContrubtionEps;
    }

    public Double getDifferentEpsEpf() {
        return differentEpsEpf;
    }

    public void setDifferentEpsEpf(Double differentEpsEpf) {
        this.differentEpsEpf = differentEpsEpf;
    }

    public Double getEpfAmount() {
        return epfAmount;
    }

    public void setEpfAmount(Double epfAmount) {
        this.epfAmount = epfAmount;
    }

    public Double getEpsAmount() {
        return epsAmount;
    }

    public void setEpsAmount(Double epsAmount) {
        this.epsAmount = epsAmount;
    }

    public Double getDiifepsEpfAmount() {
        return diifepsEpfAmount;
    }

    public void setDiifepsEpfAmount(Double diifepsEpfAmount) {
        this.diifepsEpfAmount = diifepsEpfAmount;
    }

}
