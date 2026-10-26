/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionVendor;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionVendorDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String ref_no);

    public List readByRefVendor(String ref_no, String vendor_code);

    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, String start_price, String loading_factor_per, String loading_factor_val, String final_price, int checkVendorId);

    public AuctionVendor readByVendorAuction(String auction_no, String username);

    public void updateAuctionNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, String start_price, String loading_factor_per, String loading_factor_val, String final_price, int checkVendorId);

    public List readByRefNoL1(String auction_no);

    public List readByRefNoH1(String auction_no);
    
}
