/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorPreBid;
import java.util.List;
/**
 *
 * @author admin
 */
public interface VendorPreBidDao<T> extends GenericsDAO<T> {

    public VendorPreBid readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username);

    public void updateVendorRefNo(String refNo, String username, String preBidDeviation, String preBidRemark);

    public List vendorList(String refNo);

    public List preBidList(String refNo);

    public List preBidOpenList(String refNo);

    public void openPreBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate);

    public void approvePreBid(String refNo, String checkedValues, String employee_name, String username, String formattedDate);
    
}
