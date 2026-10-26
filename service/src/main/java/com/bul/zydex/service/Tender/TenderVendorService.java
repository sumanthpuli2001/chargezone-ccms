/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TenderVendorService<T> extends GenericsService<T> {

    public List readByVendor(String refNo, String vendor_code);

    public List readByRefNo(String refNo);

    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId);

    public List vendorList(String refNo);

    public List readByRfqNo(String ref_no);

    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, int checkVendorId1);

    public List readByRfqVendor(String ref_no, String vendor_code);

    public void delete1(int parseInt);

    public List readByRefVendor(String ref_no, String vendor_code);

    public void updateVendor1(String refNo, String vendor_code, String email_id, String mobile_no);

    public TenderVendor readByRefVendor1(String refNo, String checkedValues);

    public List readVendor(String vendor_code);

    public TenderVendor readByRefNo1(String refNo);

    
    
    
}
