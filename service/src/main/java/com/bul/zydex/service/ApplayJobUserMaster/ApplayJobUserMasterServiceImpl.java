/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ApplayJobUserMaster;

import com.bul.zydex.dao.ApplayJobUserMaster.ApplayJobUserMasterDAO;
import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class ApplayJobUserMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ApplayJobUserMasterService<T> {

    private ApplayJobUserMasterDAO<T> applayJobUserMasterDAO;

    public ApplayJobUserMasterDAO<T> getApplayJobUserMasterDAO() {
        return applayJobUserMasterDAO;
    }

    public void setApplayJobUserMasterDAO(ApplayJobUserMasterDAO<T> applayJobUserMasterDAO) {
        this.applayJobUserMasterDAO = applayJobUserMasterDAO;
        setGenericsDAO(applayJobUserMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return applayJobUserMasterDAO.isExist(object);
    }

    @Override
    public boolean profileFilling(int userId) {
        return applayJobUserMasterDAO.profileFilling(userId);
    }

    @Override
    public ApplayJobUserMaster checkByUserNameandPass(T object) {
        return applayJobUserMasterDAO.checkByUserNameandPass(object);
    }

}
