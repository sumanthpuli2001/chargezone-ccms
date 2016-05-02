/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface UserActivityLogService<T> extends GenericsService<T> {

    public List<?> read(T object);

}
