/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderRegret;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TenderRegretService<T> extends GenericsService<T> {

    public List regretList(String refNo);

    public List readByTenderNo(String tender_no, String username);

    public void updateTenderRegret(String tender_no, String username, String remark);

    public List readByVendor(String username);

    public void updateTenderBid(String tender_no, String username);

    public List regretList1(String tender_no);

    
   
    
}
