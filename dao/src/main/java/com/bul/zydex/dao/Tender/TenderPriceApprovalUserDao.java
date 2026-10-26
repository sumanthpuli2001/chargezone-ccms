/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderPriceApprovalUserDao<T> extends GenericsDAO<T> {

    public TenderPriceApprovalUser approvaList1(String username);

    public List readByRefNo(int approveId);

    public List approvedTenderList(String username);

    public List holdTenderList(String username);

    public TenderPriceApprovalUser readByLevel(String tender_no, int level);

    public List auditorReworkTenderList(String username);

    public TenderPriceApprovalUser approvaList2(int parseInt);
   
    
}
