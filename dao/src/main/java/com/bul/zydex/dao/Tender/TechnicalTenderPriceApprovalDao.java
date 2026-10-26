/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TechnicalTenderPriceApproval;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TechnicalTenderPriceApprovalDao<T> extends GenericsDAO<T> {

    public boolean isExist(String refNo);

    public TechnicalTenderPriceApproval readByList(String refNo);

    public TechnicalTenderPriceApproval readByRrecycleList(String refNo);

    public List approvaList(String username);

    public List readByIds(String id);

   
   

   
    
}
