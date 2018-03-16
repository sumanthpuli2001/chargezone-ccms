/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingIdentification;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingIdentificationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingIdentification.class;
    }

    public List<?> gettrainingattendance(int id) {
        String query = "select b.id,c.employeeName"
                + " FROM TrainingIdentification b"
                + " left join b.employeeMaster c"
                + " where b.trainingMaster.id=" + id;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    public List<?> getTrainerAttendance(int id) {
        String query = "select c.id,c.employeeName"
                + " FROM TrainingIdentification b"
                + " left join b.employeeMaster c"
                + " where b.trainingMaster.id=" + id;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public Boolean checkExistance(int trainingId, int empId, int trainerId) {
        String query = "select b.id"
                + " FROM TrainingAttendance b"
                + " where b.trainingMaster.id=" + trainingId
                + " AND b.trainer.id=" + trainerId
                + " AND b.employeeMaster.id=" + empId;
        List<?> list = getHibernateTemplate().find(query);
        if(list.isEmpty()){
        return true;
        }
        return false;
    }

   
   
}
