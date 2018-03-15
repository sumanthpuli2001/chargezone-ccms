/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingAttendance;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingAttendanceDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingAttendanceDAO<T>{

    @Override
    protected Class getDomainClass() {
        return TrainingAttendance.class;
    }
    @Override
    public List<?> gettrainingattendance(String eventDate,int id) {
        String query = "select b.id,b.employeeMaster.employeeName,b.status"
                + " FROM TrainingAttendance b"
                + " where STR_TO_DATE(b.trainingDate, '%d/%m/%Y')=STR_TO_DATE('" + eventDate + "', '%d/%m/%Y')"
                + " and b.trainingMaster.id="+id;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
