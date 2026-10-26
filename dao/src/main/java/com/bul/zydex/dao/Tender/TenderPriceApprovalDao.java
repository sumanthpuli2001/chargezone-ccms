/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderPriceApprovalDao<T> extends GenericsDAO<T> {

    public List approvaList(String username);

    public List readByIds(String id);

    public TenderPriceApproval readByRefNo(String refNo);

    public List readByTenRefNo(String refNo);

    public boolean isExist(String refNo);

    public TenderPriceApproval readByList(String refNo);

    public TenderPriceApproval readByRrecycleList(String refNo);

}
