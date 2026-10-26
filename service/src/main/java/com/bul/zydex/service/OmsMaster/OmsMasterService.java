/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OmsMaster;

import com.bul.zydex.model.OmsMaster;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author bulwarks-2
 */
public interface OmsMasterService<T> extends GenericsService<T> {

    public OmsMaster readByTickitNoAndPrId(String tickitId, String omsPrId);

    public OmsMaster readByTickitNo(String tickitId);

    public OmsMaster readByPrNo(String prNo, int omsPrFlag);

}
