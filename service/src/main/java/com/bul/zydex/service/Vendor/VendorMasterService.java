/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;


/**
 *
 * @author admin
 */
public interface VendorMasterService<T> extends GenericsService<T> {
    
    public VendorMaster read(String vendorCode);

    public List readByEmailMobile(String emailid, String mobileNo);

    public List readByCodeName(String vendor_code, String vendor_name);

    public List readVendorRegNo(String LIFNR);

    public void updateVendor(String LIFNR, String J_1ILSTNO, String J_1ICSTNO, String STR_SUPPL1, String STR_SUPPL2, String string, String CITY1, String POST_CODE1, String CITY2, String STATE, String COUNTRY, String tele, String email);
    
    public List readByEmailId(String email_id);

    public List SearchByCode(String vendor_code, String vendor_name, String vendor_remark);

    public VendorMaster readByRegNo(String login_name);
}
