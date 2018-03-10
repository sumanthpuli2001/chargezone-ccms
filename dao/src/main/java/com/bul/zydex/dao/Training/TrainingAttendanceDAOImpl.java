/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingAttendance;

/**
 *
 * @author Aman
 */
public class TrainingAttendanceDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingAttendanceDAO<T>{

    @Override
    protected Class getDomainClass() {
        return TrainingAttendance.class;
    }
    
}
