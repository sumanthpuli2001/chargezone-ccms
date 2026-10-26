/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.LastWorkExpDeatils;

import com.bul.zydex.dao.LastWorkExpDeatils.LastWorkExpDeatilsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class LastWorkExpDeatilsServiceImpl<T> extends GenericsServiceImpl<T> implements LastWorkExpDeatilsService<T> {

    private LastWorkExpDeatilsDao<T> lastWorkExpDeatilsDao;

    public LastWorkExpDeatilsDao<T> getLastWorkExpDeatilsDao() {
        return lastWorkExpDeatilsDao;
    }

    public void setLastWorkExpDeatilsDao(LastWorkExpDeatilsDao<T> lastWorkExpDeatilsDao) {
        this.lastWorkExpDeatilsDao = lastWorkExpDeatilsDao;
        setGenericsDAO(lastWorkExpDeatilsDao);

    }

    @Override
    public List readByVendorinvitId(int i10) {

        return lastWorkExpDeatilsDao.readByVendorinvitId(i10);
    }

    @Override
    public List readByAllData(String vInfoId, String compName, String contPerson, String mobNo, String emaile, String designatione, String storedFileName) {
        return lastWorkExpDeatilsDao.readByAllData(vInfoId, compName, contPerson, mobNo, emaile, designatione, storedFileName);

    }

    @Override
    public List readByFileNameData(int lwId, String vInfoId, String storedFileName) {
        return lastWorkExpDeatilsDao.readByFileNameData(lwId, vInfoId, storedFileName);
    }

}
