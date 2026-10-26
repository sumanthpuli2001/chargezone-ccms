/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Sap;

import com.bul.zydex.dao.Sap.SapPurchaseItemTxtDao;
import com.bul.zydex.model.SapPurchaseItemTxt;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class SapPurchaseItemTxtServiceImpl<T> extends GenericsServiceImpl<T> implements SapPurchaseItemTxtService<T> {
    
    private SapPurchaseItemTxtDao<T> sapPurchaseItemTxtDao;

    public SapPurchaseItemTxtDao<T> getSapPurchaseItemTxtDao() {
        return sapPurchaseItemTxtDao;
    }

    public void setSapPurchaseItemTxtDao(SapPurchaseItemTxtDao<T> sapPurchaseItemTxtDao) {
        this.sapPurchaseItemTxtDao = sapPurchaseItemTxtDao;
        setGenericsDAO(sapPurchaseItemTxtDao);
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        return sapPurchaseItemTxtDao.readByRefNo(refNo, pur_no, item_no);
    }

    @Override
    public void deleteRefNo(String pur_no, String item_no) {
        sapPurchaseItemTxtDao.deleteRefNo(pur_no, item_no);
    }
}
