/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recharge;

import com.bul.zydex.dao.Recharge.RechargeDao;
import com.bul.zydex.model.RechargeMaster;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman Bahukhandi
 */
public class RechargeServiceImpl<T> extends GenericsServiceImpl<T> implements RechargeService<T> {

    private RechargeDao<T> rechargeDao;

    public RechargeDao<T> getRechargeDao() {
        return rechargeDao;
    }

    public void setRechargeDao(RechargeDao<T> rechargeDao) {
        this.rechargeDao = rechargeDao;
        setGenericsDAO(rechargeDao);
    }

    

}
