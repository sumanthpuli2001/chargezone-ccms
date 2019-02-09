/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.attendanceRegularization;

import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Success
 */
public interface ClientDetailsMasterService<T> extends GenericsService<T> 
{
    public boolean isExist(T object);
}
