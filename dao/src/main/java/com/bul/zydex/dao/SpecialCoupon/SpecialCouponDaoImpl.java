/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SpecialCoupon;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SpecialCouponMaster;

/**
 *
 * @author Aman Bahukhandi
 */
public class SpecialCouponDaoImpl<T> extends GenericsDAOImpl<T> implements SpecialCouponDao<T> {

    @Override
    protected Class getDomainClass() {
        return SpecialCouponMaster.class;
    }

}
