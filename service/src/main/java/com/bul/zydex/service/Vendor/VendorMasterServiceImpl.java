/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorMasterDao;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorMasterServiceImpl<T> extends GenericsServiceImpl<T> implements VendorMasterService<T> {
    
    private VendorMasterDao<T> vendorMasterDao;

    public VendorMasterDao<T> getVendorMasterDao() {
        return vendorMasterDao;
    }

    public void setVendorMasterDao(VendorMasterDao<T> vendorMasterDao) {
        this.vendorMasterDao = vendorMasterDao;
        setGenericsDAO(vendorMasterDao);
    }

    @Override
    public VendorMaster read(String vendorCode) {
        return vendorMasterDao.read(vendorCode);
    }

    @Override
    public List readByEmailMobile(String emailid, String mobileNo) {
        return vendorMasterDao.readByEmailMobile(emailid, mobileNo);
    }

    @Override
    public List readByCodeName(String vendor_code, String vendor_name) {
        return vendorMasterDao.readByCodeName(vendor_code, vendor_name);
    }

    @Override
    public List readVendorRegNo(String LIFNR) {
        return vendorMasterDao.readVendorRegNo(LIFNR);
    }

    @Override
    public void updateVendor(String LIFNR, String J_1ILSTNO, String J_1ICSTNO, String STR_SUPPL1, String STR_SUPPL2, String STR_SUPPL3, String CITY1, String POST_CODE1, String CITY2, String STATE, String COUNTRY, String tele, String email) {
        vendorMasterDao.updateVendor(LIFNR, J_1ILSTNO, J_1ICSTNO, STR_SUPPL1, STR_SUPPL2, STR_SUPPL3, CITY1, POST_CODE1, CITY2, STATE, COUNTRY, tele, email);
    }
    
    @Override
    public List readByEmailId(String email_id) {
     return  vendorMasterDao.readByEmailId(email_id);
    }

    @Override
    public List SearchByCode(String vendor_code, String vendor_name, String vendor_remark) {
          return vendorMasterDao.SearchByCode(vendor_code, vendor_name ,vendor_remark);
    }

    @Override
    public VendorMaster readByRegNo(String login_name) {
       return vendorMasterDao.readByRegNo(login_name);
    }
}
