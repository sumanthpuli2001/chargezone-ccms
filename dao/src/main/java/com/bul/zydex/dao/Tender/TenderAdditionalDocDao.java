/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderAdditionalDoc;
import java.util.List;
/**
 *interface
 * @author admin
 */
public interface TenderAdditionalDocDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo);

    public void deleteRefNo(String refNo);

    public List readByDoc(String refNo, String additionalfile);

    public void updateTenderNo(String refNo1, String refNo);
    
}
