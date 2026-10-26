/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.SapPurchaseItemTxt;
import java.util.List;


/**
 *
 * @author admin
 */
public interface SapPurchaseItemTxtDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo, String pur_no, String item_no);

    public void deleteRefNo(String pur_no, String item_no);
    
}
