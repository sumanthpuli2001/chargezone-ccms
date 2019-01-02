/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingMaster;
import java.util.LinkedList;

/**
 *
 * @author Rishi
 */
public class TrainingMasterDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingMaster.class;
    }

    @Override
    public void deletetrainingSubMaster(final Integer id) {
        String query = ""
                + " delete FROM TrainingSubMaster b"
                + " where b.trainingMasterid IN (" + id + ")";
        getHibernateTemplate().bulkUpdate(query);
    }

    @Override
    public List<?> fetchtrainingMaster(String date) {
        String query = ""
                + "FROM TrainingMaster b"
                + " where STR_TO_DATE(b.endDate, '%d/%m/%Y')>=STR_TO_DATE('" + date + "', '%d/%m/%Y')";
        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

    @Override
    public List<?> fetchtTrainingforFeedback(int traininigId, int user) {
        String query = ""
                //                + "select b.id, b.trainingFeedback.feedaback,b.employeeMaster.employeeName FROM EmployeeFeedback b"
                //                + " where b.trainingMaster.id=" + traininigId
                //                + " and b.employeeMaster.id in("
                //                + " SELECT a.id"
                //                + " FROM EmployeeMaster a "
                //                + " left join a.departmentMaster b "
                //                + " left join a.designationMaster c "
                //                + " WHERE a.reportingManagerLevel1  like '%" + user + "%')";
                + "select a.trainingMaster.trainingTitle, a.trainingFeedback.feedaback, description, dateTime,a.employeeMaster.employeeName,a.id from EmployeeFeedback a"
                //                +" where a.trainingMaster.id="+traininigId+" and a.employeeMaster.id= a.trainingMaster.trainer.id="+user;
                + " where a.employeeMaster.id in(select b.employeeMaster.id from TrainingIdentification b where b.trainingMaster.id=" + traininigId + ")";

        List<?> list = getHibernateTemplate().find(query);

        return list;

    }

    @Override
    public List<?> readTrainingMasterList() {
        String query = " "
                + " select a.id, a.trainingTitle, a.trainingDescription, b.trainerName,c.training, a.startDate, a.endDate "
                + " FROM TrainingMaster a "
                + " left join a.trainer b "
                + " left join a.trainingType c"
                + " order by a.id desc";
        List finallist = new LinkedList();
        List<?> list = getHibernateTemplate().find(query);
        for (Object list1 : list) {
            List slist = new LinkedList();
            Object[] o = (Object[]) list1;
            slist.add(o[0]);
            slist.add(o[1]);
            slist.add(o[2]);
            slist.add(o[3]);
            slist.add(o[4]);
            slist.add(o[5]);
            slist.add(o[6]);
            finallist.add(slist);
        }
        return finallist;

    }

    @Override
    public List<?> fetchtTrainingforFeedback1(int traininigId, int user) {
        String query = ""
                //                + "select b.id, b.trainingFeedback.feedaback,b.employeeMaster.employeeName FROM EmployeeFeedback b"
                //                + " where b.trainingMaster.id=" + traininigId
                //                + " and b.employeeMaster.id in("
                //                + " SELECT a.id"
                //                + " FROM EmployeeMaster a "
                //                + " left join a.departmentMaster b "
                //                + " left join a.designationMaster c "
                //                + " WHERE a.reportingManagerLevel1  like '%" + user + "%')";
                + "select a.trainingMaster.trainingTitle, a.trainingFeedback.feedaback, description, dateTime,a.employeeMaster.employeeName,a.id from EmployeeFeedback a"
                //                +" where a.trainingMaster.id="+traininigId+" and a.employeeMaster.id= a.trainingMaster.trainer.id="+user;
                + " where a.employeeMaster.id in(select b.employeeMaster.id from TrainingIdentification b where b.trainingMaster.id=" + traininigId + ")"
                + " AND a.trainingMaster.trainer.id =" + traininigId;

        List<?> list = getHibernateTemplate().find(query);

        return list;

    }

    @Override
    public List<?> fetchtTrainingforFeedback2(int traininigId) {
        String query = ""
                + "select a.trainingMaster.trainingTitle, a.trainingFeedback.feedaback, description, dateTime,a.employeeMaster.employeeName,a.id from EmployeeFeedback a"
                + " where a.trainingMaster.id =" + traininigId;

        List<?> list = getHibernateTemplate().find(query);

        return list;

    }

    @Override
    public List<?> readTrainingMasterSummaryList() {
        String query = " "
                + " select a.id, a.trainingTitle, a.trainingDescription, b.trainerName,c.training, a.startDate, a.endDate,d.departmentName,a.status,a.finishStatus"
                + " FROM TrainingMaster a "
                + " left join a.trainer b "
                + " left join a.trainingType c"
                + " left join a.departmentMaster d"
                + " order by a.id desc";
        List finallist = new LinkedList();
        List<?> list = getHibernateTemplate().find(query);
        for (Object list1 : list) {
            List slist = new LinkedList();
            Object[] o = (Object[]) list1;
            slist.add(o[0]);
            slist.add(o[1]);
            slist.add(o[2]);
            slist.add(o[3]);
            slist.add(o[4]);
            slist.add(o[5]);
            slist.add(o[6]);
            slist.add(o[7]);
            slist.add(o[8]);
            slist.add(o[9]);
            finallist.add(slist);
        }
        return finallist;

    }

}
