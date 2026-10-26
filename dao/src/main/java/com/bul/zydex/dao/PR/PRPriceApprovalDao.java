/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRPriceApproval;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRPriceApprovalDao<T> extends GenericsDAO<T> {

    public boolean isExist(String ref_no);

    public List approvaList(String username);

    public List readByIds(String id);

    public List readLog(String prNumber, String open_from_date, String open_to_date);

    public void deletePr(String refNo);

    public List readByprNo(String prNo);

    public PRPriceApproval readByPrNo(String prNo);

    

   
    
}
