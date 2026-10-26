/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.AuthTenderVendor;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuthTenderVendorService<T> extends GenericsService<T> {

    public List readByVendor(String refNo, String vendor_code);

    public List readByRefNo(String refNo);

    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId);

    public void deleteRefNo(String refNo);

    public void updateVendor1(String refNo, String LIFNR, String email, String tele);
    
}
