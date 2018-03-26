/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.model.TrainingFeedback;
import com.bul.zydex.service.Training.*;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */

public interface TrainingFeedbackService<T> extends GenericsService<T> {
    
     
      public List<?> read();

    public boolean isExist(T t);

 
}
