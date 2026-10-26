/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.model.PRDoc;
import com.bul.zydex.service.PR.PRDocService;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author Bulwark-5
 */
public interface PRDocService<T> extends GenericsService<T> {

    public List readByRefNo(String ref_no);

    public void updatePRNo(String refNo1, String refNo);
    
}
