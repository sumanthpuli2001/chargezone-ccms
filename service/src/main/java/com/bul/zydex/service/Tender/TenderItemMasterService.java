/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderItemMasterService<T> extends GenericsService<T> {

    public List readByItemNo(String refNo, String pur_no, String item_no);

    public List readByRefNo(String refNo);

    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId);

    public void updateTenderNo(String refNo1, String refNo);

    public void deleteRefNo(String ref_no, int item_type);

    public void updateItemDetail(String refNo, String sr_no, String item_detail);

    public List readByItemCode(String itemCode);

    public List readByRefNoAndItemType(String ref_no, int item_type);

    public int countByRefNo(String ref_no, int i);

    public int getMaxSrNo(String ref_no, int i);
    
}
