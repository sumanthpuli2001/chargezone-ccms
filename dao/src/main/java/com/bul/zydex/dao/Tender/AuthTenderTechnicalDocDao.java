/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuthTenderTechnicalDoc;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AuthTenderTechnicalDocDao<T> extends GenericsDAO<T> {
    
    public List readByRefNo(String refNo);

    public void deleteRefNo(String refNo);

    public List readByDoc(String refNo, String tenderTechnicalDocument1);

    public void deleteDoc(String docid);
}
