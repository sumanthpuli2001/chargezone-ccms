/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.model.AuctionAttachment;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionAttachmentService<T> extends GenericsService<T> {

    public List readAuctionGeneralDoc(String refNo);

    public List readAuctionAdditionalDoc(String refNo);

    public List readAuctionTechnicalDoc(String refNo);

    public void updateAuctionNo(String refNo1, String refNo);
    
}
