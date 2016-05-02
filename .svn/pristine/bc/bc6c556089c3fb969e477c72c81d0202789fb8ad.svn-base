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
        

//        List<?> list = userMasterDAO.read();
//        Iterator i = list.iterator();
//        while (i.hasNext()) {
//            user = (UserMaster) i.next();
//            if (!(user.getUserName().toLowerCase()
//                    .equals(user2.getUserName().toLowerCase()) && user
//                    .getPassword().toLowerCase()
//                    .equals(user2.getPassword().toLowerCase()))) {
//                i.remove();
//            }
//        }
//        return list;
    }

    @Override
    public boolean isExist(String userName) {

        return userMasterDAO.isExist(userName);
    }
}
