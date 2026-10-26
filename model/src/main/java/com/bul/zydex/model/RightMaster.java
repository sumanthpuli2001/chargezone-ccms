/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman Bahukhandi
 */
public class RightMaster {

    public static RightMaster readRight(String rightsName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String rightName;
    private String right;
    private String dRow;
    private int empMgt;
    private int rightMgt;
    private int vendorMgt;
    private int createTender;
    private int authorizeTender;
    private int tenderBidOpen;
    private int userReport;
    private int tenderReport;
    private int prManagement;

    private int oapCreater;
    private int oapApproval;
    private int aocCreater;
    private int aocApproval;
    private int oapApprovalCreater;
    private int aocApprovalCreater;
    private int projectManager;
    private int networkTeam;
    private int financeTeam;
    private int oapaocReport;
    private int executiveHead;
    private int projectCordinator;
    private int siteSurvey;

    private int venderRequest;
    private int venderInvite;
    private int venderInformation;
    private int buyerApproval;
    private int financialApproval;
    private int technicalApproval;
    private int hrApproval;
    private int safetyApproval;
    private int activeVendor;
    private int allVendor;
    private int vendorTechnicalCriteriaMaster;
    private int hrCriteriaMaster;
    private int safetyCriteriaMaster;

    private int procurementHead;
    private int complianceOfficer;
    private int itApproval;
    private int omsCreator;
    private int grnExecutive;

    public RightMaster() {
    }

    public RightMaster(String rightName, String right, String dRow, int empMgt, int rightMgt, int vendorMgt, int createTender, int authorizeTender, int tenderBidOpen, int userReport, int tenderReport, int prManagement, int oapCreater, int oapApproval, int aocCreater, int aocApproval, int oapApprovalCreater, int aocApprovalCreater, int projectManager, int networkTeam, int financeTeam, int oapaocReport, int executiveHead, int projectCordinator, int siteSurvey, int safetyCriteriaMaster, int complianceOfficer, int itApproval, int grnExecutive) {
        this.rightName = rightName;
        this.right = right;
        this.dRow = dRow;
        this.empMgt = empMgt;
        this.rightMgt = rightMgt;
        this.vendorMgt = vendorMgt;
        this.createTender = createTender;
        this.authorizeTender = authorizeTender;
        this.tenderBidOpen = tenderBidOpen;
        this.userReport = userReport;
        this.tenderReport = tenderReport;
        this.prManagement = prManagement;
        this.oapCreater = oapCreater;
        this.oapApproval = oapApproval;
        this.aocCreater = aocCreater;
        this.aocApproval = aocApproval;
        this.oapApprovalCreater = oapApprovalCreater;
        this.aocApprovalCreater = aocApprovalCreater;
        this.projectManager = projectManager;
        this.networkTeam = networkTeam;
        this.financeTeam = financeTeam;
        this.oapaocReport = oapaocReport;
        this.executiveHead = executiveHead;
        this.projectCordinator = projectCordinator;
        this.siteSurvey = siteSurvey;
        this.grnExecutive = grnExecutive;

    }

    public RightMaster(int venderRequest, int venderInvite, int venderInformation, int buyerApproval, int financialApproval, int technicalApproval, int hrApproval, int safetyApproval, int activeVendor, int allVendor, int vendorTechnicalCriteriaMaster, int hrCriteriaMaster, int safetyCriteriaMaster, int omsCreator) {
        this.venderRequest = venderRequest;
        this.venderInvite = venderInvite;
        this.venderInformation = venderInformation;
        this.buyerApproval = buyerApproval;
        this.financialApproval = financialApproval;
        this.technicalApproval = technicalApproval;
        this.hrApproval = hrApproval;
        this.safetyApproval = safetyApproval;
        this.activeVendor = activeVendor;
        this.allVendor = allVendor;
        this.vendorTechnicalCriteriaMaster = vendorTechnicalCriteriaMaster;
        this.hrCriteriaMaster = hrCriteriaMaster;
        this.safetyCriteriaMaster = safetyCriteriaMaster;
        this.procurementHead = procurementHead;
        this.complianceOfficer = complianceOfficer;
        this.itApproval = itApproval;
        this.omsCreator = omsCreator;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getdRow() {
        return dRow;
    }

    public void setdRow(String dRow) {
        this.dRow = dRow;
    }

    public int getEmpMgt() {
        return empMgt;
    }

    public void setEmpMgt(int empMgt) {
        this.empMgt = empMgt;
    }

    public int getRightMgt() {
        return rightMgt;
    }

    public void setRightMgt(int rightMgt) {
        this.rightMgt = rightMgt;
    }

    public int getVendorMgt() {
        return vendorMgt;
    }

    public void setVendorMgt(int vendorMgt) {
        this.vendorMgt = vendorMgt;
    }

    public int getCreateTender() {
        return createTender;
    }

    public void setCreateTender(int createTender) {
        this.createTender = createTender;
    }

    public int getAuthorizeTender() {
        return authorizeTender;
    }

    public void setAuthorizeTender(int authorizeTender) {
        this.authorizeTender = authorizeTender;
    }

    public int getTenderBidOpen() {
        return tenderBidOpen;
    }

    public void setTenderBidOpen(int tenderBidOpen) {
        this.tenderBidOpen = tenderBidOpen;
    }

    public int getUserReport() {
        return userReport;
    }

    public void setUserReport(int userReport) {
        this.userReport = userReport;
    }

    public int getTenderReport() {
        return tenderReport;
    }

    public void setTenderReport(int tenderReport) {
        this.tenderReport = tenderReport;
    }

    public int getPrManagement() {
        return prManagement;
    }

    public void setPrManagement(int prManagement) {
        this.prManagement = prManagement;
    }

    public int getOapCreater() {
        return oapCreater;
    }

    public void setOapCreater(int oapCreater) {
        this.oapCreater = oapCreater;
    }

    public int getOapApproval() {
        return oapApproval;
    }

    public void setOapApproval(int oapApproval) {
        this.oapApproval = oapApproval;
    }

    public int getAocCreater() {
        return aocCreater;
    }

    public void setAocCreater(int aocCreater) {
        this.aocCreater = aocCreater;
    }

    public int getAocApproval() {
        return aocApproval;
    }

    public void setAocApproval(int aocApproval) {
        this.aocApproval = aocApproval;
    }

    public int getOapApprovalCreater() {
        return oapApprovalCreater;
    }

    public void setOapApprovalCreater(int oapApprovalCreater) {
        this.oapApprovalCreater = oapApprovalCreater;
    }

    public int getAocApprovalCreater() {
        return aocApprovalCreater;
    }

    public void setAocApprovalCreater(int aocApprovalCreater) {
        this.aocApprovalCreater = aocApprovalCreater;
    }

    public int getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(int projectManager) {
        this.projectManager = projectManager;
    }

    public int getNetworkTeam() {
        return networkTeam;
    }

    public void setNetworkTeam(int networkTeam) {
        this.networkTeam = networkTeam;
    }

    public int getFinanceTeam() {
        return financeTeam;
    }

    public void setFinanceTeam(int financeTeam) {
        this.financeTeam = financeTeam;
    }

    public int getOapaocReport() {
        return oapaocReport;
    }

    public void setOapaocReport(int oapaocReport) {
        this.oapaocReport = oapaocReport;
    }

    public int getExecutiveHead() {
        return executiveHead;
    }

    public void setExecutiveHead(int executiveHead) {
        this.executiveHead = executiveHead;
    }

    public int getProjectCordinator() {
        return projectCordinator;
    }

    public void setProjectCordinator(int projectCordinator) {
        this.projectCordinator = projectCordinator;
    }

    public int getVenderRequest() {
        return venderRequest;
    }

    public void setVenderRequest(int venderRequest) {
        this.venderRequest = venderRequest;
    }

    public int getVenderInvite() {
        return venderInvite;
    }

    public void setVenderInvite(int venderInvite) {
        this.venderInvite = venderInvite;
    }

    public int getVenderInformation() {
        return venderInformation;
    }

    public void setVenderInformation(int venderInformation) {
        this.venderInformation = venderInformation;
    }

    public int getBuyerApproval() {
        return buyerApproval;
    }

    public void setBuyerApproval(int buyerApproval) {
        this.buyerApproval = buyerApproval;
    }

    public int getFinancialApproval() {
        return financialApproval;
    }

    public void setFinancialApproval(int financialApproval) {
        this.financialApproval = financialApproval;
    }

    public int getTechnicalApproval() {
        return technicalApproval;
    }

    public void setTechnicalApproval(int technicalApproval) {
        this.technicalApproval = technicalApproval;
    }

    public int getHrApproval() {
        return hrApproval;
    }

    public void setHrApproval(int hrApproval) {
        this.hrApproval = hrApproval;
    }

    public int getSafetyApproval() {
        return safetyApproval;
    }

    public void setSafetyApproval(int safetyApproval) {
        this.safetyApproval = safetyApproval;
    }

    public int getActiveVendor() {
        return activeVendor;
    }

    public void setActiveVendor(int activeVendor) {
        this.activeVendor = activeVendor;
    }

    public int getAllVendor() {
        return allVendor;
    }

    public void setAllVendor(int allVendor) {
        this.allVendor = allVendor;
    }

    public int getVendorTechnicalCriteriaMaster() {
        return vendorTechnicalCriteriaMaster;
    }

    public void setVendorTechnicalCriteriaMaster(int vendorTechnicalCriteriaMaster) {
        this.vendorTechnicalCriteriaMaster = vendorTechnicalCriteriaMaster;
    }

    public int getHrCriteriaMaster() {
        return hrCriteriaMaster;
    }

    public void setHrCriteriaMaster(int hrCriteriaMaster) {
        this.hrCriteriaMaster = hrCriteriaMaster;
    }

    public int getSafetyCriteriaMaster() {
        return safetyCriteriaMaster;
    }

    public void setSafetyCriteriaMaster(int safetyCriteriaMaster) {
        this.safetyCriteriaMaster = safetyCriteriaMaster;
    }

    public int getSiteSurvey() {
        return siteSurvey;
    }

    public void setSiteSurvey(int siteSurvey) {
        this.siteSurvey = siteSurvey;
    }

    public int getProcurementHead() {
        return procurementHead;
    }

    public void setProcurementHead(int procurementHead) {
        this.procurementHead = procurementHead;
    }

    public int getComplianceOfficer() {
        return complianceOfficer;
    }

    public void setComplianceOfficer(int complianceOfficer) {
        this.complianceOfficer = complianceOfficer;
    }

    public int getItApproval() {
        return itApproval;
    }

    public void setItApproval(int itApproval) {
        this.itApproval = itApproval;
    }

    public int getOmsCreator() {
        return omsCreator;
    }

    public void setOmsCreator(int omsCreator) {
        this.omsCreator = omsCreator;
    }

    public int getGrnExecutive() {
        return grnExecutive;
    }

    public void setGrnExecutive(int grnExecutive) {
        this.grnExecutive = grnExecutive;
    }

}
