/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ServiceVendorTenderBidItem4;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceVendorTenderBidItem4Dao<T> extends GenericsDAO<T> {

    public List readVendorRefNo(String file_name, String username, String refNo);

    public List readItemVendorRefNo(String refNo, String username, String file_name, String security_name);

    public void updateItemVendorRefNo(String refNo, String username, String file_name, String security_name, String security, String wage, String per, String total, String allowance, String allowance_total, String uniform, String service, String total_per_day, String total_per_month, String total_per_year, String per_day, String per_month, String per_year, String total_per_day_pp, String total_per_day_per_pp);
    
}
