/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface PolicyDeviationForAirService<T> extends GenericsService<T> {

    public List<?> readDetail(T object);

    public List<?> readlevelWise(String object);

}
