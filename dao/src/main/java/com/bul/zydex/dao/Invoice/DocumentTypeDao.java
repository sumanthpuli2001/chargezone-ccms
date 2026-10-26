/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Invoice;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DocumentTypeDao <T> extends GenericsDAO<T>{

    public List getDocumentPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalChargerCount();

    public int getFilteredChargerCount(String searchValue);
    
}
