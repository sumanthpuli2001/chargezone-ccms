/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RegisterMobForPunch;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public interface RegisterMobForPunchService<T> extends GenericsService<T>{
     List<?> readByEmpId(int id);
    
}
