/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Right;

import com.bul.zydex.dao.Right.RightDao;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class RightServiceImpl<T> extends GenericsServiceImpl<T> implements RightService<T> {

    protected RightDao<T> rightDao;

    public RightDao<T> getRightDao() {
        return rightDao;
    }

    public void setRightDao(RightDao<T> rightDao) {
        this.rightDao = rightDao;
        setGenericsDAO(rightDao);
    }

    @Override
    public RightMaster read(String rightName) {
        return rightDao.read(rightName);
    }

    @Override
    public void deleteByRightName(String checkedValues) {
        rightDao.deleteByRightName(checkedValues);
    }

    @Override
    public List readByDrow() {
        return rightDao.readByDrow();
    }

    @Override
    public List readByDrowDisable() {
        return rightDao.readByDrowDisable();
    }

}
