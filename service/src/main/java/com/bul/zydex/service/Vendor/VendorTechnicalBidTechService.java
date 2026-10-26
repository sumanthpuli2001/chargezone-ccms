/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorTechnicalBidTech;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorTechnicalBidTechService<T> extends GenericsService<T> {

    public List readByVendorRefNo(String refNo, String username);
    
    public List readVendorRefNo(String refNo, String username, String description);

    public void updateVendorRefNo(String refNo, String username, String description, int vendor_response, String remark);

    public List readByReviseVendorBid(String refNo, String username, int revise_technical_bid_id);

    public void updateAdminVendorRefNo(String refNo, String username, String vendor_tech_desc, int parseInt, String tech_vendor_remark, int revise_id);


    public void readByDelete(String refNo, String username);

    
    
    
}
