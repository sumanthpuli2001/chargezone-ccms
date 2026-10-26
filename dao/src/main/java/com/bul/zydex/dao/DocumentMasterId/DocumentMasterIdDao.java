/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DocumentMasterId;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DocumentMasterId;

/**
 *
 * @author Sumanth
 */
public interface DocumentMasterIdDao<T> extends GenericsDAO<T> {

    public DocumentMasterId readByDocumentNo();
    
}
