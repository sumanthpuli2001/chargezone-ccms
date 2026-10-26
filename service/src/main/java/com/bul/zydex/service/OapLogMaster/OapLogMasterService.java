/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapLogMaster;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapLogMasterService<T> extends GenericsService<T>  {

    public List readByOapId(String id);

    public List readBycrcid(String id);
    
}
