/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderItemMasterDao;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderItemMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TenderItemMasterService<T> {

    private TenderItemMasterDao<T> tenderItemMasterDao;

    public TenderItemMasterDao<T> getTenderItemMasterDao() {
        return tenderItemMasterDao;
    }

    public void setTenderItemMasterDao(TenderItemMasterDao<T> tenderItemMasterDao) {
        this.tenderItemMasterDao = tenderItemMasterDao;
        setGenericsDAO(tenderItemMasterDao);
    }

    @Override
    public List readByItemNo(String refNo, String pur_no, String item_no) {
        return tenderItemMasterDao.readByItemNo(refNo, pur_no, item_no);
    }

    @Override
    public List readByRefNo(String refNo) {
        return tenderItemMasterDao.readByRefNo(refNo);
    }

    @Override
    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId) {
        tenderItemMasterDao.updateByItemNo(refNo, pur_no, item_no, item_remark, qty, checkId);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        tenderItemMasterDao.updateTenderNo(refNo1, refNo);
    }

    @Override
    public void deleteRefNo(String ref_no, int item_type) {
        tenderItemMasterDao.deleteRefNo(ref_no, item_type);
    }

    @Override
    public void updateItemDetail(String refNo, String sr_no, String item_detail) {
        tenderItemMasterDao.updateItemDetail(refNo, sr_no, item_detail);
    }

    @Override
    public List readByItemCode(String itemCode) {
        return tenderItemMasterDao.readByItemCode(itemCode);
    }

    @Override
    public List readByRefNoAndItemType(String ref_no, int item_type) {
        return tenderItemMasterDao.readByRefNoAndItemType(ref_no, item_type);
    }

    @Override
    public int countByRefNo(String pr_no1, int item_type) {
        return tenderItemMasterDao.countByRefNo(pr_no1, item_type);
    }

    @Override
    public int getMaxSrNo(String ref_no, int item_type) {
        return tenderItemMasterDao.getMaxSrNo(ref_no, item_type);
    }
}
