/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRPriceApprovalUser;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRPriceApprovalUserDao<T> extends GenericsDAO<T> {

    public PRPriceApprovalUser approvaList1(String username ,String pr_no);

     public List readByRefNo(int approveId);

    public void deletePr(String refNo);

    public List readByPRNumber(String prNumber);

    
   
    
}
