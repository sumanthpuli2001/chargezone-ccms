/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderVendorDoc;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderVendorDocService<T> extends GenericsService<T> {

    public List readGeneralDoc(String refNo, String vendor_code, int i);

    public List readAdditionalDoc(String refNo, String vendor_code, int i);

    public List readTechnicalDoc(String refNo, String vendor_code, int i);

    public List readByRefNo(String refNo, String vendor_code);
    
    public List readByDocRefNo(String refNo, String vendor_code, String attachment);

    public void deleteByVendor(String refNo, String vendor_code);
    
}
