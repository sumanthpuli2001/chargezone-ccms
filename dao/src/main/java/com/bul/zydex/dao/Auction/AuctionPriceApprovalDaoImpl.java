/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.AuctionPriceApproval;
import com.bul.zydex.model.AuctionPriceApprovalComment;
import com.bul.zydex.model.AuctionPriceApprovalUser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionPriceApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionPriceApprovalDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionPriceApproval.class;
    }

    @Override
    public boolean isExist(String refNo) {
        boolean flag = false;
        
        String query = "";
        
        query += " SELECT a FROM AuctionPriceApproval a"
                + " WHERE a.auctionNo = '" + refNo + "' and (a.approvalStatus=0 or a.approvalStatus=1 or a.approvalStatus=2) ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }
                 
        return flag ;
    }

    @Override
    public List approvaList(String username) {
        String query = "";
        query += " FROM AuctionPriceApproval a, AuctionPriceApprovalUser b WHERE  a.id  =  b.auctionApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        return getHibernateTemplate().find(query);
    }

    @Override
    public AuctionPriceApproval readByList(String refNo) {
        String query = "";
        AuctionPriceApproval auctionPriceApproval = new AuctionPriceApproval();

        query += " FROM AuctionPriceApproval a"
                + " WHERE a.auctionNo = '" + refNo + "' and (a.approvalStatus=0 or a.approvalStatus=1 or a.approvalStatus=2) ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionPriceApproval = (AuctionPriceApproval) list.get(0);
        }
        return auctionPriceApproval;
    }

    @Override
    public List readByIds(String id) {
        String query = "";
        query += " FROM AuctionPriceApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }
}
