/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ClosePr;

import com.bul.zydex.service.BpGroup.*;
import com.bul.zydex.dao.BpGroup.BpGroupDao;
import com.bul.zydex.dao.ClosePr.ClosePrDao;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.ClosePr;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author bulwarks-2
 */
public class ClosePrServiceImpl<T> extends GenericsServiceImpl<T> implements ClosePrService<T> {

    private ClosePrDao<T> closePrDao;

    public ClosePrDao<T> getClosePrDao() {
        return closePrDao;
    }

    public void setClosePrDao(ClosePrDao<T> closePrDao) {
        this.closePrDao = closePrDao;
        setGenericsDAO(closePrDao);
    }

    @Override
    public ClosePr readByPrID(int id) {
        return closePrDao.readByPrID(id);
    }

}
