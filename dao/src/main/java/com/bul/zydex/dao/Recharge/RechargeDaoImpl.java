/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recharge;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RechargeMaster;

/**
 *
 * @author Aman Bahukhandi
 */
public class RechargeDaoImpl<T> extends GenericsDAOImpl<T> implements RechargeDao<T> {

    @Override
    protected Class getDomainClass() {
        return RechargeMaster.class;
    }

}
