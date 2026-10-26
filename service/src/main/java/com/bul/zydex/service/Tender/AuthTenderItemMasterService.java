/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.AuthTenderItemMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AuthTenderItemMasterService<T> extends GenericsService<T> {

    public List readByItemNo(String refNo, String pur_no, String item_no);

    public List readByRefNo(String refNo);

    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId);

    public void deleteRefNo(String refNo);
    
}
