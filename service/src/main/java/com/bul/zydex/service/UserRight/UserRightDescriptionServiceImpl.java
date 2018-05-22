/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.UserRight;

import com.bul.zydex.dao.UserRight.UserRightDescriptionDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman
 */
public class UserRightDescriptionServiceImpl<T> extends GenericsServiceImpl<T> implements UserRightDescriptionService<T>{
    
    private UserRightDescriptionDAO<T> userRightDescriptionDAO;

    public UserRightDescriptionDAO<T> getUserRightDescriptionDAO() {
        return userRightDescriptionDAO;
    }

    public void setUserRightDescriptionDAO(UserRightDescriptionDAO<T> userRightDescriptionDAO) {
        this.userRightDescriptionDAO = userRightDescriptionDAO;
        setGenericsDAO(userRightDescriptionDAO);
    }
    
    
}
