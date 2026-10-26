/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TenderCommitteeService<T> extends GenericsService<T> {

    public List readByRefNo(String ref_no, String bid_type);

    public List readByRefUser(String ref_no, String employee_code, String bid_type);

    public void updateStatus(String refNo, String username1, String string);

    public void updateTenderNo(String refNo1, String refNo);

    public List readByRefNoUser(String refNo, String username);
    
    public void deleteByRefNo(String ref_no, String bid_type);

    public List readByRefNoUser1(String refNo, String username);
    
}
