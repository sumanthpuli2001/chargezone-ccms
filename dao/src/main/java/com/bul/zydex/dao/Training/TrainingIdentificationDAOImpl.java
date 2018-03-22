/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingIdentification;
import java.util.LinkedList;
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

    @Override
    public List<?> readTrainingIdentificationList() {
        String query = "";

        query += " "
                + " SELECT a.id, b.employeeName, c.trainingTitle, a.description "
                + " FROM TrainingIdentification a "
                + " left join a.employeeMaster b "
                + " left join a.trainingMaster c "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readTrainingList(String eventDate,int userid) {
        String query = ""
                + " SELECT b.id ,b.trainingTitle"
                + " FROM TrainingIdentification a"
                + " LEFT JOIN a.trainingMaster b "
                + " WHERE STR_TO_DATE(b.startDate, '%d/%m/%Y')=STR_TO_DATE('" + eventDate + "', '%d/%m/%Y')"
                + " And a.employeeMaster.id=" + userid;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTraingFeedback() {
        String query = "";
        query += " "
                + " SELECT  a "
                + "FROM TrainingFeedback a ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
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
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<?> ListeventDates(String eventDate, int userId) {
        String query = "select b.trainingMasterid,b.title,b.trainingdate"
                + " FROM TrainingSubMaster b"
                + " where STR_TO_DATE(b.trainingdate, '%d/%m/%Y')=STR_TO_DATE('" + eventDate + "', '%d/%m/%Y')"
                + " AND b.trainerMasterid=" + userId;
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            List finallist = new LinkedList();
            for (Object list1 : list) {
                Object Objectarr[] = (Object[]) list1;
                List semifinallist = new LinkedList();
                semifinallist.add(Objectarr[0]);
                semifinallist.add(Objectarr[1]);
                semifinallist.add(Objectarr[2]);
                finallist.add(semifinallist);
            }

            return finallist;
        }
        return list;
    }

}
