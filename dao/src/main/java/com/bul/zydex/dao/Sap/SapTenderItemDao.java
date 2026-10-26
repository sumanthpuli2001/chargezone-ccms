/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.SapTenderItem;
import java.util.List;
/**
 *
 * @author admin
 */
public interface SapTenderItemDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo);

    public List readRefNo(String refNo);

    public void deleteRefNo(String refNo);

    public SapTenderItem readId(int id);
    
}
