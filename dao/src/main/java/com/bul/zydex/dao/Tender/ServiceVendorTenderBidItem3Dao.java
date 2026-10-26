/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ServiceVendorTenderBidItem3;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceVendorTenderBidItem3Dao<T> extends GenericsDAO<T> {

    public List readVendorRefNo(String file_name, String username, String refNo);

    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no);

    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String particular, String scheduled_amount, String percentage, String percentage_amount, String net_rate, String vendor_remark, String item_regret);
    
}
