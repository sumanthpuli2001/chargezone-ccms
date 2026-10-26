/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuthTenderItemMaster;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuthTenderItemMasterDao<T> extends GenericsDAO<T> {

    public List readByItemNo(String refNo, String pur_no, String item_no);

    public List readByRefNo(String refNo);

    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId);

    public void deleteRefNo(String refNo);
    
}

