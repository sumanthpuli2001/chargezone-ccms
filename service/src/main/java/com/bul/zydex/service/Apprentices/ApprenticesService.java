/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Apprentices;

import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface ApprenticesService<T> extends GenericsService<T> {

    public Boolean readByApprenticesCode(String apprenticesCode);

    public ApprenticesMaster read(String apprenticeCode);

    public void deleteByApprenticeCode(String checkedValues);

    public List readShift(String code);

    public ApprenticesMaster readByRfIdValue(String empCode);
}
