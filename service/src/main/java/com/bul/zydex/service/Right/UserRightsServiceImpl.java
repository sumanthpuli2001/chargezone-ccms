/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Right;

import com.bul.zydex.dao.Right.UserRightsDao;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRightsServiceImpl<T> extends GenericsServiceImpl<T> implements UserRightsService<T> {

    protected UserRightsDao<T> userRightsDao;

    public UserRightsDao<T> getUserRightsDao() {
        return userRightsDao;
    }

    public void setUserRightsDao(UserRightsDao<T> userRightsDao) {
        this.userRightsDao = userRightsDao;
        setGenericsDAO(userRightsDao);
    }

    @Override
    public List<?> readByUserRight(String username) {
        return userRightsDao.readByUserRight(username);
    }

    @Override
    public void updateRight(String employeeCode, int empMgt, int vendorMgt, int rightMgt, int createTender, int authorizeTender, int tenderBidOpen, int userReport, int tenderReport, int oapCreater, int oapApproval, int aocCreater, int aocApproval, int oapApprovalCreater, int aocApprovalCreater, int projectManager, int networkTeam, int financeTeam, int oapaocReport, int executiveHead, int projectcordinator, int vendorRequest, int vendorInvite, int vendorInformation, int buyerApproval, int financialApproval, int technicalApproval, int hrApproval, int safetyApproval, int activeVendor, int allVendor, int vendorTechnicalCriteriaMaster, int hrCriteriaMaster, int safetyCriteriaMaster, int sitesurvey, int procurementHead, int complianceOfficer, int itApproval, int prManagement, int omsCreator, int grnExecutive1) {
        userRightsDao.updateRight(employeeCode, empMgt, vendorMgt, rightMgt, createTender, authorizeTender, tenderBidOpen, userReport, tenderReport, oapCreater, oapApproval, aocCreater, aocApproval, oapApprovalCreater, aocApprovalCreater, projectManager, networkTeam, financeTeam, oapaocReport, executiveHead, projectcordinator, vendorRequest, vendorInvite, vendorInformation, buyerApproval, financialApproval, technicalApproval, hrApproval, safetyApproval, activeVendor, allVendor, vendorTechnicalCriteriaMaster, hrCriteriaMaster, safetyCriteriaMaster, sitesurvey, procurementHead, complianceOfficer, itApproval, prManagement, omsCreator, grnExecutive1);
    }

    @Override
    public UserRights readByUser(String username) {
        return userRightsDao.readByUser(username);
    }

    @Override
    public List readByCreated() {

        return userRightsDao.readByCreated();

    }

    @Override
    public List readByprojectManager() {
        return userRightsDao.readByprojectManager();
    }

    @Override
    public List readByDesignCoordinator() {
        return userRightsDao.readByDesignCoordinator();
    }

    @Override
    public List readByDesignManager() {
        return userRightsDao.readByDesignManager();
    }

    @Override
    public List readByCreated1() {
        return userRightsDao.readByCreated1();

    }

    @Override
    public List readByBuyerApproval() {
        return userRightsDao.readByBuyerApproval();
    }

    @Override
    public List readByexecutiveHead() {
        return userRightsDao.readByexecutiveHead();
    }

    @Override
    public List readByProcurementHead() {
        return userRightsDao.readByProcurementHead();
    }

    @Override
    public List readByComplianceOfficer() {
        return userRightsDao.readByComplianceOfficer();
    }

    @Override
    public List readByGRN() {
        return userRightsDao.readByGRN();
    }

    @Override
    public List readByFinancial() {
        return userRightsDao.readByFinancial();
    }

}
