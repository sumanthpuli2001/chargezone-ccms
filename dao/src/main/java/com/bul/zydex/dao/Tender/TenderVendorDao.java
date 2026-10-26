/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderVendor;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderVendorDao<T> extends GenericsDAO<T> {

    public List readByVendor(String refNo, String vendor_code);

    public List readByRefNo(String refNo);

    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId);

    public List vendorList(String refNo);

    public List readByRfqNo(String ref_no);

    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, int checkVendorId1);

    public List readByRfqVendor(String ref_no, String vendor_code);

    public void delete1(int id);

    public List readByRefVendor(String ref_no, String vendor_code);

    public void updateVendor1(String refNo, String vendor_code, String email_id, String mobile_no);

    public TenderVendor readByRefVendor1(String refNo, String checkedValues);

    public List readVendor(String vendor_code);

    public TenderVendor readByRefNo1(String refNo);
    
}
