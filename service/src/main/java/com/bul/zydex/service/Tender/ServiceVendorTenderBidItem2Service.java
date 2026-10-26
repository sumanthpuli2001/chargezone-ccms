/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.ServiceVendorTenderBidItem2;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceVendorTenderBidItem2Service<T> extends GenericsService<T> {

    public List readVendorRefNo(String file_name, String username, String refNo);

    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no);

    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String item_description, String onlyBearing1, String onlyBearing2, String onlyBearing3, String onlyBearing4, String onlyBearing5, String onlyBearing6, String onlyBearing7, String onlyBearing8, String onlyBearing9, String onlyBearing10);
    
}
