/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionPriceApproval;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionPriceApprovalDao<T> extends GenericsDAO<T> {

    public boolean isExist(String refNo);

    public List approvaList(String username);

    public AuctionPriceApproval readByList(String refNo);

    public List readByIds(String id);
    
}
