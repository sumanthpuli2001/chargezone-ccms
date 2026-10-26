/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TechnicalTenderPriceApprovalUser;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TechnicalTenderPriceApprovalUserDao<T> extends GenericsDAO<T> {

    public List readByRefNo(int approveId);

    public TechnicalTenderPriceApprovalUser approvaList2(int id);

    public TechnicalTenderPriceApprovalUser readByLevel(String tender_no, int level);

    
   
    
}
