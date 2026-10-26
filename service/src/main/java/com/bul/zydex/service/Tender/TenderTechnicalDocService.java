/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderTechnicalDocService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo);

    public void deleteRefNo(String refNo);

    public List readByDoc(String refNo, String technicalfile);

    public void updateTenderNo(String refNo1, String refNo);
    
}
