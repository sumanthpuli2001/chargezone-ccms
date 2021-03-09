/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RechargeInfo;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RechargeInfoMaster;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class RechargeInfoDaoImpl<T> extends GenericsDAOImpl<T> implements RechargeInfoDao<T> {

    @Override
    protected Class getDomainClass() {
        return RechargeInfoMaster.class;
    }

    @Override
    public List readMaxId(String rfId) {
        String quey = " select Max(a.id),Max(a.date) from "
                + " RechargeInfoMaster a "
                + " where a.rfId= '" + rfId + "'"
                + " order by a.id";

        return getHibernateTemplate().find(quey);
    }

    @Override
    public List readRAmount(String rfId) {
        String quey = " select a from "
                + " RechargeInfoMaster a "
                + " where a.rfId= '" + rfId + "'"
                + " order by a.id desc ";

        return getHibernateTemplate().find(quey);

    }

    @Override
    public List readDistinctEmp() {
        String quey = " select distinct a.rfId from "
                + " RechargeInfoMaster a ";
        return getHibernateTemplate().find(quey);

    }

    @Override
    public List readEmpLatestRecharge(String rfId) {
        String quey = " select a from "
                + " RechargeInfoMaster a "
                + " where a.rfId= '" + rfId + "'"
                + " order by a.id desc ";
        return getHibernateTemplate().find(quey);

    }

    @Override
    public List readByRfidAndDate(String date, String rfId) {
        String quey = " select a from "
                + " RechargeInfoMaster a "
                + " where a.rfId= '" + rfId + "'"
                + " and (STR_TO_DATE(a.date,'%Y-%m-%d') = STR_TO_DATE('" + date + "', '%Y-%m-%d')) ";
        return getHibernateTemplate().find(quey);
    }
    
     @Override
    public List countAmount(String rfId) {
        String quey = " select a.id,a.amount,a.rfId,a.date,a.rAmount "
                + "From RechargeInfoMaster a "
                + "where a.rfId='" + rfId + "'"
                + " order by a.id desc limit 1 ";
        return getHibernateTemplate().find(quey);

    }

}
