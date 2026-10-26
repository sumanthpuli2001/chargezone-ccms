/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ClosePr;

import com.bul.zydex.dao.BpGroup.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.ClosePr;

/**
 *
 * @author bulwarks-2
 */
public interface ClosePrDao <T> extends GenericsDAO<T>{

    public ClosePr readByPrID(int id);

    
}
