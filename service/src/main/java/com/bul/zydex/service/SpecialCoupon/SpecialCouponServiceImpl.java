/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SpecialCoupon;

import com.bul.zydex.dao.SpecialCoupon.SpecialCouponDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman Bahukhandi
 */
public class SpecialCouponServiceImpl<T> extends GenericsServiceImpl<T> implements SpecialCouponService<T> {

    private SpecialCouponDao<T> specialCouponDao;

    public SpecialCouponDao<T> getSpecialCouponDao() {
        return specialCouponDao;
    }

    public void setSpecialCouponDao(SpecialCouponDao<T> specialCouponDao) {
        this.specialCouponDao = specialCouponDao;
        setGenericsDAO(specialCouponDao);
    }

}
