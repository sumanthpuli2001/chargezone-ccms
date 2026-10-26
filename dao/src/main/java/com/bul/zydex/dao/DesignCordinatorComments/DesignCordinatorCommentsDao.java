/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DesignCordinatorComments;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DesignCordinatorComments;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface DesignCordinatorCommentsDao<T> extends GenericsDAO<T>  {

    public List readybydelivid(String id);

   
    
}
