/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.UserLoginLogDAO;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class UserLoginLogServiceImpl<T> extends GenericsServiceImpl<T>
        implements UserLoginLogService<T> {

    private UserLoginLogDAO<T> userLoginLogDAO;

    public UserLoginLogDAO<T> getUserLoginLogDAO() {
        return userLoginLogDAO;
    }

    public void setUserLoginLogDAO(UserLoginLogDAO<T> userLoginLogDAO) {
        this.userLoginLogDAO = userLoginLogDAO;
        setGenericsDAO(userLoginLogDAO);
    }

    @Override
    public List<?> read(T object) {
        return userLoginLogDAO.read(object);
    }

}
