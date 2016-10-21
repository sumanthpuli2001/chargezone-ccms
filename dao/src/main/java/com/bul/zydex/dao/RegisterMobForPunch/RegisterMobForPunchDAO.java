/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RegisterMobForPunch;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public interface RegisterMobForPunchDAO<T> extends GenericsDAO<T>{
    List<?> readByEmpId(int id);
    
}
