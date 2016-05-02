/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.UserRight;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.UserRightMaster;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRightMasterDAOImpl<T> extends GenericsDAOImpl<T> implements UserRightMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return UserRightMaster.class;
    }

    @Override
    public List<?> readByUserId(String userId) {

        String query = "";

        query += "  "
                + "FROM UserRightMaster a "
                + " WHERE a.userMaster.id = " + userId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByUserRight(T object) {
        UserRightMaster userRightMaster = (UserRightMaster) object;
        String query = "";
        query += " FROM UserRightMaster a"
                + " WHERE a.userMaster.id = '" + userRightMaster.getUserMaster().getId() + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readHRList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.hr=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readpoolcarAdminList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.poolCarAdmin=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readSecurityList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.security=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readCafeAdminList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.cafeteriaAdmin=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readITAdminList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.itAdmin=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readEmployeeExitRightsList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.employeeExit=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExitInterviewRightsList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.exitInterview=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readNoDueRightsList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.noDue=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readProbationToConfirmationAdminList() {

        String query = "";
        query += " "
                + " select d.id,d.employeeName "
                + " from EmployeeMaster d "
                + " left join d.userMaster e "
                + " left join e.userRightMasters f "
                + " where f.probationToConfirmation=true";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readEmployeeReferralRights() {

        String query = "";
        query += " "
                + " select um.id, em.officeEmailId, em.employeeName"
                + " from UserRightMaster urm "
                + " left join urm.userMaster um "
                + " left join um.employeeMasters em "
                + " where urm.employeeReferral=1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public List<?> readApparaisal360Rights() {

        String query = "";
        query += " "
                + " select um.id, em.officeEmailId, em.employeeName"
                + " from UserRightMaster urm "
                + " left join urm.userMaster um "
                + " left join um.employeeMasters em "
                + " where urm.appraisal360=1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTravelAdmin() {

        String query = "";
        query += " "
                + " select um.id, em.id"
                + " from UserRightMaster urm "
                + " left join urm.userMaster um "
                + " left join um.employeeMasters em "
                + " where urm.travelAdmin=1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExpenseAdmin() {

        String query = "";
        query += " "
                + " select um.id, em.id"
                + " from UserRightMaster urm "
                + " left join urm.userMaster um "
                + " left join um.employeeMasters em "
                + " where urm.travelExpenseAdmin=1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
