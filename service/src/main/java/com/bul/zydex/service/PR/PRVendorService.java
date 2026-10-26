/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.model.PRVendor;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface PRVendorService<T> extends GenericsService<T> {

    public List readByRfqNo(String ref_no);

   public void delete1(int parseInt);

    public PRVendor readId(int parseInt);

    public void updatePRNo(String refNo1, String refNo);

    public List readByRfqVendor(String ref_no, String vendor_code);

    
}
