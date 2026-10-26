/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderItemMaster;
import java.util.List;
/**
 *
 * @author admin
 */
public interface TenderItemMasterDao<T> extends GenericsDAO<T> {

    public List readByItemNo(String refNo, String pur_no, String item_no);

    public List readByRefNo(String refNo);

    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId);

    public void updateTenderNo(String refNo1, String refNo);

    public void deleteRefNo(String ref_no, int item_type);

    public void updateItemDetail(String refNo, String sr_no, String item_detail);

    public List readByItemCode(String itemCode);

    public List readByRefNoAndItemType(String ref_no, int item_type);

    public int countByRefNo(String pr_no1, int item_type);

    public int getMaxSrNo(String ref_no, int item_type);
    
}
