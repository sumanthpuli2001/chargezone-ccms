/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.UserMaster;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface UserMasterDAO<T> extends GenericsDAO<T> {

    public List<?> readByUserName(T object);

    public List<?> read(T object);

    public UserMaster read(String loginname);
    
    public List readUser(String loginname);

    public void deleteByLoginName(String loginName);

    public List readByDrow();

    public List readByDrowDisable();
    
    public void updatepass(String user11, String password);

    public void updateuser(String employeeCode, String name);

    public void updateLock(String loginName, int userTry);

    public void updateUserTry(String loginName, int userTry);

    public void updateUserTry1(String loginName);

    public void unlockuser(String loginname, String password);

    public List checkUser(String username1, String password1, String user_department1);
    
    public List readEmailId(String email_id);

    public List readByVendorCode(String email);
}
