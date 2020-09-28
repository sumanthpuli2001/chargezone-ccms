/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Apprentices;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ApprenticesMaster;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface ApprenticesDao<T> extends GenericsDAO<T> {

    public Boolean readByApprenticesCode(String apprenticesCode);

    public ApprenticesMaster read(String apprenticeCode);

    public void deleteByApprenticeCode(String checkedValues);

    public List readShift(String code);

    public ApprenticesMaster readByRfIdValue(String empCode);
}
