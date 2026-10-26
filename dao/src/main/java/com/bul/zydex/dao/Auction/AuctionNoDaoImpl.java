/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionNo;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionNoDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionNoDao<T> {
 
    @Override
    protected Class getDomainClass() {
        return AuctionNo.class;
    }

    @Override
    public AuctionNo readByAuctionNo() {
        AuctionNo auctionNo = new AuctionNo();
        String query = "";
        query += " FROM AuctionNo a order by a.auctionNo desc limit 1"
                + " ";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionNo = (AuctionNo) list.get(0);
        }
        return auctionNo;
    }
}
