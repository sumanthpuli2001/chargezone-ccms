/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRItemMasterDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderItemMasterDao;
import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class PRItemMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PRItemMasterService<T> {

    private PRItemMasterDao<T> prItemMasterDao;

    public PRItemMasterDao<T> getPrItemMasterDao() {
        return prItemMasterDao;
    }

    public void setPrItemMasterDao(PRItemMasterDao<T> prItemMasterDao) {
        this.prItemMasterDao = prItemMasterDao;
        setGenericsDAO(prItemMasterDao);
    }

    @Override
    public List readByRefNo(String refNo, int item_type) {
        return prItemMasterDao.readByRefNo(refNo, item_type);
    }

    @Override
    public void deleteRefNo(String ref_no, int item_type) {
        prItemMasterDao.deleteRefNo(ref_no, item_type);
    }

    @Override
    public PRItemMaster readId(int id) {
        return prItemMasterDao.readId(id);
    }

    @Override
    public void updatePRNo(String refNo1, String refNo) {
        prItemMasterDao.updatePRNo(refNo1, refNo);
    }

    @Override
    public List readByPRItemDesc(String ref_no, String item_desc, int i) {
        return prItemMasterDao.readByPRItemDesc(ref_no, item_desc, i);
    }

    @Override
    public int countByRefNo(String pr_no1, int itemType) {
        return prItemMasterDao.countByRefNo(pr_no1, itemType);
    }

}
