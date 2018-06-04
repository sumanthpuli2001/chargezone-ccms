/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Kaizen;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KaizenMaster;
import java.util.List;

/**
 *
 * @author Aman
 */
public class KaizenMasterDAOImpl<T> extends GenericsDAOImpl<T> implements KaizenMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return KaizenMaster.class;
    }

    @Override
    public List<?> readKaizenMaster() {
        String query = "";
        query += " Select a.id,a.srNo, a.status, e.employeeName"
                + " From KaizenMaster a , EmployeeMaster e"
                + " where a.status = 1 "
                + " AND e.userMaster.id=a.createdBy ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readKaizenMaster(Integer id) {
        //                              0    1         2          3          4
        String query = "SELECT  a.id,a.srNo, a.status, a.teamName, e.employeeName "
                + " FROM KaizenMaster a , EmployeeMaster e"
                + " WHERE a.reportingId = " + id
                + " And e.id = a.createdBy"
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readKaizenList() {
        String query = "";
        query += " SELECT a.id "
                + "FROM KaizenMaster a ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readKaizenMasterapprovalList(Integer id) {
        //                                0    1           2           3           4               5           6
        String query = "SELECT  km.id,km.srNo, km.teamName, km.status, km.currentLevel, ka.level ,km.department"
                + " From KaizenApproval ka "
                + " Left join ka.kaizenMaster km "
                + " Left join ka.employeeMaster em "
                + " where km.currentLevel >= ka.level"
                + " AND km.status != 5 "
                + " AND ka.employeeMaster.id = " + id
                + " order by ka.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readKaizenMasterList(Integer id) {
        String query = "";
//                          0       1       2       3               4          5
        query += " Select a.id, a.srNo, a.status, a.teamName, a.teamName ,a.department"
                + " From KaizenMaster a, EmployeeMaster e"
                + " where a.createdBy=" + id
                + " AND e.id = a.createdBy  ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readPastKaizenMaster() {
        String query = "";
//                          0       1       2          3               4          5              
        query += " Select a.id, a.srNo,a.teamMember,a.department,a.startDate,a.ideaGenerator,"
//                      6                   7               8           9
                + "a.problemDescription,a.compiletionDate,a.status ,em.employeeName"
                + " From KaizenMaster a , EmployeeMaster em "
                + " Where a.status = 5  AND a.createdBy = em.id";
               
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
