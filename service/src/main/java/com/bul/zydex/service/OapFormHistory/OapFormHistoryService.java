/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapFormHistory;

import com.bul.zydex.model.OapFormHistory;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OapFormHistoryService<T> extends GenericsService<T>{

    public List readBylasttimestatus(int id1);

    public List readByoapid(String id);

    public List readBydocumentno(String documentNo);

    
    
}
