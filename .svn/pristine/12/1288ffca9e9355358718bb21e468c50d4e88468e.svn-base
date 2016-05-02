/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.UserRight;

import com.bul.zydex.dao.UserRight.UserRightMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserRightMasterServiceImpl<T> extends GenericsServiceImpl<T> implements UserRightMasterService<T> {

    private UserRightMasterDAO<T> userRightMasterDAO;

    public UserRightMasterDAO<T> getUserRightMasterDAO() {
        return userRightMasterDAO;
    }

    public void setUserRightMasterDAO(UserRightMasterDAO<T> userRightMasterDAO) {
        this.userRightMasterDAO = userRightMasterDAO;
        setGenericsDAO(userRightMasterDAO);
    }

    @Override
    public List<?> readByUserId(String userId) {
        return userRightMasterDAO.readByUserId(userId);
    }

    @Override
    public List<?> readByUserRight(T object) {
        return userRightMasterDAO.readByUserRight(object);
    }

    @Override
    public List<?> readHRList() {
        return userRightMasterDAO.readHRList();
    }

    @Override
    public List<?> readpoolcarAdminList() {
        return userRightMasterDAO.readpoolcarAdminList();
    }

    @Override
    public List<?> readSecurityList() {
        return userRightMasterDAO.readSecurityList();
    }

    @Override
    public List<?> readCafeAdminList() {
        return userRightMasterDAO.readCafeAdminList();
    }

    @Override
    public List<?> readITAdminList() {
        return userRightMasterDAO.readITAdminList();
    }

    @Override
    public List<?> readEmployeeExitRightsList() {
        return userRightMasterDAO.readEmployeeExitRightsList();
    }

    @Override
    public List<?> readExitInterviewRightsList() {
        return userRightMasterDAO.readExitInterviewRightsList();
    }

    @Override
    public List<?> readNoDueRightsList() {
        return userRightMasterDAO.readNoDueRightsList();
    }

    @Override
    public List<?> readProbationToConfirmationAdminList() {
        return userRightMasterDAO.readProbationToConfirmationAdminList();
    }

    @Override
    public List<?> readEmployeeReferralRights() {
        return userRightMasterDAO.readEmployeeReferralRights();
    }

    @Override
    public List<?> readApparaisal360Rights() {
        return userRightMasterDAO.readApparaisal360Rights();
    }

    @Override
    public List<?> readTravelAdmin() {
        return userRightMasterDAO.readTravelAdmin();
    }

    @Override
    public List<?> readExpenseAdmin() {
        return userRightMasterDAO.readExpenseAdmin();
    }

}
