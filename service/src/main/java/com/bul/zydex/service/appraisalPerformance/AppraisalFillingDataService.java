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
public interface AppraisalFillingDataService<T> extends GenericsService<T>{
    public boolean isExist(String year);
    public List<?> readByCurrentYear(String cyear);
    public List<?> getCurrentAndPreviousYear();
    public List<?> getappraisalDate();
}
