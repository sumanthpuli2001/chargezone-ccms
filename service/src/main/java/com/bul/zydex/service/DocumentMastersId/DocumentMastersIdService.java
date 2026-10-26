/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DocumentMastersId;

import com.bul.zydex.model.DocumentMastersId;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Sumanth
 */
public interface DocumentMastersIdService<T> extends GenericsService<T> {

    public DocumentMastersId readByDocumentNo();
    
}
