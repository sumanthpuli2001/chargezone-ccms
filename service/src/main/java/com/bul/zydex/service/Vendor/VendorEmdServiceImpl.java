/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorEmdDao;
import com.bul.zydex.model.VendorEmd;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class VendorEmdServiceImpl<T> extends GenericsServiceImpl<T> implements VendorEmdService<T> {
    
    private VendorEmdDao<T> vendorEmdDao;

    public VendorEmdDao<T> getVendorEmdDao() {
        return vendorEmdDao;
    }

    public void setVendorEmdDao(VendorEmdDao<T> vendorEmdDao) {
        this.vendorEmdDao = vendorEmdDao;
        setGenericsDAO(vendorEmdDao);
    }

    @Override
    public VendorEmd readByVendorRefNo(String refNo, String username) {
        return vendorEmdDao.readByVendorRefNo(refNo,username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        return vendorEmdDao.readVendorRefNo(refNo,username);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String emd, String emd_date, String emd_drawee_bank, String emd_attach, String cash_cheque, String emd_cheque_no) {
        vendorEmdDao.updateVendorRefNo(refNo, username, emd, emd_date, emd_drawee_bank, emd_attach, cash_cheque, emd_cheque_no);
    }
}
