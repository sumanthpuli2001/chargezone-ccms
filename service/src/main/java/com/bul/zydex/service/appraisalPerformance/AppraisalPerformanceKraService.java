/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AppraisalPerformanceKraService<T> extends GenericsService<T> {

    public List<?> readByAppraisalKraGoal(T object);

    public List<?> readByAppraisalPerformancekraId(T object);

    public void delete1(T object);
    public List<?> readByAppraisalKraGoal1(T object);
}
