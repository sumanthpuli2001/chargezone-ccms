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
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public interface AppraisalPerformanceActivitiesService<T> extends GenericsService<T> {

    public List<?> readByAppraisalKraGoalActivities(T object);

    public void delete1(T object);
}
