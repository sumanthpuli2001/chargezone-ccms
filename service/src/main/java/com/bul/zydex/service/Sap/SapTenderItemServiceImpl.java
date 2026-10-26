/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapTenderItemDao;
import com.bul.zydex.model.SapTenderItem;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class SapTenderItemServiceImpl<T> extends GenericsServiceImpl<T> implements SapTenderItemService<T> {
    
    private SapTenderItemDao<T> sapTenderItemDao;

    public SapTenderItemDao<T> getSapTenderItemDao() {
        return sapTenderItemDao;
    }

    public void setSapTenderItemDao(SapTenderItemDao<T> sapTenderItemDao) {
        this.sapTenderItemDao = sapTenderItemDao;
        setGenericsDAO(sapTenderItemDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return sapTenderItemDao.readByRefNo(refNo);
    }

    @Override
    public List readRefNo(String refNo) {
        return sapTenderItemDao.readRefNo(refNo);
    }

    @Override
    public void deleteRefNo(String refNo) {
        sapTenderItemDao.deleteRefNo(refNo);
    }

    @Override
    public SapTenderItem readId(int id) {
        return sapTenderItemDao.readId(id);
    }
}
