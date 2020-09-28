/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Apprentices;

import com.bul.zydex.dao.Apprentices.ApprenticesDao;
import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class ApprenticesServiceImpl<T> extends GenericsServiceImpl<T> implements ApprenticesService<T> {

    private ApprenticesDao<T> apprenticesDao;

    public ApprenticesDao<T> getApprenticesDao() {
        return apprenticesDao;
    }

    public void setApprenticesDao(ApprenticesDao<T> apprenticesDao) {
        this.apprenticesDao = apprenticesDao;
        setGenericsDAO(apprenticesDao);
    }

    @Override
    public Boolean readByApprenticesCode(String apprenticesCode) {
        return apprenticesDao.readByApprenticesCode(apprenticesCode);
    }

    @Override
    public ApprenticesMaster read(String apprenticeCode) {
        return apprenticesDao.read(apprenticeCode);
    }

    @Override
    public void deleteByApprenticeCode(String checkedValues) {
        apprenticesDao.deleteByApprenticeCode(checkedValues);
    }

    @Override
    public List readShift(String code) {
        return apprenticesDao.readShift(code);
    }

    @Override
    public ApprenticesMaster readByRfIdValue(String empCode) {
        return apprenticesDao.readByRfIdValue(empCode);
    }

}
