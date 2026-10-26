/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionNo;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionNoDao<T> extends GenericsDAO<T> {

    public AuctionNo readByAuctionNo();
    
}
