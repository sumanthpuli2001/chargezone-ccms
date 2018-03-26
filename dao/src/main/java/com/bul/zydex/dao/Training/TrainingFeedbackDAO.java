/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.Training.*;
import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */

public interface TrainingFeedbackDAO<T> extends GenericsDAO<T> {

    public List<?> read();
   public boolean isExist(T t);
    
}
