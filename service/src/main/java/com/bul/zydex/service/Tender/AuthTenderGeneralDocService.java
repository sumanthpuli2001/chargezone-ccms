/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.AuthTenderGeneralDoc;
import com.bul.zydex.service.GenericsService;
import java.util.List;


/**
 *
 * @author admin
 */
public interface AuthTenderGeneralDocService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo);

    public void deleteRefNo(String refNo);

    public List readByDoc(String refNo, String tenderGeneralDocument);

    public void deleteDoc(String docid);
    
}
