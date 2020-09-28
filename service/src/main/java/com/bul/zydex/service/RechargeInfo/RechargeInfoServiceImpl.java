/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RechargeInfo;

import com.bul.zydex.dao.RechargeInfo.RechargeInfoDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class RechargeInfoServiceImpl<T> extends GenericsServiceImpl<T> implements RechargeInfoService<T> {

    private RechargeInfoDao<T> rechargeInfoDao;

    public RechargeInfoDao<T> getRechargeInfoDao() {
        return rechargeInfoDao;
    }

    public void setRechargeInfoDao(RechargeInfoDao<T> rechargeInfoDao) {
        this.rechargeInfoDao = rechargeInfoDao;
        setGenericsDAO(rechargeInfoDao);
    }

    @Override
    public List readMaxId(String rfId) {
        return rechargeInfoDao.readMaxId(rfId);
    }

    @Override
    public List readRAmount(String rfId) {
        return rechargeInfoDao.readRAmount(rfId);
    }

    @Override
    public List readDistinctEmp() {
        return rechargeInfoDao.readDistinctEmp();
    }

    @Override
    public List readEmpLatestRecharge(String rfId) {
        return rechargeInfoDao.readEmpLatestRecharge(rfId);
    }

    @Override
    public List readByRfidAndDate(String format, String rfId) {
        return rechargeInfoDao.readByRfidAndDate(format, rfId);
    }

}
