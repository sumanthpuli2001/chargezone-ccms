/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.UserActivityLogDAO;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class UserActivityLogServiceImpl<T> extends GenericsServiceImpl<T>
        implements UserActivityLogService<T> {

    private UserActivityLogDAO<T> userActivityLogDAO;

    public UserActivityLogDAO<T> getUserActivityLogDAO() {
        return userActivityLogDAO;
    }

    public void setUserActivityLogDAO(UserActivityLogDAO<T> userActivityLogDAO) {
        this.userActivityLogDAO = userActivityLogDAO;
        setGenericsDAO(userActivityLogDAO);
    }

    @Override
    public List<?> read(T object) {
        return userActivityLogDAO.read(object);
    }

}
