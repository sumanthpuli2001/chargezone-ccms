/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapDeliSchDao;
import com.bul.zydex.model.SapDeliSch;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class SapDeliSchServiceImpl<T> extends GenericsServiceImpl<T> implements SapDeliSchService<T> {

    private SapDeliSchDao<T> sapDeliSchDao;

    public SapDeliSchDao<T> getSapDeliSchDao() {
        return sapDeliSchDao;
    }

    public void setSapDeliSchDao(SapDeliSchDao<T> sapDeliSchDao) {
        this.sapDeliSchDao = sapDeliSchDao;
        setGenericsDAO(sapDeliSchDao);
    }

    @Override
    public List readData(String refNo, String pur_no, String item_no) {
        return sapDeliSchDao.readData(refNo, pur_no, item_no);
    }

    @Override
    public void deleteRefNo(String item_code) {
        sapDeliSchDao.deleteRefNo(item_code);
    }
}

