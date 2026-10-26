/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Right;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.UserRights;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UserRightsDao<T> extends GenericsDAO<T> {

    public List<?> readByUserRight(String username);

    public void updateRight(String employeeCode, int empMgt, int vendorMgt, int rightMgt, int createTender, int authorizeTender, int tenderBidOpen, int userReport, int tenderReport, int oapCreater, int oapApproval, int aocCreater, int aocApproval, int oapApprovalCreater, int aocApprovalCreater, int projectManager, int networkTeam, int financeTeam, int oapaocReport, int executiveHead, int projectcordinator, int vendorRequest, int vendorInvite, int vendorInformation, int buyerApproval, int financialApproval, int technicalApproval, int hrApproval, int safetyApproval, int activeVendor, int allVendor, int vendorTechnicalCriteriaMaster, int hrCriteriaMaster, int safetyCriteriaMaster, int sitesurvey, int procurementHead, int complianceOfficer, int itApproval, int prManagement, int omsCreator, int grnExecutive1);

    public UserRights readByUser(String username);

    public List readByCreated();

    public List readByprojectManager();

    public List readByDesignCoordinator();

    public List readByDesignManager();

    public List readByCreated1();

    public List readByBuyerApproval();

    public List readByexecutiveHead();

    public List readByProcurementHead();

    public List readByComplianceOfficer();

    public List readByGRN();

    public List readByFinancial();
}
