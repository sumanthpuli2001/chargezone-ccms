/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.CommMasterDao;
import com.bul.zydex.model.CommMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class CommMasterServiceImpl<T> extends GenericsServiceImpl<T> implements CommMasterService<T> {
    
    private CommMasterDao<T> commMasterDao;

    public CommMasterDao<T> getCommMasterDao() {
        return commMasterDao;
    }

    public void setCommMasterDao(CommMasterDao<T> commMasterDao) {
        this.commMasterDao = commMasterDao;
        setGenericsDAO(commMasterDao);
    }

    @Override
    public List readTenderVendorComm(String tender_no, String username) {
        return commMasterDao.readTenderVendorComm(tender_no, username);
    }

    @Override
    public void updateRead(String id) {
        commMasterDao.updateRead(id);
    }

    @Override
    public List readTenderComm(String tender_no) {
        return commMasterDao.readTenderComm(tender_no);
    }
}
