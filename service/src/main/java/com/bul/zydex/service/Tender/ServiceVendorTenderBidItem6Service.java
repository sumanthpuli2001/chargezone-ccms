/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.ServiceVendorTenderBidItem6;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceVendorTenderBidItem6Service<T> extends GenericsService<T> {

    public List readVendorRefNo(String file_name, String username, String refNo);

    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no);

    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String pc_type, String item_description, String uom, String qty, String amc_required_day, String rate, String net_rate, String vendor_remark, String item_regret);
    
}
