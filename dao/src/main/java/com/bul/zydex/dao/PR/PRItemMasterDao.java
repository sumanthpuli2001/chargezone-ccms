/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.model.TenderItemMaster;
import java.util.List;
/**
 *
 * @author admin
 */
public interface PRItemMasterDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo, int item_type);

    public void deleteRefNo(String ref_no, int item_type);

    public PRItemMaster readId(int id);

    public void updatePRNo(String refNo1, String refNo);

    public List readByPRItemDesc(String ref_no, String item_desc, int i);

    public int countByRefNo(String pr_no1, int itemType);

    
    
}
