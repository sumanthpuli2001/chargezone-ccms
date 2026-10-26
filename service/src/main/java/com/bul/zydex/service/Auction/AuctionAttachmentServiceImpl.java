/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionAttachmentDao;
import com.bul.zydex.model.AuctionAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionAttachmentService<T> {

    private AuctionAttachmentDao<T> auctionAttachmentDao;

    public AuctionAttachmentDao<T> getAuctionAttachmentDao() {
        return auctionAttachmentDao;
    }

    public void setAuctionAttachmentDao(AuctionAttachmentDao<T> auctionAttachmentDao) {
        this.auctionAttachmentDao = auctionAttachmentDao;
        setGenericsDAO(auctionAttachmentDao);
    }

    @Override
    public List readAuctionGeneralDoc(String refNo) {
        return auctionAttachmentDao.readAuctionGeneralDoc(refNo);
    }

    @Override
    public List readAuctionAdditionalDoc(String refNo) {
        return auctionAttachmentDao.readAuctionAdditionalDoc(refNo);
    }

    @Override
    public List readAuctionTechnicalDoc(String refNo) {
        return auctionAttachmentDao.readAuctionTechnicalDoc(refNo);
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo) {
        auctionAttachmentDao.updateAuctionNo(refNo1, refNo);
    }
}
