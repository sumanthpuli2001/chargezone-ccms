/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionPriceApprovalUser;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionPriceApprovalUserDao<T> extends GenericsDAO<T> {

    public List readByRefNo(int approveId);

    public AuctionPriceApprovalUser approvaList1(String username);

    public AuctionPriceApprovalUser readByLevel(String auction_no, int level);

    public AuctionPriceApprovalUser approvaList2(int parseInt);
    
}
