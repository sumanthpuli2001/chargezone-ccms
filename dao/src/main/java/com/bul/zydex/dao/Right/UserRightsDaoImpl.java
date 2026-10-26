/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Right;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class UserRightsDaoImpl<T> extends GenericsDAOImpl<T> implements UserRightsDao<T> {

    @Override
    protected Class getDomainClass() {
        return UserRights.class;
    }

    @Override
    public List<?> readByUserRight(String username) {
        // UserRights userRights = (UserRights) object;
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.username = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public void updateRight(String employeeCode, int empMgt, int vendorMgt, int rightMgt, int createTender, int authorizeTender, int tenderBidOpen, int userReport, int tenderReport, int oapCreater, int oapApproval, int aocCreater, int aocApproval, int oapApprovalCreater, int aocApprovalCreater, int projectManager, int networkTeam, int financeTeam, int oapaocReport, int executiveHead, int projectcordinator, int vendorRequest, int vendorInvite, int vendorInformation, int buyerApproval, int financialApproval, int technicalApproval, int hrApproval, int safetyApproval, int activeVendor, int allVendor, int vendorTechnicalCriteriaMaster, int hrCriteriaMaster, int safetyCriteriaMaster, int sitesurvey, int procurementHead, int complianceOfficer, int itApproval, int prManagement, int omsCreator, int grnExecutive1) {
        String query = "";
        query = " update UserRights a set a.employeeMgt='" + empMgt + "', a.vendorMgt='" + vendorMgt + "', a.rightMgt='" + rightMgt + "', "
                + " a.createTender = '" + createTender + "'"
                + ", a.authorizeTender = '" + authorizeTender + "'"
                + ", a.tenderBidOpen = '" + tenderBidOpen + "'"
                + ", a.userReport = '" + userReport + "'"
                + ", a.tenderReport = '" + tenderReport + "'"
                + ", a.oapCreater = '" + oapCreater + "'"
                + ", a.oapApproval = '" + oapApproval + "'"
                + ", a.aocCreater = '" + aocCreater + "'"
                + ", a.aocApproval = '" + aocApproval + "'"
                + ", a.oapApprovalCreater = '" + oapApprovalCreater + "'"
                + ", a.aocApprovalCreater = '" + aocApprovalCreater + "'"
                + ", a.projectManager = '" + projectManager + "'"
                + ", a.networkTeam = '" + networkTeam + "'"
                + ", a.financeTeam = '" + financeTeam + "'"
                + ", a.oapaocReport = '" + oapaocReport + "'"
                + ", a.executiveHead = '" + executiveHead + "'"
                + ", a.projectCordinator = '" + projectcordinator + "'"
                + ", a.venderRequest = '" + vendorRequest + "'"
                + ", a.venderInvite = '" + vendorInvite + "'"
                + ", a.venderInformation = '" + vendorInformation + "'"
                + ", a.buyerApproval = '" + buyerApproval + "'"
                + ", a.financialApproval = '" + financialApproval + "'"
                + ", a.technicalApproval = '" + technicalApproval + "'"
                + ", a.hrApproval = '" + hrApproval + "'"
                + ", a.safetyApproval = '" + safetyApproval + "'"
                + ", a.activeVendor = '" + activeVendor + "'"
                + ", a.allVendor = '" + allVendor + "'"
                + ", a.vendorTechnicalCriteriaMaster = '" + vendorTechnicalCriteriaMaster + "'"
                + ", a.hrCriteriaMaster = '" + hrCriteriaMaster + "'"
                + ", a.safetyCriteriaMaster = '" + safetyCriteriaMaster + "'"
                + ", a.siteSurvey = '" + sitesurvey + "'"
                + ", a.itApproval = '" + itApproval + "'"
                + ", a.complianceOfficer = '" + complianceOfficer + "'"
                + ", a.procurementHead = '" + procurementHead + "'"
                + ", a.prManagement = '" + prManagement + "'"
                + ", a.omsCreator = '" + omsCreator + "'"
                + ", a.grnExecutive = '" + grnExecutive1 + "'"
                + " WHERE a.username = '" + employeeCode + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public UserRights readByUser(String username) {
        UserRights userRights = new UserRights();
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.username = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            userRights = (UserRights) list.get(0);
        }
        return userRights;
    }

    @Override
    public List readByCreated() {

        String query = "select b.name,b.employeeCode";
        query += " FROM UserRights a,EmployeeMaster b"
                + " WHERE a.projectCordinator=1 "
                + " and a.username=b.employeeCode";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByprojectManager() {
        String query = "select b.name,b.employeeCode";
        query += " FROM UserRights a,EmployeeMaster b"
                + " WHERE a.projectManager=1 "
                + " and a.username=b.employeeCode";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDesignCoordinator() {
        String query = "select b.name,b.employeeCode";
        query += " FROM UserRights a,EmployeeMaster b"
                + " WHERE a.aocApprovalCreater=1 "
                + " and a.username=b.employeeCode";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDesignManager() {
        String query = "select b.name,b.employeeCode";
        query += " FROM UserRights a,EmployeeMaster b"
                + " WHERE a.oapApprovalCreater=1 "
                + " and a.username=b.employeeCode";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByCreated1() {
        String query = "select b.name,b.employeeCode";
        query += " FROM UserRights a,EmployeeMaster b"
                + " WHERE a.projectCordinator=1 "
                + " and a.username=b.employeeCode";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByBuyerApproval() {
        String query = "SELECT b.employeeCode FROM UserRights a, EmployeeMaster b "
                + "WHERE a.createTender = 1 AND a.username = b.employeeCode";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByexecutiveHead() {
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.executiveHead=1 ";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByProcurementHead() {
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.procurementHead=1 ";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByComplianceOfficer() {
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.complianceOfficer=1 ";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByGRN() {
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.grnExecutive=1 ";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByFinancial() {
        String query = "";
        query += " FROM UserRights a"
                + " WHERE a.financialApproval=1 ";

        return getHibernateTemplate().find(query);
    }

}
