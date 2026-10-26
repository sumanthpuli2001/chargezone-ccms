/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.SapItemLongTxt;
import java.util.List;


/**
 *
 * @author admin
 */
public interface SapItemLongTxtDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo, String pur_no, String item_no);

    public List readTxt(String refNo, String pur_no);

    public void deleteRefNo(String item_code, String pur_no, String item_no);
    
}
