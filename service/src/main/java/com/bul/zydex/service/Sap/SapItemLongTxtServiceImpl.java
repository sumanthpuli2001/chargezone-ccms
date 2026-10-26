/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapItemLongTxtDao;
import com.bul.zydex.model.SapItemLongTxt;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class SapItemLongTxtServiceImpl<T> extends GenericsServiceImpl<T> implements SapItemLongTxtService<T> {
    
    private SapItemLongTxtDao<T> sapItemLongTxtDao;

    public SapItemLongTxtDao<T> getSapItemLongTxtDao() {
        return sapItemLongTxtDao;
    }

    public void setSapItemLongTxtDao(SapItemLongTxtDao<T> sapItemLongTxtDao) {
        this.sapItemLongTxtDao = sapItemLongTxtDao;
        setGenericsDAO(sapItemLongTxtDao);
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        return sapItemLongTxtDao.readByRefNo(refNo, pur_no, item_no);
    }

    @Override
    public List readTxt(String refNo, String pur_no) {
        return sapItemLongTxtDao.readTxt(refNo, pur_no);
    }

    @Override
    public void deleteRefNo(String item_code, String pur_no, String item_no) {
        sapItemLongTxtDao.deleteRefNo(item_code, pur_no, item_no);
    }
}
