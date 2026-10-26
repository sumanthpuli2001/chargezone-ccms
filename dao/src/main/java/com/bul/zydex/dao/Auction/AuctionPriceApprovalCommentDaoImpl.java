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
public class AuctionPriceApprovalCommentDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionPriceApprovalCommentDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionPriceApprovalComment.class;
    }

    @Override
    public List readByRefNo(int auction_price_approval_id) {
        String query = "";
        query += " FROM AuctionPriceApprovalComment a"
                + " WHERE a.auctionApprovalId = '" + auction_price_approval_id + "' order by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AuctionPriceApprovalComment readByApproveId(int approveId) {
        String query = "";
        AuctionPriceApprovalComment auctionPriceApprovalComment = new AuctionPriceApprovalComment();
        query += " FROM AuctionPriceApprovalComment a"
                + " WHERE a.auctionApprovalId = '" + approveId + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionPriceApprovalComment = (AuctionPriceApprovalComment) list.get(0);
        }
        return auctionPriceApprovalComment;
    }
}
