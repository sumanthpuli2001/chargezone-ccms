/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionAttachment;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionAttachmentDao<T> {
 
    @Override
    protected Class getDomainClass() {
        return AuctionAttachment.class;
    }

    @Override
    public List readAuctionGeneralDoc(String refNo) {
        String query = "";
        query += " FROM AuctionAttachment a"
                + " WHERE a.auctionNo = '" + refNo + "' and a.attachmentType=0";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readAuctionAdditionalDoc(String refNo) {
        String query = "";
        query += " FROM AuctionAttachment a"
                + " WHERE a.auctionNo = '" + refNo + "' and a.attachmentType=1";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readAuctionTechnicalDoc(String refNo) {
        String query = "";
        query += " FROM AuctionAttachment a"
                + " WHERE a.auctionNo = '" + refNo + "' and a.attachmentType=2";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo) {
        String query = "";
            query += " update AuctionAttachment a"
                + " set a.auctionNo = '"+refNo+"'"
                + " WHERE a.auctionNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
