/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorFeeDao;
import com.bul.zydex.model.VendorFee;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class VendorFeeServiceImpl<T> extends GenericsServiceImpl<T> implements VendorFeeService<T> {

    private VendorFeeDao<T> vendorFeeDao;

    public VendorFeeDao<T> getVendorFeeDao() {
        return vendorFeeDao;
    }

    public void setVendorFeeDao(VendorFeeDao<T> vendorFeeDao) {
        this.vendorFeeDao = vendorFeeDao;
        setGenericsDAO(vendorFeeDao);
    }

    @Override
    public VendorFee readByVendorRefNo(String refNo, String username) {
        return vendorFeeDao.readByVendorRefNo(refNo,username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        return vendorFeeDao.readVendorRefNo(refNo,username);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String doc_cost, String fee_date, String fee_drawee_bank, String fee_attach, String fee_cheque_no) {
        vendorFeeDao.updateVendorRefNo(refNo, username, doc_cost, fee_date, fee_drawee_bank, fee_attach, fee_cheque_no);
    }
}
