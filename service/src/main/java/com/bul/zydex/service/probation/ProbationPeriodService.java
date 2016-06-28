/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.probation;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ProbationPeriodService<T> extends GenericsService<T> {

    public List<?> readprobationPeriod();

    public boolean isExist(T object);

    public List<?> readbyDesignation(int id);

}
