/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OmsMaster;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.OmsMaster;

/**
 *
 * @author bulwarks-2
 */
public interface OmsMasterDao<T> extends GenericsDAO<T> {

    public OmsMaster readByTickitNoAndPrId(String tickitId, String omsPrId);

    public OmsMaster readByTickitNo(String tickitId);

    public OmsMaster readByPrNo(String prNo, int omsPrFlag);

}
