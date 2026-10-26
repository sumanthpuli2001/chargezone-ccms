/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorInfoDao;
import com.bul.zydex.model.VendorInfo;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorInfoServiceImpl<T> extends GenericsServiceImpl<T> implements VendorInfoService<T> {
    
    private VendorInfoDao<T> vendorInfoDao;

    public VendorInfoDao<T> getVendorInfoDao() {
        return vendorInfoDao;
    }

    public void setVendorInfoDao(VendorInfoDao<T> vendorInfoDao) {
        this.vendorInfoDao = vendorInfoDao;
        setGenericsDAO(vendorInfoDao);
    }

    @Override
    public List readData(String stno, String vatno, String panno) {
        return vendorInfoDao.readData(stno, vatno, panno);
    }

    @Override
    public VendorInfo readData1(String stno, String vatno, String panno) {
        return vendorInfoDao.readData1(stno, vatno, panno);
    }

    @Override
    public List searchVendor(String fname, String sfirm, String rdate, String cinno, String address, String pinno, String cperson, String officeno, String resino, String mobno, String faxno, String email1, String email2, String salesno, String stno, String cstno, String vatno, String panno, String tenderno) {
        return vendorInfoDao.searchVendor(fname, sfirm, rdate, cinno, address, pinno, cperson, officeno, resino, mobno, faxno, email1, email2, salesno, stno, cstno, vatno, panno, tenderno);
    }
}
