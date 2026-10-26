/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Deliverable;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.Deliverable;

/**
 *
 * @author Sumanth
 */
public interface DeliverableDao<T> extends GenericsDAO<T>  {

    public Deliverable readByoapid(String id);

    public Deliverable readByAOcid(String id);
    
}
