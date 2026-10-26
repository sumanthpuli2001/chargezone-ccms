/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderPriceApprovalService<T> extends GenericsService<T> {

    public List approvaList(String username);

    public List readByIds(String id);

    public List readByTenRefNo(String refNo);

    public TenderPriceApproval readByRefNo(String refNo);

    public boolean isExist(String refNo);

    public TenderPriceApproval readByList(String refNo);

    public TenderPriceApproval readByRrecycleList(String refNo);

}
