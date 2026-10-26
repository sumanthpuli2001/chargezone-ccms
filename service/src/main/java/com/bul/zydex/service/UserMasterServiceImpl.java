/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.UserMasterDAO;
import com.bul.zydex.model.UserMaster;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class UserMasterServiceImpl<T> extends GenericsServiceImpl<T>
implements UserMasterService<T> {

    private UserMasterDAO<T> userMasterDAO;

    public UserMasterDAO<T> getUserMasterDAO() {
        return userMasterDAO;
    }

    public void setUserMasterDAO(UserMasterDAO<T> userMasterDAO) {
        this.userMasterDAO = userMasterDAO;
        setGenericsDAO(userMasterDAO);
    }

    @Override
    public List<?> readByUserName(T object) {
        return userMasterDAO.readByUserName(object);
    }

    @Override
    public List<?> read(T object) {
        UserMaster user;
        UserMaster user2 = (UserMaster) object;
        return userMasterDAO.read(object);

    }

    @Override
    public UserMaster read(String loginname) {
        return userMasterDAO.read(loginname);
    }

    @Override
    public void deleteByLoginName(String loginName) {
        userMasterDAO.deleteByLoginName(loginName);
    }

    @Override
    public List readByDrow() {
        return userMasterDAO.readByDrow();
    }

    @Override
    public List readByDrowDisable() {
        return userMasterDAO.readByDrowDisable();
    }

    @Override
    public List readUser(String loginname) {
        return userMasterDAO.readUser(loginname);
    }

    @Override
    public void updatepass(String user11, String password) {
        userMasterDAO.updatepass(user11, password);
    }

    @Override
    public void updateuser(String employeeCode, String name) {
        userMasterDAO.updateuser(employeeCode, name);
    }

    @Override
    public void updateLock(String loginName, int userTry) {
        userMasterDAO.updateLock(loginName, userTry);
    }

    @Override
    public void updateUserTry(String loginName, int userTry) {
        userMasterDAO.updateUserTry(loginName, userTry);
    }

    @Override
    public void updateUserTry1(String loginName) {
        userMasterDAO.updateUserTry1(loginName);
    }

    @Override
    public void unlockuser(String loginname, String password) {
        userMasterDAO.unlockuser(loginname, password);
    }

    @Override
    public List checkUser(String username1, String password1, String user_department1) {
        return userMasterDAO.checkUser(username1, password1, user_department1);
    }

    @Override
    public List readEmailId(String email_id) {
        return userMasterDAO.readEmailId(email_id);
    }

    @Override
    public List readByVendorCode(String email) {
        return userMasterDAO.readByVendorCode(email);
    }
}
