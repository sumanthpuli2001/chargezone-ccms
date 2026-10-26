/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionNoTemp;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionNoTempDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionNoTempDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionNoTemp.class;
    }

    @Override
    public AuctionNoTemp readLastRecord() {
        AuctionNoTemp auctionNoTemp = new AuctionNoTemp();
        String query = "";
        query += " FROM AuctionNoTemp a"
                + " order by a.id desc limit 1";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionNoTemp = (AuctionNoTemp) list.get(0);
        }
        return auctionNoTemp;
    }
}
